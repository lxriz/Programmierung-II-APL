package Model;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public final class Translation 
{
	private static HashMap<String, String> translation = new HashMap<>();
	private static String[] supportedLanguages = {"DE", "ENG"};
	
	private static String defaultLanguage = "ENG";
	
	
	// ACHTUNG NOCH NICHT DYNAMISCH !!!
	private static final String path = "/Users/loris/git/Prog II APL/Prog II APL/src/Model/translation.json";
	
	
	
	private void readFile(String lang)
	{
		try 
		{
			FileReader reader = new FileReader(path);
			JSONParser parser = new JSONParser(); 
			JSONObject object = (JSONObject)(parser.parse(reader));
			
			for(Object key : object.keySet())
			{
				String value = (String)((JSONObject)object.get(key)).get(lang);
				
				translation.put((String)key, value);
			}
			
			reader.close();
			            
	    } 
	 	catch (IOException | ParseException e) 
	 	{
            e.printStackTrace();
        }
		
	}
	
	
	public boolean selectLanguage(String lang)
	{
		switch(lang)
		{
			case "DE":
				readFile("DE");
				break;
				
			case "ENG":
				readFile("ENG");
				break;
			
			default:
				return false;
		}
		
		return true;
	}
	
	
	public String[] getSuppoertedLanguages()
	{
		return supportedLanguages;
	}
	
	
	public String getText(String input)
	{
		if(translation.containsKey(input))
		{
			return translation.get(input);
		}
		
		return "!MISSING WORD!";
	}
	
	
	public Translation(String lang)
	{
		selectLanguage(lang);
	}
	
	
	public Translation()
	{
		selectLanguage(this.defaultLanguage);
	}
	
}
