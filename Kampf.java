
/**
 * @author 
 * @version 
 */
public class Kampf
{
    // Bezugsobjekte

    // Attribute
    private Mensch spieler;
    private Mensch gegner;
    private boolean kampfAktiv = false;
    private boolean kampfFertig = false;
    private String monsterRichtung ="";
    // Konstruktor
    public Kampf()
    {

    }

    // Dienste
    public void kaempfen(String pRichtung){
        Parser parser = new Parser();
        monsterRichtung = pRichtung;
        kampfAktiv = true;
        System.out.println("Sie befinden sich im kampfmodus. Falls sie nicht wissen was sie machen können tippen sie ,hilfe,");
        while(!kampfFertig){
            Command command = parser.getCommand();
            kampfFertig = processCommand(command);
        }
        
    }
    //public void attacke(Mensch pSpieler,int pNummer){
     //   if(pNummer ==1)System.out.println("attacke1");
     //   if(pNummer ==2)System.out.println("attacke2");
     //   if(pNummer ==3)System.out.println("attacke3");
    //}
    public boolean processCommand(Command command){
        kampfFertig = false;
        if(command.isUnknown()) {
            System.out.println("Bitte überprüfen sie die eingabe!");
            return false;
        }
        String commandWord = command.getCommandWord();
        if (commandWord.equals("hilfe")) {
            printHelp();
        }else if(commandWord.equals("fliehen")){
            System.out.println("Sie sind erfolgreich vor dem kampf geflohen!");
            kampfFertig = true;
            return kampfFertig;
        }else if(commandWord.equals("Attacken")){
            zeigeAttacken();
        }else if(commandWord.equals("attacke")){
            if(!command.hasSecondWord()){
                    System.out.println("Welche Attacke wollen sie ausführen?");
                    return kampfFertig;
                }
            String attackeNr = command.getSecondWord();
            int attackeint = Integer.parseInt(attackeNr);
            kaempfe(attackeint);
        }
        return kampfFertig;
    }
    public boolean getKampfAktiv(){
        return kampfAktiv;
    }
    public void printHelp(){
        System.out.println("mit ,Attacken, sehen sie ihre Attacken\n"+"mit ,attacke (nr der attacke), attackieren sie\n"+"mit ,fliehen, fliehen sie vor dem kampf");
    }
    public void kaempfe(int pAttacke){
        if(pAttacke == 1){
            
            System.out.println("Das Monster hat jetzt ein paar hp weniger");};
        if(pAttacke == 2){
            
            System.out.println("attacke 2");}
        
    }
    public void zeigeAttacken(){
        System.out.println("Sie haben 2 Attacken zur verfügung ,welche sie benutzen können\n"+"1. Attacke: High kick Schadenspunkte 5\n"+"2. Attacke: Punch Schadenspunkte 4\n");
    }
}
