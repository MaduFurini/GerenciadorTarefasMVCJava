/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.engsoftware.maduFurini.gerenciadortarefas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dudaf
 */
public class GerenciadorDeTarefas {
    private final static List<Tarefa> tarefas = new ArrayList<>();
    
    //CONSTRUTOR???
    
    // INDEX TAREFAS
    public static List<Tarefa> index() {
        return tarefas;
    }
    
    // CADASTRO DE TAREFAS
    public static boolean store(Tarefa tarefa) {
        if (tarefa != null) 
            if (!(tarefas.contains(tarefa)))
                return tarefas.add(tarefa);
        
        return false;
    }
   
    // UPDATE TAREFAS
    public static boolean update(int row, String descricao, int prioridade, boolean concluida, LocalDate dataCriacao, LocalDate prazo) {
        if (row >= 0 && row < tarefas.size()) {
            Tarefa tarefa = tarefas.get(row);

            // Atualizando os valores da tarefa
            tarefa.setDescricao(descricao);
            tarefa.setPrioridade(prioridade);
            tarefa.setConcluida(concluida);
            tarefa.setDataCriacao(dataCriacao);

            if (prazo != null) {
                if (tarefa instanceof TarefaSimples) {
                    TarefaComPrazo tarefaComPrazo = new TarefaComPrazo(descricao, prioridade, concluida, dataCriacao, prazo);
                    tarefas.set(row, tarefaComPrazo);  
                } else if (tarefa instanceof TarefaComPrazo) {
                    ((TarefaComPrazo) tarefa).setPrazo(prazo);
                }
            } else {
                if (tarefa instanceof TarefaComPrazo) {
                    TarefaSimples tarefaSimples = new TarefaSimples(descricao, prioridade, concluida, dataCriacao);
                    tarefas.set(row, tarefaSimples);
                }
            }

            return true;
        }

        return false;
    }
    
    // DELETE TAREFAS
    public static boolean destroy(int row) {
        if (row >= 0 && row < tarefas.size()) {
            Tarefa tarefa = tarefas.get(row);

            return tarefas.remove(tarefa);
        }
        return false;  
    }
    
    // SHOW TAREFA
    public static Tarefa show(int row) {
        if (row >= 0 && row < tarefas.size()) {
            return tarefas.get(row);
        }
        
        return null;  
    }
}
