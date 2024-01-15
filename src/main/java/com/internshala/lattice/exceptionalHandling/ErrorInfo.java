package com.internshala.lattice.exceptionalHandling;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorInfo {

    private Integer errorCode;
    private String errorMsg;


}
