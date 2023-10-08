package com.gui;

import javax.swing.*;

import com.main.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class Interface {

	private JFrame frame;
	private JTextArea resultsArea;
	private JButton chooseProjectButton;

	public Interface() {
		frame = new JFrame("Analyseur de projet Java");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		resultsArea = new JTextArea();
		resultsArea.setEditable(false);

		chooseProjectButton = new JButton("Sélectionner projet...");

		// Modifier la taille du bouton
		chooseProjectButton.setPreferredSize(new Dimension(200, 40));

		// Modifier la police et la couleur du texte du bouton
		chooseProjectButton.setFont(new Font("Arial", Font.BOLD, 15));
		chooseProjectButton.setForeground(Color.BLACK); // Changer la couleur du texte
		chooseProjectButton.setBackground(Color.LIGHT_GRAY); // Changer la couleur de fond du bouton

		chooseProjectButton.addActionListener(this::chooseProjectActionPerformed);

		// Ajouter un JLabel au-dessus du bouton
		JLabel label = new JLabel("Veuillez choisir un projet:");
		label.setHorizontalAlignment(JLabel.CENTER); // Centrer le texte dans le JLabel

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.add(label);
		topPanel.add(chooseProjectButton);

		panel.add(topPanel, BorderLayout.NORTH);
		panel.add(new JScrollPane(resultsArea), BorderLayout.CENTER);

		frame.add(panel);
		frame.setVisible(true);
	}

	private void chooseProjectActionPerformed(ActionEvent event) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = chooser.showOpenDialog(frame);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFolder = chooser.getSelectedFile();

			analyzeSelectedFolder(selectedFolder);
			// Vous pouvez appeler vos méthodes d'analyse ici et mettre à jour resultsArea
			// avec les résultats.
			// Par exemple:
			// resultsArea.setText("Analyse en cours...");
			// String analysisResults = analyzeProject(selectedFolder.getPath());
			// resultsArea.setText(analysisResults);
		}
	}

	private void analyzeSelectedFolder(File selectedFolder) {
		resultsArea.setText("Analyse en cours...");
		String analysisResults = Main.analyzeProject(selectedFolder.getPath());
		resultsArea.setText(analysisResults);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Interface::new);
	}

}
