package by.epamtc.information_handling.server.bean;

public interface Component {
    void add(Component component);

    void remove(Component component);

    int getComponentNumber();

    ComponentType getComponentType();

    String getStringView();

}
