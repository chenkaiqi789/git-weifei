package com.gec.hazardous.service.impl;

import com.gec.hazardous.entity.Waste;
import com.gec.hazardous.mapper.WasteMapper;
import com.gec.hazardous.service.IWasteService;
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
public class WasteServiceImpl extends ServiceImpl<WasteMapper, Waste> implements IWasteService {

}
