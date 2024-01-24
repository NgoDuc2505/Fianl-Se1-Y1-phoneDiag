package Controller;

import Model.Adminstrator;
import Model.HomeNavigateComponent.ItemUI;
import Model.HomeNavigateComponent.ListProdHomeUI;
import Model.HomeNavigateComponent.Product;
import Model.HomeUI;
import Model.LoginUI;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeController {
    private static final HomeUI homeModel = new HomeUI("PhoneDiag");

    private static final ListProdHomeUI listProd = new ListProdHomeUI();

    private static Connection connection;
    private static Statement statement;
    private static ResultSet result;

    private static List<Integer> pageList = new ArrayList<>();

    public static HomeUI renderUI(){
        homeModel.setContentPane(homeModel.getMainContainer());
        homeModel.setSize(1400,700);
        homeModel.setLocation(100,100);
        homeModel.setDefaultCloseOperation(LoginUI.EXIT_ON_CLOSE);
        homeModel.getPageSection().setVisible(false);
        dbConnection();
        return homeModel;
    }
    public static void adminBtnClick(){
        LoginController.renderUI().setVisible(true);
        getListAdmin();
        List<Object[]> listOfProd = MProdList.getList();
        if(listOfProd.size() == 0){
            getListItem();
        }
    }

    private static void dbConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PhoneDiag","root","2505");
            System.out.println("Connected !");
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
            System.out.println("Connect Error");
        }
    }

    private static void clearPageListToEmpty(){
        pageList = new ArrayList<>();
    }

    private static void renderPageComboBox(){
        clearPageListToEmpty();
        int pageNumberTotalCount = MProdList.getTotalPage();
        for (int i = 1; i <= pageNumberTotalCount ; i++) {
            pageList.add(i);
        }
        Integer[] listRs = new Integer[pageList.size()];
        for(int i = 0; i < pageList.size(); i++) {listRs[i] = pageList.get(i);};
        DefaultComboBoxModel modelComboBox = new DefaultComboBoxModel(listRs);
        homeModel.getPageSelection().setModel(modelComboBox);
    }

    public static void getListItem(){
        MProdList.resetListEmpty();
        ResultSet rs = result;
        String query = "SELECT * FROM Product";
        try{
            rs = statement.executeQuery(query);
            while (rs.next()){
                Product prod = new Product(rs.getString(2), rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
                MProdList.addProd(prod);
            }
            System.out.println("Get success!");
            renderPageComboBox();
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error!");
        }
    }

    public static void getListAdmin(){
        MAdminstrator.resetListEmpty();
        String query = "SELECT * FROM Login";
        ResultSet rs = result;
        try{
            rs = statement.executeQuery(query);
            while(rs.next()){
                Adminstrator admin = new Adminstrator(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5));
                MAdminstrator.add(admin);
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error!");
        }
    }


    public static void renderItemProd(int pageIndex){
        listProd.getListProdCenter().removeAll();
        List<Object[]> listByPage = MProdList.getListByPage(pageIndex);
        int count = 0;
        for (int i = 0; i < listByPage.size(); i++) {
            Product currentprod = new Product(listByPage.get(i)[0].toString(),listByPage.get(i)[1].toString(),listByPage.get(i)[3].toString(),listByPage.get(i)[4].toString(),listByPage.get(i)[2].toString(),(int) listByPage.get(i)[5]);
            listProd.getListProdCenter().add(new ItemUI(currentprod.getProdImg(),currentprod.getProdName(),currentprod.getProdPrice(),currentprod.getProdId()).getItemprod());
            count++;
        }
        while (count < 10){
            listProd.getListProdCenter().add(new JPanel());
            count++;
        }
        homeModel.getNavidateHolder().add(listProd.getListProdWrapper());
        homeModel.getNavidateHolder().revalidate();
        homeModel.getNavidateHolder().repaint();
    }

    public static void switchTab(String tabName){
        switch (tabName){
            case "Product List":
                getListItem();
                homeModel.getPageSection().setVisible(true);
                homeModel.getTabTitle().setText(tabName);
                homeModel.getProductListBtn().setForeground(new Color(245,110,94));
                homeModel.getProductListBtn().setFont(new Font(homeModel.getProductListBtn().getFont().getFontName(),Font.ITALIC,14));
                homeModel.getFeaturesButton().setForeground(new Color(232,234,238));
                homeModel.getFeaturesButton().setFont(new Font(homeModel.getFeaturesButton().getFont().getFontName(),Font.BOLD,14));
                homeModel.getNavidateHolder().removeAll();
                listProd.getListProdCenter().removeAll();
                //render list item
                renderItemProd(1);
                break;
            case "Feature Products":
                homeModel.getPageSection().setVisible(false);
                homeModel.getTabTitle().setText(tabName);
                homeModel.getFeaturesButton().setForeground(new Color(245,110,94));
                homeModel.getFeaturesButton().setFont(new Font(homeModel.getFeaturesButton().getFont().getFontName(),Font.ITALIC,14));
                homeModel.getProductListBtn().setForeground(new Color(232,234,238));
                homeModel.getFeaturesButton().setFont(new Font(homeModel.getFeaturesButton().getFont().getFontName(),Font.BOLD,14));
                homeModel.getNavidateHolder().removeAll();
                homeModel.getNavidateHolder().add(homeModel.getContentPanel());
                homeModel.getNavidateHolder().revalidate();
                homeModel.getNavidateHolder().repaint();
                break;
        }
    }


    public static Connection getConnection() {
        return connection;
    }

    public static Statement getStatement() {
        return statement;
    }

    public static ResultSet getResult() {
        return result;
    }
}
