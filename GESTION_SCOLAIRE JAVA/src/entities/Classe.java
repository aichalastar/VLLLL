
package entities;

import java.util.List;

public class Classe {
    private int id;
    private String libelle;
    Filiere filiere;
    Niveau niveau;
    List<Inscription> inscription;
    public List<Inscription> getInscription(){
        return inscription;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public Filiere getFiliere() {
        return filiere;
    }
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    public Niveau getNiveau() {
        return niveau;
    }
    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
     
    
}
