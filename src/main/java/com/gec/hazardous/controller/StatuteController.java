package com.gec.hazardous.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gec.hazardous.entity.Statute;
import com.gec.hazardous.service.IStatuteService;
import com.gec.hazardous.utils.PageInfo;
import com.gec.hazardous.utils.ResultBean;
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
@RestController
@RequestMapping("/manager/statute")
public class StatuteController {

    @Autowired
    private IStatuteService statuteService;

    @GetMapping("/select")
    public ResultBean<Statute> select(@RequestParam("current") Integer current, @RequestParam("size") Integer size, Integer type) {
        LambdaQueryWrapper<Statute> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(type > 0, Statute::getType, type);
        PageInfo<Statute> page = statuteService.page(new PageInfo<>(current, size), queryWrapper);
        page.setNavigatePage();
        return ResultBean.ok(page);
    }

    //修改和保存
    @PostMapping("/saveOrUpdate")
    public ResultBean saveOrUpdate(@RequestBody Statute statute) {
        statuteService.saveOrUpdate(statute);
        return ResultBean.ok();
    }


    //删除
    @PostMapping("/doDelete/{id}")
    public ResultBean doDelete(@PathVariable long id) {
        statuteService.removeById(id);
        return ResultBean.ok();
    }

    //查询单个
    @PostMapping("/selectOne/{id}")
    public ResultBean<Statute> selectOne(@PathVariable long id) {
        System.out.println(id);
        Statute statute = statuteService.getById(id);
        return ResultBean.ok(statute);
    }


}
