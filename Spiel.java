
/**
 * @author 
 * @version 
 */
public class Spiel
{
    // Bezugsobjekte

    // Attribute
    private Parser parser;
    private Welt welt;
    private Held held;
    private Kampf kampf;
    // Konstruktor
    public Spiel()
    {
            parser = new Parser();
            welt = new Welt();
            held = new Held(25,25,"männlich","Held",15);
            kampf = new Kampf();
    }

    // Dienste
    public static void main(String[] args){
        Spiel spiel1 = new Spiel();
        spiel1.play();
    }
    public void play(){
        boolean fertig = false;
        System.out.println("Wilkommen im Adventure Game!");
        System.out.println("Falls du Hilfe benötigst schreibe einfach ,hilfe, ");
        while(!fertig){
            Command command = parser.getCommand();
            fertig = processCommand(command);
        }
        System.out.println("Das Spiel ist leider vorbei! Bis zum nächsten mal.");
    }
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        int x=held.getX();
        int y=held.getY();
        String commandWord = command.getCommandWord();
        if (commandWord.equals("hilfe")) {
            printHelp();
        }
        else if (commandWord.equals("gehe")) {
            gehe(command);
            int z=held.getX();
            int t=held.getY();
            if(itemVorhanden(z,t))itemAktion();
        }
        else if (commandWord.equals("position")) {
            System.out.println("Du bist jetzt auf der Position (" + held.getX() + "|" + held.getY() + ").");
        }
        else if (commandWord.equals("exit")) {
            return wantToQuit;
        }
        else if (commandWord.equals("inventar")) {
            held.getInventar();
        }
        else if(commandWord.equals("ja") && itemVorhanden(x,y)) {
            itemAufsammeln();
        }
        else if (commandWord.equals("nein") && itemVorhanden(x,y)) {
            System.out.println("Schade! Das Item wird weiterhinn hier liegenbleiben!");
        }
        else if (commandWord.equals("itemabgeben")) {
            if(held.inventar[0]!=null){
                if(!command.hasSecondWord()){
                    System.out.println("Von welchem index das item wegnehmen?");
                    return wantToQuit;
                }
                String pIndex = command.getSecondWord();
                int index = Integer.parseInt(pIndex) -1;
                if(held.inventar[index]!=null){
                    itemAbgeben(index);
                }else{
                    System.out.println("An dieser Stelle haben sie kein Item!");
                }
            }else{
                System.out.println("Ihr Inventar ist Leer!");
            }
        }
        else if (commandWord.equals("attacke")){ //&& kampf.getKampfAktiv()) {
            if(!command.hasSecondWord()){
                    System.out.println("Welche Attacke willst du ausführen?");
                    return wantToQuit;
                }
            String pAttacke = command.getSecondWord();
            int attackeNr = Integer.parseInt(pAttacke);
            kampf.attacke(held,attackeNr);
        }
        
