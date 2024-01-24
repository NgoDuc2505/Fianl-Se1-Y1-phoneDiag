package Model;

public class Customer {
    private String nameCus;
    private String adressCus;
    private String phoneCus;

    private String orderdate;


    public Customer(String name, String adress, String phone, String date) {
        this.nameCus = name;
        this.adressCus = adress;
        this.phoneCus = phone;
        this.orderdate = date;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getAdressCus() {
        return adressCus;
    }

    public void setAdressCus(String adressCus) {
        this.adressCus = adressCus;
    }

    public String getPhoneCus() {
        return phoneCus;
    }

    public void setPhoneCus(String phoneCus) {
        this.phoneCus = phoneCus;
    }

    public String getOrderdate() {
        return orderdate;
    }
}
