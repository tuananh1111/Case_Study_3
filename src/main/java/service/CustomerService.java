package service;

import model.Company;
import model.Customer;
import model.Supplement;
import model.TypeOfSupplement;

import java.security.PublicKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerService  implements CService{
    private String jdbcURL= "jdbc:mysql://localhost:3306/dbsupplement?useSSL=false";
    private String jdbcUsername = "root";
    private  String jdbcPassword="0964068256";
    private static final String SELECT_SUPPLEMENT_BY_PRICE_ASC="select * from supplement order by price;";
    private static final String SELECT_SUPPLEMENT_BY_PRICE_DESC="select * from supplement order by price desc;";
    private static final String SELECT_SUPPLEMENT_BY_COM01="select * from supplement where company_id='COM01';";
    private static final String SELECT_SUPPLEMENT_BY_COM02="select * from supplement where company_id='COM02';";
    private static final String SELECT_SUPPLEMENT_BY_COM03="select * from supplement where company_id='COM03';";
    private static final  String SEARCH= "select * from supplement where supplement.name_sup  like concat('%',?,'%');";
    private static final String SELECT_ID= "select * from customer where username=?";




    public CustomerService(){
    }
    public Connection getConnection(){
        Connection connection= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public Company findCompanyById(String companyId){
        Company company= null;

        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("select * from company where company_id=?");
            preparedStatement.setString(1,companyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id= resultSet.getString("company_id");
                String name= resultSet.getString("company_name");
                String address= resultSet.getString("company_address");
                company = new Company(id,name,address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return company;

    }
    public TypeOfSupplement findTypeById(String typeId){
        TypeOfSupplement type= null;

        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("select * from typeofsup where type_id=?");
            preparedStatement.setString(1,typeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("type_id");
                String name = resultSet.getString("name_type");
                String taste = resultSet.getString("taste");
                String status = resultSet.getString("status_type");
                type = new TypeOfSupplement(id, name, taste,status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return type;

    }

    public int findId(String username){
        Connection connection= getConnection();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ID);
            preparedStatement.setString(1, username);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                 int id= resultSet.getInt("customer_id");
                 String name= resultSet.getString("customer_name");
                 String number= resultSet.getString("phone_number");
                 String address= resultSet.getString("address_customer");
                 String user= resultSet.getString("username");
                 String pass= resultSet.getString("pass");
                 customer= new Customer(id, name, number, address, user, pass);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer.getCustomerId();
    }

    public String findPass(String name){
        Connection connection= getConnection();
        Customer customer= null;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ID);
            preparedStatement.setString(1, name);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int ID= resultSet.getInt("customer_id");
                String  name1= resultSet.getString("customer_name");
                String number= resultSet.getString("phone_number");
                String address= resultSet.getString("address_customer");
                String user= resultSet.getString("username");
                String pass= resultSet.getString("pass");
                customer= new Customer(ID, name1, number, address, user, pass);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer.getPassword();
    }
    public Customer selectCustomer(String name){
        Connection connection= getConnection();
        Customer customer= null;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ID);
            preparedStatement.setString(1, name);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int ID= resultSet.getInt("customer_id");
                String  name1= resultSet.getString("customer_name");
                String number= resultSet.getString("phone_number");
                String address= resultSet.getString("address_customer");
                String user= resultSet.getString("username");
                String pass= resultSet.getString("pass");
                customer= new Customer(ID, name1, number, address, user, pass);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return customer;
    }

    public void insertCustomer(Customer customer){
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("insert into customer values (?,?,?,?,?,?);");
            preparedStatement.setInt(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getUserName());
            preparedStatement.setString(6, customer.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Supplement> selectAllSupplement(){
        List<Supplement> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("select * from supplement;");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("sup_id");
                String name = resultSet.getString("name_sup");
                String image = resultSet.getString("image");
                double mass = resultSet.getDouble("mass");
                double price = resultSet.getDouble("price");
                String company = resultSet.getString("company_id");
                String type_id = resultSet.getString("type_id");
                Company company1= findCompanyById(company);
                TypeOfSupplement type= findTypeById(type_id);

                list.add(new Supplement(id, name, image,mass,price, company1,type));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public List<Supplement> selectAsc(){
        List<Supplement> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_SUPPLEMENT_BY_PRICE_ASC);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("sup_id");
                String name = resultSet.getString("name_sup");
                String image = resultSet.getString("image");
                double mass = resultSet.getDouble("mass");
                double price = resultSet.getDouble("price");
                String company = resultSet.getString("company_id");
                String type_id = resultSet.getString("type_id");
                Company company1= findCompanyById(company);
                TypeOfSupplement type= findTypeById(type_id);

                list.add(new Supplement(id, name, image,mass,price, company1,type));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public List<Supplement> selectDesc(){
        List<Supplement> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_SUPPLEMENT_BY_PRICE_DESC);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("sup_id");
                String name = resultSet.getString("name_sup");
                String image = resultSet.getString("image");
                double mass = resultSet.getDouble("mass");
                double price = resultSet.getDouble("price");
                String company = resultSet.getString("company_id");
                String type_id = resultSet.getString("type_id");
                Company company1= findCompanyById(company);
                TypeOfSupplement type= findTypeById(type_id);

                list.add(new Supplement(id, name, image,mass,price, company1,type));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Supplement> selectEvogen(){
        List<Supplement> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_SUPPLEMENT_BY_COM02);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("sup_id");
                String name = resultSet.getString("name_sup");
                String image = resultSet.getString("image");
                double mass = resultSet.getDouble("mass");
                double price = resultSet.getDouble("price");
                String company = resultSet.getString("company_id");
                String type_id = resultSet.getString("type_id");
                Company company1= findCompanyById(company);
                TypeOfSupplement type= findTypeById(type_id);

                list.add(new Supplement(id, name, image,mass,price, company1,type));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Supplement> selectBPI(){
        List<Supplement> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_SUPPLEMENT_BY_COM03);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("sup_id");
                String name = resultSet.getString("name_sup");
                String image = resultSet.getString("image");
                double mass = resultSet.getDouble("mass");
                double price = resultSet.getDouble("price");
                String company = resultSet.getString("company_id");
                String type_id = resultSet.getString("type_id");
                Company company1= findCompanyById(company);
                TypeOfSupplement type= findTypeById(type_id);

                list.add(new Supplement(id, name, image,mass,price, company1,type));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Supplement> selectNutrabolics(){
        List<Supplement> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_SUPPLEMENT_BY_COM01);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("sup_id");
                String name = resultSet.getString("name_sup");
                String image = resultSet.getString("image");
                double mass = resultSet.getDouble("mass");
                double price = resultSet.getDouble("price");
                String company = resultSet.getString("company_id");
                String type_id = resultSet.getString("type_id");
                Company company1= findCompanyById(company);
                TypeOfSupplement type= findTypeById(type_id);

                list.add(new Supplement(id, name, image,mass,price, company1,type));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    @Override
    public void viewSupplement(String name) {

    }

    @Override
    public void deleteSupplement(String name) {

    }

    @Override
    public List<Supplement> buySupplement(String name) {
        return null;
    }

    @Override
    public void payOrders() {

    }
    @Override
    public List<Supplement> searchSupplement(String name){
        List<Supplement> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
//            CallableStatement callableStatement= connection.prepareCall(SEARCH_SUPPLEMENT_PROCEDURE);
            PreparedStatement preparedStatement= connection.prepareStatement(SEARCH);

            preparedStatement.setString(1,name);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("sup_id");
                String nameSup = resultSet.getString("name_sup");
                String image = resultSet.getString("image");
                double mass = resultSet.getDouble("mass");
                double price = resultSet.getDouble("price");
                String company = resultSet.getString("company_id");
                String type_id = resultSet.getString("type_id");
                Company company1= findCompanyById(company);
                TypeOfSupplement type= findTypeById(type_id);
                list.add(new Supplement(id,nameSup, image,mass,price,company1,type));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
