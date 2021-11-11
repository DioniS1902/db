package com.lab4;

import com.lab4.model.manager.SessionManager;
import com.lab4.view.View;

public class Application {
    public static void main(String[] args) {
        SessionManager.openSession();
        View view = new View();
        view.print();
        SessionManager.closeSession();

    }
}
