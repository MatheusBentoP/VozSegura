package com.trabalho.VozSegura1.Controller;

import com.trabalho.VozSegura1.Models.Denuncia;
import com.trabalho.VozSegura1.Service.DenunciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    private final DenunciaService denunciaService;

    public DenunciaController(DenunciaService denunciaService) {
        this.denunciaService = denunciaService;
    }

    @PostMapping
    public ResponseEntity<Denuncia> postDenuncia(@RequestBody Denuncia denuncia){
        Denuncia newDenuncia = denunciaService.cadastrarDenuncia(denuncia);
        return ResponseEntity.ok(newDenuncia);
    }

    @GetMapping
    public ResponseEntity<List<Denuncia>> getDenuncia(){
    List<Denuncia> showDenuncia = denunciaService.mostrarDenuncia();
    return ResponseEntity.ok(showDenuncia);

    }

    @GetMapping("/{id}")
    public Denuncia denunciaPorId (@PathVariable Long id){
        return denunciaService.mostrarPorId(id);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarDenuncia(){
        denunciaService.deletarDenuncia();
        return ResponseEntity.noContent().build();
    }


}
