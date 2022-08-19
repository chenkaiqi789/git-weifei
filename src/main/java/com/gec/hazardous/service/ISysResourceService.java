package com.gec.hazardous.service;

import com.gec.hazardous.entity.SysResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
public interface ISysResourceService extends IService<SysResource> {

    List<SysResource> selectByUid(Long uid);
}
