package com.lab4.model.models;

import com.lab4.model.models.annotation.Column;
import com.lab4.model.models.annotation.PrimaryKey;
import com.lab4.model.models.annotation.Table;
import lombok.Data;


@Table(name = "worker_sensors")
@Data
public class WorkerSensors extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "temperature")
    private Float temperature;

    @Column(name = "palpitation")
    private Float palpitation;

    @Column(name = "sensors_id")
    private Integer sensorsId;
}
