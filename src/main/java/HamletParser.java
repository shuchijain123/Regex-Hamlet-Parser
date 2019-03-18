import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    Pattern pattern1 = null;
    Matcher matcher1 = null;
    Matcher matcher2 = null;
    String line = null;
    String newline=null;



    Scanner myscanner = null;

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

    public void setHamletData() {

        this .hamletData=hamletData;
    }



    public String ChangeStringInFile(String oldString, String newString) {
        String myfile = loadFile();

        String patternString = "(?i)"+oldString;

        pattern1 = Pattern.compile(patternString);

        matcher1 = pattern1.matcher(myfile);
        if (matcher1.find()) {

            newline = matcher1.replaceAll(newString);




        }
        return newline;
    }


    public Boolean readStringInFile(String myString) {

        Boolean ans = true;
        String myReadFile="";
        String patternString = "(?i)"+myString;

        if (myReadFile.contains(myString)) {
            ans = false;
        } else
            ans = true;

        return ans;

    }

    public void writeToFile(String s){
       try {
           ClassLoader classLoader = getClass().getClassLoader();
           File file = new File(classLoader.getResource("hamlet_Output.txt").getFile());
           FileOutputStream fooStream = new FileOutputStream(file, false); // true to append
           // false to overwrite.
           byte[] myBytes = s.getBytes();
           fooStream.write(myBytes);
           fooStream.close();
       }
       catch (IOException e){
           e.printStackTrace(System.out);
       }
    }




    public void copyFiles(){
        try {
            ClassLoader classLoader = getClass().getClassLoader();
           File file = new File(classLoader.getResource("hamlet_backup.txt").getFile());
            classLoader = getClass().getClassLoader();
         File originalfile = new File(classLoader.getResource("hamlet.txt").getFile());



            FileInputStream inFile = new FileInputStream(file);
            int fileLength =(int)file.length();

            byte Bytes[]=new byte[fileLength];

            System.out.println("File size is: " + inFile.read(Bytes));

            String file1 = new String(Bytes);
            System.out.println("File content is:\n" + file1);

            FileOutputStream outFile = new FileOutputStream(originalfile);

            for (int i = 0; i<fileLength; i++)
            {
                outFile.write(Bytes[i]);
            }

            System.out.println("File copied.");
            //close files
            inFile.close();
            outFile.close();

        }
        catch (IOException e){
            e.printStackTrace(System.out);
        }
    }




}
