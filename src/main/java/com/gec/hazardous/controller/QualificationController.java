package com.gec.hazardous.controller;


import com.gec.hazardous.service.IQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@RestController
@RequestMapping("/manager/qualification")
public class QualificationController {

    @Autowired
    private IQualificationService qualificationService;


}
