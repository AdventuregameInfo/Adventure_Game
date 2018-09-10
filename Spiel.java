
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
    // Konstruktor
    public Spiel()
    {
            parser = new Parser();
            welt = new Welt();
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
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            gehe(command);
        }
        //else if (commandWord.equals("quit")) {
         //}

        return wantToQuit;
    }
    private void printHelp(){
        System.out.println("hilfe!");
        
    }
    private void gehe(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("welche Richtung?");
            return;
        }
        String richtung = command.getSecondWord();
    }
    
}
