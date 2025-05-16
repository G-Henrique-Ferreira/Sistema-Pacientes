package com.hospital.model;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.validation.*;
import javax.validation.constraints.*;

class Internamento {

    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}$", message = "\nData inválida.")
    @NotBlank(message = "\nCampo não deve ficar em branco")
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

    public static void internarPaciente(Scanner scannerInterface, Map<Paciente, Internamento> pacientesInternados, Validator validarCadastro) {
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

        Set<ConstraintViolation<Internamento>> erros = validarCadastro.validate(internacao);

            if (!erros.isEmpty()) {
            System.out.println("Erro de validação.");
            erros.forEach(e -> System.out.println(e.getMessage()));
            return;
            }

                pacientesInternados.put(pacienteInternar, internacao); 
            } else {
            System.out.println("Paciente não encontrado.");
            }
    }
}
