import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

class CadastrarPaciente {

    private String nome;
    private String cpf;
    private String dataDeNascimento;
    private String endereco;
    //boolean pra identificar se um paciente foi internado/recebeu alta (pode servir de filtro pra listagem de pacientes)

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

class InternarPaciente {

    private String dataDeEntrada;
    private String motivoDaInternacao;
    private String leito; //(data type propenso à mudança)

    public String getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(String dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public String getMotivoDaInternacao() {
        return motivoDaInternacao;
    }

    public void setMotivoDaInternacao(String motivoDaInternacao) {
        this.motivoDaInternacao = motivoDaInternacao;
    }

    public String getLeito() {
        return leito;
    }

    public void setLeito(String leito) {
        this.leito = leito;
    }
}

class DarAlta {

    private String dataDeAlta;
    private String motivoObservação;

    public String getDataDeAlta() {
        return dataDeAlta;
    }

    public void setDataDeAlta(String dataDeAlta) {
        this.dataDeAlta = dataDeAlta;
    }

    public String getMotivoObservação() {
        return motivoObservação;
    }

    public void setMotivoObservação(String motivoObservação) {
        this.motivoObservação = motivoObservação;
    }
}

class ListarPacientes {

    //visualizar todos os pacientes
    //visualizar internados
    //visualizar os que já receberam alta
    
}

public class SistemaPacientes {
        static Scanner scannerInterface = new Scanner(System.in);
        static ArrayList<Object> dadosPacientes = new ArrayList<>();
        //é viável criar outras arrays pra internação e alta?
    public static void main(String[] args) throws Exception {
    
        while (true) {

        System.out.println(" Interface");
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
            System.out.println("Cadastro de Pacientes");
                CadastrarPaciente paciente = new CadastrarPaciente();
                String nome = scannerInterface.nextLine();
                paciente.setNome(nome);
                String cpf = scannerInterface.nextLine();
                paciente.setCpf(cpf);
                String dataDeNascimento = scannerInterface.nextLine();
                paciente.setDataDeNascimento(dataDeNascimento);
                String endereco = scannerInterface.nextLine();
                paciente.setEndereco(endereco);
                dadosPacientes.add(paciente); //resolver depois ✓ (eu acho)
                //if pra setar como pendente qualquer dado que o paciente não tenha (categoria de indigente se for possível) _ pendente
                //|adicionar na arraylist ✓| e |retornar ao menu ✓|
        }

        private static void InternarPaciente() {
            System.out.println("Internamento");
                InternarPaciente internacao = new InternarPaciente(); //talvez suma¹
                String dataDeEntrada = scannerInterface.nextLine();
                internacao.setDataDeEntrada(dataDeEntrada);
                String motivoInternacao = scannerInterface.nextLine();
                internacao.setMotivoDaInternacao(motivoInternacao);
                String leito = scannerInterface.nextLine();
                internacao.setLeito(leito);
                //provavel mudança de nomes ou objeto pra relação com paciente
                //relacionar isso com objeto paciente quando registrar na arraylist (interface || herança ?)
        }

        private static void DarAlta() {
            System.out.println("Alta Médica");
                DarAlta alta = new DarAlta(); //talvez suma²
                String dataAlta = scannerInterface.nextLine();
                alta.setDataDeAlta(dataAlta);
                String motivoOuObservacao = scannerInterface.nextLine();
                alta.setMotivoObservação(motivoOuObservacao);
        }

        private static void MostrarMenuListagem() {
            while (true) {
                System.out.println("Listagem");
                System.out.println("1.");
                System.out.println("2.");
                System.out.println("3.");
                System.out.println("4.");
                System.out.println("");

                char opcao = scannerInterface.next().charAt(0);
                scannerInterface.nextLine();

                switch (opcao) { //terminar depois de relacionar paciente / internamento / alta
                    case '1':
                    
                        break;

                    case '2':

                        break;

                    case '3':

                        break;

                    case '4':

                        return;
                }
            }
        }
}
