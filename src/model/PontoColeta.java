package model;

public class PontoColeta {
    private String bairro;
    private String tipo;
    private String dias;
    private String horario;

    public PontoColeta(String bairro, String tipo, String dias, String horario) {
        this.bairro = bairro;
        this.tipo = tipo;
        this.dias = dias;
        this.horario = horario;
    }

    public String getBairro() { return bairro; }
    public String getTipo() { return tipo; }
    public String getDias() { return dias; }
    public String getHorario() { return horario; }
}
