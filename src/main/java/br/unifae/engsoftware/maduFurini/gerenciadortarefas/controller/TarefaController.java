/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.engsoftware.maduFurini.gerenciadortarefas.controller;

import br.unifae.engsoftware.maduFurini.gerenciadortarefas.model.GerenciadorDeTarefas;
import br.unifae.engsoftware.maduFurini.gerenciadortarefas.model.Tarefa;
import br.unifae.engsoftware.maduFurini.gerenciadortarefas.model.TarefaComPrazo;
import br.unifae.engsoftware.maduFurini.gerenciadortarefas.model.TarefaSimples;
import br.unifae.engsoftware.maduFurini.gerenciadortarefas.model.TarefasTable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dudaf
 */
public class TarefaController {
    public static List<Tarefa> index () {
        return GerenciadorDeTarefas.index();
    }
    
    public DefaultTableModel gerarTabela(List<Tarefa> tarefas){
        if (tarefas == null) {
            return TarefasTable.gerarTabela(TarefaController.index());
        }
        
        return TarefasTable.gerarTabela(tarefas);
    }
    
    public boolean storeSimples(String descricao, int prioridade, boolean concluida, LocalDate data) {
        return GerenciadorDeTarefas.store(new TarefaSimples(descricao, prioridade, concluida, data));
    }
    
    public boolean storeComPrazo(String descricao, int prioridade, boolean concluida, LocalDate data, LocalDate prazo) {
        return GerenciadorDeTarefas.store(new TarefaComPrazo(descricao, prioridade, concluida, data, prazo));
    }
    
    public boolean update(int row, String descricao, int prioridade, boolean concluida, LocalDate dataCriacao, LocalDate prazo) {
        return GerenciadorDeTarefas.update(row, descricao, prioridade, concluida, dataCriacao, prazo);
    }
    
    public boolean destroy(int row) {
        return GerenciadorDeTarefas.destroy(row);
    }
    
    public static Object[] show(int row) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Tarefa tarefa = GerenciadorDeTarefas.show(row);

        if (tarefa != null) {
            Object[] dados = new Object[5];
            
            dados[0] = tarefa.getDescricao();    
            dados[1] = tarefa.getPrioridade();   
            dados[2] = tarefa.getConcluida();     
            
            dados[3] = (((LocalDate) tarefa.getDataCriacao()).format(formatter));  
                    
            if (tarefa instanceof TarefaComPrazo){
                dados[4] = (((LocalDate)((TarefaComPrazo) tarefa).getPrazo()).format(formatter));  
            } else {
                dados[4] = null;
            }
            
            return dados;
        }
        
        return null;
    }
    
    public static List<Tarefa> filtroPorPrioridade(int prioridade) {
        return GerenciadorDeTarefas.filtroPrioridade(prioridade);
    }
    
    public static List<Tarefa> filtroPorPrazo(String prazo) {
        return GerenciadorDeTarefas.filtroPrazo(prazo);
    }
}
