/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.res.labo03_prankgenerator;

import config.ConfigurationManager;
import model.prank.Prank;
import model.prank.PrankGenerator;
import smtp.SmtpClient;

import java.io.IOException;
import java.util.List;

public class MailRobot {

   public static void main(String[] args) throws IOException {
      ConfigurationManager manager = new ConfigurationManager();
       
      PrankGenerator prankGenerator = new PrankGenerator(manager);
      
      List<Prank> pranks = prankGenerator.generatePrank();

      SmtpClient smtpClient = new SmtpClient();

      for (Prank prank : pranks) {     
         smtpClient.sendMail(prank);
      }
   }
      

}

