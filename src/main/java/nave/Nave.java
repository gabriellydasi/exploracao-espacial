package nave;

import planeta.Planeta;
import recurso.Recurso;

import java.util.ArrayList;
import java.util.List;

public class Nave {
    private int posicao;
    private int combustivel;
    private static final int LITROS_DE_COMBUSTIVEL_GASTOS_POR_POSICAO = 3;

    public Nave(int quantidadeDeCombustivel) {
        this.posicao = 0;
        this.combustivel = quantidadeDeCombustivel;
    }

    public int getQuantidadeDeCombustivel() {
        return combustivel;
    }

    public int getPosicao() {
        return posicao;
    }

    public List<Recurso> explorar(List<Planeta> planetas) {
        List<Recurso> recursosColetados = new ArrayList<>();
        int posicaoBase = 0;

        for (Planeta planeta : planetas) {
            boolean naveChegouAoDestino = moverAteDestino(planeta.getPosicao());

            if (naveChegouAoDestino) {
                recursosColetados.addAll(planeta.getRecursos());
            } else {
                break;
            }
        }

        moverAteDestino(posicaoBase);
        return recursosColetados;
    }

    public List<Recurso> explorar(Planeta planeta) {
        List<Planeta> listaDeUmUnicoPlaneta = new ArrayList<>();
        listaDeUmUnicoPlaneta.add(planeta);
        return explorar(listaDeUmUnicoPlaneta);
    }

    private boolean moverAteDestino(int destino) {
        int distancia = Math.abs(destino - this.posicao);
        int combustivelNecessario = distancia * LITROS_DE_COMBUSTIVEL_GASTOS_POR_POSICAO;

        if (this.combustivel >= combustivelNecessario) {
            this.combustivel -= combustivelNecessario;
            this.posicao = destino;

            return true;
        } else {
            int movimentosPossiveis = Math.min(this.combustivel / LITROS_DE_COMBUSTIVEL_GASTOS_POR_POSICAO, distancia);
            int direcao = Integer.compare(destino, this.posicao);
            this.posicao = this.posicao + (movimentosPossiveis * direcao);
            this.combustivel -= movimentosPossiveis * LITROS_DE_COMBUSTIVEL_GASTOS_POR_POSICAO;

            return false;
        }
    }
}