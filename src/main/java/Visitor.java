import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Visitor {

    private static final Logger logger = (Logger) LogManager.getLogger(Visitor.class.getName());

    static String fullName;
    static int age;
    static String dateOfVisit;
    static String timeOfVisit;
    static String comments;
    static String nameOfContact;


    public static void main(String[] args) throws IOException {

        String name="Albert legodi";
        fullName=name.replace(' ','_');
        age=20;
        dateOfVisit="15/03/2020" ;
        timeOfVisit="11:05";
        comments="Umuzi is cold!";
        nameOfContact="Paul";
        Visitor Albert=new Visitor();

        Albert.save(fullName,age,dateOfVisit,timeOfVisit,comments,nameOfContact);

       Albert.load(fullName);

    }
    public String save(String fullName, int age, String dateOfVisit, String timeOfVisit, String comments, String nameOfContact) throws IOException {

        try {
            String full_Name = fullName.replace(" ", "_");
            FileWriter fileWriter = new FileWriter("visitor_" + full_Name.toLowerCase() + ".txt");
            fileWriter.write(fullName + " \n" + age + " \n" + dateOfVisit + " \n" + timeOfVisit + " \n" + comments + " \n" + nameOfContact);
            fileWriter.close();

            logger.info("file created");
        }
        catch (IOException e)
        {
            logger.info(e.getMessage());
        }
        return "File is created!";
    }

    public static void load(String name) {
        try {

            File myObj = new File("Visitor_" +name.toLowerCase().replace(" ", "_") + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String Albert = myReader.nextLine();

            myReader.close();
        }
    } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.warning("An error occurred.");
        }
    }

}




