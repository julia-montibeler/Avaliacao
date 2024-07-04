package questao9;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public static void iniciarMenu() {
        while (true) {
            System.out.println("\n\nRegistro de Alienígenas (Digite o índice respectivo a ação que deseja realizar): ");
            System.out.println("1 - Registrar Alienígena");
            System.out.println("2 - Registrar Espécie");
            System.out.println("3 - Registrar Planeta");
            System.out.println("4 - Relatório de Entradas");
            System.out.println("5 - Quarentena");
            System.out.println("6 - Planetas registrados");
            System.out.println("7 - Especies registradas");
            System.out.println("8 - Ranking Periculosidade");
            System.out.println("9 - Entradas dos últimos 6 meses");
            System.out.println("10 - Pesquisar por espécie");
            System.out.println("11 - Pesquisar por planeta");
            System.out.println("S - Sair");
            String r = sc.next();

            if (r.equalsIgnoreCase("S")) {
                break;
            }

            switch (r) {
                case "1" -> validarDadosAlien();
                case "2" -> validarDadosEspecie();
                case "3" -> validarDadosPlaneta();
                case "4" -> Registro.relatorioEntradas();
                case "5" -> Quarentena.listarQuarentena();
                case "6" -> Registro.listarPlanetas();
                case "7" -> Registro.listarEspecies();
                case "8" -> Registro.rankingPericulosidade();
                case "9" -> Registro.entradasSeisMeses();
                case "10" -> validarPesquisaEspecie();
                case "11" -> validarPesquisaPlaneta();

                default -> System.out.println("Opção inválida. Por favor, digite uma opção válida.");
            }

        }
        System.out.println("Você saiu do sistema");
    }

    public static void validarDadosAlien() {
        if (Registro.especies.isEmpty()) {
            System.out.println("É necessário cadastrar a espécie antes de cadastrar o alienígena");
        } else {
            System.out.print("\nDigite o nome: ");
            String nome = sc.next();
            int periculosidade = -1;
            do {
                try {
                    System.out.print("Digite a periculosidade: ");
                    periculosidade = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Você digitou um caractere inválido. Digite um número");
                }
                sc.nextLine();

            } while (periculosidade == -1);
            int indexEspecie = -1;
            Especie especie = null;
            do {
                try {
                    int contEspecie = 1;
                    for (Especie e : Registro.especies) {
                        System.out.println(contEspecie + " - " + e.getNome());
                        contEspecie++;
                    }
                    indexEspecie = sc.nextInt();
                    especie = Registro.especies.get(indexEspecie-1);
                } catch (InputMismatchException e) {
                    System.out.println("Você digitou um caractere inválido. Digite um número.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Essa espécie não existe. Digite uma espécie válida.");
                }
                sc.nextLine();
            } while (indexEspecie <= 0 || indexEspecie > Registro.especies.size());

            Registro.registrarAlienigena(nome, especie, periculosidade, LocalDateTime.now());
        }
    }


    public static void validarDadosEspecie() {
        if (Registro.planetas.isEmpty()) {
            System.out.println("É necessário cadastrar o planeta antes de cadastrar a espécie");
        } else {
            System.out.print("\nDigite o nome: ");
            String nome = sc.next();
            int periculosidade = -1;
            do {
                try {
                    System.out.print("Digite a periculosidade: ");
                    periculosidade = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Você digitou um caractere inválido. Digite um número");
                }
                sc.nextLine();

            } while (periculosidade == -1);
            int indexPlaneta = -1;
            Planeta planeta = null;
            do {
                try {
                    int contPlaneta = 1;
                    for (Planeta p : Registro.planetas) {
                        System.out.println(contPlaneta + " - " + p.getNome());
                        contPlaneta++;
                    }
                    indexPlaneta = sc.nextInt();
                    planeta = Registro.planetas.get(indexPlaneta-1);
                } catch (InputMismatchException e) {
                    System.out.println("Você digitou um caractere inválido. Digite um número.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Esse planeta não existe. Digite um planeta válido.");
                }
                sc.nextLine();
            } while (indexPlaneta <= 0 || indexPlaneta > Registro.planetas.size());
            Registro.registrarEspecie(nome, planeta, periculosidade);
        }
    }

    public static void validarDadosPlaneta() {
        System.out.print("\nDigite o nome: ");
        String nome = sc.next();
        Registro.registrarPlaneta(nome);
    }

    public static void validarPesquisaPlaneta() {
        int indexPlaneta = -1;
        Planeta planeta = null;
        do {
            try {
                int contPlaneta = 1;
                for (Planeta p : Registro.planetas) {
                    System.out.println(contPlaneta + " - " + p.getNome());
                    contPlaneta++;
                }
                indexPlaneta = sc.nextInt();
                planeta = Registro.planetas.get(indexPlaneta-1);
            } catch (InputMismatchException e) {
                System.out.println("Você digitou um caractere inválido. Digite um número.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Esse planeta não existe. Digite um planeta válido.");
            }
            sc.nextLine();
        } while (indexPlaneta <= 0 || indexPlaneta > Registro.planetas.size());
        Registro.pesquisarPorPlaneta(planeta);
    }

    public static void validarPesquisaEspecie() {
        int indexEspecie = -1;
        Especie especie = null;
        do {
            try {
                int contEspecie = 1;
                for (Especie e : Registro.especies) {
                    System.out.println(contEspecie + " - " + e.getNome());
                    contEspecie++;
                }
                indexEspecie = sc.nextInt();
                especie = Registro.especies.get(indexEspecie-1);
            } catch (InputMismatchException e) {
                System.out.println("Você digitou um caractere inválido. Digite um número.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Essa espécie não existe. Digite uma espécie válida.");
            }
            sc.nextLine();
        } while (indexEspecie <= 0 || indexEspecie > Registro.especies.size());

        Registro.pesquisarPorEspecie(especie);
    }
}
