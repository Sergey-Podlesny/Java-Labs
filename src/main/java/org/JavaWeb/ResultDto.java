package org.JavaWeb;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultDto {

    @JsonProperty("num")
    int resultNum;

    public ResultDto(int num)
    {
        resultNum = num;
    }
}
