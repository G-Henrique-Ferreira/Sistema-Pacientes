package com.hospital.model;
import java.util.Map;
import java.util.Scanner;

class AltaMedica {

    private String dataDeAlta;
    private String motivoObservacao;

    public AltaMedica(String dataDeAlta, String motivoOuObservacao) {
        this.dataDeAlta = dataDeAlta;
        this.motivoObservacao = motivoOuObservacao;
    }

    @Override
    public String toString() {
        return "\nData da Alta Médica: " + dataDeAlta + "\nMotivo da Alta ou Observação: " + motivoObservacao + " ";
    }

    public static void darAlta(Scanner scannerInterface, Map<Paciente, AltaMedica> pacientesAlta) {
        System.out.println("Alta Médica");
        System.out.println("CPF do paciente: ");
        String cpf = scannerInterface.nextLine();
        Paciente pacienteAlta = null;

        for (Paciente paciente : SistemaPacientes.pacientesInternados.keySet()) {
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
            SistemaPacientes.pacientesInternados.remove(pacienteAlta);
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}