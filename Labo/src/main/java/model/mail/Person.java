/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mail;

/**
 *
 * @author guill
 */
public class Person {
   private final String firstName;
   private final String lastName;
   private final String adress;
   
   public Person(String firstName, String lastName, String adress){
      this.firstName    = firstName;
      this.lastName     = lastName;
      this.adress       = adress;
   }
   
   public Person(String adress){
      this.adress = adress;
      this.firstName = "";
      this.lastName = "";
   }
   
   String getFirstName(){
      return this.firstName;
   }
   String getLastName(){
      return this.lastName;
   }
    public String getAdress(){
      return this.adress;
   }
   
   
}
