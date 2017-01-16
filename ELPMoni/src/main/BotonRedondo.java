package main;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;


public class BotonRedondo extends JButton implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color colorPulsado=new Color(235,166,38);
	private int ancho; 
    private int alto;
	
    public BotonRedondo(int ancho,int alto){
    	
    	this.setBounds( 0, 0, ancho, alto );
    	this.setPreferredSize(new Dimension(ancho,alto));
        this.setCursor( new Cursor(Cursor.HAND_CURSOR));
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.ancho=getWidth();
		this.alto=getHeight();
		this.repaint();
		this.addMouseListener(this);
    	
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setPaint(new Color(255,255,255));
        g2.fill(new Ellipse2D.Double(2, 2, ancho-7, alto-7));
        g2.setColor(new Color(100, 100, 100));
      	g2.drawOval(2, 2, ancho-8, alto-8);
      	g2.setColor(new Color(235,166,38));
      	g2.setStroke(new BasicStroke(10f));
      	int xs[]=new int[3];
      	int ys[]=new int[3];
      	xs[0]=ancho/2;
      	ys[0]=alto/2-10;
      	xs[1]=ancho/2-10;
      	ys[1]=alto/2+10;
      	xs[2]=ancho/2+10;
      	ys[2]=alto/2+10;
      	g2.drawPolygon(xs,ys,3);
      	g2.setColor(colorPulsado);
      	g2.fillPolygon(xs,ys,3); 

        g2.setClip( new Ellipse2D.Float(2, 2, ancho-7,alto-7) );
      	
      	g2.setColor(new Color(255, 255, 255, 50));
      	g2.drawOval(2, 2, ancho-7, alto-7);        
        g2.dispose();      
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(5f));
        g2.setColor(new Color(235,166,38));
        g2.drawOval(2, 2, ancho-7 , alto-7);
        g2.dispose();
    }

	public Color getColorPulsado() {
		return colorPulsado;
	}

	public void setColorPulsado(Color colorPulsado) {
		this.colorPulsado = colorPulsado;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		colorPulsado=new Color(245,130,7);;
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		colorPulsado=new Color(235,166,38);
		repaint();
	}

}