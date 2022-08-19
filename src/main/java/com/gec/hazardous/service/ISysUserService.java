package com.gec.hazardous.service;

import com.gec.hazardous.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
public interface ISysUserService extends IService<SysUser> {

    List<SysUser> selectByRid(Long rid);

    List<SysUser> selectNoRole(Long oid, Long rid);

    SysUser findUserByUsername(String username);

}
