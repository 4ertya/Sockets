package by.epamtc.information_handling.server.bean;

import java.io.Serializable;
import java.util.Objects;

public class SentenceComponent implements Component, Serializable {

    private String word;
    private final static ComponentType COMPONENT_TYPE = ComponentType.SENTENCECOMPONENT;

    public SentenceComponent() {
    }

    public SentenceComponent(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getComponentNumber() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ComponentType getComponentType() {
        return COMPONENT_TYPE;
    }

    @Override
    public String getStringView() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SentenceComponent that = (SentenceComponent) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return "SentenceComponent{" +
                "word= " + word + '\'' +
                '}';
    }
}
