package com.lab4.model.models;

import com.lab4.model.models.annotation.Column;
import com.lab4.model.models.annotation.PrimaryKey;
import com.lab4.model.models.annotation.Table;
import lombok.Data;

@Table(name = "position")
@Data
public class Position extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "lat")
    private Float lat_position;

    @Column(name = "long")
    private Float long_position;
}
