package controller;

import java.util.ArrayList;
import java.util.List;
import model.PontoColeta;

public class ColetaController {
    private List<PontoColeta> dados;

    public ColetaController() {
        dados = new ArrayList<>();
        carregarDados();
    }

    private void carregarDados() {
        // --- COLETA SELETIVA (Horário: A partir das 05:00h) ---
        dados.add(new PontoColeta("Alto Gasparinho", "Seletiva", "Terça-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Arraial d'Ouro", "Seletiva", "Quarta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Barracão", "Seletiva", "Sexta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Bateias", "Seletiva", "Sexta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Bela Vista", "Seletiva", "Quinta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Belchior Alto", "Seletiva", "Quarta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Belchior Baixo", "Seletiva", "Quarta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Belchior Central", "Seletiva", "Quarta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Centro", "Seletiva", "Sexta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Coloninha", "Seletiva", "Quinta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Figueira", "Seletiva", "Quinta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Gaspar Grande", "Seletiva", "Terça-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Gaspar Mirim", "Seletiva", "Terça-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Gasparinho", "Seletiva", "Terça-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Lagoa", "Seletiva", "Quarta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Macuco", "Seletiva", "Sexta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Margem Esquerda", "Seletiva", "Segunda-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Poço Grande", "Seletiva", "Quarta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Santa Terezinha", "Seletiva", "Sexta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("São Pedro", "Seletiva", "Quarta-feira", "A partir das 05:00h"));
        dados.add(new PontoColeta("Sete de Setembro", "Seletiva", "Segunda-feira", "A partir das 05:00h"));

        // --- COLETA CONVENCIONAL (Turnos: Manhã / Tarde) ---
        dados.add(new PontoColeta("Alto Gasparinho", "Convencional", "Quarta-feira", "Manhã"));
        dados.add(new PontoColeta("Arraial d'Ouro", "Convencional", "Quinta-feira", "Manhã"));
        dados.add(new PontoColeta("Barracão", "Convencional", "Quarta-feira e Sábado", "Manhã"));
        dados.add(new PontoColeta("Bateias", "Convencional", "Quarta-feira e Sábado", "Manhã"));
        dados.add(new PontoColeta("Bela Vista", "Convencional", "Segunda, Quarta e Sexta", "Tarde"));
        dados.add(new PontoColeta("Belchior Alto", "Convencional", "Segunda e Sexta", "Manhã"));
        dados.add(new PontoColeta("Belchior Baixo", "Convencional", "Segunda e Sexta", "Manhã"));
        dados.add(new PontoColeta("Belchior Central", "Convencional", "Segunda e Sexta", "Manhã"));
        dados.add(new PontoColeta("Centro", "Convencional", "Segunda a Sábado", "Tarde"));
        dados.add(new PontoColeta("Coloninha", "Convencional", "Segunda, Quarta e Sexta", "Tarde"));
        dados.add(new PontoColeta("Figueira", "Convencional", "Segunda, Quarta e Sexta", "Tarde"));
        dados.add(new PontoColeta("Gaspar Grande", "Convencional", "Segunda, Quarta e Sexta", "Manhã"));
        dados.add(new PontoColeta("Gaspar Mirim", "Convencional", "Segunda, Quarta e Sexta", "Manhã"));
        dados.add(new PontoColeta("Gasparinho", "Convencional", "Segunda, Quarta e Sexta", "Manhã"));
        dados.add(new PontoColeta("Lagoa", "Convencional", "Terça-feira e Sábado", "Manhã"));
        dados.add(new PontoColeta("Macuco", "Convencional", "Terça-feira", "Manhã"));
        dados.add(new PontoColeta("Margem Esquerda", "Convencional", "Terça, Quinta e Sábado", "Manhã"));
        dados.add(new PontoColeta("Poço Grande", "Convencional", "Terça, Quinta e Sábado", "Manhã"));
        dados.add(new PontoColeta("Santa Terezinha", "Convencional", "Terça, Quinta e Sábado", "Tarde"));
        dados.add(new PontoColeta("São Pedro", "Convencional", "Terça, Quinta e Sábado", "Tarde"));
        dados.add(new PontoColeta("Sete de Setembro", "Convencional", "Terça, Quinta e Sábado", "Tarde"));
    }

    public List<PontoColeta> listarTodos() {
        return dados;
    }

    public List<PontoColeta> filtrar(String termo) {
        List<PontoColeta> resultado = new ArrayList<>();
        for (PontoColeta p : dados) {
            if (p.getBairro().toLowerCase().contains(termo.toLowerCase()) ||
                p.getTipo().toLowerCase().contains(termo.toLowerCase()) ||
                p.getDias().toLowerCase().contains(termo.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
