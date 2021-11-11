package com.lab4.controller;

import com.lab4.model.DAO.SensorsDao;
import com.lab4.model.DAO.interfaces.GeneralDao;
import com.lab4.model.models.Sensors;


import java.util.Objects;

public class SensorsController implements com.lab4.controller.interfaces.SensorsController {

    private GeneralDao<Sensors, Integer> sensorsDao;

    @Override
    public GeneralDao<Sensors, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(sensorsDao,() -> sensorsDao = new SensorsDao());
    }
    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s |","id","transport_id", "date_time");
    }
}
