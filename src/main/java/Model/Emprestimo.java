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
public class Emprestimo {
    private Ferramenta ferramenta;
    private Amigo amigo;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Ferramenta ferramenta, Amigo amigo, Date dataEmprestimo, Date dataDevolucao) {
        this.ferramenta = ferramenta;
        this.amigo = amigo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    @Override
    public String toString() {
        return "Ferramenta: " + ferramenta.getNome() + ", Amigo: " + amigo.getNome() + ", Data de Empréstimo: " + dataEmprestimo;
    }
}
