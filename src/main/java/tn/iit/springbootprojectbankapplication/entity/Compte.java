package tn.iit.springbootprojectbankapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "t_compte")
public class Compte implements Serializable {
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rib;
    private float solde;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    public Compte(float solde, Client client) {
        super();
        this.solde = solde;
        this.client = client;
    }
}
