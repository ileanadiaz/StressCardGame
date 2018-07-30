import java.awt.*;
import java.awt.event.*;
public class Listener implements KeyListener
{
    private DrawingPanel frame;
    private Graphics g;
    private Player p1;
    private Player p2;
    private Pile center;
    private int p1Pile1;
    private int p1Card1;
    private int p1Pile2;
    private int p1Card2;
    private int p2Pile1;
    private int p2Card1;
    private int p2Pile2;
    private int p2Card2;
    private boolean p1ViewingPile;
    private boolean p2ViewingPile;
    public Listener(DrawingPanel f, Graphics gr, Player play1, Player play2, Pile c)
    {
        frame = f;
        g = gr;
        p1 = play1;
        p2 = play2;
        center = c;
        p1Pile1 = -1;
        p1Card1 = -1;
        p1Pile2 = -1;
        p1Card2 = -1;
        p2Pile1 = -1;
        p2Card1 = -1;
        p2Pile2 = -1;
        p2Card2 = -1;
        p1ViewingPile = false;
        p2ViewingPile = false;
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode(); //keyboard code for the pressed key
        System.out.println(e.getKeyChar());
        Font font = new Font("Arial",Font.PLAIN,30);
        //the following ifs check to see which key was pressed
        if(key == KeyEvent.VK_1)
        {
            checkPiles(1,0);
            p1ViewingPile = true;
            redraw();
            printPile(1,0);
        }
        else if(key == KeyEvent.VK_2)
        {
            checkPiles(1,1);
            p1ViewingPile = true;
            redraw();
            printPile(1,1);
        }
        else if(key == KeyEvent.VK_3)
        {
            checkPiles(1,2);
            p1ViewingPile = true;
            redraw();
            printPile(1,2);
        }
        else if(key == KeyEvent.VK_4)
        {
            checkPiles(1,3);
            p1ViewingPile = true;
            redraw();
            printPile(1,3);
        }
        else if(key == KeyEvent.VK_5)
        {
            checkPiles(1,4);
            p1ViewingPile = true;
            redraw();
            printPile(1,4);
        }
        else if(key == KeyEvent.VK_6)
        {
            checkPiles(1,5);
            p1ViewingPile = true;
            redraw();
            printPile(1,5);
        }
        else if(key == KeyEvent.VK_Q)
        {
            checkCards(1,0);
            p1ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_W)
        {
            checkCards(1,1);
            p1ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_E)
        {
            checkCards(1,2);
            p1ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_R)
        {
            checkCards(1,3);
            p1ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_T)
        {
            checkCards(1,4);
            p1ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_A) //P1 center
        {
            checkPiles(1,6);
            p1ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_S) //P1 back
        {
            p1ViewingPile = false;
            if(p1Pile2 != -1)
            {
                p1Pile2 = -1;
            }
            else
            {
                p1Pile1 = -1;
            }
            redraw();
        }
        else if(key == KeyEvent.VK_D) //P1 deselect
        {
            p1Card1 = -1;
            p1ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_B)
        {
            checkPiles(2,0);
            p2ViewingPile = true;
            redraw();
            printPile(2,0);
        }
        else if(key == KeyEvent.VK_N)
        {
            checkPiles(2,1);
            p2ViewingPile = true;
            redraw();
            printPile(2,1);
        }
        else if(key == KeyEvent.VK_M)
        {
            checkPiles(2,2);
            p2ViewingPile = true;
            redraw();
            printPile(2,2);
        }
        else if(key == KeyEvent.VK_COMMA)
        {
            checkPiles(2,3);
            p2ViewingPile = true;
            redraw();
            printPile(2,3);
        }
        else if(key == KeyEvent.VK_PERIOD)
        {
            checkPiles(2,4);
            p2ViewingPile = true;
            redraw();
            printPile(2,4);
        }
        else if(key == KeyEvent.VK_SLASH)
        {
            checkPiles(2,5);
            p2ViewingPile = true;
            redraw();
            printPile(2,5);
        }
        else if(key == KeyEvent.VK_J)
        {
            checkCards(2,0);
            p2ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_K)
        {
            checkCards(2,1);
            p2ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_L)
        {
            checkCards(2,2);
            p2ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_SEMICOLON)
        {
            checkCards(2,3);
            p2ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_QUOTE)
        {
            checkCards(2,4);
            p2ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_I) //P2 center
        {
            checkPiles(2,6);
            p2ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_O) //P2 back
        {
            p2ViewingPile = false;
            if(p2Pile2 != -1)
            {
                p2Pile2 = -1;
            }
            else
            {
                p2Pile1 = -1;
            }
            redraw();
        }
        else if(key == KeyEvent.VK_P) //P2 deselect
        {
            p2Card1 = -1;
            p2ViewingPile = false;
            redraw();
        }
        else if(key == KeyEvent.VK_ENTER)
        {
            redraw();
        }
        else if(key == KeyEvent.VK_SPACE)
        {
            frame.clear();
            if(p1.isDone())
            {
                g.drawString("P1 Wins!",350,20);
                g.drawString("Thanks for playing!",350,50);
            }
            else if(p2.isDone())
            {
                g.drawString("P2 Wins!",350,20);
                g.drawString("Thanks for playing!",350,50);
            }
            else
            {
                redraw();
            }
        }
        else{}
    }

