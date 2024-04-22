package services;

import java.util.List;


import entities.Inscription;
import repositories.InscriptionRepository;

public class InscriptionService {
     InscriptionRepository inscriptionRepository=new InscriptionRepository();
    public void faireInscription(Inscription inscription){
        inscriptionRepository.insert(inscription);

    }
    public List<Inscription> listerInscriptionParAnneeScolaire(String anneeScolaire){
        return inscriptionRepository.selectAllInscription(anneeScolaire);
    }
    
}
