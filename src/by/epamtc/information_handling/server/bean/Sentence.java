package by.epamtc.information_handling.server.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence implements Component, Serializable {

    private List<Component> words = new ArrayList<>();
    private String sentence;
    private final static ComponentType COMPONENT_TYPE = ComponentType.SENTENCE;
    private int componentNumber;

    public Sentence() {
    }

    public Sentence(String sentence, int componentNumber) {
        this.sentence = sentence;
        this.componentNumber = componentNumber;
    }

    public String getSentence() {
        return sentence;
    }

    public List<Component> getWords() {
        return words;
    }

    public Component getWord(int index) {
        return words.get(index);
    }

    public int getWordsSize() {
        return words.size();
    }

    @Override
    public void add(Component component) {
        words.add(component);
    }

    @Override
    public void remove(Component component) {
        words.remove(component);
    }

    @Override
    public int getComponentNumber() {
        return componentNumber;
    }

    @Override
    public ComponentType getComponentType() {
        return COMPONENT_TYPE;
    }

    @Override
    public String getStringView() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component word : words) {
            stringBuilder.append(word.getStringView()).append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence1 = (Sentence) o;
        return componentNumber == sentence1.componentNumber &&
                Objects.equals(words, sentence1.words) &&
                Objects.equals(sentence, sentence1.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words, sentence, componentNumber);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "words= " + words +
                ", sentence= " + sentence + '\'' +
                ", componentNumber= " + componentNumber +
                '}';
    }
}
