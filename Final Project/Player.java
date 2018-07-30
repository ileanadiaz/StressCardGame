import java.lang.*;
public class Player
{
    private Pile[] piles;
    private int pNum;
    
    public Player(int n)
    {
        pNum = n;
        piles = new Pile[6];
        for(int i = 0; i < 6; i++)
        {
            piles[i] = new Pile();
        }
    }
    public void add(int p, Card c)
    {
        piles[p].add(c);
    }
    public Card remove(int p, int c)
    {
        return piles[p].remove(c);
    }
    public Pile getPile(int num)
    {
        return piles[num];
    }
    public void swap(int p1, int c1, int p2, int c2)
    {
        Card card1 = piles[p1].remove(c1);
        Card card2 = piles[p2].remove(c2);
        piles[p1].add(card2);
        piles[p2].add(card1);
    }
    public void swap(int p1, int c1, Pile center, int c2)
    {
        Card card1 = piles[p1].remove(c1);
        while(center.size() != 4){}
        Card card2 = center.remove(c2);
        center.add(card1);
        piles[p1].add(card2);
    }
    public boolean isDone()
    {
        for(Pile i : piles)
        {
            if(!i.isDone())
            {
                return false;
            }
        }
        return true;
    }
    public String showPile(int p)
    {
        String output = "";
        if(p < 6 && p > -1)
        {
            output += piles[p].toString();
        }
        return output;
    }
    public String showPileKeys(int p)
    {
        String output = "";
        String[][] keys = {{"q","w","e","r","t"},{"j ","k ","l ","; ","' "}};
        for(int i = 0; i < piles[p].size(); i++)
        {
            output += keys[pNum-1][i] + "     ";
            if(showPile(p).length()  > 13)
            {
                output += "  ";
            }
        }
        return output;
    }
    public String toString()
    {
        String output = "";
        String[] p2Keys = {"B","N","M",",",".","/"};
        for(int i = 0; i < 6; i++)
        {
            if(piles[i].isDone())
            {
                output += "X ";
            }
            else if(pNum == 1)
            {
                output += (i+1) + " ";
            }
            else
            {
                output += p2Keys[i] + " ";
            }
        }
        return output;
    }
}














