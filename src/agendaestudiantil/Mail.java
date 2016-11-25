package agendaestudiantil;

import java.util.InputMismatchException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

    public static void sendMail(Tarea t) throws MessagingException {
        // Correo del destinatario
        String to = IO.readMailAdress();
        
        if (to.isEmpty()) {
            throw new InputMismatchException();
        }

        // Correo y contraseña de la cuenta que usamos para enviar el recordatorio
        String from = "agendaestudiantiljava@gmail.com";
        final String username = "agendaestudiantiljava@gmail.com";
        final String password = "proyecto final poo"; // La vida es un riesgo, carnal

        // Usamos el SMTP de Gmail
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", username);
        props.setProperty("mail.smtp.password", password);
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");



        // Inicializamos objeto Sesión
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            DateLabelFormatter df = new DateLabelFormatter();
            
            // Creamos un MimeMessage.
            Message message = new MimeMessage(session);

            // De:
            message.setFrom(new InternetAddress(from));

            // Para:
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Asunto
            message.setSubject("Agenda Estudiantil: " + t.getTarea() + " de " + t.getMateria());

            // Mensaje
            message.setText("Recordatorio: Entregar " + t.getTarea() + " de " + t.getMateria()
                + " el día " + t.getFechaEntrega().toString() );
                       
            // Enviar mensaje
            Transport.send(message);

            System.out.println("Recordatorio de " + t.getTarea() + " enviado con éxito");
            
            DB.setCorreoEnviado(t.getTarea());

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
