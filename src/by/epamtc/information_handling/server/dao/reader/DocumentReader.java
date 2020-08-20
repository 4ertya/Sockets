package by.epamtc.information_handling.server.dao.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class DocumentReader {
    public String readInfo() {
        FileReader fileReader;

        try {
            fileReader = new FileReader("resources/file.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Stream<String> stream = bufferedReader.lines();
            StringBuilder builder = new StringBuilder();
            stream.forEach(o -> builder.append(o).append("\n"));
            return builder.toString().trim();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
