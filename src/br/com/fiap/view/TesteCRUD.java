package br.com.fiap.view;


import br.com.fiap.model.dao.AvatarDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.StatusAvatarDAO;
import br.com.fiap.model.dto.AvatarDTO;
import br.com.fiap.model.dto.StatusAvatarDTO;


import java.sql.Connection;


public class TesteCRUD {
    static void main() {
        Connection con = ConnectionFactory.abrirConexao();

        //Objetos  DTO
        AvatarDTO avatar1 = new AvatarDTO();
        avatar1.setIdAvatar(1);
        avatar1.setNome("Floresto");
        avatar1.setNivelAtual(5);
        avatar1.setXpAtual(10.0);

        StatusAvatarDTO statusAvatar1 = new StatusAvatarDTO();
        statusAvatar1.setIdNivel(1);
        statusAvatar1.setNivel(5);
        statusAvatar1.setXpNecessario(15.0);
        statusAvatar1.setTitulo("imparavel");
        statusAvatar1.setSkinDesbloqueada("Avatar premium");
        statusAvatar1.setBeneficio("1 passagem de onibus");




        //Criação objetos ClienteDAO
        AvatarDAO avatarDAO1 = new AvatarDAO(con);
        StatusAvatarDAO statusAvatarDAO1 = new StatusAvatarDAO(con);


        //logs criação
      //  System.out.println(avatarDAO1.inserir(avatar1));
      //  System.out.println(statusAvatarDAO1.inserir(statusAvatar1));


        //log alteração
      //  System.out.println(statusAvatarDAO1.alterar(statusAvatar1));
      //  System.out.println(avatarDAO1.alterar(avatar1));

        //log exclusao
      //  System.out.println(avatarDAO1.excluir(avatar1));
      //  System.out.println(statusAvatarDAO1.excluir(statusAvatar1));

        //log read
       // System.out.println(avatarDAO1.listarUm(avatar1));
       // System.out.println(statusAvatarDAO1.listarUm(statusAvatar1));


        ConnectionFactory.fecharConexao(con);
    }
}
