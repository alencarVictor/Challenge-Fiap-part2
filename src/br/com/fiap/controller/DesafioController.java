package br.com.fiap.controller;

import br.com.fiap.model.dao.DesafioDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.DesafioDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class DesafioController {

    public String inserirDesafio(int idDesafio, String titulo, String descricao, String tipo, int pontos,
                                 String situacao, LocalDate dataInicio, LocalDate dataFim, Integer idBadgeExclusivo) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        DesafioDTO desafio = new DesafioDTO();
        desafio.setIdDesafio(idDesafio);
        desafio.setTitulo(titulo);
        desafio.setDescricao(descricao);
        desafio.setTipo(tipo);
        desafio.setPontos(pontos);
        desafio.setSituacao(situacao);
        desafio.setDataInicio(dataInicio);
        desafio.setDataFim(dataFim);
        desafio.setIdBadgeExclusivo(idBadgeExclusivo);

        DesafioDAO desafioDAO = new DesafioDAO(con);
        String resultado = desafioDAO.inserir(desafio);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarDesafio(int idDesafio, String titulo, String descricao, String tipo, int pontos,
                                 String situacao, LocalDate dataInicio, LocalDate dataFim, Integer idBadgeExclusivo) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        DesafioDTO desafio = new DesafioDTO();
        desafio.setIdDesafio(idDesafio);
        desafio.setTitulo(titulo);
        desafio.setDescricao(descricao);
        desafio.setTipo(tipo);
        desafio.setPontos(pontos);
        desafio.setSituacao(situacao);
        desafio.setDataInicio(dataInicio);
        desafio.setDataFim(dataFim);
        desafio.setIdBadgeExclusivo(idBadgeExclusivo);

        DesafioDAO desafioDAO = new DesafioDAO(con);
        String resultado = desafioDAO.alterar(desafio);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirDesafio(int idDesafio) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        DesafioDTO desafio = new DesafioDTO();
        desafio.setIdDesafio(idDesafio);

        DesafioDAO desafioDAO = new DesafioDAO(con);
        String resultado = desafioDAO.excluir(desafio);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmDesafio(int idDesafio) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        DesafioDTO desafio = new DesafioDTO();
        desafio.setIdDesafio(idDesafio);

        DesafioDAO desafioDAO = new DesafioDAO(con);
        String resultado = desafioDAO.listarUm(desafio);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}