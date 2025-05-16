package com.hospital.model;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

class Listagem {

    public static void listarCadastrados(ArrayList<Paciente> pacientesCadastrados) {
        System.out.println("\nLista de Pacientes:");
        for (Paciente paciente : pacientesCadastrados) {
            System.out.println(paciente);
        }
    }

    public static void listarInternados(Map<Paciente, Internamento> pacientesInternados) {
        System.out.println("\nLista de Pacientes Internados");
        for (Map.Entry<Paciente, Internamento> internamentoListagem : pacientesInternados.entrySet()) {
            System.out.println(internamentoListagem.getKey() + "\n" + internamentoListagem.getValue());
        }
    }

    public static void listarAltas (Map<Paciente, AltaMedica> pacientesAlta) {
        System.out.println("\nLista de Alta Médica");
        for (Map.Entry<Paciente, AltaMedica> altaListagem : pacientesAlta.entrySet()) {
            System.out.println(altaListagem.getKey() + "\n" + altaListagem.getValue());
        }
    }

    public static void listarPacientes(Scanner scannerInterface,
                                        ArrayList<Paciente> pacientesCadastrados, 
                                            Map<Paciente, Internamento> pacientesInternados, 
                                                Map<Paciente, AltaMedica> pacientesAlta) {

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

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}