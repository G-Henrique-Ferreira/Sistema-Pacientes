package com.hospital.model;
import java.util.ArrayList;
import java.util.Scanner;
import javax.validation.*;

import java.util.HashMap;
import java.util.Map;

public class SistemaPacientes {

    static ValidatorFactory verificacao = Validation.buildDefaultValidatorFactory();
    static Validator validarCadastro = verificacao.getValidator();

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
                Paciente.cadastrarPaciente(scannerInterface, pacientesCadastrados, validarCadastro);
                continue;
            
            case '2':
                Internamento.internarPaciente(scannerInterface, pacientesInternados);
                continue;

            case '3':
                AltaMedica.darAlta(scannerInterface, pacientesAlta);
                continue;

            case '4':
                Listagem.listarPacientes(scannerInterface, pacientesCadastrados, pacientesInternados, pacientesAlta);
                continue;

            case '5':
                System.out.println("Encerramento do sistema");
                return;

            default:
                System.out.println("Opção inválida.");
            }
        }      
    }
}
