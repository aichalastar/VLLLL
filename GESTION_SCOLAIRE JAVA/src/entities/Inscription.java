package entities;



public class Inscription {
    private int id;
    private String AnneeScolaire; 
    Etudiant etudiant;
    Classe classe;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAnneeScolaire() {
        return AnneeScolaire;
    }
    public void setAnneeScolaire(String anneeScolaire) {
        AnneeScolaire = anneeScolaire;
    }
    public Etudiant getEtudiant() {
        return etudiant;
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    }
    
    

