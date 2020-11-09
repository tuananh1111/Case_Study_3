package controller;

import model.Company;
import model.Supplement;
import model.TypeOfSupplement;
import service.SupplementService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SupplementServlet" ,urlPatterns = "/supplement")
public class SupplementServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private SupplementService service= null;
    public void init(){
        service= new SupplementService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action= request.getParameter("action");
        if (action ==null){
            action="";
        }
        switch (action){
            case "create":
                insertSup(request, response);
                break;
            case "edit":
                editSupplement(request, response);
                break;
            case "search":
                searchSupplement(request, response);
                break;
            default:
                break;
        }
    }

    private void searchSupplement(HttpServletRequest request, HttpServletResponse response) {
        String nameSup= request.getParameter("search");
        List<Supplement> list= new ArrayList<>();
        list= service.searchSupplement(nameSup);
        RequestDispatcher dispatcher= request.getRequestDispatcher("supplement/search.jsp");
        request.setAttribute("listSupplement",list);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteSupplement(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        try {
            service.deleteSupplement(id);
            List<Supplement> list= service.selectAll();
            request.setAttribute("listSupplement",list);
            RequestDispatcher dispatcher= request.getRequestDispatcher("supplement/list.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
        String action= request.getParameter("action");
        if (action ==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "view":
                viewSupplement(request,response);
                break;
            case "delete":
                deleteSupplement(request,response);
                break;
            default:
                listSupplement(request, response);
                break;
        }
    }

    private void viewSupplement(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        Supplement supplement= service.select(id);
        request.setAttribute("supplement",supplement);
        RequestDispatcher dispatcher= request.getRequestDispatcher("supplement/view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        Supplement supplement= service.select(id);
        RequestDispatcher dispatcher= request.getRequestDispatcher("supplement/edit.jsp");
        request.setAttribute("supplement", supplement);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void  editSupplement(HttpServletRequest request, HttpServletResponse response){
        Integer id=Integer.parseInt( request.getParameter("id"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        Double mass = Double.parseDouble(request.getParameter("mass"));
        Double price = Double.parseDouble(request.getParameter("price"));
        String companyId= request.getParameter("companyid");
        String typeId= request.getParameter("typeid");
        Company company= service.findCompanyById(companyId);
        TypeOfSupplement type= service.findTypeById(typeId);
        Supplement supplement= new Supplement(id,name, image, mass, price, company,type);
        try {
            service.updateSupplement(supplement);
            RequestDispatcher dispatcher= request.getRequestDispatcher("supplement/edit.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher= request.getRequestDispatcher("supplement/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private  void insertSup( HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        Double mass = Double.parseDouble(request.getParameter("mass"));
        Double price = Double.parseDouble(request.getParameter("price"));
        String companyId = request.getParameter("companyId");
        String typeId = request.getParameter("typeId");
        Company company= service.findCompanyById(companyId);
        TypeOfSupplement type= service.findTypeById(typeId);
        try {
            service.insertSupplement( new Supplement(name, image,mass,price,company, type));
            RequestDispatcher dispatcher= request.getRequestDispatcher("supplement/create.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void listSupplement(HttpServletRequest request, HttpServletResponse response) {
        List<Supplement> list= service.selectAll();
        request.setAttribute("listSupplement", list);
        RequestDispatcher dispatcher= request.getRequestDispatcher("supplement/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
