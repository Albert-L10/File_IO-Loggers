import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;



public class Visitor {


    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());


    public static boolean saveFile(String fullName, int age, String comments, String nameOfContact)throws IOException {

        FileWriter fileWriter = null;

        new File("visitor_ " + fullName.replace(" ", "_") + ".txt");

        File visitorFile;

        try {
            if (!fullName.isEmpty()) {
                String full_Name = fullName.replace(" ", "_");
                visitorFile = new File("visitor_" + full_Name.toLowerCase() + ".txt");


                if (visitorFile.createNewFile()) {
                    fileWriter = new FileWriter(visitorFile);
                    fileWriter.write(fullName + " \n" +
                            age + " \n" +
                            "Date of visit: " + LocalDate.now() + " \n" +
                            "timeOfVisit:" + LocalTime.now() + " \n" +
                            comments + " \n" +
                            nameOfContact);

                    logger.info("file created successfully");
                } else {
                    logger.debug("file already exist!");
                }
            }
            else{
                logger.error("File is not created");
            }



        }
        catch (IOException e)
        {
            logger.info(saveFile(fullName,age,comments, nameOfContact));
            logger.error(saveFile(fullName,age,comments, nameOfContact));
            e.printStackTrace();
        }
        assert fileWriter != null;
        fileWriter.close();

        return true;
    }

    public static void loadFile(String name) {


            File myObj = new File("visitor_" +name.toLowerCase().replace(" ", "_") + ".txt");

            if(!myObj.exists()) {
               logger.error("File not found");
            }
            else {
                System.out.println("File name: " + myObj.getName());
            }

    }



    public static void main(String[] args) throws IOException {

    Scanner input=new Scanner(System.in);


        System.out.println("enter 1 to Load OR  2 to Save");
       int option=input.nextInt();


        switch(option) {

            case 1:

                System.out.println("Enter your name");
                String name = input.next();
                loadFile(name);

                break;

            case 2:
                System.out.println("Enter your name");
                 name = input.next();

                System.out.println("Enter your age");
                int age = input.nextInt();

                System.out.println("Enter name of someone who assisted you?");
                String contactPerson = input.next();


                System.out.println("Any comments?");
                String comments = input.next();
                saveFile(name, age, comments, contactPerson);
                break;



            default:
                System.out.println("invalid option");

        }
    }



}




