/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Vien
 */
public class MenuInicial extends JPanel implements ActionListener{
    private final JButton iniciar;
    private final JButton fechar;
    private final InterfaceGrafica gui;

    MenuInicial(InterfaceGrafica gui)
    {
        this.gui = gui;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,3,10,3);
        iniciar = new JButton("Novo Jogo");
        fechar = new JButton("Fechar");
        iniciar.addActionListener(this);
        fechar.addActionListener(this);
        add(iniciar, gbc);
        add(fechar, gbc);
    }

    public JButton getIniciar()
    {
        return iniciar;
    }
    
    public JButton getFechar()
    {
        return fechar;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton botao = (JButton) event.getSource();
        if(botao.getText().equals("Novo Jogo"))
        {
            gui.comecaDenovo();
            gui.trocaPanel();
        }
        else
        {
            System.exit(0);
        }
    }
}
