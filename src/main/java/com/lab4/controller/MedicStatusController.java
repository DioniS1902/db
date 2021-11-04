package com.lab4.controller;

import com.lab4.model.DAO.MedicStatusDao;
import com.lab4.model.DAO.interfaces.GeneralDao;
import com.lab4.model.models.MedicStatus;

import java.util.Objects;

public class MedicStatusController implements com.lab4.controller.interfaces.MedicStatusController {
    private GeneralDao<MedicStatus, Integer> medicStatusDao;

    @Override
    public GeneralDao<MedicStatus, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(medicStatusDao,() -> medicStatusDao = new MedicStatusDao());
    }
}
