package com.lab4.model.models;

import com.lab4.model.models.annotation.Column;
import com.lab4.model.models.annotation.PrimaryKey;
import com.lab4.model.models.annotation.Table;
import lombok.Data;

@Table(name = "transport_sensors")
@Data
public class TransportSensors extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "speed")
    private Float speed;

    @Column(name = "amount_of_gasoline")
    private Float amountOfGasoline;

    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "sensors_id")
    private Integer sensorsId;
}