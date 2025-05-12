import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

class cadastrarPaciente {

    private String nome;
    private int cpf;
    private LocalDate dataDeNascimento;
    private String endereco;
    //boolean pra identificar se um paciente foi internado/recebeu alta (pode servir de filtro pra listagem de pacientes)

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    cadastrarPaciente(){

    }   
}

class internarPaciente {

    private LocalDateTime dataDeEntrada;
    private String motivoDaInternacao;
    private String leito; //(data type propenso à mudança)

    public LocalDateTime getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(LocalDateTime dataDeEntrada) {
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

    internarPaciente(){

    }
}

class darAlta {

    private LocalDateTime dataDeAlta;
    private String motivoObservação;

    public LocalDateTime getDataDeAlta() {
        return dataDeAlta;
    }

    public void setDataDeAlta(LocalDateTime dataDeAlta) {
        this.dataDeAlta = dataDeAlta;
    }

    public String getMotivoObservação() {
        return motivoObservação;
    }

    public void setMotivoObservação(String motivoObservação) {
        this.motivoObservação = motivoObservação;
    }

    darAlta(){
        
    }
}

class listarPacientes {

    //visualizar todos os pacientes
    //visualizar internados
    //visualizar os que já receberam alta

    listarPacientes(){
        
    }
}

public class SistemaPacientes {
        static Scanner seletorInterface = new Scanner(System.in);
        static ArrayList<String> dadosPacientes = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        //put in a while later
        System.out.println(" Interface");
        System.out.println("1. Cadastro de paciente");
        System.out.println("2. Internamento");
        System.out.println("3. Alta médica");
        System.out.println("4. Listagem de pacientes");
        System.out.println("5. Encerrar processo");
        System.out.println("-------------------------");

        while (true) {

        char selecaoNum = seletorInterface.next().charAt(0);

            switch (selecaoNum) {
                case '1':
                    System.out.println("Cadastro de Pacientes");
                    //setNome                   
                    //setCPF
                    //setDataDeNascimento
                    //setEndereço
                    //if pra setar como pendente qualquer dado que o paciente não tenha (categoria de indigente se for possível)
                    //adicionar na arraylist e retornar ao menu
                    break;
                
                case '2':
                    System.out.println("Internamento");
                    //setDataDeEntrada
                    //setMotivoDaInternação
                    //setLeito
                    break;

                case '3':
                    System.out.println("Alta Médica");
                    //setDataDeAlta
                    //setMotivoOuObservação
                    break;

                case '4':
                    System.out.println("Listagem");
                    //visualizar todos os pacientes
                    //visualizar internados
                    //visualizar os que já receberam alta
                    break;

                case '5':
                    System.out.println("Encerramento do sistema");
                    return;

                default: //mensagem de erro
                    break;
            }
        }
    }
}
