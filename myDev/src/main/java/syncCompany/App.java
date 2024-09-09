package syncCompany;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        File workPlace = new File("C:\\Users\\GEL1SF3\\Documents\\Pluralsight\\tesseract\\my-test\\src\\main\\settings\\tessdata");
        String filepath = workPlace.exists() ? ("C:\\Users\\GEL1SF3\\Documents\\Pluralsight\\tesseract\\my-test\\src\\main\\settings\\tessdata") : ("C:\\Program Files\\Tesseract-OCR\\tessdata");
        ITesseract instance = new Tesseract();
        //instance.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        //instance.setDatapath("C:\\Users\\GEL1SF3\\Documents\\Pluralsight\\tesseract\\my-test\\src\\main\\settings\\tessdata");
        instance.setDatapath(filepath);
        instance.setLanguage("eng");
        instance.setTessVariable("user_defined_dpi", "96");

        try {
            //File imageFile = new File("C:\\Users\\GEL1SF3\\Pictures\\testTesseract.JPG");
            File imageFile = new File("C:\\Users\\lgerovski\\Pictures\\testTesseract.JPG");
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
