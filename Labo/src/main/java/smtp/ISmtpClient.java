/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtp;
import model.mail.Message;
import java.io.IOException;

/**
 *
 * @author guill
 */
public interface ISmtpClient {
   public void sendMessage(Message message) throws IOException;
}
