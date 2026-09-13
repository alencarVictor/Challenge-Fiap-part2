package br.com.fiap.controller;

import br.com.fiap.model.dao.BadgeDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Badge;

import java.sql.Connection;
import java.sql.SQLException;

public class BadgeController {

    public String inserirBadge(int idBadge, String nome, String tipo, String descricao) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        Badge badge = new Badge();
        badge.setIdBadge(idBadge);
        badge.setNome(nome);
        badge.setTipo(tipo);
        badge.setDescricao(descricao);

        BadgeDAO badgeDAO = new BadgeDAO(con);
        String resultado = badgeDAO.inserir(badge);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarBadge(int idBadge, String nome, String tipo, String descricao) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        Badge badge = new Badge();
        badge.setIdBadge(idBadge);
        badge.setNome(nome);
        badge.setTipo(tipo);
        badge.setDescricao(descricao);

        BadgeDAO badgeDAO = new BadgeDAO(con);
        String resultado = badgeDAO.alterar(badge);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirBadge(int idBadge) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        Badge badge = new Badge();
        badge.setIdBadge(idBadge);

        BadgeDAO badgeDAO = new BadgeDAO(con);
        String resultado = badgeDAO.excluir(badge);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmBadge(int idBadge) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        Badge badge = new Badge();
        badge.setIdBadge(idBadge);

        BadgeDAO badgeDAO = new BadgeDAO(con);
        String resultado = badgeDAO.listarUm(badge);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}