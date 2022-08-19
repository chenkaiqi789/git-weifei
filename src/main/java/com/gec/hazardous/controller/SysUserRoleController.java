package com.gec.hazardous.controller;


import com.gec.hazardous.service.ISysUserRoleService;
import com.gec.hazardous.utils.ResultBean;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@RestController
@RequestMapping("/manager/role")
public class SysUserRoleController {

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @RequestMapping("/deleteBatch")
    public ResultBean deleteBatch(@RequestParam("rid") String rid, @RequestParam("ids") Long[] ids) {
        return ResultBean.ok(sysUserRoleService.deleteBatch(Long.parseLong(rid), ids));
    }

    @RequestMapping("/insertBatch")
    public ResultBean insertBatch(@RequestParam("rid") String rid, @RequestParam("ids") Long[] ids) {
        return ResultBean.ok(sysUserRoleService.insertBatch(Long.parseLong(rid), Arrays.asList(ids)));
    }


}
