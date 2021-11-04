package com.lab4.controller;

import com.lab4.model.DAO.WorkerInfoDao;
import com.lab4.model.DAO.interfaces.GeneralDao;
import com.lab4.model.models.WorkerInfo;

import java.util.Objects;

public class WorkerInfoController implements com.lab4.controller.interfaces.WorkerInfoController {

    private GeneralDao<WorkerInfo, Integer> workerInfoDao;

    @Override
    public GeneralDao<WorkerInfo, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(workerInfoDao,() -> workerInfoDao = new WorkerInfoDao());
    }
}
