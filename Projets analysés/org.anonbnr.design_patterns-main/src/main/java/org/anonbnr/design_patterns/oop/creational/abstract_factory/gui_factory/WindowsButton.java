package org.anonbnr.design_patterns.oop.creational.abstract_factory.gui_factory;

// Concrete Product A1
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a Windows button.");
    }
}