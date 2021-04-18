package org.java.web.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.OptionalDouble;

@Component
public class ResultDto {

    @JsonProperty
    private int resultNum;

    @JsonProperty
    private int requestNum;

    @JsonProperty
    private int minResultNum;

    @JsonProperty
    private int maxResultNum;

    @JsonProperty
    private OptionalDouble averResultNum;

    public void setMinResultNum(int minResultNum) {
        this.minResultNum = minResultNum;
    }

    public void setMaxResultNum(int maxResultNum) {
        this.maxResultNum = maxResultNum;
    }

    public void setAverResultNum(OptionalDouble averResultNum) {
        this.averResultNum = averResultNum;
    }

    public void setResultNum(int resultNum) {
        this.resultNum = resultNum;
    }

    public void setRequestNum(int requestNum) {
        this.requestNum = requestNum;
    }
}
