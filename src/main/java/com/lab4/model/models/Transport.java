package com.lab4.model.models;

import com.lab4.model.models.annotation.Column;
import com.lab4.model.models.annotation.PrimaryKey;
import com.lab4.model.models.annotation.Table;
import lombok.Data;

@Table(name = "transport")
@Data
public class Transport extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "model")
    private String model;

    @Column(name = "transportcol")
    private String transportCol;

    @Column(name = "career_id")
    private Integer careerId;
}
