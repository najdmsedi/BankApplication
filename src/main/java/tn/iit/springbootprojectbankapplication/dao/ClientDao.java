package tn.iit.springbootprojectbankapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.springbootprojectbankapplication.entity.Client;


@Repository
public interface ClientDao extends JpaRepository<Client, String> {

    Client findByCin(String cin);
}
