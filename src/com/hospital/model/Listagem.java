package com.hospital.model;
import java.util.ArrayList;
import java.util.Map;

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
}