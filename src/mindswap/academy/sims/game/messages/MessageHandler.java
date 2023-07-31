package mindswap.academy.sims.game.messages;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MessageHandler {

    private BufferedReader reader;

   public String manageMessage(String path) {
       String message = "";
       try {
           reader = new BufferedReader(new FileReader(path));
           String line;
           while ((line = reader.readLine()) != null){
                message += line + "\n";
           }
           reader.close();
       } catch (IOException e) {
           System.out.println(Messages.MESSAGE_ERROR);
       }
       return message;
   }
}
