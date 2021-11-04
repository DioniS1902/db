package com.lab4.model.DAO;

import com.lab4.model.models.Transport;
import com.lab4.model.models.Worker;
import com.lab4.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerDao implements  com.lab4.model.DAO.interfaces.WorkerDao{
    @Override
    public String getAll() {
        return "SELECT * FROM worker";
    }

    @Override
    public String getById() {
        return "SELECT * FROM worker WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO worker(transport_id) VALUES (?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE worker SET transport_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM worker WHERE id=?";
    }

    @Override
    public Worker recordEntity(ResultSet resultSet) throws SQLException {
        return (Worker) new Transformer<>(Worker.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Worker model) throws SQLException {
        preparedStatement.setInt(1, model.getTransportId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Worker model) throws SQLException {
        preparedStatement.setInt(2, model.getId());
        return preparedStatement;
    }
}
