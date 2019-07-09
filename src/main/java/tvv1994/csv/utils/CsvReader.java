package tvv1994.csv.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tvv1994.csv.model.AutoPart1;
import tvv1994.csv.service.AutoPartService;

import java.io.*;
import java.nio.charset.Charset;

@Service
public class CsvReader {

    private String nameFile;
    private String supplier;

    @Autowired
    private AutoPartService service;

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setNameFile(String name) {
        this.nameFile = name;
    }

    public void read() throws IOException {
        FileInputStream fl = new FileInputStream(nameFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fl, Charset.forName("UTF-8")));


        if (supplier.equals("Доставим в срок")) {

            int n=14;
            AutoPart1 autoPart;

            reader.readLine();
            while (reader.ready()) {

                String[] arr = new String[n];
                String s = reader.readLine();
                for(int i = 0; i<n; i++){
                    if(s.indexOf(";")<s.indexOf("\"") || s.indexOf("\"")==-1){
                        if(i!=n-1) {
                            arr[i] = s.substring(0, s.indexOf(";"));
                            s = s.substring(s.indexOf(";") + 1);
                        } else arr[i] = s;
                    } else {
                        if(i!=n-1) {
                            s = s.substring(s.indexOf("\"") + 1);
                            arr[i] = s.substring(0, s.indexOf("\"") - 1);
                            s = s.substring(s.indexOf("\";") + 2);
                        } else arr[i] = s.substring(0, s.indexOf("\"")-1);
                    }
                }

                autoPart = new AutoPart1(arr);
                service.save(autoPart);
            }
            reader.close();
            fl.close();
        }
    }
}
