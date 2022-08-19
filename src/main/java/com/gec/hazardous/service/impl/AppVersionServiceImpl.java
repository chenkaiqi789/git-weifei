package com.gec.hazardous.service.impl;

import com.gec.hazardous.entity.AppVersion;
import com.gec.hazardous.mapper.AppVersionMapper;
import com.gec.hazardous.service.IAppVersionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@Service
public class AppVersionServiceImpl extends ServiceImpl<AppVersionMapper, AppVersion> implements IAppVersionService {

}
