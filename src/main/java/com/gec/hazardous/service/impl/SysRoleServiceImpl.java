package com.gec.hazardous.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.gec.hazardous.domain.SysRoleDo;
import com.gec.hazardous.entity.SysRole;
import com.gec.hazardous.mapper.SysRoleMapper;
import com.gec.hazardous.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired(required = false)
    private SysRoleMapper sysRoleMapper;

    @Override
    public IPage<SysRoleDo> selectByCondition(IPage<SysRoleDo> page, Map<String, Object> params) {
        QueryWrapper<SysRoleDo> queryWrapper = new QueryWrapper();
        queryWrapper.apply("sr.del_flag=0 and sr.office_id=so.id")
                .eq(params.containsKey("dataScope") && !ObjectUtils.isEmpty(params.get("dataScope")), "sr.data_scope", params.get("dataScope"))
                .eq(params.containsKey("id") && !ObjectUtils.isEmpty(params.get("id")), "so.id", params.get("id"))
                .like(params.containsKey("name") && !ObjectUtils.isEmpty(params.get("name")), "sr.name", params.get("name"))
                .like(params.containsKey("remarks") && !ObjectUtils.isEmpty(params.get("remarks")), "sr.remarks", params.get("remarks")
                );
        return baseMapper.selectByCondition(page, queryWrapper);
    }

    @Override
    public List<SysRole> selectByUid(Long uid) {
        return sysRoleMapper.selectByUid(uid);
    }
}
