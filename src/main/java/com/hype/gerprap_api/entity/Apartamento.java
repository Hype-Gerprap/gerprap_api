package com.hype.gerprap_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "apartamento")
public class Apartamento {

    //NO-ID-CONSTRUCTOR
    public Apartamento(String codigo, Integer qtdQuartos, Integer qtdBanheiros, Integer qtdSuites, Double areaApartamento, Predio predio){
        this.codigo = codigo;
        this.qtdQuartos = qtdQuartos;
        this.qtdBanheiros = qtdBanheiros;
        this.qtdSuites = qtdSuites;
        this.areaApartamento = areaApartamento;
        this.predio = predio;
    }
    
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Getter
    @Setter
    @Column(name = "codigo", nullable = false, length = 4, unique = true)
    private String codigo;
    
    @Getter
    @Setter
    @Column(name = "qtd_quartos", nullable = false, length = 1, unique = false)
    private Integer qtdQuartos; 
    
    @Getter
    @Setter
    @Column(name = "qtd_banheiros", nullable = true, length = 1, unique = false)
    private Integer qtdBanheiros; 

    @Getter
    @Setter
    @Column(name = "qtd_suites", nullable = true, length = 1, unique = false)
    private Integer qtdSuites; 
    
    @Getter
    @Setter
    @Column(name = "area_apartamento", nullable = true, length = 8, unique = false)
    private Double areaApartamento; 

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_predio", nullable = false, unique = false)
    private Predio predio;
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", codigo='" + getCodigo() + "'" +
            ", qtdQuartos='" + getQtdQuartos() + "'" +
            ", qtdBanheiros='" + getQtdBanheiros() + "'" +
            ", qtdSuites='" + getQtdSuites() + "'" +
            ", areaApartamento='" + getAreaApartamento() + "'" +
            ", predio='" + getPredio() + "'" +
            "}";
    }

    

}
