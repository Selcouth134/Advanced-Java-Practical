import java.net.*;
import java.io.*;

public class server{
public static void main(String args[])throws Exception{


ServerSocket ss=new ServerSocket(8080);
Socket s=ss.accept();

System.out.println("Connection is Stable now.........");

/*data read*/
DataInputStream dataRead=new DataInputStream(s.getInputStream());

/*data write*/
DataOutputStream dataWrite=new DataOutputStream(s.getOutputStream());

/* read from keyboard*/
BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

String str="",str2="";

while(!str.equals("bye")){
    str=dataRead.readUTF();
    System.out.println("Client says :"+str);
    /*reading from the Keywboard Input */ 
    str2=br.readLine();
    /*writing the above message/str on the buffer from client side */
    /*since when eitherside wants to write something..buffer should be flushed */
    dataWrite.writeUTF(str2);
    /*flushing the buffer after writing so that we can write again*/
    dataWrite.flush();
}
dataRead.close();
s.close();
ss.close();
}
}
