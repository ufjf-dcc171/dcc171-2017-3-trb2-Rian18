package restaurante;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

import java.io.File;
import static java.lang.System.in;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rian Alves
 */
public class Pedido {

    
    private LocalDateTime horaInicio;
    private LocalDateTime horaFim;
    private int mesa;
    private boolean status;
    private Double somaT;
    private ArrayList<Item> itens;

    public Pedido(LocalDateTime horaInicio, LocalDateTime horaFim, boolean status, int mesa, ArrayList<Item> itens) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.status = status;
        this.mesa = mesa;
        this.itens = itens;
    }

    Pedido() {

    }

    /**
     * @return the horaInicio
     */
    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFim
     */
    public LocalDateTime getHoraFim() {
        return horaFim;
    }

    /**
     * @param horaFim the horaFim to set
     */
    public void setHoraFim(LocalDateTime horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the itens
     */
    public ArrayList<Item> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public void setItem(Item i) {
        this.itens.add(i);
    }
     public Item getItem(int i) {
         return itens.get(i);
    }

    /**
     * @return the somaT
     */
    public Double getSomaT() {
        return somaT;
    }

    /**
     * @param somaT the somaT to set
     */
    public void setSomaT(Double somaT) {
        this.somaT = somaT;
    }

    public static File gerarArquivo(Integer numMesa) {
        return new File("C:\\Users\\Rian Alves\\Desktop\\Laboratório\\ufjf-dcc171-2017-3-trb1-Rian18-master\\TESTE", "Pedido " + numMesa + ".txt");
    }

    public String HoraToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
     
        String hora = this.getHoraInicio().format(formatter);
        return hora;

    }

    public Date StringToHora(String hora1) {
        Date hora = null;
        return hora;

    }

    public String ToSerial(int i) {
        return this.getItens().get(i) + "";
    }

    /**
     * @return the mesa
     */
    public int getMesa() {
        return mesa;
    }

    /**
     * @param mesa the mesa to set
     */
    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
    
    



}
