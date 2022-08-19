package com.gec.hazardous.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.hazardous.domain.DetailDo;
import com.gec.hazardous.domain.TransferDo;
import com.gec.hazardous.entity.Transfer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */

public interface TransferMapper extends BaseMapper<Transfer> {


    @Select("SELECT " +
            "  tr.*, " +
            "su.`name` user_name, " +
            "su.phone user_phone " +
            " FROM " +
            "    transfer tr, " +
            "sys_user su " +
            "WHERE " +
            "  tr.work_order_id=#{oid} " +
            "AND tr.oprate_user_id=su.id " +
            "  ORDER BY tr.create_date DESC ")
    List<TransferDo> selectByOrderId(Serializable oid);

}
