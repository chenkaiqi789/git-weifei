package com.gec.hazardous.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gec.hazardous.domain.SysRoleDo;
import com.gec.hazardous.entity.AppVersion;
import com.gec.hazardous.service.ISysRoleService;
import com.gec.hazardous.utils.PageInfo;
import com.gec.hazardous.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@RestController
@RequestMapping("/manager/role")
public class SysRoleController {
    @Autowired
    private ISysRoleService sysRoleService;


    @GetMapping("/select/{current}/{size}")
    public ResultBean<Page> select(@PathVariable("current") Integer current, @PathVariable("size") Integer size, @RequestParam Map<String, Object> params) {
        PageInfo<SysRoleDo> page = (PageInfo<SysRoleDo>) sysRoleService.selectByCondition(new PageInfo<SysRoleDo>(current, size), params);
        //设置分页导航栏数据
        page.setNavigatePage();
        return ResultBean.ok(page);
    }


}
