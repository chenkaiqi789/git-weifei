package com.gec.hazardous.controller;


import com.gec.hazardous.domain.WorkOrderDo;
import com.gec.hazardous.service.ISysUserService;
import com.gec.hazardous.utils.PageInfo;
import com.gec.hazardous.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@RestController
@RequestMapping("/manager/user")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/selectByRid/{rid}")
    public ResultBean select(@PathVariable("rid") Long rid) {
        return ResultBean.ok(sysUserService.selectByRid(rid));
    }

    @GetMapping("/selectNoRole/{rid}/{oid}")
    public ResultBean select(@PathVariable("oid") Long oid, @PathVariable("rid") Long rid) {
        return ResultBean.ok(sysUserService.selectNoRole(oid, rid));
    }


}
