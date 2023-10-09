package com.main;

import java.io.File;
import java.util.ArrayList;

import com.analyse.FileAnalyse;
import com.parser.Parser;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<File> javaFiles = Parser.listJavaFilesForFolder(new File(Parser.projectSourcePath));
		FileAnalyse analyses = new FileAnalyse(javaFiles);

		System.out.println("1. Nombre total de classes : " + analyses.nombreTotalClasses(javaFiles));
		System.out.println("2. Nombre total de lignes : " + analyses.nombreTotalLignes(javaFiles));
		System.out.println("3. Nombre total de méthodes : " + analyses.nombreTotalMethodes(javaFiles));
		System.out.println("4. Nombre total de packages : " + analyses.nombreTotalPackages(javaFiles));
		System.out.println(
				"5. Nombre moyen de méthodes par classe : " + analyses.nombreMoyenMethodesParClasse(javaFiles));
		System.out
				.println("6. Nombre moyen de lignes par méthode : " + analyses.nombreMoyenLignesParMethode(javaFiles));
		System.out.println(
				"7. Nombre moyen d'attributs par classe : " + analyses.nombreMoyenAttributsParClasse(javaFiles));
		System.out.println("8. Nombre de méthodes par classe : " + analyses.compterMethodesParClasse(javaFiles));
		System.out.println("8. 10% des classes possédant le plus de méthodes : "
				+ analyses.top10PourcentClassePlusDeMethodes(javaFiles));
		System.out.println("9. Nombre d'attributs par classe : " + analyses.compterAttributsParClasse(javaFiles));
		System.out.println("9. 10% des classes possédant le plus d'attributs : "
				+ analyses.top10PourcentClassePlusAttributs(javaFiles));
		System.out.println("10. Classes faisant partie en même temps des deux catégories précédentes : "
				+ analyses.classesDansLesDeuxCategories(javaFiles));
		System.out
				.println("11. Classes ayant plus de X méthodes : " + analyses.classesAvecPlusDeXMethodes(javaFiles, 2));
		System.out.println("13. Nombre maximal de paramètres par rapport à toutes les méthodes de l'application : "
				+ analyses.nombreMaximalParametres(javaFiles));

	}

}
