package by.epamtc.information_handling.server.dao.impl;

import by.epamtc.information_handling.server.dao.TextDAO;
import by.epamtc.information_handling.server.dao.parsing.BlockParse;
import by.epamtc.information_handling.server.dao.reader.DocumentReader;
import by.epamtc.information_handling.server.bean.Text;

public class TxtTextDAOImpl implements TextDAO {
    @Override
    public Text getTextObject() {
        Text text = new Text();
        DocumentReader documentReader = new DocumentReader();

        String input = documentReader.readInfo();
        BlockParse.getInstance().parse(input, text);

        return text;
    }
}
