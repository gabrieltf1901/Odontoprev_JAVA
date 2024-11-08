package com.org.odontoprev.model;

import jakarta.persistence.*;

@Entity
public class Profissional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String CRM;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false)
    private String especialidadeOdontologica;

    private String contato;

    private String horarioConsulta;

    private Double avaliacaoServico;


    public Profissional(Long id, String CRM, String nomeCompleto, String especialidadeOdontologica, String contato, String horarioConsulta, Double avaliacaoServico) {
        this.id = id;
        this.CRM = CRM;
        this.nomeCompleto = nomeCompleto;
        this.especialidadeOdontologica = especialidadeOdontologica;
        this.contato = contato;
        this.horarioConsulta = horarioConsulta;
        this.avaliacaoServico = avaliacaoServico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEspecialidadeOdontologica() {
        return especialidadeOdontologica;
    }

    public void setEspecialidadeOdontologica(String especialidadeOdontologica) {
        this.especialidadeOdontologica = especialidadeOdontologica;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public Double getAvaliacaoServico() {
        return avaliacaoServico;
    }

    public void setAvaliacaoServico(Double avaliacaoServico) {
        this.avaliacaoServico = avaliacaoServico;
    }
}