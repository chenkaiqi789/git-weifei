package com.gec.hazardous.controller;


import com.gec.hazardous.entity.SysOffice;
import com.gec.hazardous.service.ISysOfficeService;
import com.gec.hazardous.utils.PageInfo;
import com.gec.hazardous.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@RestController
@RequestMapping("/manager/office")
public class SysOfficeController {

    @Autowired
    private ISysOfficeService sysOfficeService;

    /**
     * 查询机构的名称发送到考核页面选择
     */
    @GetMapping("/selectAll")
    public ResultBean<SysOffice> selectAll() {
        List<SysOffice> list = sysOfficeService.list();
        return ResultBean.ok(list);

    }

}
