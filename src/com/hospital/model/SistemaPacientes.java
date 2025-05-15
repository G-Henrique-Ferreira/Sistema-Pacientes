package com.hospital.model;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class SistemaPacientes {

    static Scanner scannerInterface = new Scanner(System.in);
    static ArrayList<Paciente> pacientesCadastrados = new ArrayList<>();
    static Map<Paciente, Internamento> pacientesInternados = new HashMap<>();
    static Map<Paciente, AltaMedica> pacientesAlta = new HashMap<>();
    public static void main(String[] args) throws Exception {

        while (true) {

            System.out.println(" \nInterface");
            System.out.println("1. Cadastro de paciente");
            System.out.println("2. Internamento");
            System.out.println("3. Alta médica");
            System.out.println("4. Listagem de pacientes");
            System.out.println("5. Encerrar processo");
            System.out.println("-------------------------");   

        char selecaoNum = scannerInterface.next().charAt(0);
        scannerInterface.nextLine();

        switch (selecaoNum) {
            case '1':
                CadastrarPaciente();
                continue;
            
            case '2':
                InternarPaciente();
                continue;

            case '3':
                DarAlta();
                continue;

            case '4':
                ListarPacientes();
                continue;

            case '5':
                System.out.println("Encerramento do sistema");
                return;

            default: //mensagem de erro
                break;
            }
        }      
    }
 
    private static void  CadastrarPaciente() {
        System.out.println("Cadastro de Paciente");
        System.out.println("Nome: ");
        String nome = scannerInterface.nextLine();
        System.out.println("CPF: ");
        String cpf = scannerInterface.nextLine();
        System.out.println("Data de Nascimento: ");
        String dataDeNascimento = scannerInterface.nextLine();   
        System.out.println("Endereço: ");
        String endereco = scannerInterface.nextLine();
        Paciente paciente = new Paciente(nome, cpf, dataDeNascimento, endereco);
        pacientesCadastrados.add(paciente);
    }

    private static void InternarPaciente() {
        System.out.println("Internamento");
        System.out.println("CPF do paciente: ");
        String cpf = scannerInterface.nextLine();
        Paciente pacienteInternar = null;

        for (Paciente paciente : pacientesCadastrados) {
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

    private static void DarAlta() {
        System.out.println("Alta Médica");
        System.out.println("CPF do paciente: ");
        String cpf = scannerInterface.nextLine();
        Paciente pacienteAlta = null;

        for (Paciente paciente : pacientesInternados.keySet()) {
            if (paciente.toString().contains(cpf)) {
                pacienteAlta = paciente;
                break;
             }
    }
                
        if (pacienteAlta != null) {
            System.out.println("Data da Alta: ");
            String dataAlta = scannerInterface.nextLine();
            System.out.println("Motivo/Observação: ");
            String motivoOuObservacao = scannerInterface.nextLine();
            AltaMedica alta = new AltaMedica(dataAlta, motivoOuObservacao);
            pacientesAlta.put(pacienteAlta, alta);
            pacientesInternados.remove(pacienteAlta);
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void ListarPacientes() {

        while (true) {
            System.out.println("\nListagem de Pacientes: ");
            System.out.println("1. Pacientes cadastrados");
            System.out.println("2. Pacientes internados");
            System.out.println("3. Lista de Alta Médica");
            System.out.println("4. Voltar ao menu principal");
            System.out.println("-----------------");

            char opcao = scannerInterface.next().charAt(0);
            scannerInterface.nextLine();

            switch (opcao) {
                case '1':
                    Listagem.listarCadastrados(pacientesCadastrados);
                    break;

                case '2':
                    Listagem.listarInternados(pacientesInternados);
                    break;

                case '3':
                    Listagem.listarAltas(pacientesAlta);
                    break;

                case '4':

                    return;
            }
        }
    }
}
