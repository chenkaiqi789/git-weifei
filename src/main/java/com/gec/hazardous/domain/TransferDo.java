package com.gec.hazardous.domain;

import com.gec.hazardous.entity.Transfer;
import lombok.Data;

import java.io.Serializable;

/**
 * 装运记录
 *
 * */

@Data
public class TransferDo extends Transfer implements Serializable {


    private String userName; //转运人姓名
    private String userPhone;//转运人电话

}
