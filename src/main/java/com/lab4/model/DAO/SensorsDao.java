package com.lab4.model.DAO;


public class SensorsDao implements com.lab4.model.DAO.interfaces.SensorsDao{
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Sensors");
        }
        return queryGenerator;
    }
}
