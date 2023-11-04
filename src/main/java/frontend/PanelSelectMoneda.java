package frontend;
import backend.MonedasEnum;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Panel cuya principal funcion es modificar la propiedad ValMonedaSelect de PanelComprador, y asi comunicar que valor de moneda se va a utilizar.
 */
public class PanelSelectMoneda extends JPanel implements ActionListener {
    /* Se utiliza ButtonGroup, de esta forma las elecciones de moneda son exclusivas entre sí */
    private final ButtonGroup bgroup;
    /* Contiene los valores de moneda elegibles */
    private final JRadioButton[] montos;
    /* Referencia a PanelComprador al cual pertenece esta instancia */
    private final PanelComprador panelComprador;
    public PanelSelectMoneda(PanelComprador p) {
        this.montos = new JRadioButton[4];
        this.bgroup = new ButtonGroup();
        this.panelComprador = p;
        this.setLayout(new FlowLayout());

        /* Creacion de los JRadioButton con los montos de moneda */
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

        /* Se agregan individualmente al ButtonGroup */
        bgroup.add(Mon100);
        bgroup.add(Mon500);
        bgroup.add(Mon1000);
        bgroup.add(Mon1500);

        /* Texto de instruccion para el usuario */
        JLabel instruccioncompra = new JLabel("Seleccione un monto: ");

        this.add(instruccioncompra);
        this.add(Mon100);
        this.add(Mon500);
        this.add(Mon1000);
        this.add(Mon1500);
    }

    /**
     * Modifica PanelComprador.ValMonedaSelect, asignandole un nuevo monto segun el JRadioButton seleccionado
     * @param e the event to be processed (click del mouse en cada JRadioButton)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < bgroup.getButtonCount(); i++) {
            if (e.getSource() == montos[i]) {
                panelComprador.setValMonedaSelect(MonedasEnum.values()[i].valor);
            }
        }
    }
}
