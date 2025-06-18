package planeta;

import recurso.Recurso;

import java.util.List;

public class Planeta {
    private final int posicao;
    private final List<Recurso> recursos;

    public Planeta(int posicao, List<Recurso> recursos) {
        this.posicao = posicao;
        this.recursos = recursos;
    }

    public int getPosicao() {
        return posicao;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public int getValorTotal() {
        int valorTotal = 0;

        for (Recurso recurso : this.recursos) {
            valorTotal += recurso.getValor();
        }

        return valorTotal;
    }

    public int getValorPorPeso() {
        int valorTotalPorPeso = 0;
        for (Recurso recurso : this.recursos) {
            valorTotalPorPeso += recurso.getValor() / recurso.getPeso();
        }

        return valorTotalPorPeso;
    }
}