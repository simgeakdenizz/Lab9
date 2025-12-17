package lab.lab9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Scenario2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input file path: ");
        String inputFile = sc.nextLine();
        System.out.print("Enter old word: ");
        String oldWord = sc.nextLine();
        System.out.print("Enter new word: ");
        String newWord = sc.nextLine();
        System.out.print("Enter output file path: ");
        String outputFile = sc.nextLine();
        BufferedReader fileReader = null;
        Formatter fileWriter = null;
        try{
            FileReader reader = new FileReader(inputFile);
            fileReader = new BufferedReader(reader);
            fileWriter = new Formatter(outputFile);
            String line;
            while((line = fileReader.readLine()) != null){
                String changedLine = line.replace(oldWord , newWord);
                fileWriter.format("%s\n" , changedLine);
            }
            System.out.println("Replaced '" + oldWord + "' with '" + newWord + "' in " + inputFile + " -> " + outputFile);
        }catch (IOException e) {
            System.err.println("File operation failed.");
        }finally {
            try{
                if(fileReader != null){
                    fileReader.close();
                }
            }catch (IOException e){
                System.out.println("Error closing input file.");
            }
            if(fileWriter != null){
                fileWriter.close();
            }
        }

    }
}
