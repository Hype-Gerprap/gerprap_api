package com.hype.gerprap_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name ="apartamento")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "apartamento")
public class Apartamento {

    //NO-ID-CONSTRUCTOR

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Getter
    @Setter
    @Column(name = "codigo", nullable = false, length = 4)
    private String codigo;
    
    @Getter
    @Setter
    @Column(name = "qtd_quartos", nullable = false, length = 1)
    private Integer qtdQuartos; 
    
    @Getter
    @Setter
    @Column(name = "qtd_banheiros", nullable = true, length = 1)
    private Integer qtdBanheiros; 

    @Getter
    @Setter
    @Column(name = "qtd_suites", nullable = true, length = 1)
    private Integer qtdSuites; 
    
    @Getter
    @Setter
    @Column(name = "area_apartamento", nullable = true, length = 1)
    private Double areaApartamento; 
    
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Predio predio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartamento )) return false;
        return id != null && id.equals(((Apartamento) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}