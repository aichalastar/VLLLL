import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Classe;
import entities.Etudiant;
import entities.Inscription;
import services.ClasseService;
import services.EtudiantService;
import services.InscriptionService;

public class AttacheView {
    public static void main(String[] args) throws Exception {

        int choix;
        Scanner sc=new Scanner(System.in);
        InscriptionService inscriptionService=new InscriptionService();
        EtudiantService etudiantService=new EtudiantService();
        ClasseService classeService=new ClasseService();
        
       
        do {
            System.out.println("1-Faire une demande d'inscription");
            System.out.println("2-Faire une demande de reinscription");
            System.out.println("3-Quitter");
            choix=sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                System.out.println("Entrer le matricule de l'etudiant");
                String matricule=sc.nextLine();
                Etudiant etudiant  =new Etudiant();
                etudiant= etudiantService.rechercherEtudiantParMatricule(matricule);
                if (etudiant==null) {
                    System.out.println("Etudiant n'existe pas.Veuillez l'inscrire");
                    System.out.println("Entrer le matricule de l'etudiant");
                    matricule=sc.nextLine();
                    System.out.println("Veuillez entrer le nom complet de l'etudiant");
                    String nomComplet=sc.nextLine();
                    System.out.println("Veuillez entrer le tuteur de l'etudiant");
                    String tuteur=sc.nextLine();
                    etudiant =new Etudiant();
                    etudiant.setMatricule(matricule);
                    etudiant.setNomComplet(nomComplet);
                    etudiant.setTuteur(tuteur);
                    etudiantService.ajouterEtudiant(etudiant);

                    
                }else{
                    System.out.println("La matricule existe deja.Reinscrivez l'etudiant");
                }
                Inscription inscription=new Inscription();
                System.out.println("Veuillez choisir l'année");
                String anneeScolaire=sc.nextLine();
                System.out.println("Les classes sont les suivantes");
                List <Classe> classes= classeService.listerClasse();
                for(Classe cl:classes){
                    System.out.println(cl.getId()+""+cl.getNiveau()+""+cl.getFiliere());
                }
                int idClasse=sc.nextInt();
                Classe classe=new Classe();
                classe=classeService.findClasseById(idClasse);
                inscription.setClasse(classe);
                inscription.setAnneeScolaire(anneeScolaire);
                inscription.setEtudiant(etudiant);
                inscriptionService.faireInscription(inscription);
                break;

                case 2:
                System.out.println("Saisir l'année d'inscription");
                anneeScolaire=sc.nextLine();
                List<Inscription>inscriptions=new ArrayList<>();
                for (Inscription insc: inscriptions) {
                    System.out.println("Matricule:"+insc.getEtudiant().getMatricule()+"NomComplet:"+insc.getEtudiant().getNomComplet()+"\n Tuteur: "+insc.getEtudiant().getTuteur());
                    System.out.println("Voulez vous filtrer cette liste par classe");
                    String reponse=sc.nextLine();
                    if (reponse.equalsIgnoreCase("oui")) {
                        System.out.println("les classes sont les suivantes");
                        classes= classeService.listerClasse();
                        for(Classe cl: classes){
                            System.out.println(cl.getId()+".");
                        }
                        
                    }
                }
                  break;
                  case 3:
                    break;





                
            
            }
                    
        }while(choix!=3);
    }
    
}
