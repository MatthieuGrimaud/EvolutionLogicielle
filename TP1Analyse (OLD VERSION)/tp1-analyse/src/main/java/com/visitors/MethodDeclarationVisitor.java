package com.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class MethodDeclarationVisitor extends ASTVisitor {
	private int cpt = 0;

	public boolean visit(MethodDeclaration node) {
		cpt++;
		return super.visit(node);
	}
	

	public int getCount() {
		return cpt;
	}
	



}
