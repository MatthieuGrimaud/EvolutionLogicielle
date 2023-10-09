package com.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;

public class FieldDeclarationVisitor extends ASTVisitor {
	int cpt = 0;

	public boolean visit(FieldDeclaration node) {
		cpt++;
		return super.visit(node);
	}

	public int getCount() {
		return cpt;
	}
}
