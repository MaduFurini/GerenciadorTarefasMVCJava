/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.engsoftware.maduFurini.gerenciadortarefas.model;

import java.time.LocalDate;

/**
 *
 * @author dudaf
 */
public class TarefaSimples extends Tarefa{
    public TarefaSimples() {}
    
    public TarefaSimples(String descricao, int prioridade, boolean concluida, LocalDate dataCriacao) {
        super(descricao, prioridade, concluida, dataCriacao);
        super.setConcluida(false);
    }
}
