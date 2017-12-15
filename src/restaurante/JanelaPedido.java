package restaurante;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rian Alves
 */
public class JanelaPedido extends JFrame {

    public final JList lstLista = new JList(new DefaultListModel());

    private ArrayList<Item> listaItem = new ArrayList<>();

    private int numero = 0;
    private LocalDateTime data;
    private JPanel principal = new JPanel();
    private JPanel principal2 = new JPanel();
    private JLabel lbl1;
    private JLabel lbl2 = new JLabel("");
    private JButton btnVoltar;
    private JButton btnAdicionar;
    private JButton btnFecharPedido;

    private JComboBox<Item> cmbItens = new JComboBox<>();

    //Botões para acessar as mesas
    private JButton btnMesa1;
    private JButton btnMesa2;
    private JButton btnMesa3;
    private JButton btnMesa4;
    private JButton btnMesa5;
    private JButton btnMesa6;
    private JButton btnMesa7;
    private JButton btnMesa8;
    private JButton btnMesa9;
    public DefaultListModel modelo = (DefaultListModel) lstLista.getModel();

    public List<Integer> lstMesasEscrita = new ArrayList<>();
    public List<Integer> lstMesasLeitura = new ArrayList<>();

    Pedido mesas[]; // Vetor com as mesas que terão os pedidos.

