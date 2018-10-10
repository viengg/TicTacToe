/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Vien
 */
public class Coordenada {
    private final int x;
    private final int y;
    
    Coordenada(int x, int y)
    {
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
    
    @Override
    public String toString()
    {
        String s = getX() + ", " + getY();
        return s;
    }
}
