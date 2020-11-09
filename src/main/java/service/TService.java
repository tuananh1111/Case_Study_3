package service;

import model.Company;
import model.TypeOfSupplement;

import java.util.List;

public interface TService {
    public void insertType(TypeOfSupplement type);
    public void updateType(TypeOfSupplement type);
    public void deleteType(String id);
    public List<TypeOfSupplement> selectAllType();
    public List<TypeOfSupplement> searchType(String nameType);
}
