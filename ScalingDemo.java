import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;

class myAdapter extends ComponentAdapter { 

    Frame f; 
    ScalingDemo s;

    public myAdapter(Frame f, ScalingDemo s) { 
        this.f = f;
        this.s = s;
    }
        
    public void componentResized(ComponentEvent e) {
        s.scale = f.getWidth();
        if (f.getHeight() - 25 < (int) (s.scale * .3) ) {
            s.scale = (int) ((f.getHeight() - 25) / .3);
        } 
    }

}

public class ScalingDemo extends Canvas {

    public static double A = .3;
    public static double B = .5; 
    public static double C = .10;
    public static double D = .40;
    public static double E = 0;
    public double scale = 0;
    public Frame f;
    
    public ScalingDemo() {
        super();
        f = new Frame();
        f.setSize(300, 180);
        f.addComponentListener(new myAdapter(f, this));
        f.add(this);
        f.setVisible(true);
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, (int) (B*scale), (int) (A*scale) );
       
        g.setColor(Color.BLUE); 
        g.fillOval( (int) ( scale * (0+D)), 
                    (int) ( scale * (0+E)),
                    (int) ( scale * C) ,
                    (int) ( scale * C ) );
    }

    public static void main(String[] args) {
        ScalingDemo demo = new ScalingDemo();
    }    

}
