package org.java.web.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class ResultDto {

    @JsonProperty
    private int resultNum;

    @JsonProperty
    private int requestNum;

    public void setResultNum(int resultNum) {
        this.resultNum = resultNum;
    }

    public void setRequestNum(int requestNum) {
        this.requestNum = requestNum;
    }
}
