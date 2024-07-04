package questao9;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Registro {
    public static ArrayList<Planeta> planetas = new ArrayList<>();
    public static ArrayList<Especie> especies = new ArrayList<>();
    public static ArrayList<Alienigena> alienigenas = new ArrayList<>();
    private static int contAliens = 0;

    public static void registrarPlaneta(String nome) {
        planetas.add(new Planeta(nome));
    }

    public static void registrarEspecie(String nome, Planeta planeta, int periculosidade) {
        especies.add(new Especie(nome, planeta, periculosidade));
    }

    public static void registrarAlienigena(String nome, Especie especie, int nivelPericulosidade, LocalDateTime dataHoraEntrada) {
        Alienigena alienigena = new Alienigena(contAliens, nome, especie, nivelPericulosidade, dataHoraEntrada);
        if (alienigena.avaliarPericulosidade() > 10) {
            Quarentena.addAlien(alienigena);
        }
        alienigenas.add(alienigena);
        contAliens++;
    }

    public static void relatorioEntradas() {
        if(alienigenas.isEmpty()) {
            System.out.println("Nenhum alienígena foi registrado");
            return;
        }
        for (Alienigena a : alienigenas) {
            a.imprimirAlien();
        }
    }

    public static void listarPlanetas() {
        if (planetas.isEmpty()) {
            System.out.println("Nenhum planeta foi registrado");
            return;
        }
        for (Planeta p : planetas) {
            System.out.println(p.getNome());
        }
    }

    public static void listarEspecies() {
        if (especies.isEmpty()) {
            System.out.println("Nenhuma espécie foi registrada");
            return;
        }
        for (Especie e : especies) {
            e.imprimirEspecie();
        }
    }

    public static void rankingPericulosidade() {
        ArrayList<Alienigena> ranking = new ArrayList<>();
        ranking.addAll(alienigenas);
        Collections.sort(ranking);

        for (Alienigena a : ranking) {
            a.imprimirAlien();
        }
    }

    public static void entradasSeisMeses() {
        if (alienigenas.isEmpty()) {
            System.out.println("Nenhum alienígena foi cadastrado");
            return;
        }
        LocalDateTime data = LocalDateTime.now().minusMonths(6);
        for (Alienigena a : alienigenas) {
            if (a.getDataHoraEntrada().isAfter(data)) {
                a.imprimirAlien();
            }
        }
    }

    public static void pesquisarPorEspecie(Especie e) {
        if (alienigenas.isEmpty()) {
            System.out.println("Nenhum alienígena foi cadastrado");
            return;
        }
        for (Alienigena a : alienigenas) {
            if (a.getEspecie().equals(e)) {
                a.imprimirAlien();
            }
        }
    }

    public static void pesquisarPorPlaneta(Planeta p) {
        if (alienigenas.isEmpty()) {
            System.out.println("Nenhum alienígena foi cadastrado");
            return;
        }
        for (Alienigena a : alienigenas) {
            if (a.getEspecie().getPlaneta().equals(p)) {
                a.imprimirAlien();
            }
        }
    }

}
