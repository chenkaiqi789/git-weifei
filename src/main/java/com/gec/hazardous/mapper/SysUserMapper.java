package com.gec.hazardous.mapper;

import com.gec.hazardous.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据角色id查询
     */
    @Select("SELECT" +
            "  su.* " +
            "FROM " +
            " sys_user_role sur," +
            " sys_user su " +
            "WHERE" +
            " sur.del_flag=0" +
            " AND su.del_flag=0" +
            " AND sur.user_id=su.id" +
            " AND sur.role_id=#{rid}")
    List<SysUser> selectByRid(Long rid);

    @Select(" SELECT *" +
            " FROM sys_user " +
            "WHERE office_id=#{oid}" +
            " AND id NOT IN(" +
            "SELECT" +
            "  su.id " +
            "FROM " +
            " sys_user_role sur," +
            " sys_user su " +
            "WHERE" +
            " sur.del_flag=0" +
            " AND su.del_flag=0" +
            " AND sur.user_id=su.id" +
            " AND sur.role_id=#{rid}" +
            " )")
    List<SysUser> selectNoRole(@Param("oid") Long oid, @Param("rid") Long rid);

}
