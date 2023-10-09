package org.anonbnr.design_patterns.oop.creational.abstract_factory.gui_factory;

// Concrete Factory 2
public class MacGUIFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
