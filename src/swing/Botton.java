/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 *
 * @author Wawan
 */
public class Botton extends JButton{
 
    private Paint paint;
    private Shape shape;
    private Paint glass;
    private boolean over;
    private boolean click;
    
    public Botton(){
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me); //To change body of generated methods, choose Tools | Templates.
                setOver(true);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                super.mouseExited(me); //To change body of generated methods, choose Tools | Templates.
                setOver(false);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me); //To change body of generated methods, choose Tools | Templates.
                setClick(true);
            }
            
            
            
        });
    }

    public boolean isOver(){
        return over;
    }
    
    public void setOver(boolean over){
        this.over = over;
        repaint();
    }
    
    public boolean isClick(){
        return click;
    }
        
    public void setClick(boolean click){
        this.click = click;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gd = (Graphics2D) g.create();
        
        paint = new GradientPaint(0, 0, Color.BLUE, 0, getHeight(), Color.RED);
        shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), getHeight(),getHeight());
        
        
        if(isOver()){
            glass = new GradientPaint(0,0,new Color(1F, 1F,1F,0F),0,getHeight(), new Color(1F,1F,1F,0.5F));
            if(isClick()){
                glass = new GradientPaint(0,0,new Color(1F, 1F,1F,0.5F),0,getHeight(), new Color(1F,1F,1F,0F));
                gd.setPaint(glass);
     
            }
            
        } else {
            glass = new GradientPaint(0,0,new Color(1F, 1F,1F,0.5F),0,getHeight(), new Color(1F,1F,1F,0F));
        }
        gd.setPaint(paint);
        gd.fill(shape);
        
        
        super.paintComponent(g);
        
        gd.setPaint(glass);
        gd.fill(shape);
        gd.dispose();
        
    }
    
    
}
