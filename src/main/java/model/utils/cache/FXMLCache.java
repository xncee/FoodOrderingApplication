package model.utils.cache;

import controllers.ContentSwitcher;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import model.utils.LocalizationUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FXMLCache {
    private static class Cache {
        Parent content;
        Object controller;

        public Cache(Parent content, Object controller) {
            this.content = content;
            this.controller = controller;
        }
    }

    private static final Map<String, Cache> fxmlCache = new HashMap<>();

    public static Parent preloadFXML(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(ContentSwitcher.class.getResource(fxmlFile), LocalizationUtil.getResourceBundle());
            Parent content = loader.load();
            fxmlCache.put(fxmlFile, new Cache(content, loader.getController()));
            System.out.println("Page loaded: " + fxmlFile);
            return content;
        } catch (IOException e) {
            return null;
        }
    }

    // Retrieve cached FXML content
    public static Parent getFXML(String fxmlFile) {
        Cache cache = fxmlCache.getOrDefault(fxmlFile, null);
        return (cache != null) ? cache.content : null;
    }

    public static Object getController(String fxmlFile) {
        Cache cache = fxmlCache.getOrDefault(fxmlFile, null);
        return (cache != null) ? cache.controller : null;
    }

    public static void clearCache() {
        fxmlCache.clear();
    }
}