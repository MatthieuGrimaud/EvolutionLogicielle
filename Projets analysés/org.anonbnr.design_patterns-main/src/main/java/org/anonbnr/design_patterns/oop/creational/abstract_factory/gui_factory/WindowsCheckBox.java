package org.anonbnr.design_patterns.oop.creational.abstract_factory.gui_factory;

// Concrete Product B1
public class WindowsCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("Painting a Windows checkbox.");
    }
}
