package com.lab4.model.DAO;

import com.lab4.model.models.Transport;
import com.lab4.model.models.TransportSensors;
import com.lab4.model.models.annotation.Column;
import com.lab4.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransportSensorsDao implements  com.lab4.model.DAO.interfaces.TransportSensorsDao{
    @Override
    public String getAll() {
        return "SELECT * FROM transport_sensors";
    }

    @Override
    public String getById() {
        return "SELECT * FROM transport_sensors WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO transport_sensors(speed, amount_of_gasoline, position_id, sensors_id) VALUES (?, ?, ?, ?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE transport_sensors SET speed=?, amount_of_gasoline=?, position_id=?, sensors_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM transport_sensors WHERE id=?";
    }
    @Override
    public TransportSensors recordEntity(ResultSet resultSet) throws SQLException {
        return (TransportSensors) new Transformer<>(TransportSensors.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, TransportSensors model) throws SQLException {
        preparedStatement.setFloat(1, model.getSpeed());
        preparedStatement.setFloat(2, model.getAmountOfGasoline());
        preparedStatement.setInt(3, model.getPositionId());
        preparedStatement.setInt(4, model.getSensorsId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, TransportSensors model) throws SQLException {
        preparedStatement.setInt(5, model.getId());
        return preparedStatement;
    }
}
