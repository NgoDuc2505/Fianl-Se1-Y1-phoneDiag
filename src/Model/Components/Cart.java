package Model.Components;

import Model.HomeNavigateComponent.Product;
import View.DialogMsgBox;


import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static List<Product> cartList = new ArrayList<>();
    private static List<Object[]> listObj = new ArrayList<>();

    public static List<Product> addToCart(Product prod, String quantity){
        int currentQuantity = Integer.parseInt(quantity);
        Product getProd = new Product(prod.getProdId(), prod.getProdName(), prod.getProdPrice(), prod.getProdDecs(), prod.getProdImg(), currentQuantity);
        cartList.add(getProd);
        return cartList;
    }

    public static Product findDuplicateItemInCart(Product currentProd){
        Product prod = new Product("-1","","","","",0);
        for (int i = 0; i < cartList.size(); i++) {
            Product getterProd = cartList.get(i);
            if(currentProd.getProdId().equals(getterProd.getProdId())){
                int getQuantity = getterProd.getQuantity();
                prod = new Product(getterProd.getProdId(),getterProd.getProdName(),getterProd.getProdPrice(),getterProd.getProdDecs(),getterProd.getProdImg(),getQuantity+1);
                cartList.remove(i);
                break;
            }
        }
        return prod;
    }

    public static List<Product> addToCart(Product prod){
        Product findDuplicateProd = findDuplicateItemInCart(prod);
        if (findDuplicateProd.getProdId().equals("-1")){
            int currentQuantity = 1;
            Product getProd = new Product(prod.getProdId(), prod.getProdName(), prod.getProdPrice(), prod.getProdDecs(), prod.getProdImg(), currentQuantity);
            cartList.add(getProd);
            String msg = "Cart has "+ getCartAmountItem();
            DialogMsgBox.runSuccess(msg);
            printList();
            return cartList;
        }else {
            cartList.add(findDuplicateProd);
            String msg = "Cart has "+ getCartAmountItem();
            DialogMsgBox.runSuccess(msg);
            printList();
            return cartList;
        }

    }
    public static List<Product> clearCart(){
        cartList = new ArrayList<>();
        listObj = new ArrayList<>();
        return cartList;
    }

    public static List<Object[]> getListCartObject(){
        listObj = new ArrayList<>();
        for (int i = 0; i < cartList.size(); i++) {
            Product currentProd = cartList.get(i);
            Object[] currentProdObject = {currentProd.getProdId(),currentProd.getProdName(),currentProd.getProdPrice(),currentProd.getQuantity()};
            listObj.add(currentProdObject);
        }
        return listObj;
    }

    public static void printList(){
        System.out.println("==== PRINT LIST ====");
        for (int i = 0; i < cartList.size(); i++) {
            System.out.println(cartList.get(i).toString());
        }
    }

    public static int getCartAmountItem(){
        int totalCountItem = 0;
        for (int i = 0; i < cartList.size(); i++) {
            totalCountItem += cartList.get(i).getQuantity();
        }
        return totalCountItem;
    }

    public static String showTotalBill(){
        int total = 0;
        for (int i = 0; i < cartList.size(); i++) {
            Product prod = cartList.get(i);
            double price = Double.parseDouble(prod.getProdPrice()) * prod.getQuantity();
            total += price;
        }
        String textTotal = total+" $";
        return textTotal;
    }

    public static List<Product> getCartList() {
        return cartList;
    }
}
