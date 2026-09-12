package br.com.fiap.model.dto;

import java.time.LocalDate;

public class RegistroDesafioDTO {

    //atributos
    private int idUsuarioDesafio;
    private String status;
    private LocalDate dataConclusao;
    private Integer pontosGanhos;
    private Double bonusMultiplicador;
    private int idUsuario;
    private int idDesafio;

    //construtor vazio
    public RegistroDesafioDTO() {
    }

    //getters e setters
    public int getIdUsuarioDesafio() {return idUsuarioDesafio;}
    public void setIdUsuarioDesafio(int idUsuarioDesafio) {this.idUsuarioDesafio = idUsuarioDesafio;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public LocalDate getDataConclusao() {return dataConclusao;}
    public void setDataConclusao(LocalDate dataConclusao) {this.dataConclusao = dataConclusao;}

    public Integer getPontosGanhos() {return pontosGanhos;}
    public void setPontosGanhos(Integer pontosGanhos) {this.pontosGanhos = pontosGanhos;}

    public Double getBonusMultiplicador() {return bonusMultiplicador;}
    public void setBonusMultiplicador(Double bonusMultiplicador) {this.bonusMultiplicador = bonusMultiplicador;}

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public int getIdDesafio() {return idDesafio;}
    public void setIdDesafio(int idDesafio) {this.idDesafio = idDesafio;}

    //metodo de logica de negocio
    public double calcularPontuacaoFinal() {
        if (this.pontosGanhos == null) {
            return 0.0;
        }
        double multiplicador = (this.bonusMultiplicador != null) ? this.bonusMultiplicador : 1.0;
        return this.pontosGanhos * multiplicador;
    }
}