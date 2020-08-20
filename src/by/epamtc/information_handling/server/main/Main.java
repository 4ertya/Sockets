package by.epamtc.information_handling.server.main;

import by.epamtc.information_handling.server.controller.ServerControl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerControl serverControl=ServerControl.getInstance();
        serverControl.control();
        }
    }



//        System.out.println("предложения по возрастанию количества слов");
//        textService.printSentencesForTheNumberOfWords(text);
//
//        System.out.println("заменяет слова заданной длины в предложении подстрокой");
//        textService.replaceWordsWithSubstring(text, 3, 4, "AAA");
//
//        System.out.println("меняет местами первое и последнее слово");
//        textService.replaceFirstWithLastInSentences(text);



