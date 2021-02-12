import java.io.*;
import java.net.*;

public class client{
public static void main(String args[])throws Exception{

    Socket s=new Socket("localhost",8080);
    
    /*data read*/
    DataInputStream dataRead=new DataInputStream(s.getInputStream());

    /*data write*/
    DataOutputStream dataWrite=new DataOutputStream(s.getOutputStream());

    /* read from keyboard*/
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    String str="",str2="";

    while(!str.equals("bye")){
        /*reading from the Keywboard Input */  
        str=br.readLine();
        /*writing the above message/str on the buffer from client side */
        /*since when either side wants to write something..buffer should be flushed */
        dataWrite.writeUTF(str);
        /*flushing the buffer after writing so that we can write again*/
        dataWrite.flush();
        str2=dataRead.readUTF();
        System.out.println("Server says : "+str2);
    }
    dataRead.close();
    s.close();
    }
}