package service;

import model.Company;

import java.sql.Connection;
import java.util.List;

public interface CompanyService {
    public void insertCompany(Company company);
    public void updateCompany(Company company);
    public void deleteCompany(String id);
    public List<Company> selectAllCompany();
}
