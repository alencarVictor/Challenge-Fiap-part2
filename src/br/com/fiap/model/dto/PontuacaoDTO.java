package br.com.fiap.model.dto;

import java.time.LocalDate;

public class PontuacaoDTO {

    //atributos
    private int idPontuacao;
    private double pontos;
    private String origem;
    private LocalDate dataRegistro;
    private int idUsuario;

    //construtor vazio
    public PontuacaoDTO() {
    }

    //getters e setters
    public int getIdPontuacao() {return idPontuacao;}
    public void setIdPontuacao(int idPontuacao) {this.idPontuacao = idPontuacao;}

    public double getPontos() {return pontos;}
    public void setPontos(double pontos) {this.pontos = pontos;}

    public String getOrigem() {return origem;}
    public void setOrigem(String origem) {this.origem = origem;}

    public LocalDate getDataRegistro() {return dataRegistro;}
    public void setDataRegistro(LocalDate dataRegistro) {this.dataRegistro = dataRegistro;}

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
