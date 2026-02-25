package com.nouradine.springgestion.handlers;

import com.nouradine.springgestion.exception.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

    private Integer httpCode;

    private ErrorCodes codes;

    private String messsage;

    private List<String> errors=new ArrayList<>();


}
