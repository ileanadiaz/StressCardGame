public class Card
{
    private String value;
    private String type;
    
    public Card(String v, String t)
    {
        value = v;
        type = t;
    }
    public String getValue()
    {
        return value;
    }
    public String getType()
    {
        return type;
    }
    public String toString()
    {
        String output = value;
        if(type.equals("spade"))
        {
            output += "\u2660";
        }
        else if(type.equals("heart"))
        {
            output += "\u2665";
        }
        else if(type.equals("diamond"))
        {
            output += "\u2666";
        }
        else
        {
            output += "\u2663";
        }
        return output;
    }
}
