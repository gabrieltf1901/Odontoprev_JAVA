package com.org.odontoprev.dto;


public class ConsultaDTO {
    private Long id;
    private String dataHoraConsulta;
    private String tipoProcedimento;
    private Double valor;
    private String status;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(String dataHoraConsulta) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

