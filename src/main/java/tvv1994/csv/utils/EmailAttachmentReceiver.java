package tvv1994.csv.utils;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.FromTerm;
import javax.mail.search.SearchTerm;

@Service
public class EmailAttachmentReceiver {

    Path tempDirWithPrefix = Files.createTempDirectory("saveDirectory");
    private String port = "993";
    private String mail;
    private String password;
    private String smail;

    public EmailAttachmentReceiver() throws IOException {
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSmail(String smail) {
        this.smail = smail;
    }

    public Path getTempDirWithPrefix() {
        return tempDirWithPrefix;
    }

    public List<String> downloadEmailAttachments() {
        List<String> listFile = new ArrayList<>();
        String[] strings = mail.split("@");
        String host = "imap." + strings[1];
        Properties properties = new Properties();

        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", port);

        properties.setProperty("mail.imap.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port",
                String.valueOf(port));

        Session session = Session.getDefaultInstance(properties);

        try {
            Store store = session.getStore("imap");
            store.connect(mail, password);

            Folder folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);

            SearchTerm searchTerm = new FromTerm(new InternetAddress(smail));
            Message[] arrayMessages = folderInbox.search(searchTerm);

            for (int i = 0; i < arrayMessages.length; i++) {
                Message message = arrayMessages[i];
                Address[] fromAddress = message.getFrom();
                String from = fromAddress[0].toString();
                String contentType = message.getContentType();
                String messageContent = "";

                String attachFiles = "";

                if (contentType.contains("multipart")) {

                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            String fileName = part.getFileName();
                            if(fileName.contains(".csv")) {
                                listFile.add(fileName);
                                attachFiles += fileName + ", ";
                                part.saveFile(tempDirWithPrefix + File.separator + fileName);
                            }
                        } else {
                            messageContent = part.getContent().toString();
                        }
                    }

                    if (attachFiles.length() > 1) {
                        attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
                    }
                }
                System.out.println("Message #" + (i + 1) + ":");
                System.out.println(from);
                System.out.println("\t Attachments: " + attachFiles);
            }

            folderInbox.close(false);
            store.close();
        } catch (NoSuchProviderException ex) {
            System.out.println("No provider for imap.");
            ex.printStackTrace();
        } catch (MessagingException ex) {
            System.out.println("Could not connect to the message store");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return listFile;
    }
}
