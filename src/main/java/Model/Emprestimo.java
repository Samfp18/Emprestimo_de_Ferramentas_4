/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author samue
 */
public class Emprestimo{
 private Ferramenta ferramenta;
    private String nomeAmigo;
    private long dataEmprestimo;
    private Long dataDevolucao; // Usamos Long para poder representar a ausência de data com null

    public Emprestimo(Ferramenta ferramenta, String nomeAmigo, long dataEmprestimo) {
        this.ferramenta = ferramenta;
        this.nomeAmigo = nomeAmigo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null; // Inicializa como null para indicar que não foi devolvida
    }

    public Emprestimo(Ferramenta ferramenta, String string, long aLong, long aLong0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public String getNomeAmigo() {
        return nomeAmigo;
    }

    public long getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Long getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(long dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataEmprestimoStr = sdf.format(new Date(dataEmprestimo));
        String dataDevolucaoStr = (dataDevolucao == null) ? "Não devolvida" : sdf.format(new Date(dataDevolucao));
        return "Ferramenta: " + ferramenta.getNomeF() + ", Amigo: " + nomeAmigo + 
               ", Data de Empréstimo: " + dataEmprestimoStr + 
               ", Data de Devolução: " + dataDevolucaoStr;
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}