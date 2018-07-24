package com.sic.callcenter.view;

import com.sic.callcenter.model.Supervisor;
import com.sic.callcenter.model.Employee;
import com.sic.callcenter.model.Operator;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Canvas where draw all elements
 *
 * @author Juan-pc
 */
public class myCanvas extends JPanel {

    ArrayList<Employee> obj;
    private int elementSize;
    
    public myCanvas(ArrayList<Employee> obj) {

        this.obj = obj;
        this.elementSize = 60;

    }

    
    
    public void paint(Graphics g) {
       super.paint(g);
        for (int i = 0; i < obj.size(); i++) {

            Employee p = obj.get(i);

            int positionY = i > 4 ? i / 5 + 1 : 1;
            int positionX = i > 4 ? i - ((positionY - 1) * 5) : i;
            // box size
            int box = getElementSize();
            // margin to the other box
            int sp = box - 10;
            // circle size
            int circle = 10;

            g.setColor(Color.white);
            g.fillRect(positionX * box, positionY * box, sp, sp);

            if (p instanceof Operator) {
                g.setColor(Color.lightGray);
            } else if (p instanceof Supervisor) {
                g.setColor(Color.GRAY);
            } else {
                g.setColor(Color.DARK_GRAY);
            }

            g.fillRect(positionX * box, positionY * box + sp / 2, sp, sp / 2);
            g.setColor(Color.pink);
            g.fillOval(positionX * box + sp / 6, positionY * box, (sp / 3) * 2, sp / 2);

            if (p.isAvaliable()) {
                g.setColor(Color.GREEN);
                g.fillOval(positionX * box, positionY * box, circle, circle);
            } else {
                g.setColor(Color.RED);
                g.fillOval(positionX * box, positionY * box, circle, circle);

                if (p.getAnswercall() != null) {
                    String text = "Id: " + String.valueOf(p.getAnswercall().getId());

                    g.drawString(text, positionX * box + sp / 3, positionY * box + ((sp / 10) * 8));
                }

            }

        }

    }

    /**
     * @return the elementSize
     */
    public int getElementSize() {
        return elementSize;
    }

    /**
     * @param elementSize the elementSize to set
     */
    public void setElementSize(int elementSize) {
        this.elementSize = elementSize;
    }

}
