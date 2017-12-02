package services;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private ResourceBundle resourceBundle;
    private final String resourceName = "text";

    private ResourceManager()  {
        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public String getValue(String key){
        return resourceBundle.getString(key);
    }

    public Locale getLocale(){
        return resourceBundle.getLocale();
    }
}
