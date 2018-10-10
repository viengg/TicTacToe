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
    public static int turn;
    private final Container content;
    private final Botao buttons[][];
    private final JogoDaVelha tabuleiro;

    InterfaceGrafica()
    {
        super("Tic Tac Toe");
        tabuleiro = new JogoDaVelha();
        content = getContentPane();
        buttons = new Botao[3][3];
        content.setLayout(new GridLayout(3, 3, 5, 5));
        initializeButtons();  
        pack();
        setSize(300,300);
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
                buttons[i][j].addActionListener(this);
                content.add(buttons[i][j]);
            }
        }
    }
    
    public JogoDaVelha getTabuleiro()
    {
        return tabuleiro;
    }
    
    private Botao getButton(int x, int y)
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
        turn = 0;
    }
    
    private void comecaDenovo()
    {
        reseta();
        tabuleiro.reseta();
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        Botao buttonPressed = (Botao)event.getSource();

        if (buttonPressed.getText().equals("")) 
        {
            turn++;
            
            buttonPressed.setText("O");
            int x = buttonPressed.getCoordenada().getX();
            int y = buttonPressed.getCoordenada().getY();
            tabuleiro.setPos("O", x, y);
            
            if(tabuleiro.hasWon(x, y))
            {
                System.out.println("Você ganhou!");
                comecaDenovo();
                return;
            }
      
            if(turn < 5)
            {
                Coordenada c = tabuleiro.getAI().getMove();
                tabuleiro.setPos("X", c.getX(), c.getY());
                getButton(c.getX(),c.getY()).setText("X");
                
                if(tabuleiro.hasWon(c.getX(),c.getY()))
                {
                    System.out.println("Você perdeu!");
                    comecaDenovo();
                }
            }
            else
            {
                System.out.println("Empate!");
                comecaDenovo();
            }
            
        }
        
    }
}
