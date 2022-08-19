package com.gec.hazardous.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gec.hazardous.domain.WorkOrderDetailDo;
import com.gec.hazardous.entity.WorkOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gec.hazardous.domain.WorkOrderDo;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
public interface IWorkOrderService extends IService<WorkOrder> {

    IPage<WorkOrderDo> selectByCondition(Page<WorkOrderDo> page, Map<String, Object> params);

    WorkOrderDetailDo selectDetailById(Serializable oid);

}
