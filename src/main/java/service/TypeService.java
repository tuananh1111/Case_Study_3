package service;

import model.Company;
import model.TypeOfSupplement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeService implements TService {

    private String jdbcURL= "jdbc:mysql://localhost:3306/dbsupplement?userSSL=false";
    private String jdbcUsername= "root";
    private String jdbcPassword= "0964068256";
    private static final String INSERT_TYPE = "insert into typeofsup values (?,?,?,?);";
    private static final String SEARCH_TYPE = "{call searchType(?)}";

    public TypeService() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertType(TypeOfSupplement type) {
        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(INSERT_TYPE);
            preparedStatement.setString(1, type.getTypeId());
            preparedStatement.setString(2, type.getTypeName());
            preparedStatement.setString(3, type.getTaste());
            preparedStatement.setString(4, type.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateType(TypeOfSupplement type) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update typeofsup set name_type=?, taste=?, status_type=? where type_id=?;");

            preparedStatement.setString(1, type.getTypeName());
            preparedStatement.setString(2, type.getTaste());
            preparedStatement.setString(3, type.getStatus());
            preparedStatement.setString(4, type.getTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteType(String id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from typeofsup where type_id=?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public TypeOfSupplement selectType(String id){
        TypeOfSupplement type = null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from typeofsup where type_id=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ID = resultSet.getString("type_id");
                String name = resultSet.getString("name_type");
                String taste = resultSet.getString("taste");
                String status = resultSet.getString("status_type");
                type= new TypeOfSupplement(ID, name, taste, status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return type;
    }

    @Override
    public List<TypeOfSupplement> selectAllType() {
        List<TypeOfSupplement> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from typeofsup;");
           ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                String id= resultSet.getString("type_id");
                String name= resultSet.getString("name_type");
                String taste= resultSet.getString("taste");
                String status= resultSet.getString("status_type");
                list.add(new TypeOfSupplement(id,name,taste,status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TypeOfSupplement> searchType(String nameType) {
        List<TypeOfSupplement> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            CallableStatement callableStatement= connection.prepareCall(SEARCH_TYPE);
            callableStatement.setString(1, nameType);
            ResultSet resultSet=callableStatement.executeQuery();
            while(resultSet.next()){
                String id= resultSet.getString("type_id");
                String name= resultSet.getString("name_type");
                String taste= resultSet.getString("taste");
                String status= resultSet.getString("status_type");
                list.add(new TypeOfSupplement(id, name, taste,status));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
