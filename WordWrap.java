import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class WordWrap {
    public static void main(String[] args) throws Exception {

        String dateFormat = "\\d{2}/\\d{2}/\\d{4}"; // represents dd/MM/yyyy
                                                    // format

        Scanner scan = new Scanner(new File("D:/Deepu/Inputfile/wordwrap/Consumer_Complaints.csv"));

        StringBuilder buffer = new StringBuilder();
        // bypassing the first line coz it has header information
        if (scan.hasNextLine()) {
            scan.nextLine();
        }
        
        FileWriter writer=new FileWriter(new File("D:/Deepu/Inputfile/wordwrap/Consumer_Complaints_wordwrap.csv"));

        while (scan.hasNextLine()) {

            String line = scan.nextLine();
            if (line.trim().isEmpty())
                continue;

            String firstString = line.split(",")[0];
            // System.out.println(firstString);
            if (firstString.matches(dateFormat)) {
                // For first time buffer is empty.If so append the data into the
                // buffer.
                if (buffer.length() == 0) {
                    buffer.append(line);
                }
                //If it is for next time,the buffer is not empty
                else{
                    //write the buffer data into the file.Then empty the buffer,and reappend the data
                    writer.append(buffer.toString());
                    writer.append("\n");
                    buffer.setLength(0);
                    buffer.append(line);
                }
                
                //System.out.println(line);
            }
            else{ //if it is not starting with date format,then it is the continuation of the record.
                buffer.append(line);
            }

        }
        
        writer.flush();
        writer.close();

    }
}