    public JanelaPedido() throws IOException, ParseException {

        super("Faça seu Pedido: ");

        //Mesas vazias, prontas para um novo pedido
        this.mesas = new Pedido[10];
        for (int i = 0; i < 10; i++) {
            mesas[i] = new Pedido(null, null, false, 0, null);
        }

        //Abastecimento do ComboBox de Itens
        Cardapio c = new Cardapio();
        List<Item> a = new ArrayList<>(c.getItens());

        for (int i = 0; i < a.size(); i++) {
            cmbItens.addItem(a.get(i));
        }

        telaMesas();

        //---Conferir Mesas com pedidos em aberto---
        lstMesasLeitura = PedidoDAO.VerMesasOcupadas();

        for (int i = 0; i < lstMesasLeitura.size(); i++) {
            TrocarVermelho(lstMesasLeitura.get(i));
          }
        lstMesasEscrita = lstMesasLeitura;

        //_------------------Funções dos Botões relativos as mesas--------------------
        btnMesa1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        new PedidoM(1).actionPerformed(e);
                        setIndice(1);
                        lstMesasEscrita.add(1);
                        leituraArquivo();
                        mesas[getIndice()].setItens(listaItem);

                    } catch (IOException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("FALHOU");

                    } catch (ParseException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        });

        btnMesa2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        new PedidoM(2).actionPerformed(e);
                        setIndice(2);
                        lstMesasEscrita.add(2);
                        leituraArquivo();
                        mesas[getIndice()].setItens(listaItem);

                    } catch (IOException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("FALHOU");

                    } catch (ParseException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        });
        btnMesa3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        new PedidoM(3).actionPerformed(e);
                        setIndice(3);
                        lstMesasEscrita.add(3);
                        leituraArquivo();
                        mesas[getIndice()].setItens(listaItem);

                    } catch (IOException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("FALHOU");

                    } catch (ParseException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        });

        btnMesa4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        new PedidoM(4).actionPerformed(e);
                        setIndice(4);
                        lstMesasEscrita.add(4);
                        leituraArquivo();
                        mesas[getIndice()].setItens(listaItem);

                    } catch (IOException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("FALHOU");

                    } catch (ParseException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        });
        btnMesa5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        new PedidoM(5).actionPerformed(e);
                        setIndice(5);
                        lstMesasEscrita.add(5);
                        leituraArquivo();
                        mesas[getIndice()].setItens(listaItem);

                    } catch (IOException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("FALHOU");

                    } catch (ParseException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        });

        btnMesa6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        new PedidoM(6).actionPerformed(e);
                        setIndice(6);
                        lstMesasEscrita.add(6);
                        leituraArquivo();
                        mesas[getIndice()].setItens(listaItem);

                    } catch (IOException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("FALHOU");

                    } catch (ParseException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        }
        );
        btnMesa7.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                try {
                    new PedidoM(7).actionPerformed(e);
                    setIndice(7);
                    lstMesasEscrita.add(7);
                    leituraArquivo();
                    mesas[getIndice()].setItens(listaItem);

                } catch (IOException ex) {
                    Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("FALHOU");

                } catch (ParseException ex) {
                    Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );

        btnMesa8.addActionListener(
                new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        new PedidoM(8).actionPerformed(e);
                        setIndice(8);
                        lstMesasEscrita.add(8);
                        leituraArquivo();
                        mesas[getIndice()].setItens(listaItem);

                    } catch (IOException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("FALHOU");

                    } catch (ParseException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        }
        );

        btnMesa9.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            )  {
                    try {
                        new PedidoM(9).actionPerformed(e);
                        setIndice(9);
                        lstMesasEscrita.add(9);
                        leituraArquivo();
                        mesas[getIndice()].setItens(listaItem);

                    } catch (IOException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("FALHOU");

                    } catch (ParseException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
        }
        );

        //----------------Funções de Botões do Pedido------------------------------
        btnAdicionar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {

                modelo.addElement(cmbItens.getSelectedItem());
                
                mesas[getIndice()].setItem((Item) cmbItens.getSelectedItem());

            }
        }
        );

        btnVoltar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                try {
                    principal2.setVisible(true);
                    btnVoltar.setVisible(false);
                    PedidoDAO.GravarArquivo(getIndice(), mesas[getIndice()]);
                    modelo.clear();
                    System.out.println(getIndice() + "  " + mesas[getIndice()].isStatus());
                    setIndice(0);
                } catch (IOException ex) {
                    Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );

        btnFecharPedido.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e
            ) {

                try {
                    LocalDateTime dataFinal = LocalDateTime.now();
                    mesas[getIndice()].setHoraFim(dataFinal);
                    Double soma = 0.0;
                    System.out.println(getIndice());
                    for (int i = 0; i < mesas[getIndice()].getItens().size(); i++) {
                        System.out.println(mesas[getIndice()].getItens());
                        soma = soma + mesas[getIndice()].getItens().get(i).getPreco();
                        
                    }
                    mesas[getIndice()].setSomaT(soma);
                    JOptionPane.showMessageDialog(null, "Encerramento!\n" + "Horário Inicial:" + mesas[getIndice()].getHoraInicio()
                            + "\n" + "Pedidos Realizados: \n" + modelo + "\n" + "Horário Final : " + mesas[getIndice()].getHoraFim() + "\n"
                                    + "Valor Total: \n" + mesas[getIndice()].getSomaT() + "\nDirija-se ao Caixa. Obrigado!");
                    System.out.println("Pedido Encerrado! Receber o pagamento!");
                    TrocarVerde(getIndice());
                    PedidoDAO.encerrarPedido(getIndice());
                    principal2.setVisible(true);
                    btnFecharPedido.setVisible(false);
                    soma = 0.0;
                    mesas[getIndice()] = new Pedido(null, null, false, 0, null);
                    modelo.removeAllElements();
                    
                   
         
                    setIndice(0);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        );

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                if (JOptionPane.showConfirmDialog(null, "Deseja sair") == JOptionPane.OK_OPTION) {

                    try {
                        PedidoDAO.AdicionarMesasOcupadas(lstMesasEscrita);
                        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        lstMesasEscrita.clear();
                    } catch (IOException ex) {
                        Logger.getLogger(JanelaPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

    }

    public class PedidoM implements ActionListener {

        public PedidoM(int j) {

            numero = j;
            setIndice(j);
            System.out.println("---" + numero);
            System.out.println("---" + getIndice());

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (mesas[getIndice()].isStatus() == false) {

                modelo.clear();
                TrocarVermelho(getIndice());
                LocalDateTime dataInicial = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                dataInicial.format(formatter);
                setDataInicial(dataInicial);
                lbl2.setText(dataInicial.toString());
                listaItem = new ArrayList<>();
                mesas[getIndice()] = new Pedido(dataInicial, null, true, getIndice(), listaItem);
                System.out.println("Iniciar Mesa" + getIndice());
                //System.out.println("Dados: " + getIndice() + "  " + mesas.get(getIndice()).getHoraInicio() + "  " + mesas.get(getIndice()).isStatus());
                telaPedido();

            } else if (mesas[getIndice()].isStatus() == true) {
                System.out.println("Entrou");

                setIndice(getIndice());
                TrocarVermelho(getIndice());

                telaPedido();
            }

        }

    }

    public void setIndice(int i) {
        this.numero = i;
    }

    public int getIndice() {
        return numero;

    }

    public void setDataInicial(LocalDateTime i) {
        this.data = i;
    }

    public LocalDateTime getDataInicial() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        data.format(formatter);
        return data;

    }

    public void leituraArquivo() throws IOException, ParseException {

        Pedido pedido = new Pedido();
        pedido = PedidoDAO.LerArquivo(getIndice());

        Iterator it = (pedido.getItens().iterator());
        listaItem = pedido.getItens();
        lstLista.setModel(modelo);
        String itemLista;
        while (it.hasNext()) {
            itemLista = String.valueOf(it.next());
            modelo.addElement(itemLista);

        }

        telaPedido();

    }

    // Configurações das Telas de acordo com as operações
    public void telaPedido() {

        principal2.setVisible(false);
        principal.setLayout(null);

        principal.add(lbl1);
        lbl1.setSize(500, 50);
        lbl1.setLocation(20, 0);

        principal.add(lbl2);
        lbl2.setSize(300, 50);
        lbl2.setLocation(290, 0);

        principal.add(cmbItens);
        cmbItens.setSize(400, 25);
        cmbItens.setLocation(20, 40);

        principal.add(btnAdicionar);
        btnAdicionar.setBackground(Color.GREEN);
        btnAdicionar.setForeground(Color.WHITE);
        btnAdicionar.setFont(new Font("", Font.BOLD, 14));
        btnAdicionar.setSize(100, 30);
        btnAdicionar.setLocation(320, 70);

        principal.add(lstLista);
        lstLista.setSize(400, 350);
        lstLista.setLocation(20, 110);

        principal.add(btnFecharPedido);
        btnFecharPedido.setVisible(true);
        btnFecharPedido.setBackground(Color.RED);
        btnFecharPedido.setForeground(Color.WHITE);
        btnFecharPedido.setFont(new Font("", Font.BOLD, 14));
        btnFecharPedido.setSize(150, 30);
        btnFecharPedido.setLocation(270, 480);

        principal.add(btnVoltar);
        btnVoltar.setBackground(Color.BLUE);
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(new Font("", Font.BOLD, 14));
        btnVoltar.setSize(150, 30);
        btnVoltar.setLocation(20, 480);
        btnVoltar.setVisible(true);

        add(principal);

    }

    private void telaMesas() {
        lbl1 = new JLabel("Digite os Pedidos da Mesa");
        lbl1.setFont(new Font("Digite os Pedidos da Mesa", Font.BOLD, 14));
        lbl2 = new JLabel("Horário de Abertura");
        lbl2.setFont(new Font("", Font.BOLD, 14));

        btnVoltar = new JButton("Voltar a Mesas");
        btnFecharPedido = new JButton("Encerrar Pedido");
        btnAdicionar = new JButton("Adicionar");

        btnMesa1 = new JButton("Mesa 1");
        btnMesa2 = new JButton("Mesa 2");
        btnMesa3 = new JButton("Mesa 3");
        btnMesa4 = new JButton("Mesa 4");
        btnMesa5 = new JButton("Mesa 5");
        btnMesa6 = new JButton("Mesa 6");
        btnMesa7 = new JButton("Mesa 7");
        btnMesa8 = new JButton("Mesa 8");
        btnMesa9 = new JButton("Mesa 9");

        principal2.setLayout(new GridLayout(3, 3));

        principal2.add(btnMesa1);
        btnMesa1.setBackground(Color.GREEN);
        btnMesa1.setForeground(Color.WHITE);
        btnMesa1.setFont(new Font("Mesa 1", Font.BOLD, 18));

        principal2.add(btnMesa2);
        btnMesa2.setBackground(Color.GREEN);
        btnMesa2.setForeground(Color.WHITE);
        btnMesa2.setFont(new Font("Mesa 2", Font.BOLD, 18));

        principal2.add(btnMesa3);
        btnMesa3.setBackground(Color.GREEN);
        btnMesa3.setForeground(Color.WHITE);
        btnMesa3.setFont(new Font("Mesa 3", Font.BOLD, 18));

        principal2.add(btnMesa4);
        btnMesa4.setBackground(Color.GREEN);
        btnMesa4.setForeground(Color.WHITE);
        btnMesa4.setFont(new Font("Mesa 4", Font.BOLD, 18));

        principal2.add(btnMesa5);
        btnMesa5.setBackground(Color.GREEN);
        btnMesa5.setForeground(Color.WHITE);
        btnMesa5.setFont(new Font("Mesa 5", Font.BOLD, 18));

        principal2.add(btnMesa6);
        btnMesa6.setBackground(Color.GREEN);
        btnMesa6.setForeground(Color.WHITE);
        btnMesa6.setFont(new Font("Mesa 6", Font.BOLD, 18));

        principal2.add(btnMesa7);
        btnMesa7.setBackground(Color.GREEN);
        btnMesa7.setForeground(Color.WHITE);
        btnMesa7.setFont(new Font("Mesa 7", Font.BOLD, 18));

        principal2.add(btnMesa8);
        btnMesa8.setBackground(Color.GREEN);
        btnMesa8.setForeground(Color.WHITE);
        btnMesa8.setFont(new Font("Mesa 8", Font.BOLD, 18));

        principal2.add(btnMesa9);
        btnMesa9.setBackground(Color.GREEN);
        btnMesa9.setForeground(Color.WHITE);
        btnMesa9.setFont(new Font("Mesa 9", Font.BOLD, 18));

        add(principal2);
    }

    public void TrocarVerde(int num) {
        switch (num) {
            case 1:
                btnMesa1.setBackground(Color.GREEN);
                break;
            case 2:
                btnMesa2.setBackground(Color.GREEN);
                break;
            case 3:
                btnMesa3.setBackground(Color.GREEN);
                break;
            case 4:
                btnMesa4.setBackground(Color.GREEN);
                break;

            case 5:
                btnMesa5.setBackground(Color.GREEN);
                break;

            case 6:
                btnMesa6.setBackground(Color.GREEN);
                break;

            case 7:
                btnMesa7.setBackground(Color.GREEN);
                break;

            case 8:
                btnMesa8.setBackground(Color.GREEN);
                break;

            case 9:
                btnMesa9.setBackground(Color.GREEN);
                break;
            default:

                System.out.println("Este não é um botão válido!");

        }
    }

    public void TrocarVermelho(int num) {
        switch (num) {
            case 1:
                btnMesa1.setBackground(Color.RED);
                break;
            case 2:
                btnMesa2.setBackground(Color.RED);
                break;
            case 3:
                btnMesa3.setBackground(Color.RED);
                break;
            case 4:
                btnMesa4.setBackground(Color.RED);
                break;

            case 5:
                btnMesa5.setBackground(Color.RED);
                break;

            case 6:
                btnMesa6.setBackground(Color.RED);
                break;

            case 7:
                btnMesa7.setBackground(Color.RED);
                break;

            case 8:
                btnMesa8.setBackground(Color.RED);
                break;

            case 9:
                btnMesa9.setBackground(Color.RED);
                break;
            default:

                System.out.println("Este não é um botão válido!");

        }
    }

}
