package services;

import java.util.ArrayList;

public class Tasks {
    private String title;
    private String description;
    private Status status;

    public Tasks() {
    }

    public Tasks(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = status.PENDING;
    }

    public String getTitle(String add) {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Título: " + title + " | Descrição: " + description + "[ " + status + " ]";
    }

    public static void listarTarefas(ArrayList<Tasks> listTaks) {
        int counter = 1;
        for (Tasks task : listTaks) {
            System.out.println(counter + ". " + task);
            counter++;
        }
    }
}
