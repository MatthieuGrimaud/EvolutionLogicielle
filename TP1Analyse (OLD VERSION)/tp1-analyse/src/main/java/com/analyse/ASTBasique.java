package com.analyse;

import org.eclipse.jdt.core.dom.CompilationUnit;

import com.visitors.FieldDeclarationVisitor;
import com.visitors.MethodDeclarationVisitor;
import com.visitors.PackageDeclarationVisitor;
import com.visitors.TypeDeclarationVisitor;

public class ASTBasique {


	// Méthode qui compte les 'TypeDeclaration' d'un AST
	public static int nbTypeDeclaration(CompilationUnit cu) {
		TypeDeclarationVisitor compteur = new TypeDeclarationVisitor();
		cu.accept(compteur);
		return compteur.getCount();
	}

	// Méthode qui compte les 'MethodDeclaration' d'un AST
	public static int nbMethodDeclaration(CompilationUnit cu) {
		MethodDeclarationVisitor compteur = new MethodDeclarationVisitor();
		cu.accept(compteur);
		return compteur.getCount();
	}

	// Méthode qui compte les 'PackageDeclaration' d'un AST
	public static int nbPackageDeclaration(CompilationUnit cu) {
		PackageDeclarationVisitor compteur = new PackageDeclarationVisitor();
		cu.accept(compteur);
		return compteur.getCount();
	}

	// Méthode qui compte les 'FieldDeclaration' d'un AST
	public static int nbFieldDeclaration(CompilationUnit cu) {
		FieldDeclarationVisitor compteur = new FieldDeclarationVisitor();
		cu.accept(compteur);
		return compteur.getCount();
	}

}
