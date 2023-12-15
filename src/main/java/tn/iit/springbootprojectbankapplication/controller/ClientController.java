package tn.iit.springbootprojectbankapplication.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.iit.springbootprojectbankapplication.entity.Client;
import tn.iit.springbootprojectbankapplication.entity.Compte;
import tn.iit.springbootprojectbankapplication.service.ClientService;
import tn.iit.springbootprojectbankapplication.service.CompteService;

import java.util.List;
@Controller
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;
    private CompteService compteService;

    @ResponseBody
    @GetMapping("/")
    public List<Client> findAllJson() {
        return clientService.findAll();
    }

    @ResponseBody
    @GetMapping("/{cin}")
    public Client findClientByCin(@PathVariable String cin) {
        return  clientService.findByCin(cin);
    }

    @ResponseBody
    @PostMapping("/")
    public Client createClient(@RequestBody Client client){
        return  clientService.save(client);
    }

    @ResponseBody
    @DeleteMapping("/{cin}")
    public ResponseEntity<Void> delete(@PathVariable String cin) {
        List<Compte> compteClient = compteService.findComptesByClientCin(cin);
        compteClient.stream().map(Compte::getRib).forEach(compteService::delete);
        clientService.delete(cin);
        return ResponseEntity.ok().build();
    }

    @ResponseBody
    @PutMapping("/{cin}")
    public ResponseEntity<Client> edit(@PathVariable String cin, @RequestBody Client client) {
        Client clientResult = clientService.update(cin,client);
        return ResponseEntity.ok().body(clientResult);
    }
}
