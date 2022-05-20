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
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pablo
 */
public class CelulaColunaBotaoRenderer extends DefaultTableCellRenderer {
    private String tipoBotao;

    public CelulaColunaBotaoRenderer(String tipoBotao) {
       this.tipoBotao = tipoBotao;
    }

    public String getTipoBotao() {
        return tipoBotao;
    }

    public void setTipoBotao(String tipoBotao) {
        this.tipoBotao = tipoBotao;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
        boolean isSelected, boolean hasFocus, int row, int col){
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, hasFocus, hasFocus, col, col);
        label.setHorizontalAlignment(CENTER);
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/todoapp/resources/"+ tipoBotao +".png")));
        
        return label;
    }
}
