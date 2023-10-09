package org.anonbnr.design_patterns.oop.creational.abstract_factory.gui_factory;

// Concrete Product B2
public class MacCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("Painting a Mac checkbox.");
    }
}
