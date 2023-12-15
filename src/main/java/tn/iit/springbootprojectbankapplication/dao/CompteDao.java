package tn.iit.springbootprojectbankapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.springbootprojectbankapplication.entity.Client;
import tn.iit.springbootprojectbankapplication.entity.Compte;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompteDao extends JpaRepository<Compte, Integer> {

    List<Compte> findByClient(Client client);

    Compte findByRib(Integer rib);

    Optional<List<Compte>> findByClientCin(String cin);
}
