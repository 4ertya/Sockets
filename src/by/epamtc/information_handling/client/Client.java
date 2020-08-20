package by.epamtc.information_handling.client;

import by.epamtc.information_handling.server.bean.Sentence;
import by.epamtc.information_handling.server.bean.Text;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String address = "127.0.0.1";
        int port = 8000;

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket(address, port);

        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        System.out.println("Choose action: ");
        System.out.println("1. Sort Sentences By The Number Of Words");
        System.out.println("2. Replace Words Of The Specified Length With a Substring");
        System.out.println("3. Replace The First Word With The Last Word In Sentences");
        System.out.println("4. No Action Required");

        String line = null;

        while (true) {
            line = input.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
            System.out.println("Sending choice...");
            objectOutputStream.writeUTF(line); // отсылаем введенную строку текста серверу.
            objectOutputStream.flush(); // заставляем поток закончить передачу данных.


            Text text = (Text) objectInputStream.readObject();
            for (Sentence sentence : text.getSentences()) {
                System.out.println(sentence.getStringView());
            }


        }
    }
}

