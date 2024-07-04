package org.umsa.bo.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import org.umsa.dto.TurnoDTO;
import org.umsa.model.Profesional;
import org.umsa.model.Socio;

import java.util.Properties;

    @ApplicationScoped
    public class EmailBOImpl {
        private static final Logger logger = Logger.getLogger(EmailBOImpl.class);

        @ConfigProperty(name = "mail.smtp.host")
        String smtpHost;

        @ConfigProperty(name = "mail.smtp.port")
        String smtpPort;

        @ConfigProperty(name = "mail.smtp.username")
        String smtpUsername;

        @ConfigProperty(name = "mail.smtp.password")
        String smtpPassword;

        @ConfigProperty(name = "mail.smtp.auth")
        String smtpAuth;

        @ConfigProperty(name = "mail.smtp.starttls.enable")
        String smtpStarttlsEnable;

        public void enviarEmail(String destinatario, TurnoDTO turnoDTO, Socio socio, Profesional profesional) throws MessagingException {
            String asunto = "Confirmación de turno";
            String cuerpo = "Estimado " + socio.getNombre() + " " + socio.getApellido() + ",\n\n" +
                    "Su turno ha sido programado para el " + turnoDTO.getFechaTurno() + " con el Dr. " +
                    profesional.getNombre() + " " + profesional.getApellido() + ".\n\n" +
                    "Motivo de consulta: " + turnoDTO.getMotivoDeConsultaTurno() + "\n\n" +
                    "Saludos,\n" +
                    "Tu Clínica";

            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", smtpHost);
            properties.setProperty("mail.smtp.port", smtpPort);
            properties.setProperty("mail.smtp.auth", smtpAuth);
            properties.setProperty("mail.smtp.starttls.enable", smtpStarttlsEnable);
            properties.setProperty("mail.smtp.ssl.trust", smtpHost);

            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(smtpUsername, smtpPassword);
                }
            });

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(smtpUsername));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);

            Transport.send(message);
        }
    }

