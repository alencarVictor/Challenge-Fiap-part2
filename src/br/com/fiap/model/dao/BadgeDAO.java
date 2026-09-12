package br.com.fiap.model.dao;


import br.com.fiap.model.dto.BadgeDTO;
import br.com.fiap.model.interfaces.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BadgeDAO implements IDAO {

    //import
    private Connection con;
    private BadgeDTO badge;

    //construtor com passagem de parametro
    public BadgeDAO(Connection con) {
        this.con = con;
    }

    //getter
    public Connection getCon() {return con;}

    //metodo da classe
    public String inserir(Object object){
        badge = (BadgeDTO) object; // Conversao implicita
        String sql = "insert into t_badge( id_badge ,nome,tipo, descricao) values(?,?,?,?)";
        //try-with-resources
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){
            ps.setInt(1, badge.getIdBadge());
            ps.setString(2, badge.getNome());
            ps.setString(3, badge.getTipo());
            ps.setString(4, badge.getDescricao());
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
        badge = (BadgeDTO) object; // Conversao implicita
        String sql = "update t_badge set nome=?,tipo=?, descricao=? where id_badge=?";
        //try-with-resources
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){



            ps.setString(1, badge.getNome());
            ps.setString(2, badge.getTipo());
            ps.setString(3, badge.getDescricao());
            ps.setInt(4, badge.getIdBadge());
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
        badge = (BadgeDTO) object; // Conversao implicita
        String sql = "delete from  t_badge where id_badge=?";
        //try-with-resources
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){
            ps.setInt(1, badge.getIdBadge());
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
        badge = (BadgeDTO) object; // Conversao implicita
        String sql = "select * from t_badge where id_badge=?";
        //try-with-resources(descarta objeto ps e rs)
        try(PreparedStatement ps = getCon().prepareStatement(sql))
        {
            ps.setInt(1,badge.getIdBadge());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){// verifica se tem linha para ler:  true/false
                return "Id_badge: " + badge.getIdBadge() + "\nNome: " + rs.getString("nome") +
                        "\nTipo: " + rs.getString("tipo") + "\nDescricao: " + rs.getString("descricao");

            }else{
                return "Registro não encontrado";
            }
        }catch (SQLException e){
            return  "Erro de SQL:" + e.getMessage();
        }
    }
}
