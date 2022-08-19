package com.gec.hazardous.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.gec.hazardous.entity.Examine;
import com.gec.hazardous.domain.ExamineDo;
import com.gec.hazardous.mapper.ExamineMapper;
import com.gec.hazardous.service.IExamineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@Service
public class ExamineServiceImpl extends ServiceImpl<ExamineMapper, Examine> implements IExamineService {

    @Override
    public IPage<ExamineDo> selectByCondition(IPage<ExamineDo> page, Map<String, Object> params) {
        QueryWrapper<ExamineDo> query = new QueryWrapper<>();
        //拼接固定的sql语句
        query.apply("ex.examine_user_id=su.id AND su.office_id=so.id AND ex.del_flag=0")
                .eq(params.containsKey("type") && !ObjectUtils.isEmpty(params.get("type")),"ex.type", params.get("type"))
                .like(params.containsKey("name") && !ObjectUtils.isEmpty(params.get("name")), "su.name", params.get("name"))
                .eq(params.containsKey("officeId") && !ObjectUtils.isEmpty(params.get("officeId")), "so.id", params.get("officeId"));
        return baseMapper.selectByCondition(page,query);
    }
}
