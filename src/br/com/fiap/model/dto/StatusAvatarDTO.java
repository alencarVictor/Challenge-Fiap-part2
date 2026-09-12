package br.com.fiap.model.dto;

public class StatusAvatarDTO {

    //Atributos
    private int idNivel;
    private int nivel;
    private double xpNecessario;
    private String titulo;
    private String skinDesbloqueada;
    private String beneficio;

    //construtor vazio

    public StatusAvatarDTO() {
    }

    //getter e setters

    public int getIdNivel() {return idNivel;}
    public void setIdNivel(int idNivel) {this.idNivel = idNivel;}

    public int getNivel() {return nivel;}
    public void setNivel(int nivel) {this.nivel = nivel;}

    public double getXpNecessario() {return xpNecessario;}
    public void setXpNecessario(double xpNecessario) {this.xpNecessario = xpNecessario;}

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getSkinDesbloqueada() {return skinDesbloqueada;}
    public void setSkinDesbloqueada(String skinDesbloqueada) {this.skinDesbloqueada = skinDesbloqueada;}

    public String getBeneficio() {return beneficio;}
    public void setBeneficio(String beneficio) {this.beneficio = beneficio;}
}
