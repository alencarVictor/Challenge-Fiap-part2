package br.com.fiap.controller;

import br.com.fiap.model.dao.PontuacaoDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.PontuacaoDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class PontuacaoController {

    public String inserirPontuacao(int idPontuacao, double pontos, String origem, LocalDate dataRegistro, int idUsuario) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        PontuacaoDTO pontuacao = new PontuacaoDTO();
        pontuacao.setIdPontuacao(idPontuacao);
        pontuacao.setPontos(pontos);
        pontuacao.setOrigem(origem);
        pontuacao.setDataRegistro(dataRegistro);
        pontuacao.setIdUsuario(idUsuario);

        PontuacaoDAO pontuacaoDAO = new PontuacaoDAO(con);
        String resultado = pontuacaoDAO.inserir(pontuacao);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarPontuacao(int idPontuacao, double pontos, String origem, LocalDate dataRegistro, int idUsuario) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        PontuacaoDTO pontuacao = new PontuacaoDTO();
        pontuacao.setIdPontuacao(idPontuacao);
        pontuacao.setPontos(pontos);
        pontuacao.setOrigem(origem);
        pontuacao.setDataRegistro(dataRegistro);
        pontuacao.setIdUsuario(idUsuario);

        PontuacaoDAO pontuacaoDAO = new PontuacaoDAO(con);
        String resultado = pontuacaoDAO.alterar(pontuacao);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirPontuacao(int idPontuacao) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        PontuacaoDTO pontuacao = new PontuacaoDTO();
        pontuacao.setIdPontuacao(idPontuacao);

        PontuacaoDAO pontuacaoDAO = new PontuacaoDAO(con);
        String resultado = pontuacaoDAO.excluir(pontuacao);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmPontuacao(int idPontuacao) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        PontuacaoDTO pontuacao = new PontuacaoDTO();
        pontuacao.setIdPontuacao(idPontuacao);

        PontuacaoDAO pontuacaoDAO = new PontuacaoDAO(con);
        String resultado = pontuacaoDAO.listarUm(pontuacao);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}