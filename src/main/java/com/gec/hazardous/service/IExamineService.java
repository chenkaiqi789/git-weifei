package com.gec.hazardous.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.hazardous.entity.Examine;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gec.hazardous.domain.ExamineDo;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
public interface IExamineService extends IService<Examine> {

    //动态拼接sql语句 条件查询
    IPage<ExamineDo> selectByCondition(IPage<ExamineDo> page, Map<String, Object> params);

}
