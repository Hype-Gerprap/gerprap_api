package com.hype.gerprap_api.entity;

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
    public Predio(String nome, String sigla, String endereco, String cidade, String estado) {
        this.nome = nome;
        this.sigla = sigla;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Getter
    @Setter
    @Column(name = "nome", nullable = false, length = 65, unique = true)
    private String nome;
    
    @Getter
    @Setter
    @Column(name = "sigla", nullable = false, length = 5, unique = false)
    private String sigla; //cond. ed. (condominio, edificio)
    
    @Getter
    @Setter
    @Column(name = "endereco", nullable = false, length = 65, unique = false)
    private String endereco;

    @Getter
    @Setter
    @Column(name = "cidade", nullable = false, length = 35, unique = false)
    private String cidade;
    
    @Getter
    @Setter
    @Column(name = "estado", nullable = false, length = 25, unique = false)
    private String estado;

    @OneToMany(mappedBy = "predio", cascade = CascadeType.REMOVE) //using id_predio unidirectional
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
            "}";
    }

}
