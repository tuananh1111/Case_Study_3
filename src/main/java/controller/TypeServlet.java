package controller;

import model.Company;
import model.TypeOfSupplement;
import service.CompanyServiceImpl;
import service.TypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "TypeServlet", urlPatterns = "/type")
public class TypeServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private TypeService typeService;
    public void init(){
        typeService= new TypeService();
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
                insertType(request,response);
                break;
            case "edit":
                editType(request,response);
                break;
            case "search":
                searchType(request, response);
                break;
            default:
                break;

        }
    }

    private void editType(HttpServletRequest request, HttpServletResponse response) {
        String id= request.getParameter("id");
        String name= request.getParameter("name");
        String taste= request.getParameter("taste");
        String status= request.getParameter("status");
        TypeOfSupplement type= new TypeOfSupplement(id, name, taste, status);
        typeService.updateType(type);
        RequestDispatcher dispatcher= request.getRequestDispatcher("type/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchType(HttpServletRequest request, HttpServletResponse response) {
        String name= request.getParameter("search");
        List<TypeOfSupplement> list= typeService.searchType(name);
        request.setAttribute("listType", list);
        RequestDispatcher dispatcher= request.getRequestDispatcher("type/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertType(HttpServletRequest request, HttpServletResponse response) {
        String id= request.getParameter("id");
        String name= request.getParameter("name");
        String taste= request.getParameter("taste");
        String status= request.getParameter("status");
        TypeOfSupplement type= new TypeOfSupplement(id, name, taste, status);
        typeService.insertType(type);
        RequestDispatcher dispatcher= request.getRequestDispatcher("type/create.jsp");
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
                showCreateFormType(request,response);
                break;
            case "edit":
                showEditFormType(request,response);
                break;
            case "delete":
                deleteType(request,response);
                break;
            default:
                listType(request,response);
                break;

        }
    }

    private void showEditFormType(HttpServletRequest request, HttpServletResponse response) {
        String id= request.getParameter("id");
        TypeOfSupplement type= typeService.selectType(id);
        RequestDispatcher dispatcher= request.getRequestDispatcher("type/edit.jsp");
        request.setAttribute("type",type);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteType(HttpServletRequest request, HttpServletResponse response) {
        String id= request.getParameter("id");
        typeService.deleteType(id);
        List<TypeOfSupplement> list= typeService.selectAllType();
        request.setAttribute("listType", list );
        RequestDispatcher dispatcher= request.getRequestDispatcher("type/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateFormType(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher= request.getRequestDispatcher("type/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void listType(HttpServletRequest request, HttpServletResponse response) {
        List<TypeOfSupplement> list = typeService.selectAllType();
        request.setAttribute("listType", list);
        RequestDispatcher dispatcher= request.getRequestDispatcher("type/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