    public void checkPiles(int playerNum, int pileNum)
    {
        if(playerNum == 1)
        {
            if(p1Pile1 == -1 || p1Card1 == -1)
            {
                p1Pile1 = pileNum;
            }
            else
            {
                p1Pile2 = pileNum;
            }
        }
        else
        {
            if(p2Pile1 == -1 || p2Card1 == -1)
            {
                p2Pile1 = pileNum;
            }
            else
            {
                p2Pile2 = pileNum;
            }
        }
    }

    public void resetNums(int p)
    {
        if(p == 1)
        {
            p1Pile1 = -1;
            p1Card1 = -1;
            p1Pile2 = -1;
            p1Card2 = -1;
        }
        else
        {
            p2Pile1 = -1;
            p2Card1 = -1;
            p2Pile2 = -1;
            p2Card2 = -1;
        }
    }

    public void checkCards(int playerNum, int cardNum)
    {
        if(playerNum == 1)
        {
            if(p1Pile1 != -1 && p1Pile2 != -1 && p1Pile1 == p1Pile2)
            {
                
            }
            if(p1Pile2 == -1)
            {
                p1Card1 = cardNum;
            }
            else if(p1Pile1 != -1)
            {
                p1Card2 = cardNum;
                if(p1Pile1 == 6)
                {
                    p1.swap(p1Pile2,p1Card2,center,p1Card1);
                    resetNums(1);
                }
                else if(p1Pile2 == 6)
                {
                    p1.swap(p1Pile1,p1Card1,center,p1Card2);
                    resetNums(1);
                }
                else
                {
                    p1.swap(p1Pile1,p1Card1,p1Pile2,p1Card2);
                    resetNums(1);
                }
            }
            else{}
        }
        else
        {
            if(p2Pile1 != -1 && p2Pile2 != -1 && p2Pile1 == p2Pile2)
            {
                
            }
            if(p2Pile2 == -1)
            {
                p2Card1 = cardNum;
            }
            else if(p2Pile1 != -1)
            {
                p2Card2 = cardNum;
                if(p2Pile1 == 6)
                {
                    p2.swap(p2Pile2,p2Card2,center,p2Card1);
                    resetNums(2);
                }
                else if(p2Pile2 == 6)
                {
                    p2.swap(p2Pile1,p2Card1,center,p2Card2);
                    resetNums(2);
                }
                else
                {
                    p2.swap(p2Pile1,p2Card1,p2Pile2,p2Card2);
                    resetNums(2);
                }
            }
            else{}
        }
    }

    public void p1Piles()
    {
        g.drawString(p1.toString(),110,130);
    }

    public void p2Piles()
    {
        g.drawString(p2.toString(),600,130);
    }

    public void printPile(int playerNum, int pileNum)
    {
        if(playerNum == 1)
        {
            g.drawString(p1.showPile(pileNum),110,130);
            g.drawString(p1.showPileKeys(pileNum),110,140);
        }
        else
        {
            g.drawString(p2.showPile(pileNum),600,130);
            g.drawString(p2.showPileKeys(pileNum),600,140);
        }
    }

    public void redraw()
    {
        frame.clear(); //clears the frame
        g.drawString("Center: " + center,325,50);
        String output = "P1:        ";
        String[][] keys = {{"q","w","e","r","t"},{"j","k","l",";","'"}};
        for(int i = 0; i < center.size(); i++)
        {
            output += keys[0][i] + "     ";
        }
        g.drawString(output,325,65);
        output = "P2:        ";
        for(int i = 0; i < center.size(); i++)
        {
            output += keys[1][i] + "      ";
        }
        g.drawString(output,325,80);
        g.drawString("P1 Controls:",10,20);
        g.drawString("P2 Controls:",720,20);
        //Player Controls:
        //P1
        //Piles: 1 2 3 4 5 6
        //Cards: q w e r t
        //Center: a
        //Back: d
        //P2
        //Piles: b n m , . /
        //Cards: j k l ; '
        //Center: i
        //Back: p
        g.drawString("Center: a",10,40);
        g.drawString("Back: s",10,60);
        g.drawString("Deselect: d",10,80);
        g.drawString("Center: i",720,40);
        g.drawString("Back: o",720,60);
        g.drawString("Deselect: p",720,80);
        if(p1Card1 != -1 && p1Pile1 > -1 && p1Pile1 < 6)
        {
            g.drawString("Selected: " + p1.getPile(p1Pile1).getCard(p1Card1).toString(),10,160);
        }
        if(p2Card1 != -1 && p2Pile1 > -1 && p2Pile1 < 6)
        {
            g.drawString("Selected: " + p2.getPile(p2Pile1).getCard(p2Card1).toString(),600,160);
        }
        if(!p1ViewingPile)
        {
            p1Piles();
        }
        else if(p1Pile2 == -1)
        {
            printPile(1,p1Pile1);
        }
        else
        {
            printPile(1,p1Pile2);
        }
        if(!p2ViewingPile)
        {
            p2Piles();
        }
        else if(p2Pile2 == -1)
        {
            printPile(2,p2Pile1);
        }
        else
        {
            printPile(2,p2Pile2);
        }
    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e)
    {

    }
}
