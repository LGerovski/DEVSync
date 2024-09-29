package syncCompany;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");


        //File workPlace = new File("C:\\Users\\GEL1SF3\\Documents\\Pluralsight\\tesseract\\my-test\\src\\main\\settings\\tessdata");
        //String filepath = workPlace.exists() ? ("C:\\Users\\GEL1SF3\\Documents\\Pluralsight\\tesseract\\my-test\\src\\main\\settings\\tessdata") : ("C:\\Program Files\\Tesseract-OCR\\tessdata");
        //String imagePath = workPlace.exists() ? ("C:\\Users\\GEL1SF3\\Pictures\\testTesseract.JPG"):("C:\\Users\\lgerovski\\Pictures\\testTesseract.JPG");
        Path tempDir = Files.createTempDirectory("tessResources-temp");

        InputStream tessdataStream = App.class.getClassLoader().getResourceAsStream("tessdata/eng.traineddata");
        if (tessdataStream == null){
            throw new RuntimeException("File not found in resources");
        }

        Path tessdataDir = tempDir.resolve("tessdata");
        Files.createDirectories(tessdataDir);

        Path tessdataFile = tessdataDir.resolve("eng.traineddata");
        Files.copy(tessdataStream, tessdataFile, StandardCopyOption.REPLACE_EXISTING);

        InputStream testIMGStream = App.class.getClassLoader().getResourceAsStream("testTesseract.JPG");
        if (testIMGStream == null){
            throw new RuntimeException("File not found in resources");
        }

        Path testIMGFile = tempDir.resolve("testTesseract.JPG");
        Files.copy(testIMGStream, testIMGFile, StandardCopyOption.REPLACE_EXISTING);

        Tesseract instance = new Tesseract();
        instance.setDatapath(tempDir.resolve("tessdata").toString());
        instance.setLanguage("eng");

        instance.setTessVariable("user_defined_dpi", "96");

        try {
            String result = instance.doOCR(testIMGFile.toFile());
            System.out.println(result);
        }catch (TesseractException e){
            e.printStackTrace();
        }

        tessdataStream.close();;
        testIMGStream.close();
        System.out.println("pass8");
    }
}
