package com.lab4.model.DAO;


public class TransportDao implements  com.lab4.model.DAO.interfaces.TransportDao{
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Transport");
        }
        return queryGenerator;
    }
}
