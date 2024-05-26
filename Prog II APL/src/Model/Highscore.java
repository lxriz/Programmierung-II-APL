package Model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

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
