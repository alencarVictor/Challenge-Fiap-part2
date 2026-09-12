package br.com.fiap.model.dao;

import br.com.fiap.model.dto.UsuarioBadgeDTO;
import br.com.fiap.model.interfaces.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioBadgeDAO implements IDAO{


        //import
        private Connection con;
        private UsuarioBadgeDTO usuarioBadge;

        //construtor com passagem de parametro
        public UsuarioBadgeDAO(Connection con) {
            this.con = con;
        }

        //getter
        public Connection getCon() {return con;}

        public String inserir(Object object){
            usuarioBadge = (UsuarioBadgeDTO) object; // Conversao implicita
            String sql = "insert into  t_usuario_badge( id_usuario_badge ,id_usuario ,id_badge ,data_conquista,destaque) values(?,?,?,?,?)";
            try (PreparedStatement ps =  getCon().prepareStatement(sql)){
                ps.setInt(1, usuarioBadge.getIdUsuarioBadge());
                ps.setInt(2, usuarioBadge.getIdUsuario());
                ps.setInt(3, usuarioBadge.getIdBadge());
                ps.setDate(4,java.sql.Date.valueOf( usuarioBadge.getDataConquista()));
                ps.setString(5, usuarioBadge.getDestaque());


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
            usuarioBadge = (UsuarioBadgeDTO) object; // Conversao implicita
            String sql = "update  t_usuario_badge set id_usuario=? ,id_badge=? ,data_conquista=?,destaque=? where  id_usuario_badge=?";
            //try-with-resources
            try (PreparedStatement ps =  getCon().prepareStatement(sql)){

                ps.setInt(1, usuarioBadge.getIdUsuario());
                ps.setInt(2, usuarioBadge.getIdBadge());
                ps.setDate(3,java.sql.Date.valueOf( usuarioBadge.getDataConquista()));
                ps.setString(4, usuarioBadge.getDestaque());
                ps.setInt(5, usuarioBadge.getIdUsuarioBadge());

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
            usuarioBadge = (UsuarioBadgeDTO) object; // Conversao implicita
            String sql = "delete from  t_usuario_badge where id_usuario_badge=?";
            //try-with-resources
            try (PreparedStatement ps =  getCon().prepareStatement(sql)){
                ps.setInt(1, usuarioBadge.getIdUsuarioBadge());
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
            usuarioBadge = (UsuarioBadgeDTO) object; // Conversao implicita
            String sql = "select * from  t_usuario_badge  where id_usuario_badge=?";
            //try-with-resources(descarta objeto ps e rs)
            try(PreparedStatement ps = getCon().prepareStatement(sql))
            {
                ps.setInt(1, usuarioBadge.getIdUsuarioBadge());
                ResultSet rs = ps.executeQuery();
                if (rs.next()){// verifica se tem linha para ler:  true/false
                    return "Id_usuario_badge: " + usuarioBadge.getIdUsuarioBadge() + "\nId_Usuario: " + rs.getInt("id_usuario") +
                            "\nId_Badge: " + rs.getInt("id_badge") +
                            "\nData_Conquista: " + rs.getDate("data_conquista") +
                            "\nDestaque: " + rs.getString("destaque");
                }else{
                    return "Registro não encontrado";
                }
            }catch (SQLException e){
                return  "Erro de SQL:" + e.getMessage();
            }
        }
    }
