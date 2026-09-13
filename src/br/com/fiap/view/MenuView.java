package br.com.fiap.view;

import br.com.fiap.controller.*;

import javax.swing.*;

public class MenuView {

    public static void main(String[] args) {
        String[] entidades = {"Avatar", "Badge", "Usuario"};
        int entidadeEscolhida;

        do {
            try {
                entidadeEscolhida = JOptionPane.showOptionDialog(
                        null,
                        "Escolha a entidade que deseja manipular",
                        "Menu Principal",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        entidades,
                        entidades[0]
                );

                switch (entidadeEscolhida) {
                    case 0:
                        manipularAvatar();
                        break;
                    case 1:
                        manipularBadge();
                        break;
                    case 2:
                        manipularUsuario();
                        break;
                    default:
                        System.out.println("Opcao invalida");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de programa");
    }

    // ===================== AVATAR =====================
    private static void manipularAvatar() throws Exception {
        String[] acoes = {"Inserir", "Alterar", "Excluir", "Listar"};
        AvatarController avatarController = new AvatarController();

        int acao = JOptionPane.showOptionDialog(
                null, "Escolha a ação", "Avatar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, acoes, acoes[0]
        );

        int idAvatar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do avatar"));
        String nome;
        int nivelAtual;
        double xpAtual;

        switch (acao) {
            case 0:
                nome = JOptionPane.showInputDialog("Digite o nome do avatar");
                nivelAtual = Integer.parseInt(JOptionPane.showInputDialog("Digite o nível atual"));
                xpAtual = Double.parseDouble(JOptionPane.showInputDialog("Digite o XP atual"));
                System.out.println(avatarController.inserirAvatar(idAvatar, nome, nivelAtual, xpAtual));
                break;
            case 1:
                nome = JOptionPane.showInputDialog("Digite o novo nome");
                nivelAtual = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo nível"));
                xpAtual = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo XP"));
                System.out.println(avatarController.alterarAvatar(idAvatar, nome, nivelAtual, xpAtual));
                break;
            case 2:
                System.out.println(avatarController.excluirAvatar(idAvatar));
                break;
            case 3:
                JOptionPane.showMessageDialog(null, avatarController.listarUmAvatar(idAvatar));
                break;
            default:
                System.out.println("Opcao invalida");
        }
    }

    // ===================== BADGE =====================
    private static void manipularBadge() throws Exception {
        String[] acoes = {"Inserir", "Alterar", "Excluir", "Listar"};
        BadgeController badgeController = new BadgeController();

        int acao = JOptionPane.showOptionDialog(
                null, "Escolha a ação", "Badge",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, acoes, acoes[0]
        );

        int idBadge = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do badge"));
        String nome, tipo, descricao;

        switch (acao) {
            case 0:
                nome = JOptionPane.showInputDialog("Digite o nome do badge");
                tipo = JOptionPane.showInputDialog("Digite o tipo (normal/lendario)");
                descricao = JOptionPane.showInputDialog("Digite a descrição");
                System.out.println(badgeController.inserirBadge(idBadge, nome, tipo, descricao));
                break;
            case 1:
                nome = JOptionPane.showInputDialog("Digite o novo nome");
                tipo = JOptionPane.showInputDialog("Digite o novo tipo (normal/lendario)");
                descricao = JOptionPane.showInputDialog("Digite a nova descrição");
                System.out.println(badgeController.alterarBadge(idBadge, nome, tipo, descricao));
                break;
            case 2:
                System.out.println(badgeController.excluirBadge(idBadge));
                break;
            case 3:
                JOptionPane.showMessageDialog(null, badgeController.listarUmBadge(idBadge));
                break;
            default:
                System.out.println("Opcao invalida");
        }
    }

    // ===================== USUARIO =====================
    private static void manipularUsuario() throws Exception {
        String[] acoes = {"Inserir", "Alterar", "Excluir", "Listar"};
        UsuarioController usuarioController = new UsuarioController();

        int acao = JOptionPane.showOptionDialog(
                null, "Escolha a ação", "Usuario",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, acoes, acoes[0]
        );

        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuário"));
        String nome, email, senha, cidade;
        int idAvatar, ofensivaAtual;

        switch (acao) {
            case 0:
                nome = JOptionPane.showInputDialog("Digite o nome");
                email = JOptionPane.showInputDialog("Digite o email");
                senha = JOptionPane.showInputDialog("Digite a senha");
                cidade = JOptionPane.showInputDialog("Digite a cidade");
                idAvatar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do avatar"));
                ofensivaAtual = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de dias de ofensiva"));
                System.out.println(usuarioController.inserirUsuario(idUsuario, nome, email, senha, cidade, idAvatar, ofensivaAtual));
                break;
            case 1:
                nome = JOptionPane.showInputDialog("Digite o novo nome");
                email = JOptionPane.showInputDialog("Digite o novo email");
                senha = JOptionPane.showInputDialog("Digite a nova senha");
                cidade = JOptionPane.showInputDialog("Digite a nova cidade");
                idAvatar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do avatar"));
                ofensivaAtual = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo numero de dias de ofensiva"));
                System.out.println(usuarioController.alterarUsuario(idUsuario, nome, email, senha, cidade, idAvatar, ofensivaAtual));
                break;
            case 2:
                System.out.println(usuarioController.excluirUsuario(idUsuario));
                break;
            case 3:
                JOptionPane.showMessageDialog(null, usuarioController.listarUmUsuario(idUsuario));
                break;
            default:
                System.out.println("Opcao invalida");
        }
    }
}