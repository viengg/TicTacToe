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
    private final Coordenada coordenada;
    
    Botao(int x, int y)
    {
        super();
        coordenada = new Coordenada(x, y);
    }
    
    public Coordenada getCoordenada()
    {
        return coordenada;
    }
}
