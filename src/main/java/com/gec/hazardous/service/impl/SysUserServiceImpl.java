package com.gec.hazardous.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gec.hazardous.entity.SysUser;
import com.gec.hazardous.mapper.SysUserMapper;
import com.gec.hazardous.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired(required = false)
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> selectByRid(Long rid) {
        return sysUserMapper.selectByRid(rid);
    }

    @Override
    public List<SysUser> selectNoRole(Long oid, Long rid) {
        return sysUserMapper.selectNoRole(oid, rid);
    }

    @Override
    public SysUser findUserByUsername(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(SysUser::getUsername, username);
        return baseMapper.selectOne(queryWrapper);
    }
}
