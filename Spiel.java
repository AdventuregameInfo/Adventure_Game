
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
    public void play(){
        boolean fertig = false;
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
            System.out.println("Du bist jetzt auf der Position (" + held.getX() + "|" + held.getY());
        }
        else if (commandWord.equals("exit")) {
            return wantToQuit;
         }

        return wantToQuit;
    }
    private void printHelp(){
        System.out.println("Du benötigst hilfe?");
        System.out.println("Es gibt verschiedene kommandos:");
        System.out.println("hilfe, gehe (richtung), position,");
    }
    private void gehe(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("welche Richtung?");
            return;
        }
        String richtung = command.getSecondWord();
        if(command.getSecondWord()=="oben"){
            if(!wandVorhanden(command.getSecondWord()))
                held.gehe(command.getSecondWord());
                
        }
        else if(command.getSecondWord()=="unten"){
            if(!wandVorhanden(command.getSecondWord()))
                held.gehe(command.getSecondWord());
                
        }
        else if(command.getSecondWord()=="rechts"){
            if(!wandVorhanden(command.getSecondWord()))
                held.gehe(command.getSecondWord());
                
        }
        else if(command.getSecondWord()=="links"){
            if(!wandVorhanden(command.getSecondWord()))
                held.gehe(command.getSecondWord());
                
        }
    }
    private boolean wandVorhanden(String pRichtung){
       int x=held.getX();
       int y=held.getY();
       switch (pRichtung){
            case "oben":if(welt.weltArray[x][y-1].getName() != "Wand")
                            return false;
                        break;
            case "unten":if(welt.weltArray[x][y+1].getName() != "Wand")
                            return false;
                         break;
            case "rechts":if(welt.weltArray[x+1][y].getName() != "Wand")
                            return false;
                          break;  
            case "links":if(welt.weltArray[x-1][y].getName() != "Wand")
                            return false;
                         break;
            default: return true;
        }
       return true;
    }
}
