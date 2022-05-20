/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Model.Tarefa;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pablo
 */
public class CelulaColunaPrazoRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
        boolean isSelected, boolean hasFocus, int row, int col){
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, hasFocus, hasFocus, col, col);
        label.setHorizontalAlignment(CENTER);
        
        TarefaTableModel tarefasModel = (TarefaTableModel) table.getModel();
        Tarefa tarefa = tarefasModel.getTarefas().get(row);
        if(tarefa.getPrazo().after(new Date())){
            label.setBackground(Color.GREEN);
        }else{
         label.setBackground(Color.RED);
        }
        return label;
    }
}

