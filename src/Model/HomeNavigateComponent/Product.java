package Model.HomeNavigateComponent;

public class Product {

    private String prodName;

    private String prodId;
    private String prodPrice;
    private String prodDecs;
    private String prodImg;
    private int quantity;


    public Product(String prodId, String prodName, String prodPrice, String prodDecs, String prodImg, int quantity) {
        this.prodName = prodName;
        this.prodId = prodId;
        this.prodPrice = prodPrice;
        this.prodDecs = prodDecs;
        this.prodImg = prodImg;
        this.quantity = quantity;
    }

    public String getProdName() {
        return prodName;
    }

    public String getProdPrice() {
        return prodPrice;
    }

    public String getProdDecs() {
        return prodDecs;
    }

    public String getProdImg() {
        String[] listOfImg = prodImg.split("-");
        String url = String.join("\\\\",listOfImg);
//        System.out.println("url: "+url);
        return prodImg;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProdId() {
        return prodId;
    }
    public int getProdIdInt() {
        int id = Integer.parseInt(prodId);
        return id;
    }
    @Override
    public String toString() {
        return "Product{" +
                "prodName='" + prodName + '\'' +
                ", prodId='" + prodId + '\'' +
                ", prodPrice='" + prodPrice + '\'' +
                ", prodDecs='" + prodDecs + '\'' +
                ", prodImg='" + prodImg + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
