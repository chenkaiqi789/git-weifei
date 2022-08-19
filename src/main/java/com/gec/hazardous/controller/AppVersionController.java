package com.gec.hazardous.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gec.hazardous.entity.AppVersion;
import com.gec.hazardous.service.IAppVersionService;
import com.gec.hazardous.utils.PageInfo;
import com.gec.hazardous.utils.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@Slf4j
@RestController
@RequestMapping("/manager/app")
public class AppVersionController {

    @Autowired
    private IAppVersionService appVersionService;

    @GetMapping("/select")
    public ResultBean<Page> select(@RequestParam("current") Integer current, @RequestParam("size") Integer size) {
        PageInfo<AppVersion> page = appVersionService.page(new PageInfo<AppVersion>(current, size));
        //设置分页导航栏数据
        page.setNavigatePage();
        return ResultBean.ok(page);
    }

    /**
     * 添加和修改一起的
     */
    @PostMapping("/saveOrUpdate")
    public ResultBean saveOrUpdate(@RequestBody AppVersion app) {
        System.out.println("唯一------" + app.getId());
        appVersionService.saveOrUpdate(app);
        return ResultBean.ok();
    }

    /*修改的中转*/
    @PostMapping("/selectOne/{id}")
    public ResultBean<AppVersion> selectOne(@PathVariable Long id) {
        System.out.println(id);
        AppVersion app = appVersionService.getById(id);
        return ResultBean.ok(app);
    }

    @PostMapping("/delete/{id}")
    public ResultBean doDelete(@PathVariable Long id) {
        /*逻辑删除*/
        appVersionService.removeById(id);
        return ResultBean.ok();
    }


}
