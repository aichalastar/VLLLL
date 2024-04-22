import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       int choix;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("1-Creer les classes");
            System.out.println("2-Lister les classes");
            System.out.println("3-Ajouter des professeurs");
            System.out.println("4-Affecter des classes aux professeurs");
            System.out.println("5-Lister les professeurs");
            System.out.println("6-Filtrer les classes d'un professeur");
            System.out.println("7-Lister les étudiants inscrits dans une année");
            System.out.println("8-Filtrer cette liste par classe");
            System.out.println("9-Quitter");
            choix=sc.nextInt();
             sc.nextLine();
             switch (choix){
                
                
             }
        } while (choix!=9);
    }
    }

