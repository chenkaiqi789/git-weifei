package com.gec.hazardous.service.impl;

import com.gec.hazardous.entity.SysLog;
import com.gec.hazardous.mapper.SysLogMapper;
import com.gec.hazardous.service.ISysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

}
