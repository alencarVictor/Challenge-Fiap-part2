package br.com.fiap.controller;

import br.com.fiap.model.dao.UsuarioBadgeDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.UsuarioBadgeDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class UsuarioBadgeController {

    public String inserirUsuarioBadge(int idUsuarioBadge, int idUsuario, int idBadge, LocalDate dataConquista, String destaque) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        UsuarioBadgeDTO usuarioBadge = new UsuarioBadgeDTO();
        usuarioBadge.setIdUsuarioBadge(idUsuarioBadge);
        usuarioBadge.setIdUsuario(idUsuario);
        usuarioBadge.setIdBadge(idBadge);
        usuarioBadge.setDataConquista(dataConquista);
        usuarioBadge.setDestaque(destaque);

        UsuarioBadgeDAO usuarioBadgeDAO = new UsuarioBadgeDAO(con);
        String resultado = usuarioBadgeDAO.inserir(usuarioBadge);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarUsuarioBadge(int idUsuarioBadge, int idUsuario, int idBadge, LocalDate dataConquista, String destaque) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        UsuarioBadgeDTO usuarioBadge = new UsuarioBadgeDTO();
        usuarioBadge.setIdUsuarioBadge(idUsuarioBadge);
        usuarioBadge.setIdUsuario(idUsuario);
        usuarioBadge.setIdBadge(idBadge);
        usuarioBadge.setDataConquista(dataConquista);
        usuarioBadge.setDestaque(destaque);

        UsuarioBadgeDAO usuarioBadgeDAO = new UsuarioBadgeDAO(con);
        String resultado = usuarioBadgeDAO.alterar(usuarioBadge);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirUsuarioBadge(int idUsuarioBadge) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        UsuarioBadgeDTO usuarioBadge = new UsuarioBadgeDTO();
        usuarioBadge.setIdUsuarioBadge(idUsuarioBadge);

        UsuarioBadgeDAO usuarioBadgeDAO = new UsuarioBadgeDAO(con);
        String resultado = usuarioBadgeDAO.excluir(usuarioBadge);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmUsuarioBadge(int idUsuarioBadge) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        UsuarioBadgeDTO usuarioBadge = new UsuarioBadgeDTO();
        usuarioBadge.setIdUsuarioBadge(idUsuarioBadge);

        UsuarioBadgeDAO usuarioBadgeDAO = new UsuarioBadgeDAO(con);
        String resultado = usuarioBadgeDAO.listarUm(usuarioBadge);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}