package tvv1994.csv.model;

public class AutoPart1{

    private String column1;
    private String vendor;
    private String column3;
    private String description;
    private String column5;
    private String column6;
    private String price;
    private String column8;
    private String count;
    private String column10;
    private String number;
    private String column12;
    private String column13;
    private String column14;

    public AutoPart1(String[] st) {
        this.column1 = st[0];
        this.vendor = st[1];
        this.column3 = st[2];
        this.description = st[3];
        this.column5 = st[4];
        this.column6 = st[5];
        this.price = st[6];
        this.column8 = st[7];
        this.count = st[8];
        this.column10 = st[9];
        this.number = st[10];
        this.column12 = st[11];
        this.column13 = st[12];
        this.column14 = st[13];
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColumn5() {
        return column5;
    }

    public void setColumn5(String column5) {
        this.column5 = column5;
    }

    public String getColumn6() {
        return column6;
    }

    public void setColumn6(String column6) {
        this.column6 = column6;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColumn8() {
        return column8;
    }

    public void setColumn8(String column8) {
        this.column8 = column8;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getColumn10() {
        return column10;
    }

    public void setColumn10(String column10) {
        this.column10 = column10;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColumn12() {
        return column12;
    }

    public void setColumn12(String column12) {
        this.column12 = column12;
    }

    public String getColumn13() {
        return column13;
    }

    public void setColumn13(String column13) {
        this.column13 = column13;
    }

    public String getColumn14() {
        return column14;
    }

    public void setColumn14(String column14) {
        this.column14 = column14;
    }
}
