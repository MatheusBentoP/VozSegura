package com.trabalho.VozSegura1.service;

import com.trabalho.VozSegura1.models.ApoioEmocional;
import com.trabalho.VozSegura1.repository.IApoioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApoioService {

    private final IApoioRepository apoioRepository;

    public ApoioService(IApoioRepository apoioRepository) {
        this.apoioRepository = apoioRepository;
    }

    public ApoioEmocional cadastroApoio(ApoioEmocional apoioEmocional) {
        return apoioRepository.save(apoioEmocional);
    }

    public List<ApoioEmocional> mostrar() {
        return apoioRepository.findAll();
    }


    public ApoioEmocional apoioPorId(Long id) {
        return apoioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrada"));
    }

    public void deletar(){
        apoioRepository.deleteAll();
    }
}


