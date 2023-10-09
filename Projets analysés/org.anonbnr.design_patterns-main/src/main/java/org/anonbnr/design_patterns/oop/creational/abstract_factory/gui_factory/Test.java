package org.anonbnr.design_patterns.oop.creational.abstract_factory.gui_factory;

// Client code
public class Test {
    public static void main(String[] args) {
        GUIFactory factory = new WindowsGUIFactory();
        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();

        button.paint(); // Output: Painting a Windows button.
        checkBox.paint(); // Output: Painting a Windows checkbox.

        factory = new MacGUIFactory();
        button = factory.createButton();
        checkBox = factory.createCheckBox();

        button.paint(); // Output: Painting a Mac button.
        checkBox.paint(); // Output: Painting a Mac checkbox.
    }
}
