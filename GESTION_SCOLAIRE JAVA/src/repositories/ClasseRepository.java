package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entities.Classe;
import entities.Filiere;
import entities.Niveau;

public class ClasseRepository extends Database {
    private static final String SQL_SELECT_BY_ID = null;
    private final String SQL_SELECT_ALL_CLASSE="select * from classe";
    private final String SQL_INSERT_CLASSE="INSERT INTO classe ( filiere, niveau) VALUES (?,?);";
    public List<Classe> selectAllClasse(){
        List<Classe> classes=new ArrayList<>();
       try {
          openConnexion();
          initPreparedStatement(SQL_SELECT_ALL_CLASSE);
          ResultSet rs= executeSelect();
            while (rs.next()) {
               //Une ligne ==> rs de la requete
                Classe classe=new Classe();
                classe.setId(rs.getInt("id_client"));
                int niveau=rs.getInt("niveau");
                int filiere=rs.getInt("filiere");
                classe.setNiveau(Niveau.values()[niveau]);
                classe.setFiliere(Filiere.values()[filiere]);
                classes.add(classe);
            }
            statement.close();
            rs.close();
             closeConnexion();
       } 
       catch (SQLException e) {
         System.out.println("Erreur de Connexion a la BD");
       }
       return classes;
      }
      public Classe insert(Classe classe){
        try {
          openConnexion();
          initPreparedStatement(SQL_INSERT_CLASSE);
          statement.setDouble(1, classe.getFiliere().ordinal());
          statement.setDouble(2, classe.getNiveau().ordinal());
          
          int nbreLigne=executeUpdate();
        } 
         catch (SQLException e) {
          System.out.println("Erreur de Connexion a la BD");
        }
           return classe;
        }
        public Classe selectClasseById(int id){
            Classe classe=null;
            try {
                openConnexion();
                initPreparedStatement(SQL_SELECT_BY_ID);
                statement.setInt(1, id);
                ResultSet rs= executeSelect();
                if (rs.next()) {
                   //Une ligne ==> rs de la requete
                    classe=new Classe();
                    classe.setId(rs.getInt("id"));
                    int niveau=rs.getInt("niveau");
                    int filiere=rs.getInt("filiere");
                    classe.setNiveau(Niveau.values()[niveau]);
                    classe.setFiliere(Filiere.values()[filiere]);
                }
                statement.close();
                rs.close();
                conn.close();
           } 
           catch (SQLException e) {
             System.out.println("Erreur de Connexion a la BD");
           }
               return classe;
          }
    
}
