package com.gui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.analyse.FileAnalyse;
import com.parser.Parser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

public class Interface {

	private JFrame frame;
	private JTextPane resultsArea;
	private JButton chooseProjectButton;
	private String cheminDossierSelectionne;
	private int positionXText;
	private int endPositionOfLastResult;
	private FileAnalyse fileAnalyse = new FileAnalyse();

	public Interface() {
		frame = new JFrame("Analyseur de projet Java");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		resultsArea = new JTextPane();
		resultsArea.setEditable(false);
		resultsArea.setFont(new Font("Arial", Font.PLAIN, 15));

		chooseProjectButton = new JButton("Sélectionner projet...");
		chooseProjectButton.setPreferredSize(new Dimension(200, 40));
		chooseProjectButton.setFont(new Font("Arial", Font.BOLD, 15));
		chooseProjectButton.setForeground(Color.BLACK);
		chooseProjectButton.setBackground(Color.WHITE);
		chooseProjectButton.setUI(new javax.swing.plaf.basic.BasicButtonUI());
		chooseProjectButton.setBorderPainted(false);
		chooseProjectButton.addActionListener(this::chooseProjectActionPerformed);

		JLabel label = new JLabel("Veuillez choisir un projet");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 20));

		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labelPanel.setBackground(frame.getBackground());
		labelPanel.add(label);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(frame.getBackground());
		buttonPanel.add(chooseProjectButton);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.add(labelPanel);
		topPanel.add(buttonPanel);

		topPanel.setBackground(frame.getBackground());

		panel.add(topPanel, BorderLayout.NORTH);
		JScrollPane scrollPaneForResults = new JScrollPane(resultsArea);
		scrollPaneForResults.setBorder(null);
		panel.add(scrollPaneForResults, BorderLayout.CENTER);

		frame.add(panel);
		frame.setVisible(true);
	}

	private void chooseProjectActionPerformed(ActionEvent event) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = chooser.showOpenDialog(frame);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFolder = chooser.getSelectedFile();
			cheminDossierSelectionne = selectedFolder.getPath(); // Stockez le chemin

			analyseFichierChoisi(selectedFolder);
		}
	}

	private void analyseFichierChoisi(File selectedFolder) {
		resultsArea.setText("");
		StyledDocument document = resultsArea.getStyledDocument();

		SimpleAttributeSet centre = new SimpleAttributeSet();
		StyleConstants.setAlignment(centre, StyleConstants.ALIGN_CENTER);

		SimpleAttributeSet bold = new SimpleAttributeSet();
		StyleConstants.setBold(bold, true);

		try {
			document.insertString(document.getLength(), "\nProjet choisi: ", null);
			document.insertString(document.getLength(), selectedFolder.getName() + "\n\n", bold);
			document.setParagraphAttributes(
					document.getLength() - selectedFolder.getName().length() - "Dossier choisi: ".length(),
					selectedFolder.getName().length() + "Dossier choisi: ".length(), centre, false);

			ArrayList<String> analysisResults = fileAnalyse.afficherAnalyse(selectedFolder.getPath());
			for (int i = 0; i < analysisResults.size(); i++) {
				if (i == 10) {

					try {
						String initialText = "11. Classes ayant plus de X méthodes: ";
						document.insertString(document.getLength(), initialText, null);
						positionXText = document.getLength() - initialText.length(); // Définir le début de la position
																						// du texte
						endPositionOfLastResult = document.getLength(); // définir la fin de la position du texte

						JButton inputButton = new JButton("Choisir X");
						inputButton.setFont(new Font("Arial", Font.BOLD, 15));
						inputButton.setForeground(Color.BLACK);
						Color inputButtonColor = Color.decode("#bfc7bd");  // Remplacez #FF5733 par votre code couleur hexa.
						inputButton.setBackground(inputButtonColor);

						inputButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
						document.insertString(document.getLength(), " ", null);
						resultsArea.insertComponent(inputButton);
						document.insertString(document.getLength(), "\n", null);

						inputButton.addActionListener(e -> {
							String inputValue = JOptionPane.showInputDialog(frame, "Entrez la valeur de X:");
							if (inputValue != null && !inputValue.isEmpty()) {
								try {
									int choixX = Integer.parseInt(inputValue);
									ArrayList<File> javaFiles = Parser
											.listJavaFilesForFolder(new File(cheminDossierSelectionne));
									String result = fileAnalyse.classesAvecPlusDeXMethodes(javaFiles, choixX)
											.toString();

									// Retirer le texte initial
									document.remove(positionXText, endPositionOfLastResult - positionXText);
									String newText = "11. Classes ayant plus de " + choixX + " méthodes: ";
									document.insertString(positionXText, newText, null);
									document.insertString(positionXText + newText.length(), result, bold);

									// Mettre à jour les positions pour refléter le changement
									endPositionOfLastResult = positionXText + newText.length() + result.length();

								} catch (NumberFormatException ex) {
									JOptionPane.showMessageDialog(frame, "Veuillez entrer un nombre valide pour X",
											"Erreur", JOptionPane.ERROR_MESSAGE);
								} catch (BadLocationException ex) {
									ex.printStackTrace();
								}
							}
						});

					} catch (BadLocationException ble) {
						System.err.println("Erreur");
					}

				}
				String line = analysisResults.get(i);
				String[] parts = line.split(": ");
				if (parts.length == 2) {
					document.insertString(document.getLength(), parts[0] + ": ", null);
					document.insertString(document.getLength(), parts[1] + "\n", bold);
				} else {
					document.insertString(document.getLength(), line + "\n", null);
				}
			}
		} catch (BadLocationException ble) {
			System.err.println("Erreur");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Interface::new);
	}

}
