import nave.Nave;
import org.junit.Assert;
import org.junit.Test;
import planeta.Planeta;
import recurso.*;

import java.util.ArrayList;
import java.util.List;

public class ExploracaoEspacialTest {
    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta() {
        int posicaoEsperada = 3;
        int combustivelEsperado = 1;
        Nave milleniumFalcon = new Nave(10);
        Planeta tatooine = new Planeta(4, new ArrayList<Recurso>());

        List<Recurso> recursos = milleniumFalcon.explorar(tatooine);
        int posicaoResultante = milleniumFalcon.getPosicao();
        int combustivelFinal = milleniumFalcon.getQuantidadeDeCombustivel();

        Assert.assertTrue(recursos.isEmpty());
        Assert.assertEquals(combustivelEsperado, combustivelFinal);
        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void deveChegarAoPlanetaQuandoHouverCombustivelSuficiente() {
        List<Recurso> recursosNaboo = new ArrayList<>();
        recursosNaboo.add(new Agua());
        recursosNaboo.add(new Ferro());
        recursosNaboo.add(new Ouro());
        recursosNaboo.add(new Oxigenio());

        Planeta naboo = new Planeta(2, recursosNaboo);

        Nave razorCrest = new Nave(12);
        List<Recurso> recursosColetados = razorCrest.explorar(naboo);

        int posicaoEsperada = 0;
        int posicaoFinal = razorCrest.getPosicao();
        Assert.assertEquals(posicaoEsperada, posicaoFinal);

        int combustivelEsperado = 0;
        int combustivelFinal = 0;
        Assert.assertEquals(combustivelEsperado, combustivelFinal);

        int totalRecursosEsperado = 4;
        int totalRecursosFinal = recursosColetados.size();
        Assert.assertEquals(totalRecursosEsperado, totalRecursosFinal);
    }

    @Test
    public void deveChegarATodosOsPlanetasDaListaQuandoHouverCombustivelSuficiente() {
        List<Recurso> recursosNaboo = new ArrayList<>();
        recursosNaboo.add(new Agua());
        recursosNaboo.add(new Ferro());
        recursosNaboo.add(new Ouro());
        recursosNaboo.add(new Oxigenio());

        List<Recurso> recursosHoth = new ArrayList<>();
        recursosHoth.add(new Agua());
        recursosHoth.add(new Oxigenio());

        List<Recurso> recursosKamino = new ArrayList<>();
        recursosKamino.add(new Agua());
        recursosKamino.add(new Oxigenio());

        Planeta naboo = new Planeta(2, recursosNaboo);
        Planeta hoth = new Planeta(4, recursosHoth);
        Planeta kamino = new Planeta(6, recursosKamino);

        List<Planeta> planetas = new ArrayList<>();
        planetas.add(naboo);
        planetas.add(hoth);
        planetas.add(kamino);

        Nave vultureDroid = new Nave(48);
        List<Recurso> recursosColetados = vultureDroid.explorar(planetas);

        int posicaoEsperada = 0;
        int posicaoFinal = vultureDroid.getPosicao();
        Assert.assertEquals(posicaoEsperada, posicaoFinal);

        int combustivelEsperado = 0;
        int combustivelFinal = 0;
        Assert.assertEquals(combustivelEsperado, combustivelFinal);

        int totalRecursosEsperado = 8;
        int totalRecursosFinal = recursosColetados.size();
        Assert.assertEquals(totalRecursosEsperado, totalRecursosFinal);
    }

    @Test
    public void deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso() {
        Planeta mustafar = new Planeta(6, new ArrayList<Recurso>());

        int valorTotalEsperado = 0;
        int valorTotalResultante = mustafar.getValorTotal();

        Assert.assertEquals(valorTotalEsperado, valorTotalResultante);
    }

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta() {
        List<Recurso> recursos = new ArrayList<>();
        recursos.add(new Agua());
        recursos.add(new Ferro());
        recursos.add(new Oxigenio());
        recursos.add(new Silicio());

        Planeta kashyyyk = new Planeta(6, recursos);

        int valorTotalEsperado = 570;
        int valorTotalResultante = kashyyyk.getValorTotal();

        Assert.assertEquals(valorTotalEsperado, valorTotalResultante);
    }

    @Test
    public void deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso() {
        Planeta mustafar = new Planeta(6, new ArrayList<Recurso>());

        int valorPorPesoEsperado = 0;
        int valorPorPesoResultante = mustafar.getValorTotal();

        Assert.assertEquals(valorPorPesoEsperado, valorPorPesoResultante);
    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta() {
        List<Recurso> recursos = new ArrayList<>();
        recursos.add(new Agua());
        recursos.add(new Ferro());
        recursos.add(new Oxigenio());
        recursos.add(new Silicio());

        Planeta kashyyyk = new Planeta(6, recursos);

        int valorPorPesoEsperado = 171;
        int valorPorPesoResultante = kashyyyk.getValorPorPeso();

        Assert.assertEquals(valorPorPesoEsperado, valorPorPesoResultante);
    }
}