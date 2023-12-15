package tn.iit.springbootprojectbankapplication;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.iit.springbootprojectbankapplication.dao.ClientDao;
import tn.iit.springbootprojectbankapplication.dao.CompteDao;
import tn.iit.springbootprojectbankapplication.entity.Client;
import tn.iit.springbootprojectbankapplication.entity.Compte;

@SpringBootApplication
public class SpringBootProjectBankApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectBankApplication.class, args);

    }

}