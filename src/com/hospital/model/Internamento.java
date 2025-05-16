package com.hospital.model;
import java.util.Map;
import java.util.Scanner;

class Internamento {

    private String dataDeEntrada;
    private String motivoDaInternacao;
    private String leito;

    public Internamento(String dataDeEntrada, String motivoDaInternacao, String leito) {
        this.dataDeEntrada = dataDeEntrada;
        this.motivoDaInternacao = motivoDaInternacao;
        this.leito = leito;
    }

    @Override
    public String toString() {
        return "\nData de Entrada: " + dataDeEntrada + "\nMotivo: " + motivoDaInternacao + "\nLeito" + leito + " ";
    }

    public static void internarPaciente(Scanner scannerInterface, Map<Paciente, Internamento> pacientesInternados) {
        System.out.println("Internamento");
        System.out.println("CPF do paciente: ");
        String cpf = scannerInterface.nextLine();
        Paciente pacienteInternar = null;

        for (Paciente paciente : SistemaPacientes.pacientesCadastrados) {
            if (paciente.toString().contains(cpf)) {
                pacienteInternar = paciente;
                break;
             }
         }
            
        if (pacienteInternar != null) {
            System.out.println("Data de Entrada:");
            String dataDeEntrada = scannerInterface.nextLine(); 
            System.out.println("Motivo da Internação: ");
            String motivoInternacao = scannerInterface.nextLine();
            System.out.println("Leito: ");
            String leitoPaciente = scannerInterface.nextLine();
            Internamento internacao = new Internamento(dataDeEntrada, motivoInternacao, leitoPaciente);
            pacientesInternados.put(pacienteInternar, internacao);
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}
