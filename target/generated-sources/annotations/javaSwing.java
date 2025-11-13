import javax.swing.*;

public class javaSwing {
    public static void main(String[] args){
        JFrame menuPrincipal = new JFrame();
        menuPrincipal.setTitle("Menu principal");
        menuPrincipal.setSize(800, 400);
        menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPrincipal.setVisible(true);

        JButton botonAgregarCliente = new JButton();
        botonAgregarCliente.setText("Agregar Cliente");
        botonAgregarCliente.setSize(50, 25);
        botonAgregarCliente.setEnabled(true);

        menuPrincipal.add(botonAgregarCliente);
    }
}
