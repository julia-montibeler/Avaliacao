package questao9;

public class Especie {
    private String nome;
    private Planeta planeta;
    private int periculosidade;

    public Especie(String nome, Planeta planeta, int periculosidade) {
        this.nome = nome;
        this.planeta = planeta;
        this.periculosidade = periculosidade;
    }

    public String getNome() {
        return nome;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public int getPericulosidade() {
        return periculosidade;
    }

    public void imprimirEspecie() {
        System.out.println(this.getNome()+". Periculosidade: "+this.periculosidade);
    }
}
