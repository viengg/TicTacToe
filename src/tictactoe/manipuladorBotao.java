/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Vien
 */
public class manipuladorBotao implements ActionListener {
    private final JogoDaVelha tabuleiro;
    private final InterfaceGrafica gui;
    
    manipuladorBotao(JogoDaVelha tabuleiro, InterfaceGrafica gui)
    {
        this.tabuleiro = tabuleiro;
        this.gui = gui;
    }
    
    private void showMenu(String resultado)
    {
        int choose = JOptionPane.showConfirmDialog(gui,
                resultado + "!\nQuer continuar jogando?", "Escolha",
                JOptionPane.YES_NO_OPTION);
        if (choose == JOptionPane.NO_OPTION) 
        {
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) 
    {
        Botao buttonPressed = (Botao) event.getSource();

        if (buttonPressed.getText().equals("")) 
        {
            tabuleiro.updateTurn();

            buttonPressed.setText("O");
            int x = buttonPressed.getCoordenada().getX();
            int y = buttonPressed.getCoordenada().getY();
            tabuleiro.setPos("O", x, y);

            if (tabuleiro.hasWon(x, y)) 
            {
                showMenu("Você ganhou");
                gui.comecaDenovo();
                return;
            }

            if (tabuleiro.getTurn() < 9) 
            {
                Coordenada c = tabuleiro.getAI().getMove();
                tabuleiro.setPos("X", c.getX(), c.getY());
                gui.getButton(c.getX(), c.getY()).setText("X");
                tabuleiro.updateTurn();

                if (tabuleiro.hasWon(c.getX(), c.getY())) 
                {
                    showMenu("Você perdeu");
                    gui.comecaDenovo();
                }
            } else 
            {
                showMenu("Empate");
                gui.comecaDenovo();
            }

        }
    }
}
