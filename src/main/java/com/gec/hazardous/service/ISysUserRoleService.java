package com.gec.hazardous.service;

import com.gec.hazardous.entity.SysUserRole;
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
public interface ISysUserRoleService extends IService<SysUserRole> {

    int deleteBatch(Long rid, Long[] ids);

    boolean insertBatch(Long rid, List<Long> ids);

}
