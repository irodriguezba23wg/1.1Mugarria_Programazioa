import javax.swing.*;
import java.awt.*;

public class FileViwer {
    private JComboBox<String> fitxategiComboBox;
    private JTextArea testuArea;
    private JButton garbituBotoia, itxiBotoia;

    public FileViwer(){
        setTitle("Proba Eventuak: Fitxategiak");
        setSize(500,300);
        setDefaultOperation(EXIT_ON_CLOSE);
        setLeyout(new FlowLayout());

        String[] fitxategiak = {"python.txt" , "c.txt" , "java.txt"};
        fitxategiComboBox = new JComboBox<>(fitxategiak);
        testuArea = new JTextArea(15,30);
        garbituBotoia = new JButton("Garbitu");
        itxiBotoia = new JButton("Itxi");



    }












    private void setTitle(String s) {
    }
}