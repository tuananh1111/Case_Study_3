package service;

import model.Company;
import model.Supplement;
import model.TypeOfSupplement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplementService implements SService {
    private String jdbcURL= "jdbc:mysql://localhost:3306/dbsupplement?userSSL=false";
    private String jdbcUsername= "root";
    private String jdbcPassword= "0964068256";
    private static final   String SELECT_ALL_SUPPLEMENT= "select * from supplement";
    private static final String SELECT_COMPANY_BY_ID= "select * from company where company_id=?";
    private static final  String SELECT_TYPE_BY_ID= "select * from typeofsup where type_id=?";
    private static final  String INSERT_SUPPLEMENT= "{call insertSup(?,?,?,?,?,?,?)}";
    private static final  String SELECT_SUPPLEMENT_BY_ID ="select * from supplement where sup_id=?";
    private static final String UPDATE_SUPPLEMENT_BY_ID ="update supplement set name_sup=?, image=?, mass=?, price=?, company_id=?, type_id=? where sup_id=?";
    private static final String UPDATE_SUPPLEMENT_PROCEDURE ="{call updateSupplement(?,?,?,?,?,?,?)}";
    private static final String DELETE_SUPPLEMENT_PROCEDURE= "{call deleteSupplement(?)}";
    private static final String SEARCH_SUPPLEMENT_PROCEDURE= "{call searchSupplement(?)";
    private static final  String SEARCH= "select * from supplement where supplement.name_sup  like concat('%',?,'%');";
    private  static final String SELECT_COMPANY="select * from company;";
    private  static final String SELECT_TYPE="select * from typeofsup;";



    protected Connection getConnection(){
        Connection connection= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public List<Company> selectAllCompany(){
        List<Company> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_COMPANY);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String id= resultSet.getString("company_id");
                String name= resultSet.getString("company_name");
                String address= resultSet.getString("company_address");
                list.add(new Company(id, name, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return list;
    }

    public List<TypeOfSupplement> selectAllType(){
        List<TypeOfSupplement> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_TYPE);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String id= resultSet.getString("type_id");
                String name= resultSet.getString("name_type");
                String taste= resultSet.getString("taste");
                String status= resultSet.getString("status_type");

                list.add(new TypeOfSupplement(id, name, taste,status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return list;
    }

    public Company findCompanyById(String companyId){
        Company company= null;

        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_COMPANY_BY_ID);
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
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_TYPE_BY_ID);
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
    @Override
    public void insertSupplement(Supplement supplement) throws SQLException {
        Connection connection= getConnection();
        CallableStatement callableStatement= connection.prepareCall(INSERT_SUPPLEMENT);
        callableStatement.setInt(1,supplement.getId());
        callableStatement.setString(2,supplement.getName());
        callableStatement.setString(3,supplement.getImage());
        callableStatement.setDouble(4,supplement.getMass());
        callableStatement.setDouble(5,supplement.getPrice());
        callableStatement.setString(6,supplement.getCompany().getComId());
        callableStatement.setString(7,supplement.getType().getTypeId());
        System.out.println(callableStatement);
        callableStatement.executeUpdate();

    }

    @Override
    public List<Supplement> selectAll() {
        List<Supplement> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            PreparedStatement callableStatement= connection.prepareStatement(SELECT_ALL_SUPPLEMENT);
            System.out.println(callableStatement);
            ResultSet resultSet= callableStatement.executeQuery();
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

    @Override
    public boolean deleteSupplement(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection= getConnection();
        CallableStatement callableStatement= connection.prepareCall(DELETE_SUPPLEMENT_PROCEDURE);
        callableStatement.setInt(1,id);
        rowDeleted= callableStatement.executeUpdate()>0;
        return rowDeleted;
    }

    @Override
    public boolean updateSupplement(Supplement supplement) throws SQLException {
       boolean rowUpdate;
        Connection connection= getConnection();
        CallableStatement preparedStatement= connection.prepareCall(UPDATE_SUPPLEMENT_PROCEDURE);

        preparedStatement.setString(1,supplement.getName());
        preparedStatement.setString(2,supplement.getImage());
        preparedStatement.setDouble(3,supplement.getMass());
        preparedStatement.setDouble(4,supplement.getPrice());
        preparedStatement.setString(5,supplement.getCompany().getComId());
        preparedStatement.setString(6,supplement.getType().getTypeId());
        preparedStatement.setInt(7,supplement.getId());
        System.out.println(preparedStatement);
        rowUpdate=preparedStatement.executeUpdate()>0;
        return rowUpdate;

    }
    public Supplement select(int id){
        Supplement supplement= null;
        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_SUPPLEMENT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name_sup");
                String image = resultSet.getString("image");
                Double mass = resultSet.getDouble("mass");
                Double price = resultSet.getDouble("price");
                String companyId= resultSet.getString("company_id");
                String typeId= resultSet.getString("type_id");
                Company company= findCompanyById(companyId);
                TypeOfSupplement type= findTypeById(typeId);

                supplement= new Supplement(name, image,mass, price, company,type);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return supplement;

    }
    public List<Supplement> searchSupplement(String nameSup){
        List<Supplement> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
//            CallableStatement callableStatement= connection.prepareCall(SEARCH_SUPPLEMENT_PROCEDURE);
            PreparedStatement preparedStatement= connection.prepareStatement(SEARCH);

            preparedStatement.setString(1,nameSup);
            ResultSet resultSet= preparedStatement.executeQuery();
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
                list.add(new Supplement(id,name, image,mass,price,company1,type));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
