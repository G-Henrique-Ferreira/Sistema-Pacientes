package com.hospital.model;

class Internamento {

    private String dataDeEntrada;
    private String motivoDaInternacao;
    private String leito;

    public String getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(String dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public String getMotivoDaInternacao() {
        return motivoDaInternacao;
    }

    public void setMotivoDaInternacao(String motivoDaInternacao) {
        this.motivoDaInternacao = motivoDaInternacao;
    }

    public String getLeito() {
        return leito;
    }

    public void setLeito(String leito) {
        this.leito = leito;
    }

    public Internamento(String dataDeEntrada, String motivoDaInternacao, String leito) {
        this.dataDeEntrada = dataDeEntrada;
        this.motivoDaInternacao = motivoDaInternacao;
        this.leito = leito;
    }

    @Override
    public String toString() {
        return "\nData de Entrada: " + dataDeEntrada + "\nMotivo: " + motivoDaInternacao + "\nLeito" + leito + " ";
    }
}
