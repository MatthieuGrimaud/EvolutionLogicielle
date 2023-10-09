package com.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class LinesByMethodVisitor extends ASTVisitor {
	int cptLignes = 0;
	private final String content;

	public LinesByMethodVisitor(String content) {
		this.content = content;
	}

	public boolean visit(MethodDeclaration node) {
		int debMethode = node.getStartPosition();
		int finMethode = debMethode + node.getLength();

		String blocMethode = content.substring(debMethode, finMethode);
		String[] lignes = blocMethode.split("\n");

		cptLignes += lignes.length;

		return super.visit(node);
	}

	public int getCount() {
		return cptLignes;
	}
}
