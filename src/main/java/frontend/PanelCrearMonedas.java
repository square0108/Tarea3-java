package frontend;
import backend.MonedasInfo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelCrearMonedas extends JPanel implements ActionListener {
    private ButtonGroup bgroup;
    private JRadioButton[] montos;
    protected int valorSelect;
    public PanelCrearMonedas() {
        this.valorSelect = 0;
        this.montos = new JRadioButton[4];
        this.bgroup = new ButtonGroup();
        this.setLayout(new FlowLayout());

        JRadioButton Mon100 = new JRadioButton("$100");
        Mon100.addActionListener(this);
        montos[0] = Mon100;
        JRadioButton Mon500 = new JRadioButton("$500");
        Mon500.addActionListener(this);
        montos[1] = Mon500;
        JRadioButton Mon1000 = new JRadioButton("$1000");
        Mon1000.addActionListener(this);
        montos[2] = Mon1000;
        JRadioButton Mon1500 = new JRadioButton("$1500");
        Mon1500.addActionListener(this);
        montos[3] = Mon1500;

        bgroup.add(Mon100);
        bgroup.add(Mon500);
        bgroup.add(Mon1000);
        bgroup.add(Mon1500);

        JLabel instruccioncompra = new JLabel("Seleccione un monto: ");

        this.add(instruccioncompra);
        this.add(Mon100);
        this.add(Mon500);
        this.add(Mon1000);
        this.add(Mon1500);
    }
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < bgroup.getButtonCount(); i++) {
            if (e.getSource() == montos[i]) {
                this.valorSelect = MonedasInfo.values()[i].valor;
                System.out.println(valorSelect);
            }
        }
    }
}
