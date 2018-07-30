import javax.swing.*;
import java.awt.*;
public class Game
{
    public static void main(String[] args)
    {
        DeckOfCards cards = new DeckOfCards();
        Pile center = new Pile();
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        cards.shuffle();
        cards.shuffle();
        cards.deal(p1,p2,center);
        //instructions
        DrawingPanel frame = new DrawingPanel(800,450);
        Graphics g = frame.getGraphics();
        Font font = new Font("Arial",Font.PLAIN,30);
        g.drawString("Welcome to Stress!",350,20);
        g.drawString("You each have 6 piles of 4 cards. Your goal is to make it so that all of the piles have all of one type of card.",10,50);
        g.drawString("For example, one pile will have all of the 4s in the deck, and another will have all of the kings.",10,80);
        g.drawString("You will complete piles by switching cards between your own piles and the cards in the center.",10,110);
        g.drawString("Each pile is represented by the key you must press to open that pile.",10,140);
        g.drawString("To switch cards, open the pile and press the corresponding keys for both cards you want to switch.",10,170);
        g.drawString("In order to select a card from the center, you must first press your Center key.",10,200);
        g.drawString("If you have selected a key and would like to deselect it, press your Deselect key.",10,230);
        g.drawString("You are only allowed to look at one of your piles at a time. To switch which pile you're looking at, press your Back key.",10,260);
        g.drawString("The controls for each player will appear on the sides of the screen once the game begins.",10,290);
        g.drawString("There must always be 4 cards in every pile.",10,320);
        g.drawString("Once you have completed a pile, an X will appear in place of the key that corresponds to the pile.",10,350);
        g.drawString("Both players work to complete their piles at the same time. The first player to complete all of their piles and press the SPACE bar wins.",10,380);
        g.drawString("Press ENTER to begin.",350,410);
        //g.drawString(String,x,y);
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
        Listener listener = new Listener(frame,g,p1,p2,center); //makes a KeyListener
        frame.addKeyListener(listener); //adds the KeyListener to the frame
    }
}








