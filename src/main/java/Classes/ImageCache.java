package Classes;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ImageCache {
    private static final Map<String, ImageIcon> imageCache = new HashMap<>();

    public static ImageIcon loadImage(String imagePath) {
        if (!imageCache.containsKey(imagePath)) {
            ImageIcon image = new ImageIcon(imagePath);
            imageCache.put(imagePath, image);
        }
        return imageCache.get(imagePath);
    }
}