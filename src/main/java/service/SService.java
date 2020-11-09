package service;

import model.Supplement;

import java.sql.SQLException;
import java.util.List;

public interface SService {
    public void insertSupplement(Supplement supplement) throws SQLException;
    public List<Supplement> selectAll();
    public boolean deleteSupplement(int id) throws SQLException;
    public boolean updateSupplement(Supplement supplement) throws SQLException;
}
