package com.gec.hazardous.domain;

import com.gec.hazardous.entity.Examine;
import lombok.Data;

import java.io.Serializable;

@Data
public class ExamineDo extends Examine implements Serializable {
    private String userName;
    private String officeName;
}
