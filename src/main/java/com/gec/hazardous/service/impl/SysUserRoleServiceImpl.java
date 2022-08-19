package com.gec.hazardous.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gec.hazardous.entity.SysUserRole;
import com.gec.hazardous.mapper.SysUserRoleMapper;
import com.gec.hazardous.service.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {
    //对某个角色,删除用户
    @Override
    public int deleteBatch(Long rid, Long[] ids) {
        QueryWrapper<SysUserRole> query = new QueryWrapper();
        query.eq("role_id", rid)
                .in("user_id", ids);
        return baseMapper.delete(query);
    }

    //对某个角色 添加用户
    @Override
    public boolean insertBatch(Long rid, List<Long> ids) {
        List<SysUserRole> list = new ArrayList<>();
        ids.forEach(aLong -> {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(rid);
            sysUserRole.setUserId(aLong);
            list.add(sysUserRole);
        });
        return saveBatch(list); //savaBatch 批量加入
    }
}
