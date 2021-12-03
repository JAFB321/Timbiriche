package UI.componentes;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;


public class JPunto extends JLabel{
    
    public int x;
    public int y;

    public JPunto(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        initListeners();

        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/punto3.png")));
        super.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        super.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        this.setOpaque(false);
        
        this.setFont(new Font("Serif", Font.PLAIN, 50));
    }
    
    

    
    private void initListeners() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
//                onMouseMoved();
            }

           
            
            
        });
    }
    
//    private void onMouseMoved(){
//        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/punto.png")));       
//    }
//    
//    private void onMouseReleased(){
//        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/punto3.png")));   
//    }
        
}
