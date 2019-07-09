package tvv1994.csv.model;

import javax.persistence.*;

@Entity
@Table(name="PRICEITEMS")
public class AutoPart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String vendor;
    private String number;
    private String searchVendor;
    private String searchNumber;
    private String description;
    private double price;
    private int count;

    public AutoPart() {
    }

    public AutoPart(String vendor, String number, String description, String price, String count) {
        this.vendor = vendor;
        this.number = number;

        if(description.length()>512) {
            this.description = description.substring(0, 512);
        } else this.description = description
                ;
        this.price = Double.parseDouble(price.replace(",", "."));

        if(count.contains(">")) {
            this.count = Integer.parseInt(count.replace(">", ""));
        } else if(count.contains("<")){
            this.count = Integer.parseInt(count.replace("<", ""));
        } else if(count.contains("-")) {
            String[] str = count.split("-");
            this.count = Integer.parseInt(str[1]);
        } else this.count = Integer.parseInt(count);

        this.searchVendor=vendor.replaceAll("[^a-zA-Z0-9]","").toUpperCase();
        this.searchNumber=number.replaceAll("[^a-zA-Z0-9]","").toUpperCase();
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getSearchVendor() {
        return searchVendor;
    }

    public void setSearchVendor(String searchVendor) {
        this.searchVendor = searchVendor;
    }

    public String getSearchNumber() {
        return searchNumber;
    }

    public void setSearchNumber(String searchNumber) {
        this.searchNumber = searchNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
