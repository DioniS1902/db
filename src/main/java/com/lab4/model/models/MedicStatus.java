package com.lab4.model.models;

import com.lab4.model.models.annotation.Column;
import com.lab4.model.models.annotation.PrimaryKey;
import com.lab4.model.models.annotation.Table;
import lombok.Data;

import java.sql.Date;

@Table(name = "medic_status")
@Data
public class MedicStatus extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "temperature")
    private Float temperature;

    @Column(name = "worker_id")
    private Float workerId;
}
