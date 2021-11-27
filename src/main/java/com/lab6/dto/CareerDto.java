package com.lab6.dto;

import com.lab6.models.Career;
import com.lab6.models.Position;

public class CareerDto {
    private Career career;

    public CareerDto(Career career){
        this.career = career;
    }

    public int getId() {
        return career.getId();
    }

    public String getName() {
        return career.getName();
    }

    public Position getPositionId() {
        return career.getPositionId();
    }

}
