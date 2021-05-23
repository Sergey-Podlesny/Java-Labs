package org.java.web.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class NumDto {

    private int num;

    public NumDto() {
    }

    public NumDto(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.num);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NumDto)) {
            return false;
        }
        NumDto numDto = (NumDto) obj;
        return numDto.num == num;
    }

    @Override
    public String toString() {
        return "num = " + num;
    }
}
