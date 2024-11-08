package com.org.odontoprev.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataHoraConsulta;

    @Column(nullable = false)
    private String tipoProcedimento;

    private Double valor;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status;


    public Consulta(Long id, LocalDateTime dataHoraConsulta, String tipoProcedimento, Double valor, StatusConsulta status) {
        this.id = id;
        this.dataHoraConsulta = dataHoraConsulta;
        this.tipoProcedimento = tipoProcedimento;
        this.valor = valor;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public String getTipoProcedimento() {
        return tipoProcedimento;
    }

    public void setTipoProcedimento(String tipoProcedimento) {
        this.tipoProcedimento = tipoProcedimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }
}
