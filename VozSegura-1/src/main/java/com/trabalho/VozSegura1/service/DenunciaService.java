package com.trabalho.VozSegura1.service;

import com.trabalho.VozSegura1.models.Denuncia;
import com.trabalho.VozSegura1.models.Evidencia;
import com.trabalho.VozSegura1.repository.IDenunciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenunciaService {

    private final IDenunciaRepository denunciaRepository;

    public DenunciaService(IDenunciaRepository denunciaRepository) {
        this.denunciaRepository = denunciaRepository;
    }

    public Denuncia cadastrarDenuncia(Denuncia denuncia){
        if (denuncia.getEvidencias() != null) {
            for (Evidencia evidencia : denuncia.getEvidencias()) {
                evidencia.setDenuncia(denuncia); // seta a relação bidirecional
            }
        }
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
