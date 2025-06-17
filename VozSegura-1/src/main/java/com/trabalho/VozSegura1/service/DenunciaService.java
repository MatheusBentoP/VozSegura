package com.trabalho.VozSegura1.Service;

import com.trabalho.VozSegura1.Models.Denuncia;
import com.trabalho.VozSegura1.Repository.IDenunciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenunciaService {

    private final IDenunciaRepository denunciaRepository;

    public DenunciaService(IDenunciaRepository denunciaRepository) {
        this.denunciaRepository = denunciaRepository;
    }

    public Denuncia cadastrarDenuncia(Denuncia denuncia){
        return denunciaRepository.save(denuncia);

    }

    public List<Denuncia> mostrarDenuncia(){
        return denunciaRepository.findAll();
    }

    public Denuncia mostrarPorId(Long id){
        return denunciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrada"));

    }

    public void deletarDenuncia(){
        denunciaRepository.deleteAll();
    }


}
