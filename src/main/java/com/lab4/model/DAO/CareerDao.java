package com.lab4.model.DAO;


public class CareerDao implements com.lab4.model.DAO.interfaces.CareerDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Career");
        }
        return queryGenerator;
    }
}

