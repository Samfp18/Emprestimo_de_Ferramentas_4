/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author samue
 */
public class RelatoriodeFerramenta extends visao.FrmRelatoriodeFerramenta {
    private List<Ferramenta> ferramentas;

    public RelatoriodeFerramenta() {
        this.ferramentas = new ArrayList<>();
    }

    // Método para adicionar uma ferramenta ao relatório
    public void adicionarFerramenta(Ferramenta ferramenta) {
        ferramentas.add(ferramenta);
    }

    // Método para listar todas as ferramentas com nome e preço
    public void listarFerramentas() {
        for (Ferramenta ferramenta : ferramentas) {
            System.out.println("Nome: " + ferramenta.getNomeF() + ", Preço: " + ferramenta.getPrecoF());
        }
    }

    // Método para calcular o total gasto com as ferramentas
    public double calcularTotalGasto() {
        double total = 0;
        for (Ferramenta ferramenta : ferramentas) {
            total += ferramenta.getPrecoF();
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RelatoriodeFerramenta relatorio = new RelatoriodeFerramenta();

        while (true) {
            System.out.println("Digite o nome da ferramenta (ou 'sair' para terminar):");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println("Digite a marca da ferramenta:");
            String marca = scanner.nextLine();

            System.out.println("Digite o preço da ferramenta:");
            double preco = scanner.nextDouble();
            scanner.nextLine();  // Consumir a nova linha deixada pelo nextDouble

            Ferramenta ferramenta = new Ferramenta(nome, marca, preco);
            relatorio.adicionarFerramenta(ferramenta);
        }

        System.out.println("\nLista de Ferramentas:");
        relatorio.listarFerramentas();

        double totalGasto = relatorio.calcularTotalGasto();
        System.out.println("Total Gasto: " + totalGasto);

        scanner.close();
    }
}
