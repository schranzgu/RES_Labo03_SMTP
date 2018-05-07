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
public class Message {
   /*
   from 1x
   to plusieurs
   cc plusieurs 
   bcc ? plusieurs
   subject 1x
   body1x
   */
   private String from;
   private String[] to;
   private String[] cc;
   private String[] bcc;
   private String object;
   private String body;
   
   
   public String getFrom(){
      return this.from;
   }
   
   public void setFrom(String from){
      this.from = from;
   }
   
   public String[] getTo(){
      return this.to;
   }
   
   public void setTo(String[] to){
      this.to = to;
   }
   
   public String[] getCc(){
      return this.cc;
   }
   
   public void setCc(String[] cc){
      this.cc = cc;
   }
   
   public String[] getBcc(){
      return this.bcc;
   }
   
   public void setBcc(String[] bcc){
      this.bcc = bcc;
   }
   
   public String getObject(){
      return this.object;
   }
   
   public void setObject(String object){
      this.object = object;
   }
   
   public String getBody(){
      return this.body;
   }
   
   public void setBody(String body){
      this.body = body;
   }
   
}
