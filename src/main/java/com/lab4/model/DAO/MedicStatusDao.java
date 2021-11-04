package com.lab4.model.DAO;

import com.lab4.model.models.MedicStatus;
import com.lab4.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicStatusDao implements com.lab4.model.DAO.interfaces.MedicStatusDao{
    @Override
    public String getAll() {
        return "SELECT * FROM medic_status";
    }

    @Override
    public String getById() {
        return "SELECT * FROM medic_status WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO medic_status(date, temperature, worker_id) VALUES (?, ?, ?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE medic_status SET date=?, temperature=?, worker_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM medic_status WHERE id=?";
    }

    @Override
    public MedicStatus recordEntity(ResultSet resultSet) throws SQLException {
        return (MedicStatus) new Transformer<>(MedicStatus.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, MedicStatus model) throws SQLException {
        preparedStatement.setDate(1, model.getDate());
        preparedStatement.setFloat(2, model.getTemperature());
        preparedStatement.setFloat(3, model.getWorkerId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, MedicStatus model) throws SQLException {
        preparedStatement.setInt(4, model.getId());
        return preparedStatement;
    }
}
