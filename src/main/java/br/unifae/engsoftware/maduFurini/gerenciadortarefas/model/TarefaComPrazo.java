/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifae.engsoftware.maduFurini.gerenciadortarefas.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author dudaf
 */
public class TarefaComPrazo extends Tarefa{
    private LocalDate prazo;
    
    public TarefaComPrazo() {}
    
    public TarefaComPrazo(String descricao, int prioridade, boolean concluida, LocalDate dataCriacao, LocalDate prazo) {
        super(descricao, prioridade, concluida, dataCriacao);
        this.prazo = prazo;
    }
    
    
    public LocalDate getPrazo() {
        return this.prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

        @Override 
    public String toString() {
        return super.toString() +
               "Prazo: " + this.getPrazo() + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.prazo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TarefaComPrazo other = (TarefaComPrazo) obj;
        return Objects.equals(this.prazo, other.prazo);
    }
}
