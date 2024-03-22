import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FileViwer extends JFrame implements ActionListener {
    private JComboBox<String>fitxategiComboBox;
    private JTextArea testuArea;
    private JButton garbituBotoia, itxiBotoia;

    public FileViwer(){
        setTitle("Proba Eventuak: Fitxategiak");
        setSize(500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        String[] fitxategiak = {"python.txt" , "c.txt" , "java.txt"};
        fitxategiComboBox = new JComboBox<>(fitxategiak);
        testuArea = new JTextArea(15,30);
        garbituBotoia = new JButton("Garbitu");
        itxiBotoia = new JButton("Itxi");

        add(fitxategiComboBox);
        add(garbituBotoia);
        add(new JScrollPane(testuArea));
        add(itxiBotoia);

        fitxategiComboBox.addActionListener(this);
        garbituBotoia.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                testuArea.setText("");
            }
        });

        itxiBotoia.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

    }

    public static void main (String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileViwer().setVisible(true);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}