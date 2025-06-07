package com.trabalho.VozSegura1.Models;

import com.trabalho.VozSegura1.Enums.TipoOcorrencia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "denuncia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private LocalDate data;
    private String descricao;

    private boolean anonimo;

    @Enumerated(EnumType.STRING)
    private TipoOcorrencia tipoOcorrencia;


}
