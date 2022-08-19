package com.gec.hazardous.controller;


import com.gec.hazardous.domain.WorkOrderDetailDo;
import com.gec.hazardous.domain.WorkOrderDo;
import com.gec.hazardous.service.IWorkOrderService;
import com.gec.hazardous.utils.PageInfo;
import com.gec.hazardous.utils.ResultBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@RestController
@RequestMapping("/manager/work")
public class WorkOrderController {

    @Autowired
    private IWorkOrderService workOrderService;

    @GetMapping("/select/{current}/{size}")
    public ResultBean<WorkOrderDo> select(@PathVariable Integer current, @PathVariable Integer size, @RequestParam Map<String, Object> params) {
        PageInfo<WorkOrderDo> pageInfo = (PageInfo<WorkOrderDo>) workOrderService.selectByCondition(new PageInfo<WorkOrderDo>(current, size), params);
        pageInfo.setNavigatePage();
        return ResultBean.ok(pageInfo);
    }

    @GetMapping("/selectOne/{oid}")
    @RequiresPermissions("sss:select")
    public ResultBean selectOne(@PathVariable Long oid) {
        WorkOrderDetailDo workOrderDetailDo = workOrderService.selectDetailById(oid);
        return ResultBean.ok(workOrderDetailDo);
    }


}
