package lab.lab9;


import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

public class WordAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file path(e.g. q1.txt): ");
        String fileName = sc.nextLine();
        String[] words = new String[10000];
        int[] counts = new int[10000];
        int totalWordCount = 0 ;
        int uniqueWordCount = 0 ;
        BufferedReader fileReader = null;
        try{
            FileReader fileConnection = new FileReader(fileName);
            fileReader = new BufferedReader(fileConnection);
            String line;

            while((line = fileReader.readLine()) != null){
                line = line.replace("," , " ");
                line = line.replace(":" , " ");
                line = line.replace(";" , " ");
                line = line.replace("." , " ");
                line = line.trim();
                String[] lineWords = line.split(" ");
                for(String currentWord : lineWords){
                    if(currentWord.length()>0){
                        totalWordCount++;
                        int foundIndex = -1;
                        for(int i = 0; i < uniqueWordCount ; i++){
                            if(words[i].equals(currentWord)){
                                foundIndex=i;
                                break;
                            }
                        }
                        if (foundIndex != -1){
                            counts[foundIndex] ++;
                        }else{
                            if(uniqueWordCount < 10000){
                                words[uniqueWordCount]= currentWord;
                                counts[uniqueWordCount]=1;
                                uniqueWordCount++;
                            }
                        }
                    }
                }
            }
        }catch(IOException e){
            System.err.println("File could not be read.");
        }finally {
            try{
                if(fileReader != null){
                    fileReader.close();
                }
            }catch (IOException e ){
                System.err.println("Error closing file.");
            }
        }
        Formatter fileWriter = null;
        try{
            fileWriter = new Formatter("word_stats.txt");
            String totalInfo = "Total Word Count: " + totalWordCount + "\n";
            String uniqueInfo = "Unique Word Count: " + uniqueWordCount + "\n";
            System.out.print(totalInfo);
            System.out.print(uniqueInfo);
            fileWriter.format("%s" , totalInfo);
            fileWriter.format("%s" , uniqueInfo);
            for(int i = 0 ; i < uniqueWordCount ; i++){
                String line = words[i] + " : " + counts[i] + "\n";
                System.out.print(line);
                fileWriter.format("%s", line);
            }
        }catch (Exception e) {
            System.err.println("Error writing to file.");
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
        System.out.println("Results saved to word_stats.txt");
    }
}
