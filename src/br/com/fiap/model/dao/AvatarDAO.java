package br.com.fiap.model.dao;



import br.com.fiap.model.dto.Avatar;
import br.com.fiap.model.interfaces.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AvatarDAO implements IDAO {
    //import
    private Connection con;
    private Avatar avatar;

    //construtor com passagem de parametro
    public AvatarDAO(Connection con) {
        this.con = con;
    }

    //getter
    public Connection getCon() {return con;}

    //metodo da classe
    public String inserir(Object object){
        avatar = (Avatar) object; // Conversao implicita
        String sql = "insert into t_avatar(id_avatar,nome,nivel_atual,xp_atual) values(?,?,?,?)";
        //try-with-resources
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){
            ps.setInt(1, avatar.getIdAvatar());
            ps.setString(2, avatar.getNome());
            ps.setInt(3, avatar.getNivelAtual());
            ps.setDouble(4, avatar.getXpAtual());
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
        avatar = (Avatar) object; // Conversao implicita
        String sql = "update t_avatar set nome=?,nivel_atual=?, xp_atual=? where id_avatar=?";
        //try-with-resources
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){


            ps.setString(1, avatar.getNome());
            ps.setInt(2, avatar.getNivelAtual());
            ps.setDouble(3, avatar.getXpAtual());
            ps.setInt(4,  avatar.getIdAvatar());
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
        avatar = (Avatar) object; // Conversao implicita
        String sql = "delete from  t_avatar where id_avatar=?";
        //try-with-resources
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){
            ps.setInt(1, avatar.getIdAvatar());
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
        avatar = (Avatar) object; // Conversao implicita
        String sql = "select * from t_avatar where id_avatar=?";
        //try-with-resources(descarta objeto ps e rs)
        try(PreparedStatement ps = getCon().prepareStatement(sql))
        {
            ps.setInt(1,avatar.getIdAvatar());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){// verifica se tem linha para ler:  true/false
                return "Id_avatar: "+ avatar.getIdAvatar()+ "\nNome: "+rs.getString("nome")+
                        "\nNivel_atual: " +rs.getInt("nivel_atual")+"\nXp_Atual: " +rs.getDouble("xp_atual");

            }else{
                return "Registro não encontrado";
            }
        }catch (SQLException e){
            return  "Erro de SQL:" + e.getMessage();
        }
    }
}


