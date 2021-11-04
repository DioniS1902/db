package com.lab4.controller;

import com.lab4.model.DAO.PositionDao;
import com.lab4.model.DAO.interfaces.GeneralDao;
import com.lab4.model.models.Position;

import java.util.Objects;

public class PositionController implements com.lab4.controller.interfaces.PositionController {
    private GeneralDao<Position, Integer> positionDao;

    @Override
    public GeneralDao<Position, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(positionDao,() -> positionDao = new PositionDao());
    }
}
