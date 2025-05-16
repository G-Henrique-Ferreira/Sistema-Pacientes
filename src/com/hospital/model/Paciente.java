package com.hospital.model;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import javax.validation.*;
import javax.validation.constraints.*;

class Paciente {

    @NotBlank(message = "Campo não deve ficar em branco.")
    private String nome;

    @NotBlank(message = "Campo não deve ficar em branco")
    @Pattern(regexp = "^\\d{11}$", message = "CPF inválido.")
    private String cpf;

    //@Past
    @NotBlank(message = "Campo não deve ficar em branco")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}$", message = "Data inválida.")
    private String dataDeNascimento;

    @NotBlank(message = "Campo não deve ficar em branco.")
    private String endereco;

    public Paciente(String nome, String cpf, String dataDeNascimento, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "\n----- Paciente ----- " +"\nNome: " + nome +  "\nCPF: " + cpf + "\nEndereço: " + endereco + "\nData de Nascimento: " + dataDeNascimento + " ";
    }

    public static void  cadastrarPaciente(Scanner scannerInterface, ArrayList<Paciente> pacientesCadastrados, Validator validarCadastro) {

        System.out.println("Cadastro de Paciente");
        System.out.println("Nome: ");
        String nome = scannerInterface.nextLine();
        System.out.println("CPF: ");
        String cpf = scannerInterface.nextLine();
        System.out.println("Data de Nascimento (DD/MM/YYYY): ");
        String dataDeNascimento = scannerInterface.nextLine();   
        System.out.println("Endereço: ");
        String endereco = scannerInterface.nextLine();

        Paciente paciente = new Paciente(nome, cpf, dataDeNascimento, endereco);

        Set<ConstraintViolation<Paciente>> erros = validarCadastro.validate(paciente);
        if (!erros.isEmpty()) {
        erros.forEach(e -> System.out.println(e.getMessage()));
        return;
        }

        pacientesCadastrados.add(paciente);
    }
}