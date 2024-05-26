package Model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;

public class Highscore 
{
	private String path = "src/Model/Highscores.txt";
	private String[][] list;
	
	private boolean completed;
	
	public Highscore()
	{
		if(checkFile())
		{
			list = new String[5][2];
			completed = readFile();
		}
	}
	
	
	public String[][] getScore()
	{
		if(this.completed)
		{
			return this.list;
		}
		
		return null;
	}
	
	
	public boolean checkFile()
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
	
	
	public boolean readFile()
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
