package com.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.PackageDeclaration;

public class PackageDeclarationVisitor extends ASTVisitor {
	private int cpt = 0;

	public boolean visit(PackageDeclaration node) {
		cpt++;
		return super.visit(node);
	}

	public int getCount() {
		return cpt;
	}

}
