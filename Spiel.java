
/**
 * @author tobias 
 * @version 0.7
 */
public class Spiel
{
    // Bezugsobjekte

    // Attribute
    private Parser parser;
    private Welt welt;
    private Held held;
    private Kampf kampf;
    private int villagerNummer=1;
    // Konstruktor
    public Spiel()
    {
            parser = new Parser();
            welt = new Welt();
            held = new Held(24,24,"männlich","Held");
            kampf = new Kampf();
            welt.erstelleWelteins();
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
            if(!kampf.heldlebt){fertig = true;break;}
            Command command = parser.getCommand();
            fertig = processCommand(command);
        }
        System.out.print('\u000C');
        System.out.println("Du bist gestorben, somit ist das Spiel leider vorbei! Bis zum nächsten mal.");
        System.out.println("created by \n"+"Julius M. \n"+"Elias F. \n"+ "Tobias H.");
    }
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
            if(!kampf.heldlebt){wantToQuit = true; return wantToQuit;}else{
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
                if(welt.itemVorhanden(z,t))itemAktion();
            }
            else if (commandWord.equals("position")) {
                System.out.println("Du bist jetzt auf der Position (" + held.getX() + "|" + held.getY() + ").");
            }
            else if (commandWord.equals("exit")) {
                return true;
            }
            else if (commandWord.equals("inventar")) {
                held.getInventar();
            }
            else if(commandWord.equals("ja") && welt.itemVorhanden(x,y)) {
                itemAufsammeln();
            }
            else if (commandWord.equals("nein") && welt.itemVorhanden(x,y)) {
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
            }else if(commandWord.equals("teleportx")){
                String pIndex = command.getSecondWord();
                int index = Integer.parseInt(pIndex);
                held.setX(index);
            }else if(commandWord.equals("teleporty")){
                String pIndex = command.getSecondWord();
                int index = Integer.parseInt(pIndex);
                held.setY(index);
            }else if(commandWord.equals("itemhand")){
                if(held.handBesetzt()){System.out.println("Ein "+held.stringHand()+" befindet sich in ihrer hand");}
                else{System.out.println("nichts ist in der hand");}
            }else if(commandWord.equals("addhand")){
                if(command.hasSecondWord()){
                    String pIndex = command.getSecondWord();
                    int index = Integer.parseInt(pIndex)-1;
                    if(index>=0){
                        if(held.itemvorhanden(index)){
                            held.setHand(held.itemAnIndex(index));
                            held.inventar[held.itemAnWelchemSlot(held.getHand().getTyp())] = null;
                        }
                        System.out.println("Ein "+held.stringHand()+" befindet sich in ihrer hand");
                    }
                }else{
                    System.out.println("aus welchem slot soll das item in die hand gelegt werden?");
                }
            }else if(commandWord.equals("removehand")){
                held.inventar[held.getInventarNaechsterSlot()]=held.getHand();
                held.setHand(null);
            }
        }
        return wantToQuit;
    }
    private void printHelp(){
        System.out.println("Du benötigst hilfe?");
        System.out.println("Es gibt verschiedene kommandos:");
        System.out.println("-,hilfe, \n"+"-,gehe (oben,unten,links,rechts),\n"+ "-,position, \n"+"-,inventar, \n"+"-,itemabgeben (index),\n"+"-,itemhand,\n"+"-,addhand (slot aus dem inventar), \n"+"-,removehand");
    }
    private void gehe(Command command){
        if(welt.itemVorhanden(held.getX(),held.getY())){
            welt.weltArray[held.getX()][held.getY()] = new Weg(held.getX(),held.getY());
        }
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
        System.out.println("Du bist jetzt auf der Position (" + held.getX() + "|" + held.getY() + ").");
        
    }
    private boolean wandVorhanden(String pRichtung){
       int x=held.getX();
       int y=held.getY();
       boolean vorhanden = true;
        if(pRichtung =="oben" && welt.weltArray[x][y-1].getName() != "Wand")
                            vorhanden = false;
       else if(pRichtung =="unten" && welt.weltArray[x][y+1].getName() != "Wand")
                            vorhanden = false;
       else if(pRichtung =="rechts" && welt.weltArray[x+1][y].getName() != "Wand")
                            vorhanden = false;
       else if(pRichtung =="links" && welt.weltArray[x-1][y].getName() != "Wand")
                            vorhanden = false;
       if(welt.weltArray[x][y-1].getTyp() == "Dorfbewohner" ^ welt.weltArray[x][y+1].getTyp() == "Dorfbewohner" ^ welt.weltArray[x+1][y].getTyp() == "Dorfbewohner" ^ welt.weltArray[x-1][y].getTyp() == "Dorfbewohner"){     
                            vorhanden = true;
        }               
       if(welt.weltArray[x][y-1].getTyp() == "Monster"){
           kampf.kaempfen("oben",welt.weltArray,held);
           if(welt.weltArray[x][y-1].getTyp() == "Monster")
                            welt.weltArray[x][y-1] = new Weg(x,y);
       }
       else if(welt.weltArray[x][y+1].getTyp() == "Monster"){
           kampf.kaempfen("unten",welt.weltArray,held);
           if(welt.weltArray[x][y+1].getTyp() == "Monster")
                            welt.weltArray[x][y-1] = new Weg(x,y);
       }
       else if(welt.weltArray[x+1][y].getTyp() == "Monster"){
           kampf.kaempfen("rechts",welt.weltArray,held);
           if(welt.weltArray[x+1][y].getTyp() == "Monster")
                            welt.weltArray[x][y-1] = new Weg(x,y);
       }
       else if(welt.weltArray[x-1][y].getTyp() == "Monster"){
           kampf.kaempfen("links",welt.weltArray,held);
           if(welt.weltArray[x-1][y].getTyp() == "Monster")
                            welt.weltArray[x][y-1] = new Weg(x,y);
        }
       if(held.handBesetzt()){
       if(pRichtung =="oben" && welt.weltArray[x][y-1].getTyp() == "Fluss" && held.getHand().getTyp()=="Boot"){
                            System.out.println("Du kannst auf dem Wasser Schwimmen, da du ein boot hast");
                            vorhanden = false;}
       else if(pRichtung =="unten" && welt.weltArray[x][y+1].getTyp() == "Fluss" && held.getHand().getTyp()=="Boot"){
                            System.out.println("Du kannst auf dem Wasser Schwimmen, da du ein boot hast");
                            vorhanden = false;}
       else if(pRichtung =="rechts" && welt.weltArray[x+1][y].getTyp() == "Fluss" && held.getHand().getTyp()=="Boot"){
                            System.out.println("Du kannst auf dem Wasser Schwimmen, da du ein boot hast");
                            vorhanden = false;}
       else if(pRichtung =="links" && welt.weltArray[x-1][y].getTyp() == "Fluss" && held.getHand().getTyp()=="Boot"){
                            System.out.println("Du kannst auf dem Wasser Schwimmen, da du ein boot hast");
                            vorhanden = false;}}
       return vorhanden;
    }
    private void wandDa(String pRichtung){
        int x=held.getX();
        int y=held.getY();
        
        if(pRichtung =="oben")System.out.println("Du bist auf eine "+welt.weltArray[x][y-1].getTyp()+" gestoßen und kannst nicht weitergehen!");
        else if(pRichtung =="unten")System.out.println("Du bist auf eine "+welt.weltArray[x][y+1].getTyp()+" gestoßen und kannst nicht weitergehen!");
        else if(pRichtung =="links")System.out.println("Du bist auf eine "+welt.weltArray[x-1][y].getTyp()+" gestoßen und kannst nicht weitergehen!");
        else if(pRichtung =="rechts")System.out.println("Du bist auf eine "+welt.weltArray[x+1][y-1].getTyp()+" gestoßen und kannst nicht weitergehen!");
        
        if(welt.weltArray[x][y-1].getTyp() == "Dorfbewohner" ^ welt.weltArray[x][y+1].getTyp() == "Dorfbewohner" ^ welt.weltArray[x+1][y].getTyp() == "Dorfbewohner" ^ welt.weltArray[x-1][y].getTyp() == "Dorfbewohner"){
            try
            {
                Thread.sleep(1700);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }     
            villagerText();
        }
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
        if(!welt.itemVorhanden(x,y)){
            container = held.inventar[pIndex];
            switch(container.getName()){
                case "Schwert":welt.weltArray[x][y] = new Schwert(x,y,"Schwert",container.getSchadenspunkte());
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
    private void villagerText(){
       
       switch(villagerNummer){
            case 1:     System.out.print('\u000C');
                        System.out.println("Ich bin der Erste Villager und werde dir deine Aufgabe erzählen. Dein Bruder ist plötzlich verschwunden und er braucht deine Hilfe!");
                        System.out.println("Er zählt auf dich und du musst dein bestes geben um ihn zu retten. ");
                        System.out.println("Wenn du weiter in die Richtung gehst in die du gerade unterwegs warst, wirst du deine erste Waffen finden. Jedoch musst du stehts aufpassen.");
                        System.out.println("Hier in der Gegend lauern im Moment sehr viele Monster herum. Wenn du pech hast wirst du auf welche treffen. Nimm deshalb immer eine deiner Waffen in deine Hand.");
                        System.out.println("Wie das geht kannst du mit ,hilfe, nachgucken");
                        break;
            case 2:     System.out.print('\u000C');
                        System.out.println("Ich bin der Erste v");
                        break;
            case 3:     System.out.print('\u000C');
                        System.out.println("Ich bin der Erste v");
                        break;
            case 4:     System.out.print('\u000C');
                        System.out.println("Ich bin der Erste v");
                        break;
            case 5:     System.out.print('\u000C');
                        System.out.println("Ich bin der Erste v");
                        break;
            case 6:     System.out.print('\u000C');
                        System.out.println("Ich bin der Erste v");
                        break;
            default:    break;
        }
        try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }     
            
        
        System.out.println("Nun erfülle deine Aufgabe für einen weiteren Hinweis!");
        if(welt.weltArray[held.getX()][held.getY()-1].getTyp()=="Dorfbewohner"){
            welt.weltArray[held.getX()][held.getY()-1] = new Weg(held.getX(),held.getY()-1);
        }else if(welt.weltArray[held.getX()][held.getY()+1].getTyp()=="Dorfbewohner"){
            welt.weltArray[held.getX()][held.getY()+1] = new Weg(held.getX(),held.getY()+1);
        }else if(welt.weltArray[held.getX()+1][held.getY()].getTyp()=="Dorfbewohner"){
            welt.weltArray[held.getX()+1][held.getY()] = new Weg(held.getX()+1,held.getY());
        }else if(welt.weltArray[held.getX()-1][held.getY()].getTyp()=="Dorfbewohner"){
            welt.weltArray[held.getX()-1][held.getY()] = new Weg(held.getX()-1,held.getY());
        }
        villagerNummer++;
    }
}
