package model;


import java.io.*;
import java.util.ArrayList;
/**
 * @author Elias Kalkhofer
 * @date 8.03.2021
 */
public class CSV
{
    public ArrayList<Input> loadFromFile(String filename)
    {
        ArrayList<Input> inputs = new ArrayList<>();
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String limit;
            String[] box;
            bufferedReader.readLine();

            while((limit = bufferedReader.readLine()) != null)
            {
                box = limit.split(";");                                                                           //Auslese der CSV Datei, Trennzeichen dabei ist ";"
                Input input = new Input(box[0], box[1], box[2]);                                                        //Einzelne Auslese der Kästen
                inputs.add(input);
            }
            bufferedReader.close();
        }
        catch(IOException ex)
        {
            System.out.printf("Error while Loading\n");
        }
        return inputs;
    }


    public void saveToFile(String filename, ArrayList<Input> inputs)
    {
        try
        {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.write("Name;Adresse;Telefonnummer");                                                                 // Damit in Excel ein "Header" gemacht wird
            bw.newLine();

            for (Input input:inputs)
            {
                bw.write(input.getName() + ";" + input.getAddress() + ";" + input.getPhone());                      //Eintrag in CSV Datei mit Trennzeichen ";"
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException ex)
        {
            System.out.printf("Error while saving file");
        }
    }
}
