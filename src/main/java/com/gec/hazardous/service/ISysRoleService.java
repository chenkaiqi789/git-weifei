package com.gec.hazardous.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.hazardous.domain.SysRoleDo;
import com.gec.hazardous.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
public interface ISysRoleService extends IService<SysRole> {


    IPage<SysRoleDo> selectByCondition(IPage<SysRoleDo> page, Map<String, Object> params);

    List<SysRole> selectByUid(Long uid);


}
