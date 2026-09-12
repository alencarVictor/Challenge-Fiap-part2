package br.com.fiap.model.dao;


import br.com.fiap.model.dto.StatusAvatarDTO;
import br.com.fiap.model.interfaces.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StatusAvatarDAO implements IDAO {

    private Connection con;
    private StatusAvatarDTO statusAvatar;

    //construtor com passagem de parametro
    public StatusAvatarDAO(Connection con) {
        this.con = con;
    }

    //getter
    public Connection getCon() {
        return con;
    }

    //metodo da classe
    public String inserir(Object object) {
        statusAvatar = (StatusAvatarDTO) object; // Conversao implicita
        String sql = "insert into t_status_avatar(id_nivel,nivel,xp_necessario,titulo,skin_desbloqueada,beneficio) values(?,?,?,?,?,?)";
        //try-with-resources
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, statusAvatar.getIdNivel());
            ps.setInt(2, statusAvatar.getNivel());
            ps.setDouble(3, statusAvatar.getXpNecessario());
            ps.setString(4, statusAvatar.getTitulo());
            ps.setString(5, statusAvatar.getSkinDesbloqueada());
            ps.setString(6, statusAvatar.getBeneficio());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";

            } else {
                return "Erro ao inserir";

            }

        } catch (SQLException e) {
            return "Erro de SQL:" + e.getMessage();
        }
    }

    public String alterar(Object object) {
        statusAvatar = (StatusAvatarDTO) object; // Conversao implicita
        String sql = "update t_status_avatar set nivel=?,xp_necessario=?, titulo=? , skin_desbloqueada=? ,beneficio=? where id_nivel=?";
        //try-with-resources
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {


            ps.setInt(1, statusAvatar.getNivel());
            ps.setDouble(2, statusAvatar.getXpNecessario());
            ps.setString(3, statusAvatar.getTitulo());
            ps.setString(4, statusAvatar.getSkinDesbloqueada());
            ps.setString(5, statusAvatar.getBeneficio());
            ps.setInt(6, statusAvatar.getIdNivel());
            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso";

            } else {
                return "Erro ao alterar";

            }

        } catch (SQLException e) {
            return "Erro de SQL:" + e.getMessage();
        }
    }

    public String excluir(Object object) {
        statusAvatar = (StatusAvatarDTO) object; // Conversao implicita
        String sql = "delete from  t_status_avatar where id_nivel=?";
        //try-with-resources
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, statusAvatar.getIdNivel());
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";

            } else {
                return "Erro ao excluir";

            }

        } catch (SQLException e) {
            return "Erro de SQL:" + e.getMessage();
        }
    }

    public String listarUm(Object object) {
        statusAvatar = (StatusAvatarDTO) object; // Conversao implicita
        String sql = "select * from t_status_avatar where id_nivel=?";
        //try-with-resources(descarta objeto ps e rs)
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, statusAvatar.getIdNivel());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {// verifica se tem linha para ler: true/false
                return "Id_nivel: " + rs.getInt("id_nivel") +
                        "\nNivel: " + rs.getInt("nivel") +
                        "\nXp_Necessario: " + rs.getDouble("xp_necessario") +
                        "\nTitulo: " + rs.getString("titulo") +
                        "\nSkin_Desbloqueada: " + rs.getString("skin_desbloqueada") +
                        "\nBeneficio: " + rs.getString("beneficio");
            } else {
                return "Registro não encontrado";
            }
        } catch (SQLException e) {
            return "Erro de SQL:" + e.getMessage();
        }
    }
}

