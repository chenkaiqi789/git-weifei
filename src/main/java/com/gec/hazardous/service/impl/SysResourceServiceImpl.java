package com.gec.hazardous.service.impl;

import com.gec.hazardous.entity.SysResource;
import com.gec.hazardous.mapper.SysResourceMapper;
import com.gec.hazardous.service.ISysResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements ISysResourceService {

    @Autowired(required = false)
    private SysResourceMapper sysResourceMapper;

    @Override
    public List<SysResource> selectByUid(Long uid) {
        return sysResourceMapper.selectByUid(uid);
    }
}
