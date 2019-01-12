import java.util.Random;
/**
 * @author tobias
 * @version 0.8
 */
public class Kampf
{
    // Bezugsobjekte

    // Attribute
    private Held held;
    private Gegenstand gegner;
    private boolean kampfAktiv = false;
    private boolean kampfFertig = false;
    private String monsterRichtung ="";
    private Gegenstand[][] pArray;
    private int x,y,hp,monsterHp;
    public boolean heldlebt =true,gegnerbesiegt = true;
    

    // Konstruktor
    public Kampf()
    {

    }

    // Dienste
    public void kaempfen(String pRichtung,Gegenstand[][] test,Held spieler){
        kampfFertig = false;
        Parser parser = new Parser();
        monsterRichtung = pRichtung;
        kampfAktiv = true;
        pArray = test;
        held = spieler;
       if(pRichtung =="oben"){gegner = pArray[held.getX()][held.getY()-1];}
       else if(pRichtung =="unten"){gegner = pArray[held.getX()][held.getY()+1];}
       else if(pRichtung =="rechts"){gegner = pArray[held.getX()+1][held.getY()];}
       else if(pRichtung =="links"){gegner = pArray[held.getX()-1][held.getY()];}
        
        //monsterHp=gegner.getHp();
        System.out.println("Im näheren Umfeld von einem schritt befindet sich ein Monster. Es will dich angreifen.\n"+"Du befindest dich im kampfmodus. Falls du nicht weißt was du machen kannst sind hier die kommandos:\n");
        printHelp();
        while(!kampfFertig){
            Command command = parser.getCommand();
            kampfFertig = processCommand(command);
        }
        if(held.getHp()<=0){
            System.out.println("Du bist tot");
            heldlebt = false;
        }
        
    }
    public boolean processCommand(Command command){
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
        }else if(commandWord.equals("itemhand")){
                if(held.handBesetzt()){System.out.println("Ein "+held.stringHand()+" befindet sich in ihrer hand");}
                else{System.out.println("nichts ist in der hand");}
        }else if(commandWord.equals("addhand")){
                if(command.hasSecondWord()){
                    String pIndex = command.getSecondWord();
                    int index = Integer.parseInt(pIndex)-1;
                    if(held.itemvorhanden(index)){
                        held.setHand(held.itemAnIndex(index));
                    }
                    System.out.println("Ein "+held.stringHand()+" befindet sich in ihrer hand");
                }else{
                    System.out.println("aus welchem slot soll das item in die hand gelegt werden?");
                }
        }else if (commandWord.equals("inventar")) {
                held.getInventar();
        }else if(commandWord.equals("removehand")){
                held.inventar[held.getInventarNaechsterSlot()]=held.getHand();
                held.setHand(null);
        }
        return kampfFertig;
    }
    public boolean getKampfAktiv(){
        return kampfAktiv;
    }
    public void printHelp(){
        System.out.println("-,Attacken, zeigt deine Attacken\n"+"-,attacke (nr der attacke), ist zum angriff\n"+"-,fliehen, hilft dir beim fliehen vor dem Kampf\n"+"-,itemhand, zeigt dir was du in der Hand hast \n"+"-,addhand (slot aus inventar), platziert ein objekt in deine Hand\n"+"-,inventar, zeigt dir dein Inventar");
    }
    public void kaempfe(int pAttacke){
        int monsterSchaden = 0;
        int heldSchaden = 0;
        
        
        if(held.getHp()>0){
            if(monsterRichtung == "oben"){
                    monsterSchaden = zufallsZahl() * pArray[held.getX()][held.getY()-1].getSchadenspunkte();
                }
            else if(monsterRichtung == "unten"){
                    monsterSchaden = zufallsZahl() * pArray[held.getX()][held.getY()+1].getSchadenspunkte();
                }
            else if(monsterRichtung == "rechts"){
                    monsterSchaden = zufallsZahl() * pArray[held.getX()+1][held.getY()].getSchadenspunkte();
                }
            else if(monsterRichtung == "links"){
                    monsterSchaden = zufallsZahl() * pArray[held.getX()-1][held.getY()].getSchadenspunkte();
                }
            held.setHp(held.getHp()-monsterSchaden);
            if(pAttacke == 1){
                    if(held.handBesetzt())heldSchaden = held.getHand().getSchadenspunkte()*zufallsZahl();
                    else System.out.println("nicht verfügbar, da kein item in der Hand ist!");
            }
            else if(pAttacke == 2){
                    heldSchaden = 7 * zufallsZahl();
            }else if(pAttacke ==3){
                held.setHp(0);
            }
        }else{
            
            kampfFertig = true;
            kampfAktiv = false;
        }
        gegner.setHp(gegner.getHp()-heldSchaden);
        if(gegner.getHp()<0)gegner.setHp(0);
        System.out.println("Das Monster hat jetzt nur noch "+gegner.getHp()+" HP. Du hast "+heldSchaden+" HP Schaden gemacht. ");
        if(gegnerbesiegt==false || gegner.getHp()<=0){
            kampfFertig = true;
            kampfAktiv = false;
            gegnerbesiegt = false;
            gegnerTot();
            return;
        }
        
        
        System.out.println("Du hast jetzt nur noch "+held.getHp()+" HP. Das Monster hat "+monsterSchaden+" HP Schaden gemacht. ");
    }
    public void zeigeAttacken(){
        if(held.handBesetzt()){
            System.out.println("Du hast 2 Attacken zur verfügung: \n"+"1. Attacke: "+held.stringHand()+" Schadenspunkte "+held.hand.getSchadenspunkte()+"\n"+"2. Attacke: Punch Schadenspunkte 7\n");
        }else{
            System.out.println("Du hast 2 Attacken zur verfügung: \n"+"1. Attacke: nicht verfügbar, da nix in der hand ist \n"+"2. Attacke: Punch Schadenspunkte 7\n");
        }  
    }
    public void gegnerTot(){
        System.out.println("Du hast dein Gegner besiegt. Hast jedoch nur noch "+held.getHp()+" hp. Nimm dich lieber in acht! Du kannst jetzt weitergehen.");
    }
    public int zufallsZahl(){
        int randomNum = new Random().nextInt(3);
        return randomNum;
    }
}
