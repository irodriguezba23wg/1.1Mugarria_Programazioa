package Mugarria3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboListener implements ActionListener {

    private JComboBox konbinatua;
    private JPanel panela;
    private ImageIcon[] irudiIkonoak;
    private JLabel irudiEtiketa;

    public ComboListener(JComboBox konbinatua, JPanel panela, JLabel irudiEtiketa, ImageIcon[] irudiIkonoak) {
        this.konbinatua = konbinatua;
        this.panela = panela;
        this.irudiEtiketa = irudiEtiketa;
        this.irudiIkonoak = irudiIkonoak;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int hautatutakoIndizea = konbinatua.getSelectedIndex();

        ImageIcon hautatutakoIkonoa = irudiIkonoak[hautatutakoIndizea];
        irudiEtiketa.setIcon(hautatutakoIkonoa);
        System.out.println(irudiEtiketa.getIcon());
        panela.add(irudiEtiketa);
    }
}
