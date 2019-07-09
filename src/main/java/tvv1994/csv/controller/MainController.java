package tvv1994.csv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tvv1994.csv.utils.CsvReader;
import tvv1994.csv.utils.EmailAttachmentReceiver;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private CsvReader csvReader;

    @Autowired
    private EmailAttachmentReceiver receiver;

    @PostMapping("/load")
    public String add(@RequestParam String mail, @RequestParam String password, @RequestParam String smail, @RequestParam String supplier, Model model) throws IOException {

        if(!mail.isEmpty() && !mail.equals("") && !password.isEmpty() && !password.equals("")
                && !smail.isEmpty() && !smail.equals("") && !supplier.isEmpty() && !supplier.equals("")) {
            receiver.setMail(mail);
            receiver.setPassword(password);
            receiver.setSmail(smail);

            try {
                for (String name : receiver.downloadEmailAttachments()) {
                    csvReader.setNameFile(receiver.getTempDirWithPrefix().toString()+"/"+name);
                    csvReader.setSupplier(supplier);
                    csvReader.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IOException("Поля не должны быть пустыми!");
        }
        return "index";
    }
}
