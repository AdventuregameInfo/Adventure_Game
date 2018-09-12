
/**
 * @author 
 * @version 
 */
public class Gegenstand
{
    // Bezugsobjekte

    // Attribute
    private int xKoordinate;
    private int yKoordinate;
    private String name;
    
    // Konstruktor
    public Gegenstand(int pXKoordinate,int pYKoordinate,String pName)
    {
        xKoordinate = pXKoordinate;
        yKoordinate = pYKoordinate;
        name = pName;
    }

    // Dienste
    public int getXPosition(){
        return xKoordinate;
    }
    public int getYPosition(){
        return yKoordinate;
    }
    public void setX(int pX){
        xKoordinate=pX;
    }
    public void setY(int pY){
        yKoordinate=pY;
    }
    public String getName(){
        return name;
    }
    public void setName(String pName){
        name = pName;
    }
}
