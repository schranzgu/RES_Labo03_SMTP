/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import model.mail.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author guill
 *
 * basé sur http://afnay.com/tutoriel/Java/fichier_properties.php
 */

public class ConfigurationManager {
   private  String smtpServerAdress;
   private  int smtpServerPort;
   private  int numberOfGroups;
   private  String toCC;
   private String sender;
   private  String msgDelimiter;
   
   String victimsFile = "victims.RES.utf8";
   String messagesFile = "message.utf8";
   

   public ConfigurationManager() throws IOException{
      final Properties prop = new Properties();
      InputStream input = null;
    
      
      input = new FileInputStream("config.properties");

      // load the properties file
      prop.load(input);

      // get the property values
      smtpServerAdress = prop.getProperty("smtpServerAdress");
      smtpServerPort = Integer.parseInt(prop.getProperty("smtpServerPort"));
      numberOfGroups = Integer.parseInt(prop.getProperty("numberOfGroups"));
      toCC = prop.getProperty("toCC");
      sender = prop.getProperty("sender");
      msgDelimiter = prop.getProperty("msgDelimiter");
   }
   
   
   public String getSmtpServerAdress(){
      return this.smtpServerAdress;
   }
   public int getSmtpServerPort(){
      return this.smtpServerPort;
   }
   public int getNumberOfGroups(){
      return this.numberOfGroups;
   }
   public String getSender(){
      return this.sender;
   }
   public String getToCC(){
      return this.toCC;
   }
   public String getMsgDelimiter(){
      return this.msgDelimiter;
   }
   
   public List<String> listMails() throws IOException{
      List<String> adress;
      adress =  Files.readAllLines(Paths.get(victimsFile));
      return adress;
   }
   
   public List<String> listMessages() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(messagesFile));
        List<String> messages = new ArrayList<>();

        StringBuilder prank = new StringBuilder();
        for(String line : lines) {
            if(line.compareTo(this.msgDelimiter) == 0) {
                messages.add(prank.toString());
                prank = new StringBuilder();
            }
            else {
                prank.append(line + "\r\n");
            }
        }

        return messages;
    }

}

