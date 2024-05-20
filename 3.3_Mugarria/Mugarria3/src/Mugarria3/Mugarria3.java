package Mugarria3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Mugarria3 extends JFrame implements ActionListener {
    private JPanel panela;
    private JLabel irudiEtiketa;
    private JComboBox irudiKonbinatua;
    private JCheckBox iruzkinGordeCheckBox;
    private JTextField testuEremua;
    private JButton gordeBotoia;
    private ImageIcon[] irudiIkonoak;

    public Mugarria3(){
        super("Irudia Kargatu");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900,500));

        this.setLayout(null);
        panela = (JPanel) this.getContentPane();
        addWindowListener( new ItxiMezua() );

        JPasswordField pasahitzaEremua = new JPasswordField();
        Object[] mezua = {"Pasahitza Sartu:", pasahitzaEremua};

        int aukera = JOptionPane.showConfirmDialog(null, mezua, "Pasahitz Eskaera", JOptionPane.OK_CANCEL_OPTION);

        if (aukera == JOptionPane.OK_OPTION) {
            char[] pasahitza = pasahitzaEremua.getPassword();
            String sartutakoPasahitza = new String(pasahitza);

            if (sartutakoPasahitza.equals("damocles")) {
                System.out.println("Sartutako Pasahitza: " + sartutakoPasahitza);
            }
            else{
                System.out.println("Pasahitz Okerra");
                System.exit(0);
            }
        }
        else {
            System.out.println("Eragiketa Bertan Behera Utzi Da.");
            System.exit(0);
        }

        String[] irudiak = {"etxea.jpg", "Mendia.jpg", "denda.jpg"};
        irudiKonbinatua = new JComboBox<>(irudiak);

        irudiKonbinatua.setSelectedIndex(0);
        irudiKonbinatua.setBounds(20, 20, 200, 45);

        panela.add(irudiKonbinatua);

        irudiIkonoak = new ImageIcon[]{
                new ImageIcon(new ImageIcon("argazkiak/etxea.jpeg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)),
                new ImageIcon(new ImageIcon("argazkiak/Mendia.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)),
                new ImageIcon(new ImageIcon("argazkiak/denda.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT))
        };

        irudiEtiketa = new JLabel(irudiak[0]);
        irudiEtiketa.setBounds(20, 100, 200, 200);
        panela.add(irudiEtiketa);

        ComboListener entzulea = new ComboListener(irudiKonbinatua, panela, irudiEtiketa, irudiIkonoak);
        irudiKonbinatua.addActionListener(entzulea);

        iruzkinGordeCheckBox = new JCheckBox("Zure iruzkina gorde", true);
        iruzkinGordeCheckBox.setBounds(50, 300, 200,50);
        iruzkinGordeCheckBox.isSelected();
        panela.add(iruzkinGordeCheckBox);

        testuEremua = new JTextField(10);
        testuEremua.setBounds(310, 300, 250, 40);
        panela.add(testuEremua);

        gordeBotoia = new JButton("GORDE");
        gordeBotoia.setBounds(200, 400, 100, 40);
        panela.add(gordeBotoia);

        gordeBotoia.addActionListener(this);

        this.setVisible(true);
        this.pack();
    }

    public class ItxiMezua extends WindowAdapter {
        public void windowClosing( WindowEvent e ) {
            JOptionPane.showMessageDialog
                    (null, "Agur","Sarrera",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Mugarria3();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fitxategiIzena = "Buffer_Fitxategiak/mugarria3.txt";
        String irudiIzena = irudiEtiketa.getName();

        if (iruzkinGordeCheckBox.isSelected()){
            BufferedWriter bw;
            String lerroBerria = "\n";
            try {
                bw = new BufferedWriter(new FileWriter(fitxategiIzena, true));

                bw.append(lerroBerria);
                bw.append(irudiIzena).append(" ").append(testuEremua.getText());

                if (bw!=null){
                    bw.close();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog
                    (null, "Zure iruzkina ondo gorde da!","Sarrera",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog
                    (null, "Zure iruzkina ez da gordeko!","Alerta",JOptionPane.WARNING_MESSAGE);
        }
    }
}
