package br.com.fiap.model.dao;

import br.com.fiap.model.dto.PontuacaoDTO;
import br.com.fiap.model.interfaces.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PontuacaoDAO implements IDAO {

        //import
        private Connection con;
        private PontuacaoDTO pontuacao;

        //construtor com passagem de parametro
        public PontuacaoDAO(Connection con) {
            this.con = con;
        }

        //getter
        public Connection getCon() {return con;}

        public String inserir(Object object){
            pontuacao = (PontuacaoDTO) object; // Conversao implicita
            String sql = "insert into t_pontuacao( id_pontuacao ,pontos,origem ,data_registro,id_usuario) values(?,?,?,?,?)";
            try (PreparedStatement ps =  getCon().prepareStatement(sql)){
                ps.setInt(1, pontuacao.getIdPontuacao());
                ps.setDouble(2, pontuacao.getPontos());
                ps.setString(3, pontuacao.getOrigem());
                ps.setDate(4,java.sql.Date.valueOf( pontuacao.getDataRegistro()));
                ps.setInt(5, pontuacao.getIdUsuario());


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
            pontuacao = (PontuacaoDTO) object; // Conversao implicita
            String sql = "update t_pontuacao set pontos=?, origem=?, data_registro =?, id_usuario=? where id_pontuacao=?";
            //try-with-resources
            try (PreparedStatement ps =  getCon().prepareStatement(sql)){

                ps.setDouble(1, pontuacao.getPontos());
                ps.setString(2, pontuacao.getOrigem());
                ps.setDate(3,java.sql.Date.valueOf( pontuacao.getDataRegistro()));
                ps.setInt(4, pontuacao.getIdUsuario());
                ps.setInt(5, pontuacao.getIdPontuacao());

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
            pontuacao = (PontuacaoDTO) object; // Conversao implicita
            String sql = "delete from t_pontuacao where id_pontuacao=?";
            //try-with-resources
            try (PreparedStatement ps =  getCon().prepareStatement(sql)){
                ps.setInt(1, pontuacao.getIdPontuacao());
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
            pontuacao = (PontuacaoDTO) object; // Conversao implicita
            String sql = "select * from t_pontuacao  where id_pontuacao=?";
            //try-with-resources(descarta objeto ps e rs)
            try(PreparedStatement ps = getCon().prepareStatement(sql))
            {
                ps.setInt(1,pontuacao.getIdPontuacao());
                ResultSet rs = ps.executeQuery();
                if (rs.next()){// verifica se tem linha para ler:  true/false
                    return "Id_pontuacao: " + pontuacao.getIdPontuacao() + "\nPontos: " + rs.getDouble("pontos") +
                            "\nOrigem: " + rs.getString("origem") +
                            "\nData_Registro: " + rs.getDate("data_registro") +
                            "\nId_Usuario: " + rs.getInt("id_usuario");
                }else{
                    return "Registro não encontrado";
                }
            }catch (SQLException e){
                return  "Erro de SQL:" + e.getMessage();
            }
        }
    }

