/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoe;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Vien
 */
public class InterfaceGrafica extends JFrame{
    private final Container content;
    private final Container buttonsPanel;
    private final Botao buttons[][];
    private final JogoDaVelha tabuleiro;
    private final MenuInicial menu;
    private final CardLayout cards;

    InterfaceGrafica()
    {
        super("Tic Tac Toe");
        cards = new CardLayout();
        tabuleiro = new JogoDaVelha();
        content = getContentPane();
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 3, 5, 5));
        menu = new MenuInicial(this);
        buttons = new Botao[3][3];
        content.setLayout(cards);
        content.add(menu);
        initializeButtons();
        pack();
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void initializeButtons()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                buttons[i][j] = new Botao(j, i);
                buttons[i][j].addActionListener(new ManipuladorBotao
                                                        (tabuleiro, this));
                buttonsPanel.add(buttons[i][j]);
            }
        }
        content.add(buttonsPanel);
    }
    
    public JogoDaVelha getTabuleiro()
    {
        return tabuleiro;
    }
    
    public Botao getButton(int x, int y)
    {
        return buttons[y][x];
    }
    
    private void reseta()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                buttons[i][j].setText("");
            }
        }
    }
    
    public void comecaDenovo()
    {
        reseta();
        tabuleiro.reseta();
    }
    
    public void trocaPanel()
    {
        cards.next(content);
    }            
}
