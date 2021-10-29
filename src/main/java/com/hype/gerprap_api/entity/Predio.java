package com.hype.gerprap_api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "predio")
public class Predio {

    //NO-ID-CONSTRUCTOR
    public Predio(String nome, String sigla, String endereco, String cidade, String estado, List<Apartamento> apartamentos) {
        this.nome = nome;
        this.sigla = sigla;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.apartamentos = apartamentos;
    }

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
    @OneToMany(mappedBy = "predio") //using id_predio unidirectional
    private List<Apartamento> apartamentos;

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", sigla='" + getSigla() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", cidade='" + getCidade() + "'" +
            ", estado='" + getEstado() + "'" +
            ", apartamentos='" + getApartamentos() + "'" +
            "}";
    }

}
