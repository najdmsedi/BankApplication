package tn.iit.springbootprojectbankapplication.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.iit.springbootprojectbankapplication.dao.ClientDao;
import tn.iit.springbootprojectbankapplication.entity.Client;
import tn.iit.springbootprojectbankapplication.exception.ClientNotFoundException;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientService {
    private final ClientDao clientDao;

    public List<Client> findAll() {
        return clientDao.findAll(Sort.by(Sort.Direction.DESC, "cin"));
    }

    public Client save(Client client) {
        return clientDao.save(client);
    }
    public Client update(String cin, Client updatedClient) {
        Client existingClient  = clientDao.findByCin(cin);
        if (existingClient != null) {
                existingClient.setNom(updatedClient.getNom());
                existingClient.setPrenom(updatedClient.getPrenom());
                clientDao.save(existingClient);
        }
        return existingClient ;
    }




    public void delete(String cin) {
        clientDao.deleteById(cin);
    }

    public Client findByCin(String cin) {
        return clientDao.findById(cin).orElseThrow(()->new ClientNotFoundException("client not found"));
    }

}
