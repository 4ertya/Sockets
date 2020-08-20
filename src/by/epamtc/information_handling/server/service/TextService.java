package by.epamtc.information_handling.server.service;


import by.epamtc.information_handling.server.bean.Text;

public interface TextService {

    void printSentencesForTheNumberOfWords(Text text);

    void replaceWordsWithSubstring(Text text, int sentenceIndex, int wordsLength, String substring);

    void replaceFirstWithLastInSentences(Text text);
}
