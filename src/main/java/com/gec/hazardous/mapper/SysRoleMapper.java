package com.gec.hazardous.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.hazardous.domain.SysRoleDo;
import com.gec.hazardous.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("SELECT " +
            "  sr.*, " +
            "so.name office_name " +
            "FROM " +
            " sys_role sr," +
            " sys_office so " +
            " ${ew.customSqlSegment}")
    IPage<SysRoleDo> selectByCondition(IPage<SysRoleDo> page, QueryWrapper ew);

    /**
     * 根据用户id查询角色
     */
    @Select("SELECT " +
            "  sr.* " +
            "FROM " +
            "  sys_role sr," +
            "  sys_user_role sur," +
            "  sys_user su " +
            "WHERE" +
            "   su.id=sur.user_id " +
            " AND sr.id=sur.role_id " +
            " AND su.id=#{uid}" +
            " AND su.del_flag=0" +
            " AND sur.del_flag=0" +
            " AND sr.del_flag=0")
    List<SysRole> selectByUid(Long uid);

}
