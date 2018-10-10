/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.Random;
/**
 *
 * @author Vien
 */
public class PlayerOponente {
    private final JogoDaVelha tabuleiro;
    
    PlayerOponente(JogoDaVelha tabuleiro)
    {
        this.tabuleiro = tabuleiro;
    }
    public Coordenada getMove()
    {
        int x, y;
        Random r = new Random();
        do
        {
            x = r.nextInt(3);
            y = r.nextInt(3);
        } while(!tabuleiro.isValid(x, y));
        
        Coordenada c = new Coordenada(x, y);
        return c;
    }
}
