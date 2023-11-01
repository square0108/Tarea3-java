package frontend;
import backend.*;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {
    public Ventana() {
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("meow moew meoww mweo :3");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        PanelPrincipal MAIN = new PanelPrincipal();

        this.add(MAIN,BorderLayout.CENTER);

        this.setVisible(true);
    }
}
