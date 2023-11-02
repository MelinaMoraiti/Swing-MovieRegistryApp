
package movieregistrationapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author user
 */
public class AboutFrame extends JFrame {
    private JButton backBtn;
    private JPanel topPanel;
    private JPanel centerPanel;
   // private JLabel appLogo;
    public AboutFrame() {
        JButton backBtn = new JButton("Back");
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JLabel aboutLabel = new JLabel();
        ImageIcon appLogo = new ImageIcon("images/appLogo3.jpg");
         
        aboutLabel.setBorder(new EmptyBorder(0,10,0,10));//top,left,bottom,right

        aboutLabel.setText("<html><h2><font color='red'>Movie Registration App</h2><br>"
                + "<h3>Developer:  Melina Moraiti</h3>"
                +" <br>Time of development (from - to): 03/06/2022 - 06/06/2022</html>" );
        aboutLabel.setIcon(appLogo);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(backBtn);
        centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        centerPanel.add(aboutLabel);
      
        this.add(centerPanel,BorderLayout.CENTER);
        this.add(topPanel,BorderLayout.NORTH);
     
        //setup the frame
        this.setSize(500, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("About");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    
    this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               goBack();
            }
     });
    
    backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBack();
            }
    });
    
    }
    private void goBack()
    {
        this.dispose();
    }

    
    
}
