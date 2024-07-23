
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Bootcamp de Desenvolvimento de Software!");
        System.out.print("Insira o nome do bootcamp: ");
        String nomeBootcamp = scanner.nextLine();
        String descricaoBootcamp = "Descrição do Bootcamp " + nomeBootcamp;
        Bootcamp bootcamp = new Bootcamp();

        Mentoria mentoria = new Mentoria("Mentoria de Java", "Descrição mentoria Java");
        bootcamp.getConteudos().add(mentoria);

        // Lista para armazenar os desenvolvedores inscritos no bootcamp
        List<Dev> desenvolvedoresInscritos = new ArrayList<>();

        while (true) {
            System.out.println("Opções:");
            System.out.println("1. Inscrever-se no bootcamp");
            System.out.println("2. Progredir em um conteúdo");
            System.out.println("3. Ver conteúdos inscritos");
            System.out.println("4. Ver conteúdos concluídos");
            System.out.println("5. Ver XP");
            System.out.println("6. Adicionar curso ao bootcamp");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o newline

            switch (opcao) {
                case 1:
                    System.out.print("Insira o nome do desenvolvedor: ");
                    String nomeDev = scanner.nextLine();
                    Dev dev = new Dev(nomeDev);
                    dev.inscreverBootcamp(bootcamp);
                    desenvolvedoresInscritos.add(dev); // Adiciona o desenvolvedor à lista de inscritos
                    System.out.println("Você se inscreveu com sucesso no bootcamp!");
                    break;
                case 2:
                    System.out.print("Insira o nome do desenvolvedor: ");
                    nomeDev = scanner.nextLine();
                    // Procura o desenvolvedor inscrito na lista
                    Dev devProgresso = buscarDevPorNome(nomeDev, desenvolvedoresInscritos);
                    if (devProgresso != null) {
                        devProgresso.progredir();
                        System.out.println("Progresso realizado com sucesso!");
                    } else {
                        System.out.println("Desenvolvedor não encontrado ou não inscrito no bootcamp.");
                    }
                    break;
                case 3:
                    System.out.print("Insira o nome do desenvolvedor: ");
                    nomeDev = scanner.nextLine();
                    // Procura o desenvolvedor inscrito na lista
                    Dev devInscritos = buscarDevPorNome(nomeDev, desenvolvedoresInscritos);
                    if (devInscritos != null) {
                        System.out.println("Conteúdos Inscritos " + nomeDev + ": " + devInscritos.getConteudosInscritos());
                    } else {
                        System.out.println("Desenvolvedor não encontrado ou não inscrito no bootcamp.");
                    }
                    break;
                case 4:
                    System.out.print("Insira o nome do desenvolvedor: ");
                    nomeDev = scanner.nextLine();
                    // Procura o desenvolvedor inscrito na lista
                    Dev devConcluidos = buscarDevPorNome(nomeDev, desenvolvedoresInscritos);
                    if (devConcluidos != null) {
                        System.out.println("Conteúdos Concluídos " + nomeDev + ": " + devConcluidos.getConteudosConcluidos());
                    } else {
                        System.out.println("Desenvolvedor não encontrado ou não inscrito no bootcamp.");
                    }
                    break;
                case 5:
                    System.out.print("Insira o nome do desenvolvedor: ");
                    nomeDev = scanner.nextLine();
                    // Procura o desenvolvedor inscrito na lista
                    Dev devXP = buscarDevPorNome(nomeDev, desenvolvedoresInscritos);
                    if (devXP != null) {
                        System.out.println("XP de " + nomeDev + ": " + devXP.calcularTotalXp());
                    } else {
                        System.out.println("Desenvolvedor não encontrado ou não inscrito no bootcamp.");
                    }
                    break;
                case 6:
                    System.out.println("Cursos disponíveis:");
                    List<Curso> cursosDisponiveis = Curso.getCursosDisponiveis();
                    for (int i = 0; i < cursosDisponiveis.size(); i++) {
                        System.out.println((i + 1) + ". " + cursosDisponiveis.get(i).getTitulo());
                    }
                    System.out.print("Escolha um curso para adicionar ao bootcamp: ");
                    int cursoEscolhido = scanner.nextInt();
                    scanner.nextLine(); // Consumir o newline
                    if (cursoEscolhido > 0 && cursoEscolhido <= cursosDisponiveis.size()) {
                        Curso curso = cursosDisponiveis.get(cursoEscolhido - 1);
                        System.out.print("Insira o nome do desenvolvedor que deseja adicionar ao curso: ");
                        nomeDev = scanner.nextLine();
                        // Procura o desenvolvedor inscrito na lista
                        Dev devAdicionarCurso = buscarDevPorNome(nomeDev, desenvolvedoresInscritos);
                        if (devAdicionarCurso != null) {
                            bootcamp.getConteudos().add(curso);
                            devAdicionarCurso.inscreverConteudo(curso);
                            System.out.println("Curso " + curso.getTitulo() + " adicionado ao bootcamp para " + nomeDev + "!");
                        } else {
                            System.out.println("Desenvolvedor não encontrado ou não inscrito no bootcamp.");
                        }
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // Método auxiliar para buscar um desenvolvedor pelo nome na lista de inscritos
    private static Dev buscarDevPorNome(String nome, List<Dev> listaDevs) {
        for (Dev dev : listaDevs) {
            if (dev.getNome().equalsIgnoreCase(nome)) {
                return dev;
            }
        }
        return null; // Retorna null se não encontrar o desenvolvedor na lista
    }
}