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
public class Tarefa implements Prioritizavel {
    private String descricao;
    private boolean concluida;
    private int prioridade;
    private LocalDate dataCriacao;
    
    public Tarefa() {}
    
    public Tarefa(String descricao, int prioridade, boolean concluida, LocalDate dataCriacao) {
        this.descricao = descricao;
        this.concluida = concluida;
        this.prioridade = prioridade;
        this.dataCriacao = dataCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    @Override
    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    
        @Override
    public String toString() {
        return """
               === DADOS === 
               Descri\u00e7\u00e3o: """ + this.descricao + "\n" +
                "Concluída: " + (this.concluida ? "Sim" : "Não") + "\n" +
                "Prioridade: " + this.prioridade + "\n" +
                "Data de criação: " + this.dataCriacao + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.descricao);
        hash = 67 * hash + (this.concluida ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.dataCriacao);
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
        final Tarefa other = (Tarefa) obj;
        if (this.concluida != other.concluida) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return Objects.equals(this.dataCriacao, other.dataCriacao);
    }
}
