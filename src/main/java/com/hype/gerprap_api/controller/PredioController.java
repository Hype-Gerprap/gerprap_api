package com.hype.gerprap_api.controller;

import java.util.List;
import java.util.Optional;

import com.hype.gerprap_api.entity.Predio;
import com.hype.gerprap_api.repository.PredioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/predio")
@CrossOrigin
public class PredioController {
 
    //instanciando o repositório do usuário para usar o banco (JPA-MySql):
    @Autowired
    private PredioRepository predioRepository;

    // find all predios
    @GetMapping("/all-predios")
    public List<Predio> listPredios() {
        return predioRepository.findAll();
    }

    // find predio by id
    @GetMapping("/predio-id={id}")
    public Optional<Predio> selectById(@PathVariable(value = "id") Long id) {
        return predioRepository.findById(id);
    }

    // find predio (podem haver muitos "predios" com o mesmo "nome") by nome
    @GetMapping("/list-predios-nome={nome}")
    public List<Predio> selectByName(@PathVariable(value = "nome") String nome) {
        return predioRepository.findAllByNome(nome);
    }

    // find predio by nome ("nome" deve ser uma "unique key")
    @GetMapping("/predio-nome={nome}")
    public Optional<Predio> selectByNome(@PathVariable(value = "nome") String nome) {
        return predioRepository.findByNome(nome);
    }

    // insert new predio
    @PostMapping("/insert-predio")
    public Predio savePredio(@RequestBody Predio predio){
				Optional<Predio> findByNome = predioRepository.findByNome(predio.getNome());

				if(!findByNome.isPresent()){
					return predioRepository.save(predio);
				}else{
					return new Predio();
				}
    }

    // delete predio (VOID)
    @DeleteMapping("/delete-predio={id}")
    public void deletePredio(@PathVariable Long id){
        predioRepository.deleteById(id);
    }

    // update predio
    @PutMapping("/update-predio={id}")
    public Predio updatePredio(@RequestBody Predio predio){
				return predioRepository.save(predio);
	}

}
