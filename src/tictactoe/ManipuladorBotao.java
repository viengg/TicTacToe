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
public class ManipuladorBotao implements ActionListener {
    private final JogoDaVelha tabuleiro;
    private final InterfaceGrafica gui;
    
    ManipuladorBotao(JogoDaVelha tabuleiro, InterfaceGrafica gui)
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
    
    private void computaTurnoHumano(Botao buttonPressed)
    {
        buttonPressed.setText("O");
        int x = buttonPressed.getCoordenada().getX();
        int y = buttonPressed.getCoordenada().getY();
        tabuleiro.setPos("O", x, y);
        tabuleiro.incrementTurn();
    }
    
    private void computaTurnoAI(Coordenada c)
    {
        gui.getButton(c.getX(), c.getY()).setText("X");
        tabuleiro.setPos("X", c.getX(), c.getY());
        tabuleiro.incrementTurn();
    }

    @Override
    public void actionPerformed(ActionEvent event) 
    {
        Botao buttonPressed = (Botao) event.getSource();

        if (buttonPressed.getText().equals("")) 
        {
            computaTurnoHumano(buttonPressed);
            int x = buttonPressed.getCoordenada().getX();
            int y = buttonPressed.getCoordenada().getY();

            if (tabuleiro.hasWon(x, y))
            {
                showMenu("Você ganhou");
                gui.comecaDenovo();
                return;
            }

            if (tabuleiro.getTurn() < 9) //Enquanto houveram casas disponiveis
            {
                Coordenada resposta = tabuleiro.getAI().getMove();
                computaTurnoAI(resposta);

                if (tabuleiro.hasWon(resposta.getX(), resposta.getY())) 
                {
                    showMenu("Você perdeu");
                    gui.comecaDenovo();
                }
            } 
            else 
            {
                showMenu("Empate");
                gui.comecaDenovo();
            }
        }
    }
}
