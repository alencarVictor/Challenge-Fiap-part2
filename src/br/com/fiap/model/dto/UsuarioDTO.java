package br.com.fiap.model.dto;

import java.time.LocalDate;

public class UsuarioDTO {

    //atributos
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataCadastro;
    private String cidade;
    private int idAvatar;
    private int ofensivaAtual;
    private int maiorOfensiva;
    private LocalDate dataUltimaAcao;


    //construtor vazio
    public UsuarioDTO() {
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

    public LocalDate getDataCadastro() {return dataCadastro;}
    public void setDataCadastro(LocalDate dataCadastro) {this.dataCadastro = dataCadastro;}

    public String getCidade() {return cidade;}
    public void setCidade(String cidade) {this.cidade = cidade;}

    public int getIdAvatar() {return idAvatar;}
    public void setIdAvatar(int idAvatar) {this.idAvatar = idAvatar;}

    public int getOfensivaAtual() {return ofensivaAtual;}
    public void setOfensivaAtual(int ofensivaAtual) {this.ofensivaAtual = ofensivaAtual;}

    public int getMaiorOfensiva() {return maiorOfensiva;}
    public void setMaiorOfensiva(int maiorOfensiva) {this.maiorOfensiva = maiorOfensiva;}

    public LocalDate getDataUltimaAcao() {return dataUltimaAcao;}
    public void setDataUltimaAcao(LocalDate dataUltimaAcao) {
        this.dataUltimaAcao = dataUltimaAcao;
    }
}
