package com.lab4.model.DAO;

public class PositionDao  implements com.lab4.model.DAO.interfaces.PositionDao{
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Position");
        }
        return queryGenerator;
    }
}
