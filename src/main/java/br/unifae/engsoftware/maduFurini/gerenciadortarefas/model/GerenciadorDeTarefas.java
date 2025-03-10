/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.engsoftware.maduFurini.gerenciadortarefas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    
    // FILTRO POR PRIORIDADE
    public static List<Tarefa> filtroPrioridade(int prioridade) {
        List<Tarefa> tarefasFiltradas = new ArrayList<>();
        
        for (Tarefa tarefa : tarefas) {
            if(tarefa.getPrioridade() == prioridade) {
                tarefasFiltradas.add(tarefa);
            }
        }
        
        return tarefasFiltradas;
    }
    
    // FILTRO POR PRAZO
    public static List<Tarefa> filtroPrazo(String prazo) {
        LocalDate hoje = LocalDate.now();
        List<Tarefa> tarefasFiltradas;

        /**
         * Anotações de estudo - primeira vez filtrando por data em JAVA
         * 
         * stream() -> converte a lista em um fluxo de objetos
         * filter() -> aplica uma condições para cada um dos objetos - ou seja, define as condições que os itens devem ter para continuarem na lista
         * sorted() -> ordenar o fluxo de objetos
         * comparing() -> comparar os prazos e ordenar do mais antigo ao mais recente
         * reversed() -> inverter a classificação do fluxo de obejtos - tornando-o descrescente
         * collect() & toList() -> coletar os resultados e transformá-los em uma List
         */
        tarefasFiltradas = switch (prazo) {
            case "Sem Prazo" -> tarefas.stream()
                    .filter(t -> !(t instanceof TarefaComPrazo))
                    .collect(Collectors.toList());
            case "Hoje" -> tarefas.stream()
                    .filter(t -> t instanceof TarefaComPrazo &&
                            ((TarefaComPrazo) t).getPrazo().equals(hoje))
                    .collect(Collectors.toList());
            case "Próximos 7 dias" -> tarefas.stream()
                    .filter(t -> t instanceof TarefaComPrazo &&
                            ((TarefaComPrazo) t).getPrazo().isAfter(hoje) &&
                            ((TarefaComPrazo) t).getPrazo().isBefore(hoje.plusDays(7).plusDays(1)))
                    .collect(Collectors.toList());
            case "Últimos 7 dias" -> tarefas.stream()
                    .filter(t -> t instanceof TarefaComPrazo &&
                            ((TarefaComPrazo) t).getPrazo().isBefore(hoje) &&
                            ((TarefaComPrazo) t).getPrazo().isAfter(hoje.minusDays(7)))
                    .collect(Collectors.toList());
            case "Ordem crescente" -> tarefas.stream()
                    .filter(t -> t instanceof TarefaComPrazo)
                    .sorted(Comparator.comparing(t -> ((TarefaComPrazo) t).getPrazo()))
                    .collect(Collectors.toList());
            case "Ordem decrescente" -> tarefas.stream()
                    .filter(t -> t instanceof TarefaComPrazo)
                    .sorted(Comparator.comparing((Tarefa t) -> ((TarefaComPrazo) t).getPrazo()).reversed())
                    .collect(Collectors.toList());
            default -> new ArrayList<>(tarefas);
        };

        return tarefasFiltradas;
    }

}
