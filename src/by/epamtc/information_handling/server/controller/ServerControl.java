package by.epamtc.information_handling.server.controller;

import by.epamtc.information_handling.server.bean.Text;
import by.epamtc.information_handling.server.dao.DAOFactory;
import by.epamtc.information_handling.server.dao.parsing.BlockParse;
import by.epamtc.information_handling.server.service.TextService;
import by.epamtc.information_handling.server.service.impl.TextServiceImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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


    //        System.out.println("весь текст");
//        System.out.println(text.getStringView());
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

            while (line==null){
                line = objectInputStream.readUTF();
            }
            switch (line) {
                case "1":
                    textService.printSentencesForTheNumberOfWords(text);
                case "2":
                    textService.replaceWordsWithSubstring(text, 3, 4, "AAA");
                case "3":
                    textService.replaceFirstWithLastInSentences(text);
                case "4":
                default:
                    System.out.println("Wrong action!!!");
            }

            objectOutputStream.writeObject(text);
            objectOutputStream.flush();
        }
    }
}
