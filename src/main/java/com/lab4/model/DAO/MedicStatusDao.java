package com.lab4.model.DAO;


public class MedicStatusDao implements com.lab4.model.DAO.interfaces.MedicStatusDao{
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("MedicStatus");
        }
        return queryGenerator;
    }
}
