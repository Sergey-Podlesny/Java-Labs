package org.java.web.entity;

import org.springframework.stereotype.Component;

public class NumDto {

    private int num;

    public NumDto(int num){
        this.num = num;
    }

    public int getNum(){
        return num;
    }
}
