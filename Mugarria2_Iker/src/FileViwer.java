import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileViwer extends JFrame {
    private JComboBox<String> fitxategiComboBox;
    private JTextArea testuArea;
    private JButton garbituBotoia, itxiBotoia;

    public FileViwer() {
        setTitle("Proba Eventuak: Fitxategiak");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        String[] fitxategiak = {"python.txt", "c.txt", "java.txt"};
        fitxategiComboBox = new JComboBox<>(fitxategiak);
        testuArea = new JTextArea(20, 50);
        garbituBotoia = new JButton("Garbitu");
        itxiBotoia = new JButton("Itxi");

        JPanel goikoPanela = new JPanel(new FlowLayout(FlowLayout.LEFT));
        goikoPanela.add(fitxategiComboBox);
        goikoPanela.add(garbituBotoia);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(goikoPanela, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(new JScrollPane(testuArea), gbc);

        JPanel behekoPanela = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        behekoPanela.add(itxiBotoia);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(behekoPanela, gbc);

        fitxategiComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hautatutakoFitxategia = (String) fitxategiComboBox.getSelectedItem();
                fitxategiaKargatu(hautatutakoFitxategia);
            }
        });

        garbituBotoia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                testuArea.setText("");
            }
        });

        itxiBotoia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void fitxategiaKargatu(String fitxategiIzena) {
        File fitxategia = new File(fitxategiIzena);
        if (fitxategia.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fitxategia))) {
                testuArea.setText("");
                String lerroa;
                while ((lerroa = br.readLine()) != null) {
                    testuArea.append(lerroa + "\n");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Fitxategia ez da existitzen: " + fitxategiIzena, "Errorea", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileViwer().setVisible(true);
            }
        });
    }
}
