package tn.iit.springbootprojectbankapplication.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.iit.springbootprojectbankapplication.dao.CompteDao;
import tn.iit.springbootprojectbankapplication.entity.Compte;
import tn.iit.springbootprojectbankapplication.exception.ClientNotFoundException;

import java.util.List;

@AllArgsConstructor
@Service
public class CompteService {
    private final CompteDao compteDao;
    public List<Compte> findAll() {
        return compteDao.findAll(Sort.by(Sort.Direction.DESC, "rib"));
    }

    public void save(Compte compte) {
        compteDao.save(compte);
    }
    public Compte update(Integer rib,Compte updatedcompte) {
        Compte existingCompte = compteDao.findByRib(rib);
        existingCompte.setSolde(updatedcompte.getSolde());
        compteDao.save(existingCompte);
        return existingCompte;
    }

    public void delete(Integer rib) {
        compteDao.deleteById(rib);
    }

    public List<Compte> findComptesByClientCin(String cin) {
        return  compteDao.findByClientCin(cin).orElseThrow(()->new ClientNotFoundException("account not found"));
    }

}
