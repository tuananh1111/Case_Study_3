package controller;

import com.mysql.cj.jdbc.CallableStatement;
import model.Company;
import service.CompanyService;
import service.CompanyServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@WebServlet(name = "CompanyServlet", urlPatterns = "/company")
public class CompanyServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private CompanyServiceImpl companyService;
    public void init(){
        companyService= new CompanyServiceImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action== null){
            action= "";
        }
        switch (action){
            case "create":
                insertCompany(request,response);
                break;
            case "edit":
                editCompany(request,response);
                break;
            case "search":
                searchCompany(request, response);
                break;
            default:
                break;

        }
    }

    private void searchCompany(HttpServletRequest request, HttpServletResponse response) {
        String name= request.getParameter("search");
        List<Company> list= companyService.searchCompany(name);
        request.setAttribute("listCompany", list);
        RequestDispatcher dispatcher= request.getRequestDispatcher("company/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCompany(HttpServletRequest request, HttpServletResponse response) {
        String id= request.getParameter("id");
        String name= request.getParameter("name");
        String address= request.getParameter("address");
        Company company= new Company(id, name, address);
        companyService.updateCompany(company);
        RequestDispatcher dispatcher= request.getRequestDispatcher("company/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void insertCompany(HttpServletRequest request, HttpServletResponse response) {
        String id= request.getParameter("id");
        String name= request.getParameter("name");
        String address= request.getParameter("address");
        Company company= new Company(id, name,address);
        companyService.insertCompany(company);
        RequestDispatcher dispatcher= request.getRequestDispatcher("company/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action== null){
            action= "";
        }
        switch (action){
            case "create":
                showCreateFormCom(request,response);
                break;
            case "edit":
                showEditFormCom(request,response);
                break;
            case "delete":
                deleteCom(request,response);
                break;
            default:
                listCom(request,response);
                break;

        }
    }

    private void deleteCom(HttpServletRequest request, HttpServletResponse response) {
        String id= request.getParameter("id");
        companyService.deleteCompany(id);
        List<Company> list= companyService.selectAllCompany();
        request.setAttribute("listCompany", list );
        RequestDispatcher dispatcher= request.getRequestDispatcher("company/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditFormCom(HttpServletRequest request, HttpServletResponse response) {
        String id= request.getParameter("id");
        Company company= companyService.selectCompany(id);
        RequestDispatcher dispatcher= request.getRequestDispatcher("company/edit.jsp");
        request.setAttribute("company",company);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateFormCom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher= request.getRequestDispatcher("company/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCom(HttpServletRequest request, HttpServletResponse response) {
        List<Company> list = companyService.selectAllCompany();
        request.setAttribute("listCompany", list);
        RequestDispatcher dispatcher= request.getRequestDispatcher("company/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
