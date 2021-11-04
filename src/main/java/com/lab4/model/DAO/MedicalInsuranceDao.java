package com.lab4.model.DAO;

import com.lab4.model.models.MedicalInsurance;
import com.lab4.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicalInsuranceDao implements com.lab4.model.DAO.interfaces.MedicalInsuranceDao {
    @Override
    public String getAll() {
        return "SELECT * FROM medic_insurance";
    }

    @Override
    public String getById() {
        return "SELECT * FROM medic_insurance WHERE id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT INTO medic_insurance(medic_code) VALUES (?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE medic_insurance SET medic_code=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM medic_insurance WHERE id=?";
    }

    @Override
    public com.lab4.model.models.MedicalInsurance recordEntity(ResultSet resultSet) throws SQLException {
        return (MedicalInsurance) new Transformer<>(MedicalInsurance.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, MedicalInsurance model) throws SQLException {
        preparedStatement.setInt(1, model.getMedicCode());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, MedicalInsurance model) throws SQLException {
        preparedStatement.setInt(2, model.getId());
        return preparedStatement;
    }
}
