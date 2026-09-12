package br.com.fiap.model.dto;

public class BadgeDTO {

    //atributos
    private int idBadge;
    private String nome;
    private String tipo;
    private String descricao;

    //construtor vazio
    public BadgeDTO() {
    }

    //getters e setters
    public int getIdBadge() {return idBadge;}
    public void setIdBadge(int idBadge) {this.idBadge = idBadge;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
}
