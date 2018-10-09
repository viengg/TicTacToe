/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import javax.swing.*;

/**
 *
 * @author Vien
 */
public class Botao extends JButton{
    private int x;
    private int y;
    
    Botao(int x, int y)
    {
        super();
        this.x = x;
        this.y = y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
}
