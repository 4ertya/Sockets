package by.epamtc.information_handling.server.main;

import by.epamtc.information_handling.server.controller.ServerControl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerControl serverControl=ServerControl.getInstance();
        serverControl.control();
        }
    }




