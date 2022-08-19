package com.gec.hazardous.mapper;

import com.gec.hazardous.entity.SysResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {
    @Select("SELECT" +
            "  sre.* " +
            "FROM " +
            "  sys_user sus," +
            "  sys_user_role sur," +
            "  sys_role sro," +
            "  sys_role_resource srr," +
            "  sys_resource sre " +
            "WHERE" +
            "   sus.id=#{uid} " +
            " AND sus.del_flag=0" +
            " AND sur.del_flag=0" +
            " AND sro.del_flag=0" +
            " AND srr.del_flag=0" +
            " AND sre.del_flag=0" +
            " AND sur.user_id=sus.id" +
            " AND sur.role_id=sro.id" +
            " AND srr.role_id=sro.id" +
            " AND srr.resource_id=sre.id")
    List<SysResource> selectByUid(Long uid);

}
