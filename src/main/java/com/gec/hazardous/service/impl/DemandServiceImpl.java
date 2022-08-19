package com.gec.hazardous.service.impl;

import com.gec.hazardous.entity.Demand;
import com.gec.hazardous.mapper.DemandMapper;
import com.gec.hazardous.service.IDemandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户的需求填写 服务实现类
 * </p>
 *
 * @author com.gec
 * @since 2022-08-15
 */
@Service
public class DemandServiceImpl extends ServiceImpl<DemandMapper, Demand> implements IDemandService {

}
