package com.gec.hazardous.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.hazardous.domain.DetailDo;
import com.gec.hazardous.entity.Detail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
public interface DetailMapper extends BaseMapper<Detail> {

    @Select("SELECT " +
            "   de.*, " +
            " wt.`code` waste_type_code, " +
            " wt.`name` waste_type_name, " +
            " wa.`code` waste_code " +
            "FROM " +
            "   detail de, " +
            " waste_type wt, " +
            " waste wa " +
            " WHERE " +
            "     de.work_order_id=#{oid} " +
            "AND de.waste_id=wa.id " +
            "AND de.waste_type_id=wt.id ")
    List<DetailDo> selectByOrderId(Serializable oid);

}
