package com.gec.hazardous.domain;

import com.gec.hazardous.entity.WorkOrder;
import lombok.Data;

import java.io.Serializable;

@Data
public class WorkOrderDo extends WorkOrder implements Serializable {


    private String createUserName; //发起人
    private String createOfficeName; //发起单位
    private String transportUserName; //运输人
    private String recipientUserName; //处理人

}
