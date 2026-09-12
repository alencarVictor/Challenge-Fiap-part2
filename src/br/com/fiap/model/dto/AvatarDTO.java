package br.com.fiap.model.dto;

public class AvatarDTO {
    //atributos
    private int idAvatar;
    private String nome;
    private int nivelAtual;
    private double xpAtual;

    //construtor vazio
    public AvatarDTO() {
    }

    public int getIdAvatar() {return idAvatar;}
    public void setIdAvatar(int idAvatar) {this.idAvatar = idAvatar;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public int getNivelAtual() {return nivelAtual;}
    public void setNivelAtual(int nivelAtual) {this.nivelAtual = nivelAtual;}

    public double getXpAtual() {return xpAtual;}
    public void setXpAtual(double xpAtual) {this.xpAtual = xpAtual;
    }

    //metodos de logica de negocio
    public void ganharXp(double xp) {
        if (xp > 0) {
            this.xpAtual += xp;
        }
    }

    public boolean podeSubirNivel(double xpNecessarioProximoNivel) {
        return this.xpAtual >= xpNecessarioProximoNivel;
    }
}