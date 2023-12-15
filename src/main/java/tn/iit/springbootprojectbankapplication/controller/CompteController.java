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
@RequestMapping("/comptes")
@AllArgsConstructor
public class CompteController {

    private CompteService compteService;
    private ClientService clientService;

    @ResponseBody // --> retour de type json
    @GetMapping("/")
    public List<Compte> findAllJson() {
        return compteService.findAll();
    }

    @ResponseBody
    @GetMapping("/{cin}")
    public List<Compte> findComptesByClientCin(@PathVariable String cin) {
        return  compteService.findComptesByClientCin(cin);
    }

    @ResponseBody
    @PostMapping("/")
    public ResponseEntity<Compte> save(@RequestParam(name = "cin") String cin,
                                        @RequestParam(name = "solde") float solde) {
        Client client= clientService.findByCin(cin);
        Compte compte = new Compte(solde,client);
        compteService.save(compte);
        return ResponseEntity.ok().body(compte);
    }
    @ResponseBody
    @DeleteMapping("/{rib}")
    public int delete(@PathVariable Integer rib) {
        try {
            compteService.delete(rib);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @ResponseBody
    @PutMapping("/{rib}")
    public ResponseEntity<Compte> edit(@PathVariable Integer rib, @RequestBody Compte compte) {
        Compte compteResult = compteService.update(rib,compte);
        return ResponseEntity.ok().body(compteResult);
    }



}
