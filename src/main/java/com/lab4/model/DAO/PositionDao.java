package com.lab4.model.DAO;

import com.lab4.model.models.Position;
import com.lab4.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionDao  implements com.lab4.model.DAO.interfaces.PositionDao{
    @Override
    public String getAll() {
        return "SELECT * FROM position";
    }

    @Override
    public String getById() {
        return "SELECT * FROM position WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO position(lat, long) VALUES (?, ?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE position SET lat=?, long=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM position WHERE id=?";
    }

    @Override
    public Position recordEntity(ResultSet resultSet) throws SQLException {
        return (Position) new Transformer<>(Position.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Position model) throws SQLException {
        preparedStatement.setFloat(1, model.getLat_position());
        preparedStatement.setFloat(2, model.getLong_position());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Position model) throws SQLException {
        preparedStatement.setInt(3, model.getId());
        return preparedStatement;
    }
}
