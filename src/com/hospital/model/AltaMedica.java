package com.hospital.model;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import javax.validation.*;
import javax.validation.constraints.*;

class AltaMedica {

    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}$", message = "Data inválida.")
    @NotBlank(message = "Campo não deve ficar em branco.")
    private String dataDeAlta;

    @NotBlank(message = "Campo não deve ficar em branco.")
    private String motivoObservacao;

    public AltaMedica(String dataDeAlta, String motivoOuObservacao) {
        this.dataDeAlta = dataDeAlta;
        this.motivoObservacao = motivoOuObservacao;
    }

    @Override
    public String toString() {
        return "\nData da Alta Médica: " + dataDeAlta + "\nMotivo da Alta ou Observação: " + motivoObservacao + " ";
    }

    public static void darAlta(Scanner scannerInterface, Map<Paciente, AltaMedica> pacientesAlta, Validator validarCadastro) {
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

            SistemaPacientes.pacientesInternados.remove(pacienteAlta);

        Set<ConstraintViolation<AltaMedica>> erros = validarCadastro.validate(alta);

            if (!erros.isEmpty()) {
                System.out.println("Erro de validação.");
                erros.forEach(e -> System.out.println(e.getMessage()));
                return;
                }

                pacientesAlta.put(pacienteAlta, alta);
            } else {
            System.out.println("Paciente não encontrado.");
            }
    }
}