/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author samue
 */
public class Relatório {
 public static String relatorioFerramentas(List<Ferramenta> ferramentas) {
        StringBuilder relatorio = new StringBuilder("Relatório de Ferramentas:\n");
        for (Ferramenta ferramenta : ferramentas) {
            relatorio.append("Nome: ").append(ferramenta.getNome()).append(", Marca: ").append(ferramenta.getMarca()).append(", Custo: ").append(ferramenta.getCustoAquisicao()).append("\n");
        }
        return relatorio.toString();
    }
}