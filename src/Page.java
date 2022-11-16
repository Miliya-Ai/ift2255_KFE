import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Page extends Controller{
    protected ArrayList<String> tabNomOptions = new ArrayList<String>() ;

    public Page() {

    }

    public void entete (String nomPage){
        out("\n"
            + "################ " + nomPage + " ##################"
            + "\n");
    }

    public String afficherOptions () {
        String optionDonnee = "";
        int lenghtTabNomOptions = tabNomOptions.size() ;
        int indexTab = 0;
        for (int i = 1; i <= lenghtTabNomOptions; i++){
            optionDonnee += "[" + i + "]: " + tabNomOptions.get(indexTab) + "\n";
            indexTab += 1;
        }
        return optionDonnee;
    }

    public void addTabNomOptions(String option) {
        this.tabNomOptions.add(option);
    }

    public void out (String message){
        System.out.println(message);
    }

    public void filtrer () {
        Scanner myObj = new Scanner(System.in);
        String stringNumeroOption = myObj.nextLine();
        //String optionChoisi = tabNomOptions.get(numeroOption - 1);

        int intNumeroOption = 0;

        try {
            intNumeroOption = Integer.parseInt(stringNumeroOption);
            changerPage(intNumeroOption);
        } catch (Exception e) {
            out("Svp, entrer un chiffre");
            filtrer();

        }

    }


    //https://stackoverflow.com/questions/6994518/how-to-delete-the-content-of-text-file-without-deleting-itself
    public void effacer() throws IOException {
        /*BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/passResident.txt"));
        writer.write("");
        writer.flush();

        BufferedWriter writer2 = Files.newBufferedWriter(Paths.get("src/passConsommateur.txt"));
        writer2.write("");
        writer.flush();*/

        PrintWriter pw = new PrintWriter("src/passResident.txt");
        pw.close();

        PrintWriter pw2 = new PrintWriter("src/passConsommateur.txt");
        pw2.close();



    }
    public void changerPage(int intNumeroOption) throws IOException {

    }
}
