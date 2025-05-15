package com.hospital.model;

class AltaMedica {

    private String dataDeAlta;
    private String motivoObservacao;

    public String getDataDeAlta() {
        return dataDeAlta;
    }

    public void setDataDeAlta(String dataDeAlta) {
        this.dataDeAlta = dataDeAlta;
    }

    public String getMotivoObservacao() {
        return motivoObservacao;
    }

    public void setMotivoObservacao(String motivoObservacao) {
        this.motivoObservacao = motivoObservacao;
    }

    public AltaMedica(String dataDeAlta, String motivoOuObservacao) {
        this.dataDeAlta = dataDeAlta;
        this.motivoObservacao = motivoOuObservacao;
    }

    @Override
    public String toString() {
        return "\nData da Alta Médica: " + dataDeAlta + "\nMotivo da Alta ou Observação: " + motivoObservacao + " ";
    }
}