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
        ITesseract instance = new Tesseract();
        //instance.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        instance.setDatapath("C:\\Users\\GEL1SF3\\Documents\\Pluralsight\\tesseract\\my-test\\src\\main\\settings\\tessdata");
        instance.setLanguage("eng");

        try {
            File imageFile = new File("C:\\Users\\GEL1SF3\\Pictures\\testTesseract.JPG");
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
