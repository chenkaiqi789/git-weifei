package com.gec.hazardous.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gec.hazardous.domain.DetailDo;
import com.gec.hazardous.domain.TransferDo;
import com.gec.hazardous.domain.WorkOrderDetailDo;
import com.gec.hazardous.entity.WorkOrder;
import com.gec.hazardous.domain.WorkOrderDo;
import com.gec.hazardous.mapper.DetailMapper;
import com.gec.hazardous.mapper.TransferMapper;
import com.gec.hazardous.mapper.WorkOrderMapper;
import com.gec.hazardous.service.IWorkOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@Service
public class WorkOrderServiceImpl extends ServiceImpl<WorkOrderMapper, WorkOrder> implements IWorkOrderService {

    @Autowired(required = false)
    private TransferMapper transferMapper;
    @Autowired(required = false)
    private DetailMapper detailMapper;

    @Override
    public IPage<WorkOrderDo> selectByCondition(Page<WorkOrderDo> page, Map<String, Object> params) {
        QueryWrapper<WorkOrderDo> wrapper = new QueryWrapper();
        wrapper.eq("wo.del_flag", 0)
                .eq(params.containsKey("status") && !ObjectUtils.isEmpty(params.get("status")),
                        "wo.`status`", params.get("status"))
                .ge(params.containsKey("startDate") && !ObjectUtils.isEmpty(params.get("startDate")),
                        "wo.create_date", params.get("startDate"))
                .le(params.containsKey("endDate") && !ObjectUtils.isEmpty(params.get("endDate")),
                        "wo.create_date", params.get("endDate"))
                .and(params.containsKey("officeId") && !ObjectUtils.isEmpty(params.get("officeId")),
                        qw -> qw.eq("co.id", params.get("officeId"))
                                .or()
                                .eq("`to`.id", params.get("officeId"))
                                .or()
                                .eq("ro.id", params.get("officeId"))
                );

        return baseMapper.selectByCondition(page, wrapper);
    }

    @Override
    public WorkOrderDetailDo selectDetailById(Serializable oid) {
        //工单和用户,用户公司的信息
        WorkOrderDetailDo workOrderDetailDo = baseMapper.selectDetailById(oid);
        //查询详细订单记录
        List<DetailDo> details = detailMapper.selectByOrderId(oid);
        //查询转运列表
        List<TransferDo> transfers = transferMapper.selectByOrderId(oid);
        //设置详单记录
        workOrderDetailDo.setDetails(details);
        //设置转运记录
        workOrderDetailDo.setTransfers(transfers);

        return workOrderDetailDo;
    }
}
