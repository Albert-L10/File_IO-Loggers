import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;



public class Visitor {


    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());


    public static void saveFile(String fullName, int age, String dateOfVisit, String timeOfVisit, String comments, String nameOfContact) {

        try {
            String full_Name = fullName.replace(" ", "_");
            FileWriter fileWriter = new FileWriter("visitor_"+ full_Name.toLowerCase() + ".txt");

            fileWriter.write(fullName + " \n" +
                    age + " \n" +
                    dateOfVisit + " \n" +
                    timeOfVisit + " \n" +
                    comments + " \n" +
                    nameOfContact);

            fileWriter.close();

            logger.info("file created successfully");
        }
        catch (Exception e)
        {
            logger.error("Error"+e.getMessage());
        }
    }

    public static void loadFile(String name) {
        try {

            File myObj = new File("Visitor_" +name.toLowerCase().replace(" ", "_") + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String read = myReader.nextLine();
                logger.info(read);


            }
            myReader.close();
        } catch (FileNotFoundException e) {

            logger.error("An error occurred.");
            e.printStackTrace();

        }
    }



    public static void main(String[] args) {

    Scanner input=new Scanner(System.in);

        System.out.println("Enter your name");
        String name=input.nextLine();

        System.out.println("Enter your age");
        int age=input.nextInt();

        System.out.println("Enter date of visit");
        String visitDate=input.next();

        System.out.println("Enter time visited");
        String time=input.next();

        System.out.println("Enter name of someone who assisted you?");
        String contactPerson=input.next();


        System.out.println("Any comments?");
        String comments=input.next();

        saveFile(name,age,visitDate,time,comments,contactPerson);
        
        loadFile(name);


    }



}




