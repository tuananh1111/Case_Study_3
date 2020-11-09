package service;

import model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompanyServiceImpl implements CompanyService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/dbsupplement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "0964068256";
    private static final String INSERT_COMPANY = "insert into company values (?,?,?);";
    private static final String SELECT_COMPANY_BY_ID = "SELECT * FROM company WHERE company_id=?;";
    private static final String SELECT_ALL_COMPANY = "SELECT * FROM company;";
    private static final String DELETE_COMPANY_BY_ID = "DELETE FROM company where company_id=?;";
    private static final String UPDATE_COMPANY = "update company set company_name= ?, company_address=? where company_id= ?;";
    private  static final String SEARCH_COMPANY_BY_ID= "{call searchCompany(?)}";

    public CompanyServiceImpl() {
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
    public void insertCompany(Company company) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMPANY);
            preparedStatement.setString(1, company.getComId());
            preparedStatement.setString(2, company.getComName());
            preparedStatement.setString(3, company.getComAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Company selectCompany(String id) {
        Company company = null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMPANY_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ID = resultSet.getString("company_id");
                String name = resultSet.getString("company_name");
                String address = resultSet.getString("company_address");
                company = new Company(ID, name, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return company;
    }

    @Override
    public List<Company> selectAllCompany() {
        List<Company> list = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMPANY);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("company_id");
                String name = resultSet.getString("company_name");
                String address = resultSet.getString("company_address");
                list.add(new Company(id, name, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateCompany(Company company) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COMPANY);

            preparedStatement.setString(1, company.getComName());
            preparedStatement.setString(2, company.getComAddress());
            preparedStatement.setString(3, company.getComId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteCompany(String id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COMPANY_BY_ID);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Company> searchCompany(String nameCompany){
        List<Company> list= new ArrayList<>();
        Connection connection= getConnection();
        try {
            CallableStatement callableStatement= connection.prepareCall(SEARCH_COMPANY_BY_ID);
            callableStatement.setString(1, nameCompany);
            ResultSet resultSet=callableStatement.executeQuery();
            while(resultSet.next()){
                String id= resultSet.getString("company_id");
                String name= resultSet.getString("company_name");
                String address= resultSet.getString("company_address");
                list.add(new Company(id, name, address));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
