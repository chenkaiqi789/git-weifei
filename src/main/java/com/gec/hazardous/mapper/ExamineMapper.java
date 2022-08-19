package com.gec.hazardous.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.hazardous.entity.Examine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gec.hazardous.domain.ExamineDo;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
public interface ExamineMapper extends BaseMapper<Examine> {
    /**
     * so ${ew.customSqlSegment} 自定义sql固定写法
     * */
    @Select("SELECT ex.*,su.name user_name,so.name office_name " +
            "FROM examine ex,sys_user su,sys_office so ${ew.customSqlSegment}")
    IPage<ExamineDo> selectByCondition(IPage<ExamineDo> page, QueryWrapper ew);

}
