package com.lab4.controller;

import com.lab4.model.DAO.CareerDao;
import com.lab4.model.DAO.interfaces.GeneralDao;
import com.lab4.model.models.Career;

import java.util.Objects;

public class CareerController implements com.lab4.controller.interfaces.CareerController {
    private GeneralDao<Career, Integer> careerDao;

    @Override
    public GeneralDao<Career, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(careerDao,() -> careerDao = new CareerDao());
    }
}
