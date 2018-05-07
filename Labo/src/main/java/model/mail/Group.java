/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mail;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author guill
 */
public class Group {
   private List<Person> members = new ArrayList<>();
   
   public void addMember(Person newMember){
      members.add(newMember);
   }
   
   public void addMembers(Group newMembers){
      members.addAll(newMembers.getMembers());
   }
   
   public List<Person> getMembers (){
      return this.members; 
   }
   
}
