package questao9;

import java.time.LocalDateTime;

public class Alienigena implements Comparable<Alienigena>{
    private int id = 0;
    private String nome;
    private Especie especie;
    private int nivelPericulosidade;
    private LocalDateTime dataHoraEntrada;

    public Alienigena(int id, String nome, Especie especie, int nivelPericulosidade, LocalDateTime dataHoraEntrada) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.nivelPericulosidade = nivelPericulosidade;
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public void imprimirAlien() {
        System.out.print("\n"+this.id+" - "+this.nome+". Espécie: "+this.especie.getNome()+". Planeta: "+this.especie.getPlaneta().getNome()+
                ". Periculosidade: "+this.avaliarPericulosidade());
        if (Quarentena.getListaQuarentena().contains(this)) {
            System.out.print(". Em Quarentena");
        }
    }

    public int avaliarPericulosidade() {
        return this.nivelPericulosidade + this.especie.getPericulosidade();
    }


    @Override
    public int compareTo(Alienigena o) {
        return o.avaliarPericulosidade() - this.avaliarPericulosidade();
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public Especie getEspecie() {
        return especie;
    }
}
