/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author M912
 */
public class InterfaceGrafica extends JFrame implements ActionListener{
    private Container content;
//    private JButton buttons[][];
    private Botao buttons[][];
    private GridLayout grid;
    private Tabuleiro tabuleiro;
    private int turn;

    InterfaceGrafica(Tabuleiro tabuleiro)
    {
        super("Tic Tac Toe");
        this.tabuleiro = tabuleiro;
        content = getContentPane();
//        buttons = new JButton[3][3];
        buttons = new Botao[3][3];
        grid = new GridLayout(3, 3, 5, 5);
        content.setLayout(grid);
        initializeButtons();  
        pack();
        setSize(300,300);
        setVisible(true);
    }
    
    private void initializeButtons()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                buttons[i][j] = new Botao(i, j);
                buttons[i][j].addActionListener(this);
                content.add(buttons[i][j]);
            }
        }
    }

    public void atualiza(Tabuleiro tabuleiro)
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                buttons[i][j].setText(tabuleiro.getPos(i, j));
            }
        }      
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        JButton buttonPressed = (Botao)event.getSource();
        String s;
        
        if(turn%2 == 0)
        {
            s = "O";
        }
        else
        {
            s = "X";
        }
        buttonPressed.setText(s);
        tabuleiro.setPos(s, buttonPressed.getX(), buttonPressed.getY());
        System.out.println(tabuleiro);
        turn++;
    }
}
