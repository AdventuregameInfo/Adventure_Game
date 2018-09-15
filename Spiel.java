
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
    // Konstruktor
    public Spiel()
    {
            parser = new Parser();
            welt = new Welt();
            held = new Held(25,25,"männlich","Held",15);

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

        String commandWord = command.getCommandWord();
        if (commandWord.equals("hilfe")) {
            printHelp();
        }
        else if (commandWord.equals("gehe")) {
            gehe(command);
        }
        else if (commandWord.equals("position")) {
            System.out.println("Du bist jetzt auf der Position (" + held.getX() + "|" + held.getY() + ").");
        }
        else if (commandWord.equals("exit")) {
            return wantToQuit;
        }else if (commandWord.equals("inventar")) {
            held.getInventar();
        }

        return wantToQuit;
    }
    private void printHelp(){
        System.out.println("Du benötigst hilfe?");
        System.out.println("Es gibt verschiedene kommandos:");
        System.out.println("hilfe, gehe (richtung), position, inventar");
    }
    private void gehe(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("welche Richtung?");
            return;
        }
        String richtung = command.getSecondWord();
        if(richtung.equals("oben")){
            if(!wandVorhanden("oben"))
                held.gehe("oben");
            else{wandDa();}
                
        }
        else if(richtung.equals("unten")){
            if(!wandVorhanden("unten"))
                held.gehe("unten");
            else{wandDa();} 
        }
        else if(richtung.equals("rechts")){
            if(!wandVorhanden("rechts"))
                held.gehe("rechts");
            else{wandDa();}    
        }
        else if(richtung.equals("links")){
            if(!wandVorhanden("links"))
                held.gehe("links");
            else{wandDa();}
        }
        
    }
    private boolean wandVorhanden(String pRichtung){
       int x=held.getX();
       int y=held.getY();
       boolean vorhanden = false;
       
           if(pRichtung =="oben" && welt.weltArray[x][y-1].getName() == "Weg")
                            vorhanden = false;
           else if(pRichtung =="unten" && welt.weltArray[x][y+1].getName() == "Weg")
                            vorhanden = false;
           else if(pRichtung =="rechts" && welt.weltArray[x+1][y].getName() == "Weg")
                            vorhanden = false;
           else if(pRichtung =="links" && welt.weltArray[x-1][y].getName() == "Weg")
                            vorhanden = false;
           else{vorhanden = true;}
        
      
       return vorhanden;
    }
    public void wandDa(){
        System.out.println("Du bist auf eine Wand gestoßen!");
    }
}
