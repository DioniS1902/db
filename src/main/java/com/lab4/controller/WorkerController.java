package com.lab4.controller;

import com.lab4.model.DAO.interfaces.GeneralDao;
import com.lab4.model.DAO.WorkerDao;
import com.lab4.model.models.Worker;

import java.util.Objects;

public class WorkerController implements com.lab4.controller.interfaces.WorkerController {

    private GeneralDao<Worker, Integer> workerDao;

    @Override
    public GeneralDao<Worker, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(workerDao,() -> workerDao = new WorkerDao());
    }
    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s |","id","transport_id");
    }
}
