package com.lab4.model.DAO;


public class WorkerSensorsDao implements  com.lab4.model.DAO.interfaces.WorkerSensorsDao{
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("WorkerSensors");
        }
        return queryGenerator;
    }
}
