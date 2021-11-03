package com.hype.gerprap_api.controller;

import java.util.List;
import java.util.Optional;

import com.hype.gerprap_api.entity.Apartamento;
import com.hype.gerprap_api.repository.ApartamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apartamento")
@CrossOrigin
public class ApartamentoController {

    //instanciando o repositório do usuário para usar o banco (JPA-MySql):
    @Autowired
    private ApartamentoRepository apartamentoRepository;

    // find all apartamentos
    @GetMapping("/all-apartamentos")
    public List<Apartamento> listApartamentos() {
        return apartamentoRepository.findAll();
    }

    // find apartamento by id
    @GetMapping("/apartamento-id={id}")
    public Optional<Apartamento> selectById(@PathVariable(value = "id") Long id) {
        return apartamentoRepository.findById(id);
    }

    // find apartamento (podem haver muitos "apartamentos" com o mesmo "codigo") by codigo
    @GetMapping("/list-apartamentos-codigo={codigo}")
    public List<Apartamento> selectByName(@PathVariable(value = "codigo") String codigo) {
        return apartamentoRepository.findAllByCodigo(codigo);
    }

    // find apartamento by codigo ("codigo" deve ser uma "unique key")
    @GetMapping("/apartamento-codigo={codigo}")
    public Optional<Apartamento> selectByCodigo(@PathVariable(value = "codigo") String codigo) {
        return apartamentoRepository.findByCodigo(codigo);
    }

    // insert new apartamento
    @PostMapping("/insert-apartamento")
    public Apartamento saveApartamento(@RequestBody Apartamento apartamento){
				Optional<Apartamento> findByCodigo = apartamentoRepository.findByCodigo(apartamento.getCodigo());

				if(findByCodigo.isEmpty()){
					return apartamentoRepository.save(apartamento);
				}else{
					return new Apartamento();
				}
    }

    // delete apartamento (VOID)
    @DeleteMapping("/delete-apartamento={id}")
    public void deleteApartamento(@PathVariable Long id){
        apartamentoRepository.deleteById(id);
    }

    // update apartamento
    @PutMapping("/update-apartamento={id}")
    public Apartamento updateApartamento(@RequestBody Apartamento apartamento){
				return apartamentoRepository.save(apartamento);
	}


}
