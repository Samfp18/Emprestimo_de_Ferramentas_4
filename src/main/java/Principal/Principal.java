/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import dao.AmigoDAO;
import dao.AmigoDAOImpl;
import dao.FerramentaDAO;
import dao.FerramentaDAOImpl;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class Principal {
 public static void main(String[] args) {
        FerramentaDAO ferramentaDAO = new FerramentaDAOImpl();
        AmigoDAO amigoDAO = new AmigoDAOImpl();

        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("=== Menu Principal ===\n"
                    + "1. Gerenciar Ferramentas\n"
                    + "2. Gerenciar Amigos\n"
                    + "3. Sair\n"
                    + "Escolha uma opção:"));

            switch (opcao) {
                case 1:
                    ferramentaDAO.menuFerramentas();
                    break;
                case 2:
                    amigoDAO.menuAmigos();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 3);
    }
}