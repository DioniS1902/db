package com.lab4.controller;

import com.lab4.model.DAO.WorkerSensorsDao;
import com.lab4.model.DAO.interfaces.GeneralDao;
import com.lab4.model.models.WorkerSensors;

import java.util.Objects;

public class WorkerSensorsController implements com.lab4.controller.interfaces.WorkerSensorsController {

    private GeneralDao<WorkerSensors, Integer> workerSensorsDao;

    @Override
    public GeneralDao<WorkerSensors, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(workerSensorsDao,() -> workerSensorsDao = new WorkerSensorsDao());
    }

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-20s |","id","temperature", "palpitation", "sensors_id");
    }
}
