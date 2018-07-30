import java.util.*;
public class Pile
{
    private ArrayList<Card> cards;
    
    public Pile()
    {
        cards = new ArrayList<Card>();
    }
    public void add(Card c)
    {
        cards.add(c);
    }
    public Card remove(int index)
    {
        return cards.remove(index);
    }
    public Card getCard(int c)
    {
        return cards.get(c);
    }
    public boolean correctSize()
    {
        return cards.size() == 4;
    }
    public int size()
    {
        return cards.size();
    }
    public boolean isDone()
    {
        if(!correctSize())
        {
            return false;
        }
        for(int i = 1; i < cards.size(); i++)
        {
            if(!cards.get(0).getValue().equals(cards.get(i).getValue()))
            {
                return false;
            }
        }
        return true;
    }
    public String toString()
    {
        String output = "";
        for(Card i : cards)
        {
            output += i.toString() + " ";
        }
        return output;
    }
}