        return wantToQuit;
    }
    private void printHelp(){
        System.out.println("Du benötigst hilfe?");
        System.out.println("Es gibt verschiedene kommandos:");
        System.out.println("hilfe, gehe (oben,unten,links,rechts), position, inventar, itemabgeben (index)");
    }
    private void gehe(Command command){

        if(!command.hasSecondWord()) {
            System.out.println("welche Richtung?");
            return;
        }
        String richtung = command.getSecondWord();
        if(richtung.equals("oben")){
            if(!wandVorhanden("oben")){
                held.gehe("oben");
                }
            else{wandDa("oben");}
        }
        else if(richtung.equals("unten")){
            if(!wandVorhanden("unten")){
                held.gehe("unten");
                }
            else{wandDa("unten");} 
        }
        else if(richtung.equals("rechts")){
            if(!wandVorhanden("rechts")){
                held.gehe("rechts");
                }
            else{wandDa("rechts");}    
        }
        else if(richtung.equals("links")){
            if(!wandVorhanden("links")){
                held.gehe("links");
                }
            else{wandDa("links");}
        }
        
    }
    private boolean wandVorhanden(String pRichtung){
       int x=held.getX();
       int y=held.getY();
       boolean vorhanden = false;
       
       if(pRichtung =="oben" && welt.weltArray[x][y-1].getName() == "Weg" ^ itemVorhanden(x,y-1))
                            vorhanden = false;
       else if(pRichtung =="unten" && welt.weltArray[x][y+1].getName() == "Weg" ^ itemVorhanden(x,y+1))
                            vorhanden = false;
       else if(pRichtung =="rechts" && welt.weltArray[x+1][y].getName() == "Weg" ^ itemVorhanden(x+1,y))
                            vorhanden = false;
       else if(pRichtung =="links" && welt.weltArray[x-1][y].getName() == "Weg" ^ itemVorhanden(x-1,y))
                            vorhanden = false;
       else{                
                            if(welt.weltArray[x][y-1].getName() == "Mensch" ^ welt.weltArray[x][y+1].getName() == "Mensch" ^ welt.weltArray[x+1][y].getName() == "Mensch" ^ welt.weltArray[x-1][y].getName() == "Mensch")
                                         //villagerText();
                            vorhanden = true;
        }
        
      
       return vorhanden;
    }
    private void wandDa(String pRichtung){
        int x=held.getX();
        int y=held.getY();
        if(welt.weltArray[x][y-1].getName() == "Mensch" ^ welt.weltArray[x][y+1].getName() == "Mensch" ^ welt.weltArray[x+1][y].getName() == "Mensch" ^ welt.weltArray[x-1][y].getName() == "Mensch"){
                    
            return;
        }
        if(pRichtung =="oben")System.out.println("Du bist auf eine "+welt.weltArray[x][y-1].getTyp()+" gestoßen!");
        if(pRichtung =="unten")System.out.println("Du bist auf eine "+welt.weltArray[x][y+1].getTyp()+" gestoßen!");
        if(pRichtung =="links")System.out.println("Du bist auf eine "+welt.weltArray[x-1][y].getTyp()+" gestoßen!");
        if(pRichtung =="rechts")System.out.println("Du bist auf eine "+welt.weltArray[x+1][y-1].getTyp()+" gestoßen!");
    }
    private boolean itemVorhanden(int pX,int pY){
        boolean ergebniss = false;
        int x=pX;
        int y=pY;
        
        switch(welt.weltArray[x][y].getName()){
            case "Schwert":ergebniss = true;
                           break;
            default:       ergebniss = false;
                           break;
        }
        return ergebniss;
    }
    private void itemAktion(){
        int x=held.getX();
        int y=held.getY();
        System.out.println("Sie haben ein " + welt.weltArray[x][y].getName() +" gefunden!");
        System.out.println("Wollen sie das Item aufheben?");
        System.out.println("ja oder nein?");
    }
    private void itemAufsammeln(){
        int x=held.getX();
        int y=held.getY();
        held.setInventar(held.getInventarNaechsterSlot(),welt.weltArray[x][y]);
        welt.weltArray[x][y] = new Weg(x,y);
    }
    
    private void itemAbgeben(int pIndex){
        int x=held.getX();
        int y=held.getY();
        Gegenstand container;
        String typ;
        if(!itemVorhanden(x,y)){
            container = held.inventar[pIndex];
            switch(container.getName()){
                case "Schwert":welt.weltArray[x][y] = new Schwert(x,y,"Schwert");
                               System.out.println("Sie haben ein Schwert an die stelle (" + held.getX() +","+ held.getY() +") abgelegt");
                                break;
                default:    System.out.println("Es ist ein Fehler aufgetreten!");
                                break;
            }
           held.inventar[pIndex] = null;
        }else{
            System.out.println("Hier liegt bereits ein item!");
        }
    }
}
