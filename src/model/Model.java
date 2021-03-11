package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Elias Kalkhofer
 * @date 8.03.2021
 */
public class Model
{
    public ArrayList<Input> inputs;
    public int position;
    final String FILEPATH = System.getProperty("user.dir") + "\\Addressbook.csv";
    File file = new File(FILEPATH);


    public Model()
    {
        try {
            this.inputs = new ArrayList<>();
            this.position = 0;
            if (file.createNewFile())
            {
                System.out.printf("Addressbook.csv was created");
            }
        }
        catch (Exception exception)
        {
        }

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    saveToCSV();
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }, "Shutdown-thread"));
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public Input getInput(int position)
    {
        return inputs.get(position);
    }

    public void addInput(Input input)
    {
        inputs.add(input);
        Collections.sort(inputs);
        position = 0;
    }

    public void saveToCSV()
    {
        CSV csv = new CSV();
        csv.saveToFile("Addressbook.csv",inputs);                                                                     //Speichern der inputs in Datei excel.csv
    }

    public void loadFromCSV()
    {
            CSV csv = new CSV();
            inputs = csv.loadFromFile("Addressbook.csv");                                                                 //Auslesen der Datei excel.csv
            position = 0;
    }

    public int sizeOfBook()
    {
        return inputs.size();
    }

    public void delete()
    {
        inputs.remove(position);
    }

    public void saveChange(Input input)
    {
        inputs.set(position,input);
    }
}
