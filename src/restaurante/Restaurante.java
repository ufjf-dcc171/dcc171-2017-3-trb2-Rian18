
package restaurante;

import java.awt.HeadlessException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Rian Alves
 */
public class Restaurante {

    public static void main(String[] args) {
        
        
        Inicio janelaInicio = new Inicio();
        janelaInicio.setVisible(true); //ideal colocar por último 
        janelaInicio.setSize(470,850);
        janelaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaInicio.setLocationRelativeTo(null); // Tela aparece no centro 
   

        
       //Para Teste
        Pedido[] mesas = new Pedido[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Mesas : " + mesas[i]);
        }

    }

    public static void telaPedidos() throws IOException, ParseException 
    {
        JanelaPedido janelaPedidos = new JanelaPedido();
        janelaPedidos.setVisible(true); //ideal colocar por último 
        janelaPedidos.setSize(470, 600);
        janelaPedidos.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        janelaPedidos.setLocationRelativeTo(null);
    
    }
    
    public static void telaCardapio()
    {
       Cardapio janelaCardapio = new Cardapio();
        janelaCardapio.setVisible(true); //ideal colocar por último 
        janelaCardapio.setSize(470,600);
        janelaCardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaCardapio.setLocationRelativeTo(null);

    }

   

    
    }

