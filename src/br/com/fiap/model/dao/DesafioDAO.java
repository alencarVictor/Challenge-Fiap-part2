package br.com.fiap.model.dao;

import br.com.fiap.model.dto.DesafioDTO;
import br.com.fiap.model.interfaces.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DesafioDAO implements IDAO{

        //import
        private Connection con;
        private DesafioDTO desafio;

        //construtor com passagem de parametro
        public DesafioDAO(Connection con) {
            this.con = con;
        }

        //getter
        public Connection getCon() {return con;}

    public String inserir(Object object){
        desafio = (DesafioDTO) object; // Conversao implicita
        String sql = "insert into t_desafio (id_desafio, titulo, descricao, tipo, pontos, situacao, data_inicio, data_fim, id_badge_exclusivo) values(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){
            ps.setInt(1, desafio.getIdDesafio());
            ps.setString(2, desafio.getTitulo());
            ps.setString(3, desafio.getDescricao());
            ps.setString(4, desafio.getTipo());
            ps.setInt(5, desafio.getPontos());
            ps.setString(6, desafio.getSituacao());
            ps.setDate(7, java.sql.Date.valueOf(desafio.getDataInicio()));

            if (desafio.getDataFim() != null){
                ps.setDate(8, java.sql.Date.valueOf(desafio.getDataFim()));
            } else {
                ps.setNull(8, java.sql.Types.DATE);
            }

            if (desafio.getIdBadgeExclusivo() != null){
                ps.setInt(9, desafio.getIdBadgeExclusivo());
            } else {
                ps.setNull(9, java.sql.Types.INTEGER);
            }

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
        desafio = (DesafioDTO) object; // Conversao implicita
        String sql = "update t_desafio set titulo=?, descricao=?, tipo=?, pontos=?, situacao=?, data_inicio=?, data_fim=?, id_badge_exclusivo=? where id_desafio=?";
        //try-with-resources
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){

            ps.setString(1, desafio.getTitulo());
            ps.setString(2, desafio.getDescricao());
            ps.setString(3, desafio.getTipo());
            ps.setInt(4, desafio.getPontos());
            ps.setString(5, desafio.getSituacao());
            ps.setDate(6, java.sql.Date.valueOf(desafio.getDataInicio()));

            if (desafio.getDataFim() != null){
                ps.setDate(7, java.sql.Date.valueOf(desafio.getDataFim()));
            } else {
                ps.setNull(7, java.sql.Types.DATE);
            }

            if (desafio.getIdBadgeExclusivo() != null){
                ps.setInt(8, desafio.getIdBadgeExclusivo());
            } else {
                ps.setNull(8, java.sql.Types.INTEGER);
            }

            ps.setInt(9, desafio.getIdDesafio());

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
            desafio = (DesafioDTO) object; // Conversao implicita
            String sql = "delete from t_desafio where id_desafio=?";
            //try-with-resources
            try (PreparedStatement ps =  getCon().prepareStatement(sql)){
                ps.setInt(1, desafio.getIdDesafio());
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
            desafio = (DesafioDTO) object; // Conversao implicita
            String sql = "select * from t_desafio where id_desafio=?";
            //try-with-resources(descarta objeto ps e rs)
            try(PreparedStatement ps = getCon().prepareStatement(sql))
            {
                ps.setInt(1,desafio.getIdDesafio());
                ResultSet rs = ps.executeQuery();
                if (rs.next()){// verifica se tem linha para ler:  true/false
                    return "Id_desafio: " + desafio.getIdDesafio() + "\nTitulo: " + rs.getString("titulo") +
                            "\nDescricao: " + rs.getString("descricao") +
                            "\nTipo: " + rs.getString("tipo") +
                            "\nPontos: " + rs.getInt("pontos") +
                            "\nSituacao: " + rs.getString("situacao") +
                            "\nData_Inicio: " + rs.getDate("data_inicio") +
                            "\nData_Fim: " + rs.getDate("data_fim") +
                            "\nId_Badge_Exclusivo: " + rs.getObject("id_badge_exclusivo");
                }else{
                    return "Registro não encontrado";
                }
            }catch (SQLException e){
                return  "Erro de SQL:" + e.getMessage();
            }
        }
    }
