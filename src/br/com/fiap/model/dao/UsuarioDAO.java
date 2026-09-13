package br.com.fiap.model.dao;


import br.com.fiap.model.dto.Usuario;
import br.com.fiap.model.interfaces.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO implements IDAO {
    //import
    private Connection con;
    private Usuario usuario;

    //construtor com passagem de parametro
    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    //getter
    public Connection getCon() {return con;}

    public String inserir(Object object){
        usuario = (Usuario) object; // Conversao implicita
        String sql = "insert into t_usuario(id_usuario ,nome,email ,senha,cidade,id_avatar,ofensiva_atual) values(?,?,?,?,?,?,?)";
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){
            ps.setInt(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.setString(5, usuario.getCidade());
            ps.setInt(6, usuario.getIdAvatar());
            ps.setInt(7, usuario.getOfensivaAtual());


            if (ps.executeUpdate() > 0){
                return "Inserido com sucesso";
            }else {
                return "Erro ao inserir";
            }

        }catch (SQLException e){
            return "Erro de SQL:" + e.getMessage();
        }
    }

    public String alterar(Object object){
        usuario = (Usuario) object; // Conversao implicita
        String sql = "update t_usuario set nome=?, email=?, senha=?,  cidade=?, id_avatar=?, ofensiva_atual=? where id_usuario=?";
        //try-with-resources
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getCidade());
            ps.setInt(5, usuario.getIdAvatar());
            ps.setInt(6, usuario.getOfensivaAtual());
            ps.setInt(7, usuario.getIdUsuario());

            if (ps.executeUpdate() > 0){
                return "Alterado com sucesso";
            }else {
                return "Erro ao alterar";
            }

        }catch (SQLException e){
            return "Erro de SQL:" + e.getMessage();
        }
    }

    public String excluir(Object object){
        usuario = (Usuario) object; // Conversao implicita
        String sql = "delete from t_usuario where id_usuario=?";
        //try-with-resources
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){
            ps.setInt(1, usuario.getIdUsuario());
            if (ps.executeUpdate() > 0){
                return "Excluido com sucesso";

            }else {
                return "Erro ao excluir";

            }

        }catch (SQLException e){
            return "Erro de SQL:" + e.getMessage();
        }
    }

    public String listarUm(Object object){
        usuario = (Usuario) object; // Conversao implicita
        String sql = "select * from t_usuario where id_usuario=?";
        //try-with-resources(descarta objeto ps e rs)
        try(PreparedStatement ps = getCon().prepareStatement(sql))
        {
            ps.setInt(1,usuario.getIdUsuario());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){// verifica se tem linha para ler:  true/false
                return "Id_usuario: " + usuario.getIdUsuario() + "\nNome: " + rs.getString("nome") +
                        "\nEmail: " + rs.getString("email") +
                        "\nCidade: " + rs.getString("cidade") +
                        "\nId_Avatar: " + rs.getInt("id_avatar") +
                        "\nOfensiva_Atual: " + rs.getInt("ofensiva_atual")+" dias";

            }else{
                return "Registro não encontrado";
            }
        }catch (SQLException e){
            return  "Erro de SQL:" + e.getMessage();
        }
    }
}
