/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoe;

/**
 *
 * @author M912
 */
public class JogoDaVelha {
    private final String grid[][];
    private final PlayerOponente ai;
    JogoDaVelha()
    {
        this.grid = new String[3][3];
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                grid[i][j] = "";
            }
        }
        ai = new PlayerOponente(this);
    }

    public String getPos(int x, int y)
    {
        return grid[y][x];
    }

    public void setPos(String s, int x, int y)
    {
        grid[y][x] = s;
    }
    
    public boolean isValid(int x, int y)
    {
        return getPos(x, y).equals("");
    }
    
    public PlayerOponente getAI()
    {
        return ai;
    }
    
    private boolean checkHorizontal(int y)
    {
        return getPos(0,y).equals(getPos(1,y)) && 
                getPos(1,y).equals(getPos(2,y)) &&
                !getPos(0,y).equals("");
    }
    
    private boolean checkVertical(int x)
    {
        return getPos(x,0).equals(getPos(x,1)) && 
                getPos(x,1).equals(getPos(x,2)) &&
                !getPos(x,0).equals("");
    }
    
    private boolean checkDiagonal(int x, int y)
    {
        return (getPos(0,0).equals(getPos(1,1))&& 
                getPos(1,1).equals(getPos(2,2))
                ||
                 (getPos(2,0).equals(getPos(1,1))&& 
                  getPos(1,1).equals(getPos(0,2))))
                &&
                !getPos(1,1).equals("");
    }
    
    public boolean hasWon(int x, int y)
    {
        return checkHorizontal(y) || checkVertical(x) || checkDiagonal(x,y);
    }
    
    public void reseta()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                grid[i][j] = "";
            }
        }
    }
    
    @Override
    public String toString()
    {
        String s = "";
        
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                s += grid[i][j] + " ";
            }
            s += "\n";
        }
        
        return s;
    }
    
}
