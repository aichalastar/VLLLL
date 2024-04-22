package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Client;

import entities.Etudiant;
import entities.Inscription;

public class InscriptionRepository extends Database  {
    private final String SQL_INSERT="INSERT INTO inscription ( id_in, annee_in, matricule_et, id_classe) VALUES (?,?,?,?);";
    
  
    public void insert(Inscription inscription){
        try {
             openConnexion();
             initPreparedStatement(SQL_INSERT);
             statement.setInt(1,inscription.getId());
             statement.setString(2,inscription.getAnneeScolaire());
             statement.setString(3,inscription.getEtudiant().getMatricule());
             statement.setInt(4,inscription.getClasse().getId());
             executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Inscription> selectAllInscription(String anneeScolaire){
         List<Inscription> inscriptions=new ArrayList<>();
        try {
          openConnexion();
          initPreparedStatement(SQL_SELECT_ALL);
          statement.setString(1, anneeScolaire);
          ResultSet rs= executeSelect();
            while (rs.next()) {
               //Une ligne ==> rs de la requete
                Inscription inscription=new Inscription();
                inscription.setId(rs.getInt("id"));
                inscription.setAnneeScolaire(rs.getString("anneeScolaire"));
                Etudiant etudiant=new Etudiant();
                etudiant.setMatricule(rs.getString("matricule"));
                etudiant.setNomComplet(rs.getString("nomComplet"));
                etudiant.setTuteur(rs.getString("Tuteur"));
                inscription.setEtudiant(etudiant);
                inscriptions.add(inscription);
                
            }
            statement.close();
            rs.close();
             closeConnexion();
       } 
       catch (SQLException e) {
         System.out.println("Erreur de Connexion a la BD");
       }
       return inscriptions;
      }
    
}
