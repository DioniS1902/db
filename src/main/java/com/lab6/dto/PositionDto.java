package com.lab6.dto;

import com.lab6.models.Position;

public class PositionDto {
    private Position position;

    public PositionDto(Position position) {
        this.position = position;
    }

    public int getId() {
        return position.getId();
    }

    public Double getLat() {
        return position.getLat();
    }

    public Double getPlong() {
        return position.getPlong();
    }
}
