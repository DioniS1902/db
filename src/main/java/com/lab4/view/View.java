package com.lab4.view;

import com.lab4.controller.*;
import com.lab4.controller.interfaces.GeneralController;
import com.lab4.model.models.*;
import com.lab4.model.models.GeneralModel;
import java.nio.charset.StandardCharsets;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View implements Printable{
    private final Map<String, GeneralController> controllers;
    private final Map<String, GeneralModel> models;
    private String consoleInput;
    private Scanner input;
    boolean isQuit;

    public View() {
        input = new Scanner(System.in, StandardCharsets.UTF_8);
        isQuit = false;
        models = new HashMap<>();
        controllers = new HashMap<>();
        controllers.put("Career",new CareerController());
        controllers.put("MedicalInsurance",new MedicalInsuranceController());
        controllers.put("MedicStatus",new MedicStatusController());
        controllers.put("Position",new PositionController());
        controllers.put("Sensors",new SensorsController());
        controllers.put("Transport",new TransportController());
        controllers.put("TransportSensor",new TransportSesnsorsController());
        controllers.put("Worker",new WorkerController());
        controllers.put("WorkerInfo",new WorkerInfoController());
        controllers.put("WorkerSensors",new WorkerSensorsController());


        models.put("Career",new Career());
        models.put("MedicalInsurance",new MedicalInsurance());
        models.put("MedicStatus",new MedicStatus());
        models.put("Position",new Position());
        models.put("Sensors",new Sensors());
        models.put("Transport",new Transport());
        models.put("TransportSensor",new TransportSensors());
        models.put("Worker",new Worker());
        models.put("WorkerInfo",new WorkerInfo());
        models.put("WorkerSensors",new WorkerSensors());
    }

    @Override
    public void print(){
        while (!isQuit) {
            try {
                System.out.println("Type in console key to choose option(key - option):");
                System.out.println(getTables());
                consoleInput = input.nextLine().toUpperCase();
                switch (consoleInput) {
                    case "C" -> printMethodModel("Career");
                    case "MI" -> printMethodModel("MedicalInsurance");
                    case "MS" -> printMethodModel("MedicStatus");
                    case "P" -> printMethodModel("Position");
                    case "S" -> printMethodModel("Sensors");
                    case "T" -> printMethodModel("Transport");
                    case "TS" -> printMethodModel("TransportSensor");
                    case "W" -> printMethodModel("Worker");
                    case "WI" -> printMethodModel("WorkerInfo");
                    case "WS" -> printMethodModel("WorkerSensors");
                    case "Q" -> isQuit = true;
                    default -> System.out.println("invalid input");
                }
            } catch (Exception e) {

                System.out.println(e);
            }
        }
    }

    private void printMethodModel(String table) throws SQLException {
        boolean isBack = false;
        while (!isBack) {
            System.out.println(getMethodModel(table));
            consoleInput = input.nextLine().toUpperCase();
            switch (consoleInput) {
                case "FA" -> printFindAll(controllers.get(table));
                case "FBI" -> printFindById(controllers.get(table));
                case "C" -> createModel(controllers.get(table), models.get(table));
                case "U" -> updateModel(controllers.get(table), models.get(table));
                case "D" -> delete(controllers.get(table));
                case "B" -> isBack = true;
                default -> System.out.println("invalid input");
            }
        }
    }

    private String getTables() {
        StringBuffer str = new  StringBuffer();
        str.append("    C - Career\n");
        str.append("    MI - MedicalInsurance\n");
        str.append("    MS - MedicStatus\n");
        str.append("    S - Sensors\n");
        str.append("    P - Position\n");
        str.append("    T - Transport\n");
        str.append("    W - Worker\n");
        str.append("    WI - WorkerInfo\n");
        str.append("    WS - WorkerSensors\n");
        str.append("    Q - quit\n");
        return str.toString();
    }

    private String getMethodModel(String table) {
        StringBuffer str = new  StringBuffer();
        str.append(table+"\n");
        str.append("    FA - Find All\n");
        str.append("    FBI - Find by id\n");
        str.append("    C - Create\n");
        str.append("    U - Update\n");
        str.append("    D - Delete\n");
        str.append("    B - back\n");
        return str.toString();
    }

    private void printFindAll(GeneralController controller) throws SQLException {
        for (Object a:controller.findAll()) {
            System.out.println(a);
        }
    }

    private void printFindById(GeneralController controller) throws SQLException {
        System.out.println("Print id of model:");
        consoleInput = input.nextLine();
        System.out.println(controller.findById(Integer.parseInt(consoleInput)));
    }

    private void createModel(GeneralController controller, GeneralModel model) throws SQLException {
        controller.create(getModel(model,false));
        System.out.println("Success");
    }

    private void updateModel(GeneralController controller, GeneralModel model) throws SQLException {
        model = getModel(model,true);
        if(model == null){
            System.out.println("Bad input");
        }else {
            controller.update(model);
            System.out.println("Success");
        }
    }

    private GeneralModel getModel(GeneralModel model,boolean isToUpdate){
        try {
            model = model.getClass().getConstructor().newInstance();
            Field[] fields = model.getClass().getDeclaredFields();
            for (Field field: fields) {
                if(field.getName() == "id" && !isToUpdate){
                    continue;
                }
                System.out.println("Print value of " + field.getName() + " type " + field.getAnnotatedType() + ": ");
                consoleInput = input.nextLine();
                field.setAccessible(true);
                switch (field.getAnnotatedType().toString()) {
                    case "java.lang.Integer":
                        field.set(model, Integer.parseInt(consoleInput));
                        break;
                    case "java.lang.String":
                        field.set(model, consoleInput);
                        break;
                    case "java.lang.Float":
                        field.set(model, Float.parseFloat(consoleInput));
                        break;
                    case "java.lang.Double":
                        field.set(model, Double.parseDouble(consoleInput));
                        break;
                    case "com.lab4.model.models.Career":
                        field.set(model, controllers.get("Career").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.lab4.model.models.MedicalInsurance":
                        field.set(model, controllers.get("MedicalInsurance").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.lab4.model.models.MedicStatus":
                        field.set(model, controllers.get("MedicStatus").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.lab4.model.models.Position":
                        field.set(model, controllers.get("Position").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.lab4.model.models.Sensors":
                        field.set(model, controllers.get("Sensors").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.lab4.model.models.Transport":
                        field.set(model, controllers.get("Transport").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.lab4.model.models.TransportSensor":
                        field.set(model, controllers.get("TransportSensor").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.lab4.model.models.Worker":
                        field.set(model, controllers.get("Worker").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.lab4.model.models.WorkerInfo":
                        field.set(model, controllers.get("WorkerInfo").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "com.lab4.model.models.WorkerSensors":
                        field.set(model, controllers.get("WorkerSensors").findById(Integer.parseInt(consoleInput)));
                        break;
                    case "java.sql.Date":
                        field.set(model, Date.valueOf(consoleInput));
                        break;
                    default:
                        break;

                }
            }
            return model;
        }catch (Exception e){
            System.out.println("bad input" + e);
        }
        return null;
    }

    public void delete(GeneralController controller) throws SQLException {
        System.out.println("Print id of model to delete:");
        consoleInput = input.nextLine();
        System.out.println("Success");
        System.out.println(controller.delete(Integer.parseInt(consoleInput)));
    }
}
