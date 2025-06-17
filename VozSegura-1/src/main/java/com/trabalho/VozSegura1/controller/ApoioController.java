package com.trabalho.VozSegura1.controller;

import com.trabalho.VozSegura1.models.ApoioEmocional;
import com.trabalho.VozSegura1.service.ApoioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apoio")
public class ApoioController {

    private final ApoioService apoioService;

    public ApoioController(ApoioService apoioService) {
        this.apoioService = apoioService;
    }

    @PostMapping
    public ResponseEntity<ApoioEmocional> postApoio(@RequestBody ApoioEmocional apoioEmocional){
     ApoioEmocional newApoio = apoioService.cadastroApoio(apoioEmocional);
        return ResponseEntity.ok(newApoio);
    }

    @GetMapping
    public ResponseEntity<List<ApoioEmocional>> getApoios(){
        List<ApoioEmocional> showApoio = apoioService.mostrar();
        return ResponseEntity.ok(showApoio);
    }

    @GetMapping("/{id}")
    public ApoioEmocional apoioEmocionalPorId(@PathVariable Long id){
        return apoioService.apoioPorId(id);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(){
        apoioService.deletar();
        return ResponseEntity.noContent().build();
    }

}
