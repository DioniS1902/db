package com.lab4.model.DAO;

import com.lab4.model.models.WorkerInfo;
import com.lab4.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerInfoDao implements  com.lab4.model.DAO.interfaces.WorkerInfoDao{
    @Override
    public String getAll() {
        return "SELECT * FROM worker_info";
    }

    @Override
    public String getById() {
        return "SELECT * FROM worker_info WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO worker_info(first_name, last_name, birhday) VALUES (?, ?, ?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE worker_info SET first_name=?, last_name=?, birhday=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM worker_info WHERE id=?";
    }


    @Override
    public WorkerInfo recordEntity(ResultSet resultSet) throws SQLException {
        return (WorkerInfo) new Transformer<>(WorkerInfo.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, WorkerInfo model) throws SQLException {
        preparedStatement.setString(1, model.getFirstName());
        preparedStatement.setString(2, model.getLastName());
        preparedStatement.setDate(3, model.getBirhday());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, WorkerInfo model) throws SQLException {
        preparedStatement.setInt(4, model.getWorkerId());
        return preparedStatement;
    }
}

