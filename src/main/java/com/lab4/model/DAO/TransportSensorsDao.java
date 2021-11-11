package com.lab4.model.DAO;


public class TransportSensorsDao implements  com.lab4.model.DAO.interfaces.TransportSensorsDao{
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("TransportSensors");
        }
        return queryGenerator;
    }
}
