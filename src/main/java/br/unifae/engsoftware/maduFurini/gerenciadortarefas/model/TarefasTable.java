/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.engsoftware.maduFurini.gerenciadortarefas.model;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sempher
 */
public class TarefasTable {
    public static DefaultTableModel gerarTabela(List<Tarefa> tarefas) {
        String[] colunas = {"Descrição", "Prioridade", "Data de criação", "Prazo", "Concluída"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Tarefa tarefa : tarefas) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            modelo.addRow(new Object[]{
                tarefa.getDescricao(), 
                tarefa.getPrioridade(), 
                tarefa.getDataCriacao().format(dtf), 
                tarefa instanceof TarefaComPrazo ? ((TarefaComPrazo) tarefa).getPrazo().format(dtf) : "Indefinido",
                tarefa.getConcluida() ? "Sim" : "Não"
            });
        }

        return modelo;
    }
}
