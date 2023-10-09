package org.anonbnr.design_patterns.oop.creational.abstract_factory.gui_factory;

// Concrete Product A2
public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a Mac button.");
    }
}
