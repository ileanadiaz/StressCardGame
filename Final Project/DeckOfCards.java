import java.util.*;
public class DeckOfCards
{
    private ArrayList<Card> cards;
    
    public DeckOfCards()
    {
        cards = new ArrayList<Card>();
        String value;
        String type;
        for(int i = 1; i <= 13; i++)
        {
            if(i == 1)
            {
                value = "A";
            }
            else if(i == 11)
            {
                value = "J";
            }
            else if(i == 12)
            {
                value = "Q";
            }
            else if(i == 13)
            {
                value = "K";
            }
            else
            {
                value = "" + i;
            }
            for(int j = 1; j <= 4; j++)
            {
                if(j == 1)
                {
                    type = "spade";
                }
                else if(j == 2)
                {
                    type = "heart";
                }
                else if(j == 3)
                {
                    type = "diamond";
                }
                else
                {
                    type = "club";
                }
                cards.add(new Card(value,type));
            }
        }
    }
    public void shuffle()
    {
        for(int i = 0; i < 51; i++)
        {
            int index = (int)(52 * Math.random());
            Card temp = cards.remove(index);
            Card orig = cards.remove(i);
            cards.add(i,temp);
            cards.add(index,orig);
        }
    }
    public void deal(Player p1, Player p2, Pile center)
    {
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                p1.add(i,cards.remove(0));
                p2.add(i,cards.remove(0));
            }
        }
        for(int i = 0; i < 4; i++)
        {
            center.add(cards.remove(0));
        }
    }
}















