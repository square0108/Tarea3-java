package frontend;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Actualizador implements ActionListener {
    private static ArrayList<Component> components = new ArrayList<>();
    public void addComponent(Component component) {
        components.add(component);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Component component : components) {
            component.repaint();
            component.revalidate();
        }
    }
}
