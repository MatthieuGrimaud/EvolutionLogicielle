package org.anonbnr.design_patterns.architectural.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * a concrete class that plays the role of a concrete view
 * in the MVC architectural design pattern.<br><br>
 * It provides a view for the Counter model, whose value is displayed
 * in a label within a frame and gets updated automatically upon
 * changing the value of its corresponding model through an associated
 * CounterController
 * @author anonbnr
 * @see Counter
 * @see CounterController
 */
public class CounterView extends View {

	/* ATTRIBUTES */
	private JFrame frame;
	private JLabel label;
	private JButton incrementBtn, decrementBtn;

	/* CONSTRUCTOR */
	public CounterView(Counter model, Controller controller) {
		super(model, controller);

		this.initializeLabel();
		this.initializeFrame();
		this.initializeIncrementButton();
		this.initializeDecrementButton();
	}

	/* METHODS */
	public int getValue() {
		return ((Counter) model).getValue();
	}

	@Override
	public void update(Object how) {
		label.setText(String.valueOf(this.getValue()));
	}

	@Override
	public void open() {

		frame.add(label);

		JPanel panel = new JPanel();
		panel.add(incrementBtn);
		panel.add(decrementBtn);

		frame.add(panel, BorderLayout.SOUTH);
		frame.setVisible(true);
	}

	private void initializeLabel() {
		label = new JLabel(String.valueOf(this.getValue()), JLabel.CENTER);
	}

	private void initializeIncrementButton() {
		incrementBtn = new JButton("increment");
		incrementBtn.addActionListener(controller);
	}

	private void initializeDecrementButton() {
		decrementBtn = new JButton("decrement");
		decrementBtn.addActionListener(controller);
	}

	private void initializeFrame() {
		frame = new JFrame();
		frame.setTitle("Counter View");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}