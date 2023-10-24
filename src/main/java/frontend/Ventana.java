package frontend;
import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {
    public Ventana() {
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("meow moew meoww mweo :3");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,800);

        this.add(new JButton("A"), BorderLayout.SOUTH);
        this.add(new JButton("A"), BorderLayout.EAST);
        this.add(new JButton("A"), BorderLayout.WEST);
        this.add(new JButton("A"), BorderLayout.NORTH);

        this.setVisible(true);
    }
}
