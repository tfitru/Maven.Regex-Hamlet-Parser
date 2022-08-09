import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {
        return hamletData;
    }

    public Matcher findHoratio() {
        Pattern p = Pattern.compile("Horatio",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(hamletData);
        return m;
    }

    public Matcher findHamlet() throws IOException {
        Pattern p = Pattern.compile("Hamlet",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(hamletData);
        return m;
    }

    public StringBuffer changeHamletToLeon() throws IOException {
        Pattern p = Pattern.compile("Hamlet",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(hamletData);
        StringBuffer buffer = new StringBuffer();
        while(m.find()){
            m.appendReplacement(buffer, "Leon" );
        }

        return buffer;
    }

    public StringBuffer changeHoratioToTariq() {
        Pattern p = Pattern.compile("Horatio",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(hamletData);
        StringBuffer buffer = new StringBuffer();
        while(m.find()){
            m.appendReplacement(buffer, "Tariq" );
        }

        System.out.println(buffer);

        return buffer;
    }
    }

