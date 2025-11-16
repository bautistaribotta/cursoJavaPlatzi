package gui;
import javax.swing.*;
import java.awt.*;

public class cursoSwing1 {
    public static void main(String[] args){
        miMarco menu = new miMarco();
        menu.setVisible(false);
        menu.setTitle("Menu principal");

        miMarcoCentrado menu2 = new miMarcoCentrado();
        menu2.setTitle("Menu principal 2");

    }
}

class miMarco extends JFrame{
    public miMarco(){
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}

class miMarcoCentrado extends JFrame{
    public miMarcoCentrado(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Obtener el tamaño de la pantalla
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = miPantalla.getScreenSize(); // Posee 2 valores, height y width
        int alto = tamanoPantalla.height;
        int ancho = tamanoPantalla.width;
        setSize(ancho/2, alto/2);
        setLocation(ancho/4, alto/4);

        Image miIcono = miPantalla.getImage("C:/ruta/completa/al/icono.gif");
        setIconImage(miIcono);
    }
}