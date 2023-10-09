package com.analyse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import com.parser.Parser;
import com.visitors.LinesByMethodVisitor;

public class FileAnalyse {
	
	public FileAnalyse() {
	}
	public FileAnalyse(ArrayList<File> javaFiles) {
	}

	// Question 1 : Nombre total de classes
	public int nombreTotalClasses(ArrayList<File> javaFiles) {
		int cptClasses = 0;
		for (File javaFile : javaFiles) {
			String content;
			try {
				content = FileUtils.readFileToString(javaFile, "UTF-8");
				CompilationUnit cu = Parser.parse(content.toCharArray());

				cptClasses += ASTBasique.nbTypeDeclaration(cu);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cptClasses;
	}

	// Question 2 : Nombre total de lignes
	public int nombreTotalLignes(ArrayList<File> javaFiles) {

		int nombreTotalLignes = 0;

		for (File javaFile : javaFiles) {
			try {
				List<String> lines = FileUtils.readLines(javaFile, "UTF-8");
				nombreTotalLignes += lines.size();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return nombreTotalLignes;
	}

	// Question 3 : Nombre total de méthodes
	public int nombreTotalMethodes(ArrayList<File> javaFiles) {
		int cptMethodes = 0;

		for (File javaFile : javaFiles) {
			String content;
			try {
				content = FileUtils.readFileToString(javaFile, "UTF-8");
				CompilationUnit cu = Parser.parse(content.toCharArray());

				cptMethodes += ASTBasique.nbMethodDeclaration(cu);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return cptMethodes;
	}

	// Question 4: Nombre de packages
	public int nombreTotalPackages(ArrayList<File> javaFiles) {
		final Set<String> uniquePackages = new HashSet<>();
		for (File javaFile : javaFiles) {
			String content;
			try {
				content = FileUtils.readFileToString(javaFile, "UTF-8");
				CompilationUnit cu = Parser.parse(content.toCharArray());

				cu.accept(new ASTVisitor() {
					public boolean visit(PackageDeclaration node) {
						uniquePackages.add(node.getName().getFullyQualifiedName());
						return super.visit(node);
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return uniquePackages.size();
	}

	// Question 5: Nombre moyen de méthodes par classe
	public float nombreMoyenMethodesParClasse(ArrayList<File> javaFiles) {
		int nbClasses = nombreTotalClasses(javaFiles);
		int nbMethodes = nombreTotalMethodes(javaFiles);

		float nbMoyen = nbMethodes / nbClasses;

		return nbMoyen;
	}

	// Question 6 : Méthode qui compte les lignes de code à l'intérieur des méthodes
	// d'un AST
	public static int nblignesParMethodes(CompilationUnit cu, final String content) {
		LinesByMethodVisitor compteur = new LinesByMethodVisitor(content);
		cu.accept(compteur);
		return compteur.getCount();
	}

	// Question 6 : Méthode qui renvoie le nombre total de lignes à l'intérieur des
	// méthodes
	public int nombreTotalLignesDansMethodes(ArrayList<File> javaFiles) {
		int cptLignes = 0;

		for (File javaFile : javaFiles) {
			String content;
			try {
				content = FileUtils.readFileToString(javaFile, "UTF-8");
				CompilationUnit cu = Parser.parse(content.toCharArray());

				cptLignes += nblignesParMethodes(cu, content);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return cptLignes;
	}

	// Question 6: Nombre moyen de lignes de code par méthode
	public float nombreMoyenLignesParMethode(ArrayList<File> javaFiles) {
		int nbLignesMethodes = nombreTotalLignesDansMethodes(javaFiles);
		int nbMethodes = nombreTotalMethodes(javaFiles);

		float nbMoyenLignes = nbLignesMethodes / nbMethodes;

		return nbMoyenLignes;
	}

	// Question 7: Méthode qui compte le nombre total d'attributs dans tous les
	// fichiers Java
	public int nombreTotalAttributs(ArrayList<File> javaFiles) {
		int cptAttributs = 0;

		for (File javaFile : javaFiles) {
			String content;
			try {
				content = FileUtils.readFileToString(javaFile, "UTF-8");
				CompilationUnit cu = Parser.parse(content.toCharArray());
				
				cptAttributs += ASTBasique.nbFieldDeclaration(cu);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return cptAttributs;
	}

	// Question 7: Nombre moyen d'attributs par classe
	public float nombreMoyenAttributsParClasse(ArrayList<File> javaFiles) {
		int nbAttributs = nombreTotalAttributs(javaFiles);
		int nbClasses = nombreTotalClasses(javaFiles);

		float nbMoyenLignes = nbAttributs / nbClasses;

		return nbMoyenLignes;
	}

	// Compte le nombre de méthodes par classe et renvoie -> nom classe + nb
	// methodes
	public Map<String, Integer> compterMethodesParClasse(ArrayList<File> javaFiles) {
		final Map<String, Integer> methodesParClasse = new HashMap<>();

		for (File javaFile : javaFiles) {
			String content;
			try {
				content = FileUtils.readFileToString(javaFile, "UTF-8");
				CompilationUnit cu = Parser.parse(content.toCharArray());
				cu.accept(new ASTVisitor() {
					public boolean visit(TypeDeclaration node) {
						String nomClasse = node.getName().getFullyQualifiedName();
						MethodDeclaration[] methodes = node.getMethods();
						methodesParClasse.put(nomClasse, methodes.length);
						return super.visit(node);
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return methodesParClasse;
	}

	// Question 8 : Les 10% des classes qui possèdent le plus grand nombre de
	// méthodes
	public List<String> top10PourcentClassePlusDeMethodes(ArrayList<File> javaFiles) {
		Map<String, Integer> methodesParClasse = compterMethodesParClasse(javaFiles);

		List<Map.Entry<String, Integer>> entries = new ArrayList<>(methodesParClasse.entrySet());

		Collections.sort(entries, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

		// Récupère le 10% supérieur
		int taille10Pourcent = (int) (entries.size() * 0.10);
		return entries.subList(0, taille10Pourcent).stream().map(e -> e.getKey()).collect(Collectors.toList());
	}

	// Compte le nombre d'attributs par classe et renvoie -> nom classe + nb
	// attributs
	public Map<String, Integer> compterAttributsParClasse(ArrayList<File> javaFiles) {
		final Map<String, Integer> attributsParClasse = new HashMap<>();

		for (File javaFile : javaFiles) {
			String content;
			try {
				content = FileUtils.readFileToString(javaFile, "UTF-8");
				CompilationUnit cu = Parser.parse(content.toCharArray());
				cu.accept(new ASTVisitor() {
					public boolean visit(TypeDeclaration node) {
						String nomClasse = node.getName().getFullyQualifiedName();
						FieldDeclaration[] attributs = node.getFields();
						attributsParClasse.put(nomClasse, attributs.length);
						return super.visit(node);
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return attributsParClasse;
	}

	// Question 9 : Les 10% des classes qui possèdent le plus grand nombre
	// d'attributs
	public List<String> top10PourcentClassePlusAttributs(ArrayList<File> javaFiles) {
		Map<String, Integer> attributsParClasse = compterAttributsParClasse(javaFiles);

		List<Map.Entry<String, Integer>> entries = new ArrayList<>(attributsParClasse.entrySet());

		Collections.sort(entries, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

		// Récupère le 10% supérieur
		int taille10Pourcent = (int) (entries.size() * 0.10);
		return entries.subList(0, taille10Pourcent).stream().map(e -> e.getKey()).collect(Collectors.toList());
	}

	// Question 10 : Classes faisant partie des deux catégories précédentes
	public List<String> classesDansLesDeuxCategories(ArrayList<File> javaFiles) {
		List<String> topClassesMethodes = top10PourcentClassePlusDeMethodes(javaFiles);
		List<String> topClassesAttributs = top10PourcentClassePlusAttributs(javaFiles);

		topClassesMethodes.retainAll(topClassesAttributs);

		return topClassesMethodes;
	}

	// Question 11 : Classes qui possèdent plus de X méthodes
	public List<String> classesAvecPlusDeXMethodes(ArrayList<File> javaFiles, int X) {
		List<String> classes = new ArrayList<>();

		for (File javaFile : javaFiles) {
			try {
				String content = FileUtils.readFileToString(javaFile, "UTF-8");
				CompilationUnit cu = Parser.parse(content.toCharArray());

				cu.accept(new ASTVisitor() {
					public boolean visit(TypeDeclaration node) {
						int nbmethodes = node.getMethods().length;
						if (nbmethodes > X) {
							classes.add(node.getName().getFullyQualifiedName());
						}
						return super.visit(node);
					}
				});

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return classes;
	}

	// Question 13 : Le nombre maximal de paramètres par rapport à toutes les
	// m"thodes de l'application
	public int nombreMaximalParametres(ArrayList<File> javaFiles) {
		int[] maxParametres = { 0 };

		for (File javaFile : javaFiles) {
			try {
				String content = FileUtils.readFileToString(javaFile, "UTF-8");
				CompilationUnit cu = Parser.parse(content.toCharArray());
				cu.accept(new ASTVisitor() {
					public boolean visit(MethodDeclaration node) {
						int nombreParametres = node.parameters().size();
						if (nombreParametres > maxParametres[0]) {
							maxParametres[0] = nombreParametres;
						}
						return super.visit(node);
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return maxParametres[0];
	}
	
	/*public String afficherAnalyse(String projectSourcePath) {
        StringBuilder results = new StringBuilder();

        ArrayList<File> javaFiles = Parser.listJavaFilesForFolder(new File(projectSourcePath));
        results.append("1. Nombre total de classes : ").append(nombreTotalClasses(javaFiles)).append("\n\n");
        results.append("2. Nombre total de lignes : ").append(nombreTotalLignes(javaFiles)).append("\n\n");
        results.append("3. Nombre total de méthodes : " + nombreTotalMethodes(javaFiles)).append("\n\n");;
        results.append("4. Nombre total de packages : " + nombreTotalPackages(javaFiles)).append("\n\n");;
        results.append("5. Nombre moyen de méthodes par classe : " + nombreMoyenMethodesParClasse(javaFiles)).append("\n\n");;
        results.append("6. Nombre moyen de lignes par méthode : " + nombreMoyenLignesParMethode(javaFiles)).append("\n\n");;
        results.append("7. Nombre moyen d'attributs par classe : " + nombreMoyenAttributsParClasse(javaFiles)).append("\n\n");;
        results.append("8. 10% des classes possédant le plus de méthodes : " + top10PourcentClassePlusDeMethodes(javaFiles)).append("\n\n");;
        results.append("9. 10% des classes possédant le plus d'attributs : " + top10PourcentClassePlusAttributs(javaFiles)).append("\n\n");;
        results.append("10. Classes faisant partie en même temps des deux catégories précédentes : " + classesDansLesDeuxCategories(javaFiles)).append("\n\n");;
        results.append("13. Nombre maximal de paramètres par rapport à toutes les méthodes de l'application : "+ nombreMaximalParametres(javaFiles)).append("\n\n");;
       

        return results.toString();
    }*/
	
	// Dans FileAnalyse
	public ArrayList<String> afficherAnalyse(String projectSourcePath) {
	    ArrayList<String> results = new ArrayList<>();
	    ArrayList<File> javaFiles = Parser.listJavaFilesForFolder(new File(projectSourcePath));
	    
	    results.add("1. Nombre total de classes : " + nombreTotalClasses(javaFiles) + "\n\n");
        results.add("2. Nombre total de lignes : " + nombreTotalLignes(javaFiles) + "\n\n");
        results.add("3. Nombre total de méthodes : " + nombreTotalMethodes(javaFiles) +"\n\n");;
        results.add("4. Nombre total de packages : " + nombreTotalPackages(javaFiles) + "\n\n");;
        results.add("5. Nombre moyen de méthodes par classe : " + nombreMoyenMethodesParClasse(javaFiles) + "\n\n");;
        results.add("6. Nombre moyen de lignes par méthode : " + nombreMoyenLignesParMethode(javaFiles) + "\n\n");;
        results.add("7. Nombre moyen d'attributs par classe : " + nombreMoyenAttributsParClasse(javaFiles) + "\n\n");;
        results.add("8. 10% des classes possédant le plus de méthodes : " + top10PourcentClassePlusDeMethodes(javaFiles) + "\n\n");
        results.add("9. 10% des classes possédant le plus d'attributs : " + top10PourcentClassePlusAttributs(javaFiles) + "\n\n");
        results.add("10. Classes faisant partie en même temps des deux catégories précédentes : " + classesDansLesDeuxCategories(javaFiles) + "\n\n");
        results.add("\n13. Nombre maximal de paramètres par rapport à toutes les méthodes de l'application : "+ nombreMaximalParametres(javaFiles) + "\n\n");
	    return results;
	}

}
