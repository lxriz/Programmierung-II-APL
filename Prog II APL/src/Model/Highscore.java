package Model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * The Highscore class manages a list of high scores, reading from and writing to a file.
 */
public class Highscore 
{
    private String path = "src/Model/Highscores.txt";
    private String[][] list;
    
    private boolean completed;
    
    /**
     * Constructs a Highscore object and initializes the high score list by reading from the file if it exists.
     */
    public Highscore()
    {
        if(checkFile())
        {
            list = new String[5][2];
            completed = readFile();
        }
    }
    
    /**
     * Adds a new score to the high score list, updating the file.
     * 
     * @param score an array containing the name and score to be added
     */
    public void getNewScore(String[] score)
    {
        int i = 0;
        String[] temp = score;
        for(String[] entry : this.list)
        {
            if(entry[0] == null)
            {
                this.list[i][0] = temp[0];
                this.list[i][1] = temp[1];
                break;
            }
            
            if(Double.parseDouble(temp[1]) > Double.parseDouble(this.list[i][1]))
            {
                String temp0 = this.list[i][0];
                String temp1 = this.list[i][1];
            
                this.list[i][0] = temp[0];
                this.list[i][1] = temp[1];
                
                temp[0] = temp0;
                temp[1] = temp1;
            }
            i++;
        }
        
        writeFile();
    }
    
    /**
     * Writes the current high score list to the file.
     */
    private void writeFile()
    {
        try 
        {
            FileWriter writer = new FileWriter(path);
            BufferedWriter buffer = new BufferedWriter(writer);
            
            for(String[] entry : this.list)
            {
                if(entry[0] == null)
                {
                    break;
                }
                buffer.write(entry[0]);
                buffer.write(";");
                buffer.write(entry[1]);
                buffer.newLine();
            }
            
            buffer.close();
            writer.close();
        } 
        catch (IOException e) 
        {
            // Handle the exception
        }
    }
    
    /**
     * Returns the current high score list.
     * 
     * @return the high score list, or null if the list is not completed
     */
    public String[][] getScore()
    {
        if(this.completed)
        {
            return this.list;
        }
        
        return null;
    }
    
    /**
     * Checks if the high score file exists, and creates it if it does not.
     * 
     * @return true if the file exists or was created successfully, false otherwise
     */
    private boolean checkFile()
    {
        File file = new File(path);
        
        if(!file.exists())
        {
            try 
            {
                file.createNewFile();
            } 
            catch (IOException e) 
            {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Reads the high score list from the file.
     * 
     * @return true if the file was read successfully, false otherwise
     */
    private boolean readFile()
    {
        try 
        {
            FileReader reader = new FileReader(path);
            BufferedReader buffer = new BufferedReader(reader);
            
            try 
            {
                for(int i = 0; i<5; i++)
                {
                    String line = buffer.readLine();
                    if(line == null)
                    {
                        break;
                    }
                    
                    String[] temp = line.split(";");
                    if(temp.length != 2)
                    {
                        return false;
                    }
                    this.list[i][0] = temp[0];
                    this.list[i][1] = temp[1];
                    
                }                
                
                buffer.close();
                reader.close();
            } 
            catch (IOException e) 
            {
                return false;
            }
        } 
        catch (FileNotFoundException e) 
        {
            return false;
        }
        
        return true;
    }
}

