
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
        if (commandWord.equals("hilfe")) {
            printHelp();
        }
        else if (commandWord.equals("gehe")) {
            gehe(command);
        }
        else if (commandWord.equals("position")) {
            
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
    }
    
}
