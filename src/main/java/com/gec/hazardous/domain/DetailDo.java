package com.gec.hazardous.domain;

import com.gec.hazardous.entity.Detail;
import lombok.Data;

import java.io.Serializable;

/**
 * 危废详细信息
 *
 * */

@Data
public class DetailDo extends Detail implements Serializable {

    private String wasteTypeCode; //废物类型编号
    private String wasteTypeName; //废物类型
    private String wasteCode; //废物编号
}
