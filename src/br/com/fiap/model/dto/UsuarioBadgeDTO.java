package br.com.fiap.model.dto;

import java.time.LocalDate;

public class UsuarioBadgeDTO {

    //atributos
    private int idUsuarioBadge;
    private int idUsuario;
    private int idBadge;
    private LocalDate dataConquista;
    private String destaque;


    //construtor vazio
    public UsuarioBadgeDTO() {
    }

    //getters e setters
    public int getIdUsuarioBadge() {return idUsuarioBadge;}
    public void setIdUsuarioBadge(int idUsuarioBadge) {this.idUsuarioBadge = idUsuarioBadge;}

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public int getIdBadge() {return idBadge;}
    public void setIdBadge(int idBadge) {this.idBadge = idBadge;}

    public LocalDate getDataConquista() {return dataConquista;}
    public void setDataConquista(LocalDate dataConquista) {this.dataConquista = dataConquista;}

    public String getDestaque() {return destaque;}
    public void setDestaque(String destaque) {this.destaque = destaque;}
}
