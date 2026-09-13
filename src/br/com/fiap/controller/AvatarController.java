package br.com.fiap.controller;

import br.com.fiap.model.dao.AvatarDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Avatar;

import java.sql.Connection;
import java.sql.SQLException;

public class AvatarController {

    public String inserirAvatar(int idAvatar, String nome, int nivelAtual, double xpAtual) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        Avatar avatar = new Avatar();
        avatar.setIdAvatar(idAvatar);
        avatar.setNome(nome);
        avatar.setNivelAtual(nivelAtual);
        avatar.setXpAtual(xpAtual);

        AvatarDAO avatarDAO = new AvatarDAO(con);
        String resultado = avatarDAO.inserir(avatar);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarAvatar(int idAvatar, String nome, int nivelAtual, double xpAtual) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        Avatar avatar = new Avatar();
        avatar.setIdAvatar(idAvatar);
        avatar.setNome(nome);
        avatar.setNivelAtual(nivelAtual);
        avatar.setXpAtual(xpAtual);

        AvatarDAO avatarDAO = new AvatarDAO(con);
        String resultado = avatarDAO.alterar(avatar);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirAvatar(int idAvatar) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        Avatar avatar = new Avatar();
        avatar.setIdAvatar(idAvatar);

        AvatarDAO avatarDAO = new AvatarDAO(con);
        String resultado = avatarDAO.excluir(avatar);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmAvatar(int idAvatar) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        Avatar avatar = new Avatar();
        avatar.setIdAvatar(idAvatar);

        AvatarDAO avatarDAO = new AvatarDAO(con);
        String resultado = avatarDAO.listarUm(avatar);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}