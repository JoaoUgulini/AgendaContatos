package Agenda;

import javax.swing.*;
import java.awt.*;

public class Sobre extends JPanel {
    public Sobre() {
        setLayout(new BorderLayout());
        JLabel lblSobre = new JLabel("<html><h1>Agenda de Contatos v1.0</h1><p>Desenvolvido por: João Miguel Ugulini</p><p>Email: joaomiguelugulini@gmail.com</p></html>", SwingConstants.CENTER);
        add(lblSobre, BorderLayout.CENTER);
    }
}
