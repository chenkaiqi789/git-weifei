package com.gec.hazardous.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gec.hazardous.domain.ExamineDo;
import com.gec.hazardous.service.IExamineService;
import com.gec.hazardous.utils.PageInfo;
import com.gec.hazardous.utils.ResultBean;
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
@RequestMapping("/manager/examine")
public class ExamineController {

    @Autowired
    private IExamineService examineService;

    @GetMapping("/select/{current}/{size}")
    public ResultBean<Page> select(@PathVariable("current") int current, @PathVariable("size") int size, @RequestParam Map<String, Object> params) {
        PageInfo<ExamineDo> pageInfo = (PageInfo<ExamineDo>) examineService.selectByCondition(new PageInfo<>(current, size), params);
        pageInfo.setNavigatePage();
        return ResultBean.ok(pageInfo);
    }

}
