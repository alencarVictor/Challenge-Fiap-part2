package br.com.fiap.controller;

import br.com.fiap.model.dao.RegistroDesafioDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.RegistroDesafioDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class RegistroDesafioController {

    public String inserirRegistroDesafio(int idUsuarioDesafio, String status, LocalDate dataConclusao,
                                         Integer pontosGanhos, Double bonusMultiplicador, int idUsuario, int idDesafio) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        RegistroDesafioDTO registroDesafio = new RegistroDesafioDTO();
        registroDesafio.setIdUsuarioDesafio(idUsuarioDesafio);
        registroDesafio.setStatus(status);
        registroDesafio.setDataConclusao(dataConclusao);
        registroDesafio.setPontosGanhos(pontosGanhos);
        registroDesafio.setBonusMultiplicador(bonusMultiplicador);
        registroDesafio.setIdUsuario(idUsuario);
        registroDesafio.setIdDesafio(idDesafio);

        RegistroDesafioDAO registroDesafioDAO = new RegistroDesafioDAO(con);
        String resultado = registroDesafioDAO.inserir(registroDesafio);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarRegistroDesafio(int idUsuarioDesafio, String status, LocalDate dataConclusao,
                                         Integer pontosGanhos, Double bonusMultiplicador, int idUsuario, int idDesafio) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        RegistroDesafioDTO registroDesafio = new RegistroDesafioDTO();
        registroDesafio.setIdUsuarioDesafio(idUsuarioDesafio);
        registroDesafio.setStatus(status);
        registroDesafio.setDataConclusao(dataConclusao);
        registroDesafio.setPontosGanhos(pontosGanhos);
        registroDesafio.setBonusMultiplicador(bonusMultiplicador);
        registroDesafio.setIdUsuario(idUsuario);
        registroDesafio.setIdDesafio(idDesafio);

        RegistroDesafioDAO registroDesafioDAO = new RegistroDesafioDAO(con);
        String resultado = registroDesafioDAO.alterar(registroDesafio);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirRegistroDesafio(int idUsuarioDesafio) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        RegistroDesafioDTO registroDesafio = new RegistroDesafioDTO();
        registroDesafio.setIdUsuarioDesafio(idUsuarioDesafio);

        RegistroDesafioDAO registroDesafioDAO = new RegistroDesafioDAO(con);
        String resultado = registroDesafioDAO.excluir(registroDesafio);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmRegistroDesafio(int idUsuarioDesafio) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        RegistroDesafioDTO registroDesafio = new RegistroDesafioDTO();
        registroDesafio.setIdUsuarioDesafio(idUsuarioDesafio);

        RegistroDesafioDAO registroDesafioDAO = new RegistroDesafioDAO(con);
        String resultado = registroDesafioDAO.listarUm(registroDesafio);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}