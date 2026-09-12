package br.com.fiap.model.dao;

import br.com.fiap.model.dto.RegistroDesafioDTO;
import br.com.fiap.model.interfaces.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroDesafioDAO implements IDAO {

    //import
    private Connection con;
    private RegistroDesafioDTO registroDesafio;

    //construtor com passagem de parametro
    public RegistroDesafioDAO(Connection con) {
        this.con = con;
    }

    //getter
    public Connection getCon() {return con;}

    public String inserir(Object object){
        registroDesafio = (RegistroDesafioDTO) object; // Conversao implicita
        String sql = "insert into t_registro_desafio (id_usuario_desafio, status, data_conclusao, pontos_ganhos, bonus_multiplicador, id_usuario, id_desafio) values(?,?,?,?,?,?,?)";
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){
            ps.setInt(1, registroDesafio.getIdUsuarioDesafio());
            ps.setString(2, registroDesafio.getStatus());

            if (registroDesafio.getDataConclusao() != null){
                ps.setDate(3, java.sql.Date.valueOf(registroDesafio.getDataConclusao()));
            } else {
                ps.setNull(3, java.sql.Types.DATE);
            }

            if (registroDesafio.getPontosGanhos() != null){
                ps.setInt(4, registroDesafio.getPontosGanhos());
            } else {
                ps.setNull(4, java.sql.Types.INTEGER);
            }

            if (registroDesafio.getBonusMultiplicador() != null){
                ps.setDouble(5, registroDesafio.getBonusMultiplicador());
            } else {
                ps.setNull(5, java.sql.Types.DOUBLE);
            }

            ps.setInt(6, registroDesafio.getIdUsuario());
            ps.setInt(7, registroDesafio.getIdDesafio());

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
        registroDesafio = (RegistroDesafioDTO) object; // Conversao implicita
        String sql = "update t_registro_desafio set status=?, data_conclusao=?, pontos_ganhos=?, bonus_multiplicador=?, id_usuario=?, id_desafio=? where id_usuario_desafio=?";
        //try-with-resources
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){

            ps.setString(1, registroDesafio.getStatus());

            if (registroDesafio.getDataConclusao() != null){
                ps.setDate(2, java.sql.Date.valueOf(registroDesafio.getDataConclusao()));
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }

            if (registroDesafio.getPontosGanhos() != null){
                ps.setInt(3, registroDesafio.getPontosGanhos());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }

            if (registroDesafio.getBonusMultiplicador() != null){
                ps.setDouble(4, registroDesafio.getBonusMultiplicador());
            } else {
                ps.setNull(4, java.sql.Types.DOUBLE);
            }

            ps.setInt(5, registroDesafio.getIdUsuario());
            ps.setInt(6, registroDesafio.getIdDesafio());
            ps.setInt(7, registroDesafio.getIdUsuarioDesafio());

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
        registroDesafio = (RegistroDesafioDTO) object; // Conversao implicita
        String sql = "delete from t_registro_desafio where id_usuario_desafio=?";
        //try-with-resources
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){
            ps.setInt(1, registroDesafio.getIdUsuarioDesafio());
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
        registroDesafio = (RegistroDesafioDTO) object; // Conversao implicita
        String sql = "select * from t_registro_desafio where id_usuario_desafio=?";
        //try-with-resources(descarta objeto ps e rs)
        try(PreparedStatement ps = getCon().prepareStatement(sql))
        {
            ps.setInt(1, registroDesafio.getIdUsuarioDesafio());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){// verifica se tem linha para ler:  true/false
                return "Id_usuario_desafio: " + registroDesafio.getIdUsuarioDesafio() +
                        "\nStatus: " + rs.getString("status") +
                        "\nData_Conclusao: " + rs.getDate("data_conclusao") +
                        "\nPontos_Ganhos: " + rs.getObject("pontos_ganhos") +
                        "\nBonus_Multiplicador: " + rs.getObject("bonus_multiplicador") +
                        "\nId_Usuario: " + rs.getInt("id_usuario") +
                        "\nId_Desafio: " + rs.getInt("id_desafio");
            }else{
                return "Registro não encontrado";
            }
        }catch (SQLException e){
            return  "Erro de SQL:" + e.getMessage();
        }
    }
}