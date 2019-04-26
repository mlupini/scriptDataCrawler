import java.io.IOException;
import java.util.ArrayList;

public class crawler {

    public static void main(String[] args) throws IOException, InterruptedException {

        String anaconda = "C:\\Users\\asus\\Anaconda3\\Scripts\\activate.bat C:\\Users\\asus\\Anaconda3";

        //inizializzo tutti gli utenti
        String[] setUpInizialUsers = new String[]{"matteolupini", "lorenzo.mannocci","simon_barandoni","andreabagnoli__"};

        //prima parte di codice, in cerca dell'utente su cui applicare
        final String firstPartOfInstruction = "python crawl_follower_with_login.py";

        //array list di utenti già ricercati
        ArrayList<String> alreadyCrawledUsers = new ArrayList<String>();

        //utenti da ricercare
        ArrayList<String> usersToCrawl = new ArrayList<String>();

        //scorro il primo array di startup in modo da inizializzare il percorso
        for(int startupIndex = 0; startupIndex < 4; startupIndex++){

            //estrazione nome utente da array
            String secondPart = setUpInizialUsers[startupIndex];

            //combinazione dei due path per creare l'instruzione
            String command = firstPartOfInstruction + " " + secondPart;

            System.out.println(command);

            Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd C:\\Users\\asus\\instagram-profilecrawl && " + anaconda + " && " + command + "\"");

            alreadyCrawledUsers.add(setUpInizialUsers[startupIndex]);
        }

        /*
        EFfettuato il crawl dei primi 4 profili, ora devo andare a cercare all'interno di ogni file .txt
        generato i singoli follower per ciascun profilo e fare il crawl per quei follower.
         */

        //effettua prima una prova con lorenzo.

        //prova superata mediante l'utilizzo di anaconda

        //path della folder
        final File folder = new File("/home/you/Desktop");
        //chiamata del metodo per trovare tutti i file all'interno della folder
        listFilesForFolder(folder);
        //directory dove copio gli elementi
        final File folderWhereToCopy = new File("path");



    }

    //metodo pubblico per listare tutti i file della folder
    public void listFilesForFolder(final File folder) {

    //per ogni file entry nella folder
        for (final File fileEntry : folder.listFiles()) {
        //se il file e una directory, impossibile allora rientra nella directory
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } 
        //il file non e una directory
            else {
            //stampa il nome
                System.out.println(fileEntry.getName());

            //estrae l'estenzione
                String ext = FilenameUtils.getExtension(fileEntry);

            //controllo che l'estenzione sia corretta
                if(ext == "txt"){
                    //copio il file in un altra directory
                    FileUtils.copyFileToDirectory(fileEntry, folderWhereToCopy)

                    //chiamo il metodo per la gestione dei nomi dentro un file .txt
                    insertNewCrawlUsers(fileEntry);

                }
                //se non e corretta non faccio nulla.
                else{

                }
            }
        }
    }

    public void insertNewCrawlUsers(File fileEntry){

        //estraggo il nome
        String name = fileEntry.getName();

        //bufferedReader per lettura nomi utente
        BufferedReader br = new BufferedReader(new FileReader(fileEntry)); 

        String st; 

        //per ogni riga del txt, leggo la linea e salvo la stringa nell'array degli utenti da cui fare il crawl
        while ((st = br.readLine()) != null) {
            System.out.println(st); 
            usersToCrawl.add(st);
        }
    } 
} 

