
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
    private String typ;
    
    // Konstruktor
    public Gegenstand(int pXKoordinate,int pYKoordinate,String pName,String pTyp)
    {
        xKoordinate = pXKoordinate;
        yKoordinate = pYKoordinate;
        name = pName;
        typ = pTyp;
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
    public String getTyp(){
        return typ;
    }
    public void setTyp(String pTyp){
        typ=pTyp;
    }
}
