package br.com.fiap.model.dto;

import java.time.LocalDate;


public class DesafioDTO {

    //atributos
    private int idDesafio;
    private String titulo;
    private String descricao;
    private String tipo;
    private int pontos;
    private String situacao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Integer idBadgeExclusivo;

    //construtor vazio
    public DesafioDTO() {
    }

    //getters e setters
    public int getIdDesafio() {return idDesafio;}
    public void setIdDesafio(int idDesafio) {this.idDesafio = idDesafio;}

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public int getPontos() {return pontos;}
    public void setPontos(int pontos) {this.pontos = pontos;}

    public String getSituacao() {return situacao;}
    public void setSituacao(String situacao) {this.situacao = situacao;}

    public LocalDate getDataInicio() {return dataInicio;}
    public void setDataInicio(LocalDate dataInicio) {this.dataInicio = dataInicio;}

    public LocalDate getDataFim() {return dataFim;}
    public void setDataFim(LocalDate dataFim) {this.dataFim = dataFim;}

    public Integer getIdBadgeExclusivo() {return idBadgeExclusivo;}
    public void setIdBadgeExclusivo(Integer idBadgeExclusivo) {
        this.idBadgeExclusivo = idBadgeExclusivo;
    }
}
