import java.io.IOException;
import java.util.ArrayList;

public class crawler {

    public static void main(String[] args) throws IOException, InterruptedException {

        //inizializzo tutti gli utenti
        String[] setUpInizialUsers = new String[]{"matteolupini", "lorenzo.mannocci","simon_barandoni","andreabagnoli__"};

        //prima parte di codice, in cerca dell'utente su cui applicare
        final String firstPartOfInstruction = "python3.7 crawl_profile.py";

        //array list di utenti già ricercati
        ArrayList<String> alreadyCrawledUsers = new ArrayList<String>();

        //scorro il primo array di startup in modo da inizializzare il percorso
        for(int startupIndex = 0; startupIndex < 4; startupIndex++){

            //estrazione nome utente da array
            String secondPart = setUpInizialUsers[startupIndex];

            //combinazione dei due path per creare l'instruzione
            String command = firstPartOfInstruction + " " + secondPart;

            System.out.println(command);

            //inizializzo un process builder usando il path
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd \"C:\\Program Files\\Microsoft SQL Server\" && command");
            builder.redirectErrorStream(true);

            //start del processo
            Process p = builder.start();

            //attesa della fine del processo con l'obiettivo di non sovraccaricare la ram.
            p.waitFor();

            alreadyCrawledUsers.add(setUpInizialUsers[startupIndex]);
        }

        /*
        EFfettuato il crawl dei primi 4 profili, ora devo andare a cercare all'interno di ogni file .txt
        generato i singoli follower per ciascun profilo e fare il crawl per quei follower.
         */

        //effettua prima una prova con lorenzo.

    }
}
