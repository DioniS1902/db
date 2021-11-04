package com.lab4.model.DAO;

import com.lab4.model.models.Sensors;
import com.lab4.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SensorsDao implements com.lab4.model.DAO.interfaces.SensorsDao{
    @Override
    public String getAll() {
        return "SELECT * FROM sensors";
    }

    @Override
    public String getById() {
        return "SELECT * FROM sensors WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO sensors(transport_id, date_time) VALUES (?, ?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE sensors SET transport_id=?, date_time=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM sensors WHERE id=?";
    }

    @Override
    public Sensors recordEntity(ResultSet resultSet) throws SQLException {
        return (Sensors) new Transformer<>(Sensors.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Sensors model) throws SQLException {
        preparedStatement.setInt(1, model.getTransportId());
        preparedStatement.setString(2, model.getDateTime());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Sensors model) throws SQLException {
        preparedStatement.setInt(3, model.getId());
        return preparedStatement;
    }
}
