package syncCompany;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //File workPlace = new File("C:\\Users\\GEL1SF3\\Documents\\Pluralsight\\tesseract\\my-test\\src\\main\\settings\\tessdata");
        //String filepath = workPlace.exists() ? ("C:\\Users\\GEL1SF3\\Documents\\Pluralsight\\tesseract\\my-test\\src\\main\\settings\\tessdata") : ("C:\\Program Files\\Tesseract-OCR\\tessdata");
        //String imagePath = workPlace.exists() ? ("C:\\Users\\GEL1SF3\\Pictures\\testTesseract.JPG"):("C:\\Users\\lgerovski\\Pictures\\testTesseract.JPG");
        String filepath = null;
        String imagePath = null;
        try {
            URL tessdataUrl = App.class.getClassLoader().getResource("tessdata");
            URL picturesUrl = App.class.getClassLoader().getResource("testTesseract.JPG");
            filepath = Paths.get(tessdataUrl.toURI()).toString();
            imagePath = Paths.get(picturesUrl.toURI()).toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ITesseract instance = new Tesseract();
        instance.setDatapath(filepath);
        instance.setLanguage("eng");
        instance.setTessVariable("user_defined_dpi", "96");

        try {
            File imageFile = new File(imagePath);
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
