package br.com.fiap.controller;

import br.com.fiap.model.dao.StatusAvatarDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.StatusAvatarDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class StatusAvatarController {

    public String inserirStatus(int idNivel, int nivel, double xpNecessario, String titulo, String skinDesbloqueada, String beneficio) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        StatusAvatarDTO status = new StatusAvatarDTO();
        status.setIdNivel(idNivel);
        status.setNivel(nivel);
        status.setXpNecessario(xpNecessario);
        status.setTitulo(titulo);
        status.setSkinDesbloqueada(skinDesbloqueada);
        status.setBeneficio(beneficio);

        StatusAvatarDAO statusDAO = new StatusAvatarDAO(con);
        String resultado = statusDAO.inserir(status);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarStatus(int idNivel, int nivel, double xpNecessario, String titulo, String skinDesbloqueada, String beneficio) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        StatusAvatarDTO status = new StatusAvatarDTO();
        status.setIdNivel(idNivel);
        status.setNivel(nivel);
        status.setXpNecessario(xpNecessario);
        status.setTitulo(titulo);
        status.setSkinDesbloqueada(skinDesbloqueada);
        status.setBeneficio(beneficio);

        StatusAvatarDAO statusDAO = new StatusAvatarDAO(con);
        String resultado = statusDAO.alterar(status);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirStatus(int idNivel) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        StatusAvatarDTO status = new StatusAvatarDTO();
        status.setIdNivel(idNivel);

        StatusAvatarDAO statusDAO = new StatusAvatarDAO(con);
        String resultado = statusDAO.excluir(status);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmStatus(int idNivel) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        StatusAvatarDTO status = new StatusAvatarDTO();
        status.setIdNivel(idNivel);

        StatusAvatarDAO statusDAO = new StatusAvatarDAO(con);
        String resultado = statusDAO.listarUm(status);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}