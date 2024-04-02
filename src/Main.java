import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        
        //only for windows machines
        String filePath = "C:\\Users\\Y\\Downloads\\Groceries.txt"; // because '\' is an escape character  
        String fileToWrite = "C:\\Users\\Y\\Downloads\\GroceriesFormatted.txt";
        
        //only for MAC/LINUX machines
        //String filePath = "/Users/Y/Downloads/Groceries.txt";
        //String fileToWrite = "/Users/Y/Downloads/ABC.txt";

        String [] array = new String[4];
        String id;
        String itemName;
        String quantity;
        double price;
        //String temp = "";
        String separator = ",";
        double total = 0;

        FileReader fileReader = new FileReader(filePath);
        FileWriter fileWriter = new FileWriter(fileToWrite);

        BufferedReader reader = new BufferedReader(fileReader);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write("****************************************************");
        writer.write("\nID#\t Item\t Quantity\t Price(€).\t");

        String line;
        
        while((line = reader.readLine()) != null){
            array = line.split(separator);
            
            id = array[0];
            itemName = array[1];
            quantity = array[2];
            price = Double.parseDouble(array[3]);  //for int -->  Int.parseInt()

            total += price;
            
            System.out.println(line);

            writer.write("\n" + array[0] + "   \t" + array[1] + "   \t" + array[2] + "   \t" + array[3] + ".\t");
        }
        
        System.out.println("\n" + "Total price of groceries: " + Math.round(total));
        
        writer.write("\n****************************************************");
        writer.write("\n" + "The grocery shopping total is:€" + Math.round(total));
        writer.write("\n****************************************************");

        reader.close();
        
        writer.flush();
        writer.close();
    }
}
