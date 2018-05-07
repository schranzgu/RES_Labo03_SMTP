/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp;
import model.prank.*;

import config.ConfigurationManager;
import java.io.*;
import java.net.Socket;
import model.mail.*;


/**
 *
 * @author guill
 */
public class SmtpClient { // implements ISmtpClient{
   
   
   public void sendMail(Prank message) throws IOException{
      
      PrintWriter writer;
      ConfigurationManager config = new ConfigurationManager();
      Socket socket = new Socket(config.getSmtpServerAdress(), config.getSmtpServerPort());
      writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
      
      writer.print         ("EHLO you\r\n");
      System.out.print     ("EHLO you\r\n");
      writer.flush();

      writer.print         ("MAIL FROM: " + message.getSender().getAdress()+ "\r\n"); 
      System.out.print     ("MAIL FROM: " + message.getSender().getAdress()+ "\r\n");
      writer.flush();
      
      
      for(Person to : message.getVictims().getMembers()){
         writer.print      ("RCPT TO: " + to.getAdress() + "\r\n");
         System.out.print  ("RCPT TO: " + to.getAdress() + "\r\n");
         writer.flush();
         
      }
      
      for(Person toCC : message.getCcs().getMembers()){
         writer.print      ("RCPT TO: " + toCC.getAdress() + "\r\n");
         System.out.print  ("RCPT TO: " + toCC.getAdress() + "(cc)" + "\r\n");
         writer.flush();
         
      }

      writer.print         ("DATA\r\n");
      System.out.print     ("DATA\r\n");
      writer.flush();
      
      writer.print         ("From: " + message.getSender().getAdress()+ "\r\n");      
      System.out.print     ("From: " + message.getSender().getAdress()+ "\r\n");
      writer.flush();     

      writer.print         ("To: " + message.getVictims().getMembers().get(0).getAdress());
      System.out.print     ("To: " + message.getVictims().getMembers().get(0).getAdress());
      
      for(int i = 1; i < message.getVictims().getMembers().size(); ++i){
         writer.print      (", " + message.getVictims().getMembers().get(i).getAdress());
         System.out.print  (", " + message.getVictims().getMembers().get(i).getAdress());
      }
      
      writer.print         ("\r\n");
      System.out.print     ("\r\n");
      writer.flush();
      
      writer.print         ("Cc: " + message.getCcs().getMembers().get(0).getAdress());
      System.out.print     ("Cc: " + message.getCcs().getMembers().get(0).getAdress());
      
      for(int i = 1; i < message.getCcs().getMembers().size(); ++i){
         writer.print      (", " + message.getCcs().getMembers().get(i).getAdress());
         System.out.print  (", " + message.getCcs().getMembers().get(i).getAdress());
      }
      
      writer.print         ("\r\n");
      System.out.print     ("\r\n");
      writer.flush();   
      
      String messageToSplit = message.getMessage();
      String[] parts = messageToSplit.split("#");
      String subject = parts[0];
      String body = parts[1];
      
      writer.print         ("Subject: " + subject + "\r\n");
      System.out.print     ("Subject: " + subject + "\r\n");
      writer.flush();
      

      writer.print         ("\r\n");
      System.out.print     ("\r\n");
      writer.flush();

      writer.print         (body+ "\r\n");
      System.out.print     (body+ "\r\n");
      writer.flush();

      writer.print         (".\r\n");
      System.out.print     (".\r\n");
      writer.flush();
      
      writer.print         ("quit\r\n");
      System.out.print     ("quit\r\n");
      writer.flush();
      
      System.out.println("Pressez enter pour envoyer le mail suivant !");
      System.in.read();
      writer.close();
   }
}
