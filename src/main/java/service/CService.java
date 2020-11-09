package service;

import model.Supplement;

import java.util.List;

public interface CService {
    public void viewSupplement(String name);
    public void deleteSupplement(String name);
    public List<Supplement> searchSupplement(String name);
    public List<Supplement> buySupplement(String name);
    public void payOrders();
}
