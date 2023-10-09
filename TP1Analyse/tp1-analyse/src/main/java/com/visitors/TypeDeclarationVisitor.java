package com.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class TypeDeclarationVisitor extends ASTVisitor {
	private int cpt = 0;

	public boolean visit(TypeDeclaration node) {
		if (!node.isInterface()) {
			cpt++;
		}
		return super.visit(node);
	}


	public int getCount() {
		return cpt;
	}

}
