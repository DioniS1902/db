package com.lab4.model.DAO;


public class MedicalInsuranceDao implements com.lab4.model.DAO.interfaces.MedicalInsuranceDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("MedicalInsurance");
        }
        return queryGenerator;
    }
}
