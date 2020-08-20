package by.epamtc.information_handling.server.bean;

import java.io.Serializable;
import java.util.Objects;

public class CodeBlock implements Component, Serializable {

    private String codeBlock;
    private final static ComponentType COMPONENT_TYPE = ComponentType.CODEBLOCK;
    private int componentNumber;

    public CodeBlock() {
    }

    public CodeBlock(String codeBlock, int componentNumber) {
        this.codeBlock = codeBlock;
        this.componentNumber = componentNumber;
    }

    public String getCodeBlock() {
        return codeBlock;
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
        return componentNumber;
    }

    @Override
    public ComponentType getComponentType() {
        return COMPONENT_TYPE;
    }

    @Override
    public String getStringView() {
        return codeBlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeBlock codeBlock1 = (CodeBlock) o;
        return componentNumber == codeBlock1.componentNumber &&
                Objects.equals(codeBlock, codeBlock1.codeBlock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeBlock, componentNumber);
    }

    @Override
    public String toString() {
        return "CodeBlock{" +
                "codeBlock= " + codeBlock + '\'' +
                ", componentNumber= " + componentNumber +
                '}';
    }
}
