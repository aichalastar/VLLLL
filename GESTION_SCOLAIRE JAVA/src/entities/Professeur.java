package entities;

public class Professeur {
    private int nci;
    private String nomComplet;
    private Grade grade;
    public int getNci() {
        return nci;
    }
    public void setNci(int nci) {
        this.nci = nci;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    
}
