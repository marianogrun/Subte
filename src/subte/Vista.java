package subte;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vista {

    private Modelo m;
    private JFrame f;
    private JPanel p;
    private JLabel labelEstacion;
    private JTextField textFieldEstacion;
    private JTextArea textAreaComentario;
    private JButton botonAvanzar;

    public Vista(Modelo m) {
        this.m = m;
        this.m.addExceptionListener(new ExceptionListener());
        f = new JFrame();
        p = new JPanel();
        p.setBackground(Color.red);
        labelEstacion = new JLabel("Estación: ");
        labelEstacion.setForeground(Color.WHITE);
        textFieldEstacion = new JTextField(26);
        textFieldEstacion.setText("Leandro N. Alem");
        textAreaComentario = new JTextArea(4, 50);
        textAreaComentario.setEditable(false);
        botonAvanzar = new JButton("Avanzar");
        p.add(labelEstacion);
        p.add(textFieldEstacion);
        p.add(textAreaComentario);
        p.add(botonAvanzar);
        f.getContentPane().add(p);
    }

    public void mostrar() {
        f.setTitle("Subte - Línea B");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    public void mostrarTextFieldEstacion (String s) {
        textFieldEstacion.setText(s);
    }

    public String obtenerTextFieldEstacion () {
        return textFieldEstacion.getText();
    }

    public void mostrarTextAreaComentario (String s) {
        textAreaComentario.setText(s);
    }

    public void addBotonAvanzarListener(ActionListener al) {
        botonAvanzar.addActionListener(al);
    }

    public void mostrarExcepcion(String s) {
        JOptionPane.showMessageDialog(f, s, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    private class ExceptionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            mostrarExcepcion(event.getActionCommand());
        }
    }
}
