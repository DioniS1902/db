package com.lab4.controller;

import com.lab4.model.DAO.TransportSensorsDao;
import com.lab4.model.DAO.interfaces.GeneralDao;
import com.lab4.model.models.TransportSensors;

import java.util.Objects;

public class TransportSesnsorsController implements com.lab4.controller.interfaces.TransportSesnsorsController {

    private GeneralDao<TransportSensors, Integer> transportSensorsDao;

    @Override
    public GeneralDao<TransportSensors, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(transportSensorsDao,() -> transportSensorsDao = new TransportSensorsDao());
    }

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s |","id","speed", "amount_of_gasoline", "position_id", "sensors_id");
    }
}
