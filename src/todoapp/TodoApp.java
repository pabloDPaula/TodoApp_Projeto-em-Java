/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoapp;

import Controller.ProjetoController;
import Controller.TarefaController;
import Model.Projeto;
import Model.Tarefa;
import util.ConnectionFactory;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author pablo
 */
public class TodoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //                  CRUD de projetos
        /*
        ProjetoController projetocontroller = new ProjetoController();
        Projeto projeto = new Projeto();
        projeto.setNome("Projeto");
        projeto.setDescricao("Descrição");
        projetocontroller.cadastrar(projeto);
       */
       
        /*
        ProjetoController projetocontroller = new ProjetoController();
        Projeto projeto = new Projeto();
        projeto.setId(1);
        projeto.setNome("Novo projeto");
        projeto.setDescricao("Nova descrição");
        projetocontroller.atualizar(projeto);
       */
        
        /*
        ProjetoController projetocontroller = new ProjetoController();
        List<Projeto> projetos = projetocontroller.buscarTodos();
        System.out.println("Total de projetos = "+projetos.size());
        */
        /*
         ProjetoController projetocontroller = new ProjetoController();
         projetocontroller.removerPorId(1);
        */
        
        
         //                  CRUD de tarefas
         
        /*
        TarefaController tarefacontroller = new TarefaController();
        Tarefa tarefa = new Tarefa();
        tarefa.setIdProjeto(3);
        tarefa.setNome("Tarefa 2");
        tarefa.setDescricao("Descrição 2");
        tarefa.setCompletado(false);
        tarefa.setObservacao("Observacao 2");
        tarefacontroller.cadastrar(tarefa);
        */
        /*
        TarefaController tarefacontroller = new TarefaController();
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1);
        tarefa.setIdProjeto(3);
        tarefa.setNome("Tarefa 1");
        tarefa.setDescricao("Descrição 1");
        tarefa.setCompletado(true);
        tarefa.setObservacao("Observacao 1");
        tarefacontroller.atualizar(tarefa);
        */
        
        TarefaController tarefacontroller = new TarefaController();
        tarefacontroller.removerPorId(4);
        
        /*
        TarefaController tarefacontroller = new TarefaController();
        List<Tarefa> tarefas = tarefacontroller.buscarTodos(3);
        System.out.println("Total de tarefas pertencentes ao projeto"+tarefas.size());
        */
    }
    
}
