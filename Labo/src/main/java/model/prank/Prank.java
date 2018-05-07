/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.prank;

import model.mail.*;

/**
 *
 * @author guill
 */
public class Prank {
   private Person sender;
   private String message;
   private Group victims;
   private Group cc;
   
   public Prank(){
      sender = null;
      message = null;
      victims = new Group();
      cc = new Group();
   }
   
   public Person getSender(){
      return this.sender;
   }
   
   public void setSender(Person sender){
      this.sender = sender;
   }
   
   public Group getVictims(){
      return this.victims;
   }
   
   public void addVictim(Person newVictim){
      this.victims.addMember(newVictim);
   }
   
   public void addVictims(Group newVictims){
      this.victims.addMembers(newVictims);
   }
   
   public Group getCcs(){
      return this.cc;
   }
   
   public void addCc(Person newCc){
      this.cc.addMember(newCc);
   }
   
   public void addCcs(Group newCcs){
      this.cc.addMembers(newCcs);
   }
   
   public String getMessage(){
      return this.message;
   }
   
   public void setMessage(String message){
      this.message = message;
   }
}
