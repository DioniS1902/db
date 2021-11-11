package com.lab4.model.DAO;


public class WorkerInfoDao implements  com.lab4.model.DAO.interfaces.WorkerInfoDao{
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("WorkerInfo");
        }
        return queryGenerator;
    }
}

