package com.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class Parser {

	/*
	 * public final static String projectPath =
	 * "C:\\Users\\ASUS\\ew\\AgenceRESTService"; public final static String
	 * projectSourcePath = projectPath + "\\src"; // Modifiez cela si nécessaire
	 * 
	 * public static ArrayList<File> listJavaFilesForFolder(final File folder) {
	 * ArrayList<File> javaFiles = new ArrayList<>(); for (File fileEntry :
	 * folder.listFiles()) { if (fileEntry.isDirectory()) {
	 * javaFiles.addAll(listJavaFilesForFolder(fileEntry)); } else if
	 * (fileEntry.getName().endsWith(".java")) { javaFiles.add(fileEntry); } }
	 * return javaFiles; }
	 */

	// Récupère tous les fichiers .java dans le répertoire et les sous-répertoires
	public static ArrayList<File> listJavaFilesForFolder(final File folder) {
		ArrayList<File> javaFiles = new ArrayList<>();
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				javaFiles.addAll(listJavaFilesForFolder(fileEntry));
			} else if (fileEntry.getName().endsWith(".java")) {
				javaFiles.add(fileEntry);
			}
		}
		return javaFiles;
	}

	public static CompilationUnit parse(char[] classSource) {
		ASTParser parser = ASTParser.newParser(AST.JLS8); // Par exemple, pour Java 8
		parser.setResolveBindings(false); // désactive la résolution des liaisons
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setBindingsRecovery(false);
		Map options = JavaCore.getOptions();
		parser.setCompilerOptions(options);
		parser.setUnitName("");
		parser.setSource(classSource);
		return (CompilationUnit) parser.createAST(null);
	}
}
