package by.epamtc.information_handling.server.controller;

import by.epamtc.information_handling.client.Client;
import by.epamtc.information_handling.server.bean.Text;
import by.epamtc.information_handling.server.dao.DAOFactory;
import by.epamtc.information_handling.server.dao.parsing.BlockParse;
import by.epamtc.information_handling.server.service.TextService;
import by.epamtc.information_handling.server.service.impl.TextServiceImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerControl {

    private static ServerControl instance;
    private DAOFactory daoFactory = DAOFactory.getInstance();
    private TextService textService = new TextServiceImpl();
    private static final int port = 8000;
    ServerSocket serverSocket = new ServerSocket(port);

    public ServerControl() throws IOException {
    }

    public static ServerControl getInstance() throws IOException {
        if (instance == null) {
            instance = new ServerControl();
        }
        return instance;
    }

    public void control() throws IOException {

        while (true) {
            System.out.println("Waiting...");
            Socket clientSocket = serverSocket.accept();

            System.out.println("Creating empty object for user...");
            Text text = daoFactory.getTxtTextDAO().getTextObject();

            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            String line = null;

            line = objectInputStream.readUTF();

            System.out.println("выбор: " + line);

            switch (line) {
                case "1":
                    textService.printSentencesForTheNumberOfWords(text);
                    break;
                case "2":
                    textService.replaceWordsWithSubstring(text, 3, 4, "AAA");
                    break;
                case "3":
                    textService.replaceFirstWithLastInSentences(text);
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Wrong action!!!");
            }

            objectOutputStream.writeObject(text);
            objectOutputStream.flush();

        }
    }
}
