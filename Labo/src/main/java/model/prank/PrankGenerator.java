   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.prank;

import java.util.*;
import config.ConfigurationManager;
import model.mail.*;
import java.io.IOException;
/**
 *
 * @author guill
 */
public class PrankGenerator {
   private ConfigurationManager manager;
   
   public PrankGenerator (ConfigurationManager manager){
      this.manager = manager;
   }
   
   public List<Prank> generatePrank() throws IOException{
      List<Prank> pranks = new ArrayList<>();
      List<String> messages = manager.listMessages();
      List<String> listMails = manager.listMails();
     
      int nbGroups = manager.getNumberOfGroups();
      int nbPersons = listMails.size();
      int nbPersPerGroup = nbPersons/nbGroups;
      
      Prank prank;
      for(int i = 0; i < nbGroups; ++i){
         prank = new Prank();
         prank.addCc(new Person(manager.getToCC()));        
         prank.setSender(new Person(manager.getSender()));
         prank.setMessage(messages.get(i));
         
         for (int j = 0; j < nbPersPerGroup; ++j){
            Person persTemp = new Person(listMails.get(i*nbPersPerGroup + j));
            prank.addVictim(persTemp);
         }
         
         pranks.add(prank);
      }
      
      return pranks;
   }
   
   
   
   
}
