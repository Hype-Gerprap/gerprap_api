package com.hype.gerprap_api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "predio")
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode
@Table(name = "predio")
public class Predio {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Getter
    @Setter
    @Column(name = "nome", nullable = false, length = 65)
    private String nome;
    
    @Getter
    @Setter
    @Column(name = "sigla", nullable = false, length = 5)
    private String sigla; //cond. ed. (condominio, edificio)
    
    @Getter
    @Setter
    @Column(name = "endereco", nullable = false, length = 65)
    private String endereco;

    @Getter
    @Setter
    @Column(name = "cidade", nullable = false, length = 35)
    private String cidade;
    
    @Getter
    @Setter
    @Column(name = "estado", nullable = false, length = 25)
    private String estado;

    @Getter
    @Setter
    //@Column(name = "id_predio", nullable = false)
    @OneToMany(
        mappedBy = "predio",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Apartamento> apartamentos = new ArrayList<>();
 
    public void addApartamento(Apartamento apartamento) {
        apartamentos.add(apartamento);
        apartamento.setPredio(this);
    }
 
    public void removeApartamento(Apartamento apartamento) {
        apartamentos.remove(apartamento);
        apartamento.setPredio(null);
    }

}
