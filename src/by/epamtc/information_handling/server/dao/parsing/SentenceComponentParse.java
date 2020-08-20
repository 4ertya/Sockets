package by.epamtc.information_handling.server.dao.parsing;

import by.epamtc.information_handling.server.bean.Component;
import by.epamtc.information_handling.server.bean.SentenceComponent;
import by.epamtc.information_handling.server.dao.reader.PropertyReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceComponentParse implements DataParse {
    private static SentenceComponentParse instance;
    private final String sentenceComponentRegEx = PropertyReader.getInstance().getProperties()
            .getProperty("sentenceComponentRegEx");
    private Pattern pattern = Pattern.compile(sentenceComponentRegEx);

    public static SentenceComponentParse getInstance() {
        if (instance == null) {
            instance = new SentenceComponentParse();
        }
        return instance;
    }

    @Override
    public void parse(String input, Component sentenceObject) {
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.group() != null) {
                sentenceObject.add(new SentenceComponent(matcher.group().trim()));
            }
        }
    }
}
