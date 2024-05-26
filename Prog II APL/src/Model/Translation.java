package Model;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



/**
 * A class that manages translations for different languages.
 */
public final class Translation {

    /** The translations. */
    private HashMap<String, String> translation = new HashMap<>();

    /** The supported languages. */
    private String[] supportedLanguages = {"DE", "ENG", "FR"};

    /** The default language. */
    private String defaultLanguage = "ENG";

    /** The path to the translation file. */
    // WARNING NOT YET DYNAMIC !!!
    private final String path = "/Users/loris/git/Prog II APL/Prog II APL/src/Model/translation.json";

    /**
     * Reads the translation file.
     *
     * @param lang The language for which translations should be read.
     */
    private void readFile(String lang) 
    {
        try {
            FileReader reader = new FileReader(path);
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) (parser.parse(reader));

            for (Object key : object.keySet()) {
                String value = (String) ((JSONObject) object.get(key)).get(lang);
                translation.put((String) key, value);
            }

            reader.close();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Selects a language.
     *
     * @param lang The selected language.
     * @return true if the language is successfully selected, false otherwise.
     */
    public boolean selectLanguage(String lang) 
    {
        switch (lang) {
            case "DE":
                readFile(lang);
                break;

            case "ENG":
                readFile(lang);
                break;
            case "FR":
                readFile(lang);
                break;

            default:
                return false;
        }

        return true;
    }

    /**
     * Gets the supported languages.
     *
     * @return The supported languages.
     */
    public String[] getSupportedLanguages() 
    {
        return supportedLanguages;
    }

    /**
     * Gets the text for the specified key.
     *
     * @param input The key for translation.
     * @return The translation or "* ERROR *" if no translation is found.
     */
    public String getText(String input)
    {
        if (translation.containsKey(input)) 
        {
            return translation.get(input);
        }

        return "* ERROR *";
    }

    /**
     * Instantiates a new Translation with the specified language.
     *
     * @param lang The language.
     */
    public Translation(String lang)
    {
        selectLanguage(lang);
    }

    /**
     * Instantiates a new Translation with the default language.
     */
    public Translation() 
    {
        selectLanguage(this.defaultLanguage);
    }

}

