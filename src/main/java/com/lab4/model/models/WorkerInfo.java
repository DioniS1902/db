package com.lab4.model.models;

import com.lab4.model.models.annotation.Column;
import com.lab4.model.models.annotation.PrimaryKey;
import com.lab4.model.models.annotation.Table;
import lombok.Data;

import java.sql.Date;

@Table(name = "worker_info")
@Data
public class WorkerInfo extends GeneralModel{
    @PrimaryKey
    @Column(name = "worker_id")
    private Integer workerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birhday")
    private Date birhday;
}
