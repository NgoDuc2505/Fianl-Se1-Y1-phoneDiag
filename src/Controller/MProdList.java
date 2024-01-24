package Controller;

import Model.HomeNavigateComponent.Product;

import java.util.ArrayList;
import java.util.List;

public class MProdList {

    private static List<Object[]> listProd = new ArrayList<>();

    private final static int countPerPage = 10;


    public static List<Object[]>  addProd(Product prod){
        Object[] currentList = {prod.getProdId(),prod.getProdName(),prod.getProdImg(),prod.getProdPrice(),prod.getProdDecs(),prod.getQuantity()};
        listProd.add(currentList);
        return listProd;
    }

    public static Product findProdById(String id){
        Product prod = new Product("","","","","",-1);
        for (int i = 0; i < listProd.size(); i++) {
            Object[] currentObj = listProd.get(i);
            Product currentProd = new Product(currentObj[0].toString(),currentObj[1].toString(),currentObj[3].toString(),currentObj[4].toString(),currentObj[2].toString(),(int)currentObj[5]);
            if(currentProd.getProdId().equals(id)){
                prod = currentProd;
                return prod;
            }

        }
        return prod;
    }

    public static List<Object[]> findProdListById(String id){
        List<Object[]> findedList = new ArrayList<>();
        for (int i = 0; i < listProd.size(); i++) {
            Object[] currentObj = listProd.get(i);
            if(currentObj[0].toString().equals(id)){
                findedList.add(currentObj);
            }
        }
        return findedList;
    }

    public static void resetListEmpty(){
        listProd = new ArrayList<>();
    }

    public static List<Object[]> getList(){
        return listProd;
    }

    public static List<Object[]> getListByPage(int page){
        List<Object[]> listByPage = new ArrayList<>();
        int startLoop = 0;
        int endLoop = 0;
        startLoop = countPerPage * (page - 1);
        endLoop = countPerPage * (page - 1) + countPerPage - 1;
        if(endLoop >= listProd.size()){
            endLoop = listProd.size() - 1;
        }
        System.out.println(startLoop);
        System.out.println(endLoop);
        for (int i = startLoop; i <= endLoop ; i++) {
            listByPage.add(listProd.get(i));
        }
        return listByPage;
    }

    public static int getTotalPage(){
        int numberOfItem = listProd.size();
        int result = (numberOfItem / countPerPage) +1;
        return result;
    }

    public static void printList(){
        for (int i = 0; i < listProd.size(); i++) {
            Product currentprod = new Product(listProd.get(i)[0].toString(),listProd.get(i)[1].toString(),listProd.get(i)[3].toString(),listProd.get(i)[4].toString(),listProd.get(i)[2].toString(),(int) listProd.get(i)[5]);
            System.out.println("----------------------");
            System.out.println(currentprod.toString());
        }
    }

}
