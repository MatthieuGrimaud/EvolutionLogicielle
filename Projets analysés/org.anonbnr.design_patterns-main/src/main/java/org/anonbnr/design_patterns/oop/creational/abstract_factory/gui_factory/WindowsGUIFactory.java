package org.anonbnr.design_patterns.oop.creational.abstract_factory.gui_factory;

// Concrete Factory 1
public class WindowsGUIFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}