package com.gec.hazardous.domain;

import com.gec.hazardous.entity.WorkOrder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 *
 * */

@Data
public class WorkOrderDetailDo extends WorkOrder implements Serializable {

    private List<DetailDo> details;//工单详情的信息列表
    private List<TransferDo> transfers;//工单转运的记录

    private String createUserName; //发起人
    private String createUserPhone;//发起人电话
    private String createOfficeName; //发起单位

    private String transportUserName; //运输人
    private String transportUserPhone;//运输人电话
    private String transportOfficeName;//运输公司

    private String recipientUserName; //处理人
    private String recipientUserPhone;//处理人的电话
    private String recipientOfficeName;//处理公司

}
