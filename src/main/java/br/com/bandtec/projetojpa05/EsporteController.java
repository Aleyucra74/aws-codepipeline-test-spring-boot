package br.com.bandtec.projetojpa05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/esportes")
public class EsporteController {

    @Autowired
    private EsporteRepository repository;

    @Autowired
    private CategoriaEsporteRepository categoriaEsporteRepository;

    @GetMapping
    public ResponseEntity getEsportes(){
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity postEsporte(@RequestBody Esporte novoEsporte){
        if(categoriaEsporteRepository.existsById(novoEsporte.getCategoria().getId())){
            repository.save(novoEsporte);
            return ResponseEntity.status(201).build();
        }else {
            return ResponseEntity.status(400).body("nao existe");
        }
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity getEsportePorCategoria(@PathVariable Integer idCategoria){
        return ResponseEntity.status(200).body(repository.findByCategoriaId(idCategoria));
    }



}
