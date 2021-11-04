package com.lab4.model.DAO;

import com.lab4.model.models.Transport;
import com.lab4.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransportDao implements  com.lab4.model.DAO.interfaces.TransportDao{
    @Override
    public String getAll() {
        return "SELECT * FROM transport";
    }

    @Override
    public String getById() {
        return "SELECT * FROM transport WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO transport(model, transportcol, career_id) VALUES (?, ?, ?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE transport SET model=?, transportcol=?, career_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM transport WHERE id=?";
    }
    @Override
    public Transport recordEntity(ResultSet resultSet) throws SQLException {
        return (Transport) new Transformer<>(Transport.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Transport model) throws SQLException {
        preparedStatement.setString(1, model.getModel());
        preparedStatement.setString(2, model.getTransportCol());
        preparedStatement.setInt(3, model.getCareerId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Transport model) throws SQLException {
        preparedStatement.setInt(4, model.getId());
        return preparedStatement;
    }
}
