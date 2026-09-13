package br.com.fiap.model.dto;

public class Usuario {

    //atributos
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String cidade;
    private int idAvatar;
    private int ofensivaAtual;




    //construtor vazio
    public Usuario() {
    }


    //getters e setters
    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}



    public String getCidade() {return cidade;}
    public void setCidade(String cidade) {this.cidade = cidade;}

    public int getIdAvatar() {return idAvatar;}
    public void setIdAvatar(int idAvatar) {this.idAvatar = idAvatar;}

    public int getOfensivaAtual() {return ofensivaAtual;}
    public void setOfensivaAtual(int ofensivaAtual) {this.ofensivaAtual = ofensivaAtual;}


}
