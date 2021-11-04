package com.lab4.controller;

import com.lab4.model.DAO.TransportDao;
import com.lab4.model.DAO.interfaces.GeneralDao;
import com.lab4.model.models.Transport;

import java.util.Objects;

public class TransportController implements com.lab4.controller.interfaces.TransportController {

    private GeneralDao<Transport, Integer> transportDao;

    @Override
    public GeneralDao<Transport, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(transportDao,() -> transportDao = new TransportDao());
    }
}