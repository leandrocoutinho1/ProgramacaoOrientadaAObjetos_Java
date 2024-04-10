/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AppViagem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author leandro.coutinho
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();
        ViagensDisponiveis viagensDisponiveis = new ViagensDisponiveis();
        int opcao = 0;
        
        System.out.println("▂▃▄▅▆▇█▓▒░ Bem-vindo ao JavaTour! ░▒▓█▇▆▅▄▃▂\n");
        System.out.println("Estamos empolgados em tê-lo(a) conosco. Vamos explorar destinos emocionantes!");
        System.out.println("Nossa seleção inclui os destinos mais vibrantes e icônicos.");
        System.out.println("Trabalharemos com 4 países da América: Brasil, Argentina, Estados Unidos e Canadá, e 3 da Europa: França, Inglaterra e Portugal.");
        System.out.println("Prepare-se para uma jornada fascinante através de culturas, paisagens e experiências únicas.");
        System.out.println("Escolha o seu destino e embarque conosco nesta aventura!\n");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Mostrar Usuários Cadastrados");
            System.out.println("3. Adicionar Viagem para Usuário");
            System.out.println("4. Visualizar Viagens Cadastradas por Usuário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro de Usuário ---");
                    System.out.print("Nome: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();

                    int id;
                    boolean idValido;
                    do {
                        System.out.print("ID: ");
                        id = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer do scanner

                        // Verificar se o ID já existe
                        idValido = true;
                        for (Usuario user : usuarios) {
                            if (user.getId() == id) {
                                idValido = false;
                                System.out.println("Este ID já está em uso. Por favor, escolha outro ID único.");
                                break;
                            }
                        }
                    } while (!idValido);

                    String email;
                    boolean emailValido;
                    do {
                        System.out.print("E-mail: ");
                        email = scanner.nextLine();

                        // Verificar se o e-mail já existe
                        emailValido = true;
                        for (Usuario user : usuarios) {
                            if (user.getEmail().equals(email)) {
                                emailValido = false;
                                System.out.println("Este e-mail já está em uso. Por favor, escolha outro e-mail único.");
                                break;
                            }
                        }
                    } while (!emailValido);

                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    LocalDate dataNascimento = null;
                    boolean dataValida = false;
                    do {
                        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
                        String dataNascimentoStr = scanner.nextLine();

                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

                            // Verificar se a data de nascimento é no passado
                            if (dataNascimento.isBefore(LocalDate.now())) {
                                dataValida = true;
                            } else {
                                System.out.println("A data de nascimento não pode ser no futuro.");
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de data inválido. Certifique-se de digitar no formato dd/MM/yyyy.");
                        }
                    } while (!dataValida);

                    Usuario usuario = new Usuario(nome, id, email, senha, dataNascimento);
                    usuarios.add(usuario);
                    System.out.println("Usuário cadastrado com sucesso.");
                    break;
                case 2:
                    if (usuarios.isEmpty()) {
                        System.out.println("A lista de usuários está vazia.");
                    } else {
                        System.out.println("\n--- Usuários Cadastrados ---");
                        for (Usuario user : usuarios) {
                            System.out.println("ID: " + user.getId() + " - Nome: " + user.getNome());
                        }
                    }
                    break;
                case 3:
                    if (usuarios.isEmpty()) {
                        System.out.println("Não há usuários cadastrados.");
                        break;
                    }

                    System.out.println("\n--- Adicionar Viagem para Usuário ---");
                    System.out.println("Escolha um usuário:");

                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println((i + 1) + ". " + usuarios.get(i).getNome());
                    }

                    int escolhaUsuario = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaUsuario < 1 || escolhaUsuario > usuarios.size()) {
                        System.out.println("Escolha de usuário inválida.");
                        break;
                    }

                    Usuario usuarioEscolhido = usuarios.get(escolhaUsuario - 1);

                    System.out.println("\n--- Selecionar Viagem ---");

                    // Mostrar lista de cidades de origem
                    System.out.println("Selecione a cidade de origem:");
                    List<String> cidadesOrigem = viagensDisponiveis.getCidadesOrigem();
                    for (int i = 0; i < cidadesOrigem.size(); i++) {
                        System.out.println((i + 1) + ". " + cidadesOrigem.get(i));
                    }
                    System.out.print("Escolha: ");
                    int escolhaOrigem = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    if (escolhaOrigem < 1 || escolhaOrigem > cidadesOrigem.size()) {
                        System.out.println("Escolha de cidade de origem inválida.");
                        break;
                    }
                    String cidadeOrigem = cidadesOrigem.get(escolhaOrigem - 1);
                    String paisOrigem = cidadeOrigem.split(", ")[1];

                    // Mostrar lista de cidades de destino
                    System.out.println("\nSelecione a cidade de destino:");
                    List<String> cidadesDestino = viagensDisponiveis.getCidadesDestino(cidadeOrigem);
                    for (int i = 0; i < cidadesDestino.size(); i++) {
                        System.out.println((i + 1) + ". " + cidadesDestino.get(i));
                    }
                    System.out.print("Escolha: ");
                    int escolhaDestino = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    if (escolhaDestino < 1 || escolhaDestino > cidadesDestino.size()) {
                        System.out.println("Escolha de cidade de destino inválida.");
                        break;
                    }
                    String cidadeDestino = cidadesDestino.get(escolhaDestino - 1);
                    String paisDestino = cidadeDestino.split(", ")[1];

                    // Solicitar data da viagem
                    System.out.print("\nDigite a data da viagem (dd/MM/yyyy): ");
                    String dataViagemStr = scanner.nextLine();

                    // Tratamento da data
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date dataViagem = dateFormat.parse(dataViagemStr);
                        // Verificar se a data é futura
                        if (dataViagem.before(new Date())) {
                            System.out.println("A data da viagem deve ser no futuro.");
                            break;
                        }
                        
                        // Solicitar horário da viagem
                        System.out.print("Digite o horário da viagem (HH:mm): ");
                        String horarioViagem = scanner.nextLine();

                        // Calcular o valor da viagem
                        double precoBase = 100; // Preço base da viagem
                        long diasParaViagem = (dataViagem.getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24);
                        double precoFinal = precoBase + (diasParaViagem * 10); // Quanto mais próximo, mais caro

                        // Mostrar detalhes da viagem e confirmar
                        System.out.println("\n--- Detalhes da Viagem ---");
                        System.out.println("Origem: " + cidadeOrigem);
                        System.out.println("Destino: " + cidadeDestino);
                        System.out.println("Data da Viagem: " + dataViagemStr);
                        System.out.println("Preço da Viagem: R$" + precoFinal);

                        // Confirmar a viagem
                        System.out.print("\nDeseja confirmar esta viagem? (S/N): ");
                        String confirmacao = scanner.nextLine();

                        if (confirmacao.equalsIgnoreCase("S")) {
                            // Criar a viagem
                            Viagem viagem = new Viagem(new DestinoViagem(cidadeOrigem, paisOrigem, cidadeDestino, paisDestino, dataViagem, horarioViagem, new ArrayList<>()), dataViagem, "");
                            // Adicionar a viagem ao usuário
                            usuarioEscolhido.requisitarViagem(viagem);
                            System.out.println("Viagem criada com sucesso!");
                        } else {
                            System.out.println("Viagem cancelada.");
                        }

                    } catch (ParseException e) {
                        System.out.println("Data inválida. Certifique-se de digitar no formato dd/MM/yyyy.");
                    }

                    break;
                case 4:
                    if (usuarios.isEmpty()) {
                        System.out.println("Não há usuários cadastrados.");
                        break;
                    }

                    System.out.println("\n--- Visualizar Viagens Cadastradas por Usuário ---");
                    System.out.println("Escolha um usuário para visualizar suas viagens: \n");

                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println((i + 1) + ". " + usuarios.get(i).getNome());
                    }

                    int escolhaUsuarioVis = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaUsuarioVis < 1 || escolhaUsuarioVis > usuarios.size()) {
                        System.out.println("Escolha de usuário inválida.");
                        break;
                    }

                    Usuario usuarioEscolhidoVis = usuarios.get(escolhaUsuarioVis - 1);
                    System.out.println("\nViagens cadastradas para o usuário " + usuarioEscolhidoVis.getNome() + ":");
                    System.out.println(usuarioEscolhidoVis.mostrarViagens());
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while(opcao != 5);
        scanner.close();
    }
}