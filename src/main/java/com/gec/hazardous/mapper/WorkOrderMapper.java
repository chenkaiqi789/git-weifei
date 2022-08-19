package com.gec.hazardous.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gec.hazardous.domain.WorkOrderDetailDo;
import com.gec.hazardous.entity.WorkOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gec.hazardous.domain.WorkOrderDo;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
public interface WorkOrderMapper extends BaseMapper<WorkOrder> {
    @Select("SELECT " +
            "  wo.*, " +
            "cu.name create_user_name, " +
            "co.name create_office_name , " +
            "tu.name transport_user_name , " +
            "ru.name recipient_user_name " +
            "FROM " +
            "   work_order wo " +
            " LEFT JOIN sys_user cu " +
            " ON wo.create_user_id=cu.id " +
            "  LEFT JOIN sys_office co " +
            " ON cu.office_id=co.id " +
            "  LEFT JOIN sys_user tu " +
            " ON wo.transport_user_id=tu.id " +
            "  LEFT JOIN sys_office `to` " +
            " ON tu.office_id=`to`.id " +
            "  LEFT JOIN sys_user ru " +
            " ON wo.recipient_user_id=ru.id " +
            "  LEFT JOIN sys_office ro " +
            " ON ru.office_id=ro.id " +
            " ${ew.customSqlSegment} "
    )
    IPage<WorkOrderDo> selectByCondition(Page<WorkOrderDo> page, Wrapper ew);

    @Select("SELECT " +
            "  wo.*, " +
            "cu.name create_user_name, " +
            "cu.phone create_user_phone, " +
            "co.name create_office_name , " +
            "tu.name transport_user_name , " +
            "tu.phone transport_user_phone, " +
            "`to`.name  transport_office_name, " +
            "ru.name recipient_user_name, " +
            "ru.phone recipient_user_phone, " +
            "ro.name  recipient_office_name " +
            "FROM " +
            "   work_order wo " +
            " LEFT JOIN sys_user cu  " +
            " ON wo.create_user_id=cu.id " +
            "  LEFT JOIN sys_office co  " +
            " ON cu.office_id=co.id " +
            "  LEFT JOIN sys_user tu  " +
            " ON wo.transport_user_id=tu.id  " +
            "  LEFT JOIN sys_office `to`  " +
            " ON tu.office_id=`to`.id" +
            "  LEFT JOIN sys_user ru  " +
            " ON wo.recipient_user_id=ru.id " +
            "  LEFT JOIN sys_office ro  " +
            " ON ru.office_id=ro.id " +
            " WHERE " +
            "   wo.del_flag=0" +
            " AND wo.id=#{oid}")
    WorkOrderDetailDo selectDetailById(Serializable oid);

}
