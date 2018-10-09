/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoe;

/**
 *
 * @author M912
 */
public class Tabuleiro {
    private String grid[][] = new String[3][3];
    Tabuleiro()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                grid[i][j] = "A";
            }
        }
    }

    public String getPos(int x, int y)
    {
        return grid[y][x];
    }

    public void setPos(String s, int x, int y)
    {
        grid[y][x] = s;
    }
    
    public String toString()
    {
        String s = "";
        
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                s += (getPos(i, j) + " ");
            }
            s += "\n";
        }
        
        return s;
    }
    
}
