/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holdemyall;

/**
 *
 * @author storm
 */
public class Card implements Comparable<Card>{
    public String suit;
    public int face;
    
    public Card( String suit, int face)
    {
        this.suit = suit;
        this.face = face;
    }
    
    @Override
    public int compareTo(Card o) {
        return face - o.face;
    }
  
}
