package br.com.fiap.controller;

import br.com.fiap.model.dao.UsuarioDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.UsuarioDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class UsuarioController {

    public String inserirUsuario(int idUsuario, String nome, String email, String senha,
                                 String cidade, int idAvatar, int ofensivaAtual) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setIdUsuario(idUsuario);
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setCidade(cidade);
        usuario.setIdAvatar(idAvatar);
        usuario.setOfensivaAtual(ofensivaAtual);

        UsuarioDAO usuarioDAO = new UsuarioDAO(con);
        String resultado = usuarioDAO.inserir(usuario);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarUsuario(int idUsuario, String nome, String email, String senha,
                                 String cidade, int idAvatar, int ofensivaAtual) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setIdUsuario(idUsuario);
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setCidade(cidade);
        usuario.setIdAvatar(idAvatar);
        usuario.setOfensivaAtual(ofensivaAtual);

        UsuarioDAO usuarioDAO = new UsuarioDAO(con);
        String resultado = usuarioDAO.alterar(usuario);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirUsuario(int idUsuario) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setIdUsuario(idUsuario);

        UsuarioDAO usuarioDAO = new UsuarioDAO(con);
        String resultado = usuarioDAO.excluir(usuario);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmUsuario(int idUsuario) throws SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setIdUsuario(idUsuario);

        UsuarioDAO usuarioDAO = new UsuarioDAO(con);
        String resultado = usuarioDAO.listarUm(usuario);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}