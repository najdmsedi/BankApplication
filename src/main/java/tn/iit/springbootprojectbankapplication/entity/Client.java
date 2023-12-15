package tn.iit.springbootprojectbankapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "t_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @Column(length = 10)
    private String cin;
    private String nom;
    private String prenom;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy="client")
    private List<Compte> comptes;


}
