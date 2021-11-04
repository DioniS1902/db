package com.lab4.model.DAO;

import com.lab4.model.models.Career;
import com.lab4.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CareerDao implements com.lab4.model.DAO.interfaces.CareerDao {
    @Override
    public String getAll() {
        return "SELECT * FROM career";
    }

    @Override
    public String getById() {
        return "SELECT * FROM career WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO career(name, position_id) VALUES (?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE career SET name=?, position_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM career WHERE id=?";
    }


    @Override
    public Career recordEntity(ResultSet resultSet) throws SQLException {
        return (Career) new Transformer<>(Career.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Career model) throws SQLException {
        preparedStatement.setString(1, model.getName());
        preparedStatement.setInt(2, model.getPositionId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Career model) throws SQLException {
        preparedStatement.setInt(3, model.getId());
        return preparedStatement;
    }
}

