package frontend;
import backend.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class PanelBotones extends JPanel implements ActionListener {
    JButton[] botones;
    public PanelBotones(){
        this.setLayout(new GridLayout(5,1));
        this.botones = new JButton[5];
        botones[0] = new JButton("Coca Cola");
        botones[1] = new JButton("Sprite");
        botones[2] = new JButton("Fanta");
        botones[3] = new JButton("Snickers");
        botones[4] = new JButton("Super 8");

        for (int i = 0; i < botones.length; i++) {
            botones[i].addActionListener(this);
            this.add(botones[i]);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < botones.length; i++) {
            if (e.getSource() == botones[i]) {

            }
        }
    }
}
