package exemple;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    public static void main(String[] args) {
        Auteur auteur1 = new Auteur("J.K. Rowling");
        Livre livre1 = new Livre("Harry Potter à l'école des sorciers", auteur1);

        Auteur auteur2 = new Auteur("J.R.R. Tolkien");
        Livre livre2 = new Livre("Le Seigneur des Anneaux", auteur2);

        Etagere etagere = new Etagere();
        etagere.ajouterLivre(livre1);
        etagere.ajouterLivre(livre2);

        etagere.afficherLivres();
    }
}

class Auteur {
    private String nom;

    public Auteur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

class Livre {
    private String titre;
    private Auteur auteur;

    public Livre(String titre, Auteur auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Auteur getAuteur() {
        return this.auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public String afficherDetails() {
        return "\"" + this.titre + "\" par " + this.auteur.getNom();
    }
}

class Etagere {
    private List<Livre> livres = new ArrayList<>();

    public void ajouterLivre(Livre livre) {
        this.livres.add(livre);
    }

    public void supprimerLivre(Livre livre) {
        this.livres.remove(livre);
    }

    public void afficherLivres() {
        for (Livre livre : livres) {
            System.out.println(livre.afficherDetails());
        }
    }
}
