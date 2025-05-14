import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CadastrarPaciente {

    private String nome;
    private String cpf;
    private String dataDeNascimento;
    private String endereco;
    //boolean pra identificar se um paciente foi internado/recebeu alta (pode servir de filtro pra listagem de pacientes)

    public CadastrarPaciente(String nome, String cpf, String dataDeNascimento, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "\n----- Paciente ----- " +"\nNome: " + nome +  "\nCPF: " + cpf + "\nEndereço: " + endereco + "\nData de Nascimento: " + dataDeNascimento + " ";
    }
}

class InternarPaciente {

    private String dataDeEntrada;
    private String motivoDaInternacao;
    private String leito;

    public InternarPaciente(String dataDeEntrada, String motivoDaInternacao, String leito) {
        this.dataDeEntrada = dataDeEntrada;
        this.motivoDaInternacao = motivoDaInternacao;
        this.leito = leito;
    }

    @Override
    public String toString() {
        return "\nData de Entrada: " + dataDeEntrada + "\nMotivo: " + motivoDaInternacao + "\nLeito" + leito + " ";
    }
}

class DarAlta {

    private String dataDeAlta;
    private String motivoObservacao;

    public DarAlta(String dataDeAlta, String motivoOuObservacao) {
        this.dataDeAlta = dataDeAlta;
        this.motivoObservacao = motivoOuObservacao;
    }

    @Override
    public String toString() {
        return "\nData da Alta Médica: " + dataDeAlta + "\nMotivo da Alta ou Observação: " + motivoObservacao + " ";
    }

    public String getDataDeAlta() {
        return dataDeAlta;
    }

    public void setDataDeAlta(String dataDeAlta) {
        this.dataDeAlta = dataDeAlta;
    }

    public String getMotivoObservação() {
        return motivoObservacao;
    }

    public void setMotivoObservação(String motivoObservação) {
        this.motivoObservacao = motivoObservação;
    }
}

class ListarPacientes {

    //visualizar todos os pacientes
    //visualizar internados
    //visualizar os que já receberam alta

}

public class SistemaPacientes {
        static Scanner scannerInterface = new Scanner(System.in);
        static ArrayList<CadastrarPaciente> dadosPacientes = new ArrayList<>();
        static Map<CadastrarPaciente, InternarPaciente> pacientesInternados = new HashMap<>();
        static Map<CadastrarPaciente, DarAlta> pacientesAlta = new HashMap<>();
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
                MostrarMenuListagem();
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
                CadastrarPaciente paciente = new CadastrarPaciente(nome, cpf, dataDeNascimento, endereco);
                dadosPacientes.add(paciente); //resolver depois ✓ (eu acho)
                //if pra setar como pendente qualquer dado que o paciente não tenha (categoria de indigente se for possível) _ pendente
                //|adicionar na arraylist ✓| e |retornar ao menu ✓|
        }

        private static void InternarPaciente() {
            System.out.println("Internamento");
            System.out.println("CPF do paciente: ");
            String cpf = scannerInterface.nextLine();
            CadastrarPaciente pacienteInternar = null;

            for (CadastrarPaciente paciente : dadosPacientes) {
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
                InternarPaciente internacao = new InternarPaciente(dataDeEntrada, motivoInternacao, leitoPaciente);
                pacientesInternados.put(pacienteInternar, internacao);
            } else {
                System.out.println("Paciente não encontrado.");
            }
        }

        private static void DarAlta() {
            System.out.println("Alta Médica");
            System.out.println("CPF do paciente: ");
            String cpf = scannerInterface.nextLine();
            CadastrarPaciente pacienteAlta = null;

            for (CadastrarPaciente paciente : pacientesInternados.keySet()) {
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
                DarAlta alta = new DarAlta(dataAlta, motivoOuObservacao);
                pacientesAlta.put(pacienteAlta, alta);
                pacientesInternados.remove(pacienteAlta);
            } else {
                System.out.println("Paciente não encontrado.");
            }
        }

        private static void MostrarMenuListagem() {
            while (true) {
                System.out.println("\nListagem");
                System.out.println("1. Pacientes cadastrados");
                System.out.println("2. Pacientes internados");
                System.out.println("3. Lista de Alta Médica");
                System.out.println("4. Voltar ao menu principal");
                System.out.println("-----------------");

                char opcao = scannerInterface.next().charAt(0);
                scannerInterface.nextLine();

                switch (opcao) { //terminar depois de relacionar paciente / internamento / alta
                    case '1':
                        System.out.println("\nLista de Pacientes:");
                        for (CadastrarPaciente paciente : dadosPacientes) {
                        System.out.println(paciente);
                        }
                        break;

                    case '2':
                        System.out.println("\nLista de Pacientes Internados");
                        for (Map.Entry<CadastrarPaciente, InternarPaciente> internamentoListagem : pacientesInternados.entrySet()) {
                            System.out.println(internamentoListagem.getKey() + "\n" + internamentoListagem.getValue());
                        }
                        break;

                    case '3':
                        System.out.println("\nLista de Alta Médica");
                        for (Map.Entry<CadastrarPaciente, DarAlta> altaListagem : pacientesAlta.entrySet()) {
                            System.out.println(altaListagem.getKey() + "\n" + altaListagem.getValue());
                        }
                        break;

                    case '4':

                        return;
                }
            }
        }
}
