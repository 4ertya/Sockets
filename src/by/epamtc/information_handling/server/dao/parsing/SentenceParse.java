package by.epamtc.information_handling.server.dao.parsing;

import by.epamtc.information_handling.server.bean.Component;
import by.epamtc.information_handling.server.bean.Sentence;
import by.epamtc.information_handling.server.bean.Text;
import by.epamtc.information_handling.server.dao.reader.PropertyReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParse implements DataParse {
    private final String sentenceRegEx = PropertyReader.getInstance().getProperties().getProperty("sentenceRegEx");
    private static SentenceParse instance;
    Pattern sentencePattern = Pattern.compile(sentenceRegEx);

    private SentenceParse() {
    }

    public static SentenceParse getInstance() {
        if (instance == null) {
            instance = new SentenceParse();
        }
        return instance;
    }

    @Override
    public void parse(String input, Component textObject) {
        Text text = (Text) textObject;
        Matcher matcher = sentencePattern.matcher(input);
        while (matcher.find()) {
            String str = matcher.group().trim();
            Sentence sentence = new Sentence(str, text.getComponentNumber());
            SentenceComponentParse.getInstance().parse(str, sentence);
            text.addSentence(sentence);
            text.increaseComponentNumber();
        }
    }
}
