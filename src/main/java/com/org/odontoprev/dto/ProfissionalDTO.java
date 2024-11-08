package com.org.odontoprev.dto;


public class ProfissionalDTO {
    private Long id;
    private String CRM;
    private String nomeCompleto;
    private String especialidadeOdontologica;
    private String contato;
    private String horarioConsulta;
    private Double avaliacaoServico;

    // Getters e Setters

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
