package questao9;

import java.util.ArrayList;

public class Quarentena {
    private static ArrayList<Alienigena> listaQuarentena = new ArrayList<>();

    public static void addAlien(Alienigena alien) {
        listaQuarentena.add(alien);
    }

    public static void excluirAlien(Alienigena alien) {
        listaQuarentena.remove(alien);
    }

    public static void listarQuarentena() {
        for (Alienigena a : listaQuarentena) {
            a.imprimirAlien();
        }
    }

    public static ArrayList<Alienigena> getListaQuarentena() {
        return listaQuarentena;
    }
}
