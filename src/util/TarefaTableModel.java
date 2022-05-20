/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Model.Tarefa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pablo
 */
public class TarefaTableModel extends AbstractTableModel{

    String[] columns = {"Nome", "Descrição","Prazo","Tarefa Conluída","Editar","Excluir"};
    List<Tarefa> tarefas = new ArrayList<>();
    
    //Quantidade de linhas ( quantidade de tarefas )
    @Override
    public int getRowCount() {
        return tarefas.size();
    }

    //Quantidade de colunas ( tamanho do vetor columns )
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        //Se coluna for a 3 (Tarefa Conluída) deixa editável
        if(columnIndex == 3){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
   public Class<?> getColumnClass(int columnIndex){
       if(tarefas.isEmpty()){
           return Object.class;
       }
       
       /*
        chama o getValueAt da primeira linha e pega os dados de cada 
        coluna(nome...) e retorna o tipo dele
       */
       return this.getValueAt(0,columnIndex).getClass();
   }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return tarefas.get(rowIndex).getNome();
            case 1:
                return tarefas.get(rowIndex).getDescricao();
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tarefas.get(rowIndex).getPrazo());
            case 3:
                return tarefas.get(rowIndex).isCompletado();
            case 4:
                return "";
            case 5:
                return "";
            default:
                return "Dados não encontrados";
            
        }
    }
    
    /*
        Assim que clicarmos no check de Tarefa Conluída, será chamado o 
        método setValueAt passando o valor que está armazenado, a linha e a coluna
        em que o check se encontra
    */
    @Override
    public void setValueAt(Object value,int rowIndex, int columnIndex){
        tarefas.get(rowIndex).setCompletado((boolean) value);
    }
    
    
    public String[] getColumns() {
        return columns;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
    
    
    
    
}
