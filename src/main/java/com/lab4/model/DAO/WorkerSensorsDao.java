package com.lab4.model.DAO;

import com.lab4.model.models.WorkerSensors;
import com.lab4.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerSensorsDao implements  com.lab4.model.DAO.interfaces.WorkerSensorsDao{
    @Override
    public String getAll() {
        return "SELECT * FROM worker_sensors";
    }

    @Override
    public String getById() {
        return "SELECT * FROM worker_sensors WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO worker_sensors(temperature, palpitation, sensors_id) VALUES (?, ?, ?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE worker_sensors SET temperature=?, palpitation=?, sensors_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM worker_sensors WHERE id=?";
    }

    @Override
    public WorkerSensors recordEntity(ResultSet resultSet) throws SQLException {
        return (WorkerSensors) new Transformer<>(WorkerSensors.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, WorkerSensors model) throws SQLException {
        preparedStatement.setFloat(1, model.getTemperature());
        preparedStatement.setFloat(2, model.getPalpitation());
        preparedStatement.setInt(3, model.getSensorsId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, WorkerSensors model) throws SQLException {
        preparedStatement.setInt(4, model.getId());
        return preparedStatement;
    }
}
