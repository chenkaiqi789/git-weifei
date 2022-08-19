package com.gec;

import com.gec.hazardous.entity.AppVersion;
import com.gec.hazardous.domain.ExamineDo;
import com.gec.hazardous.domain.WorkOrderDo;
import com.gec.hazardous.service.IAppVersionService;
import com.gec.hazardous.service.IExamineService;
import com.gec.hazardous.service.IWorkOrderService;
import com.gec.hazardous.utils.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
@Slf4j
class Day0815SpringBootHazardousApplicationTests {
    @Autowired
    private IAppVersionService appVersionService;

    @Autowired
    private IExamineService examineService;

    @Autowired
    private IWorkOrderService workOrderService;

    @Test
    void contextLoads() {
        List<AppVersion> list = appVersionService.list();
        list.forEach(appVersion -> log.info(" " + appVersion));
    }

    @Test
    void contextLoads1() {
        PageInfo<AppVersion> page = appVersionService.page(new PageInfo<AppVersion>(1, 5));
        page.getRecords().forEach(appVersion -> System.out.println(appVersion));
    }

    @Test
    void contextLoads2() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("officeId", 56);
        params.put("type", 1);
        params.put("name", "人员");

        PageInfo<ExamineDo> page = new PageInfo<>(1, 5);
        PageInfo<ExamineDo> pageInfo = (PageInfo<ExamineDo>) examineService.selectByCondition(page, params);

        pageInfo.getRecords().forEach(examineDo -> {
            System.out.println(examineDo);
        });
    }

    @Test
    void contextLoads3() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("status", 1);
        params.put("officeId", 56);
        PageInfo<WorkOrderDo> page = new PageInfo<>(1, 5);
        PageInfo<WorkOrderDo> pageInfo = (PageInfo<WorkOrderDo>) workOrderService.selectByCondition(page, params);
        pageInfo.getRecords().forEach(workOrderDo -> {
            System.out.println(workOrderDo);
        });
    }

}
