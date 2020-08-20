package by.epamtc.information_handling.server.dao.parsing;

import by.epamtc.information_handling.server.bean.CodeBlock;
import by.epamtc.information_handling.server.bean.Component;
import by.epamtc.information_handling.server.bean.Text;
import by.epamtc.information_handling.server.dao.reader.PropertyReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlockParse implements DataParse {

    private final String blocksRegEx = PropertyReader.getInstance().getProperties().getProperty("blocksRegEx");
    private Pattern pattern = Pattern.compile(blocksRegEx);
    private static BlockParse instance;

    private BlockParse() {
    }

    public static BlockParse getInstance() {
        if (instance == null) {
            instance = new BlockParse();
        }
        return instance;
    }

    @Override
    public void parse(String input, Component textObject) {
        Text text = (Text) textObject;
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String textBlock = matcher.group("Text");
            String codeBLock = matcher.group("Code");

            if (textBlock != null) {
                SentenceParse.getInstance().parse(textBlock, text);
            }

            if (codeBLock != null) {
                text.addCodeBlock(new CodeBlock(codeBLock, text.getComponentNumber()));
                text.increaseComponentNumber();
            }
        }
    }
}
