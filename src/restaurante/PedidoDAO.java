package restaurante;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import static javafx.application.Platform.exit;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author Rian Alves
 */
public class PedidoDAO {

    List<Item> itempedidos;
    public static Pedido pedido;
    public static ArrayList<Integer> mesasOcupadas = new ArrayList<>();
    //int numMesa = 0 ;

    public PedidoDAO(List<Item> itempedidos, Pedido pedido) {
        this.itempedidos = itempedidos;
        this.pedido = pedido;
    }

    public static void GravarArquivo(int numMesa, Pedido p) throws IOException {
        File arquivoPedido = Pedido.gerarArquivo(numMesa);
        List<Item> itens = p.getItens();

        if (!(arquivoPedido).exists()) {
            arquivoPedido.createNewFile();
        }

        PrintWriter escrever = new PrintWriter(arquivoPedido);

        escrever.println(p.HoraToString());
        escrever.println(p.getMesa());

        for (int i = 0; i < itens.size(); i++) {
            escrever.println(p.ToSerial(i));

        }
        escrever.close();

    }

    
    public static void AdicionarMesasOcupadas(List<Integer> listaMesasOcupadas) throws IOException {
        File arquivoOcupadas = new File("TESTE", "Mesas Ocupadas.txt ");

        if (!(arquivoOcupadas).exists()) {
            arquivoOcupadas.createNewFile();
        }

        PrintWriter escrever = new PrintWriter(arquivoOcupadas);

        for (int i = 0; i < listaMesasOcupadas.size(); i++) {
            escrever.println(listaMesasOcupadas.get(i));

        }

        escrever.close();

    }

    public static List<Integer> VerMesasOcupadas() throws FileNotFoundException, IOException {
        String linha;

        File arquivoOcupadas = new File("TESTE", "Mesas Ocupadas.txt ");
        BufferedReader leitor = new BufferedReader(new FileReader(arquivoOcupadas));

        while ((linha = leitor.readLine()) != null) {
            if (linha.isEmpty()) {
                mesasOcupadas.add(0);
            } else {
                mesasOcupadas.add(Integer.parseInt(linha));
            }
        }
        return mesasOcupadas;
    }

   

    public static Pedido LerArquivo(Integer numMesa) throws IOException, ParseException {

        File arquivoPedido = Pedido.gerarArquivo(numMesa);
        pedido = new Pedido(null, null, true, 0, null);
        String linha = null;
        ArrayList<Item> itens = new ArrayList<>();

        if ((arquivoPedido).exists()) {

            BufferedReader leitor = new BufferedReader(new FileReader(arquivoPedido));

            String primeiraLinha = leitor.readLine();
            String segundaLinha = leitor.readLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime data = LocalDateTime.parse(primeiraLinha, formatter);
            pedido.setHoraInicio(data);
            pedido.setMesa(Integer.parseInt(segundaLinha));
            pedido.setStatus(true);

            while ((linha = leitor.readLine()) != null) {
                String[] cod = linha.split("___");

                if (cod.length == 3) {
                    Item i = new Item();
                    i.setCodigo(Integer.parseInt(cod[0]));
                    i.setDescricao(cod[1]);
                    i.setPreco(Double.parseDouble(cod[2]));
                    itens.add(i);

                } else {
                    System.out.println("Formato Invalido: " + linha);
                    System.out.println("FALHOU " + linha);

                }
            }
            pedido.setItens(itens);

            return pedido;
        }
        return null;
    }

    public static List<Integer> encerrarPedido(int numMesa) throws FileNotFoundException {

        File arquivoOcupadas = new File("TESTE", "Mesas Ocupadas.txt ");
        File arquivoPedido = Pedido.gerarArquivo(numMesa);

        for (int i = 0; i < mesasOcupadas.size(); i++) {
            if (mesasOcupadas.contains(i)) {
                mesasOcupadas.remove(numMesa);
                
            }
           
        }
         PrintWriter escrever = new PrintWriter(arquivoOcupadas);

                for (int j = 0; j < mesasOcupadas.size(); j++) {
                    escrever.println(mesasOcupadas.get(j));
                }
                 escrever.close();

       

        PrintWriter escrever2 = new PrintWriter(arquivoPedido);
        escrever2.println("11-11-1111 11:11");
        escrever2.println(numMesa);
        escrever2.close();

        System.out.println("PEDIDO ENCERRADO! ARQUIVO APAGADO");

        return mesasOcupadas;
    }
}
