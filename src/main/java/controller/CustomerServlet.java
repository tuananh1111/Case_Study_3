package controller;

import model.Customer;
import model.Supplement;
import service.CustomerService;
import service.SupplementService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "CustomerServlet", urlPatterns = "/home")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private CustomerService service= null;
    public void init(){
        service= new CustomerService();
    }
    NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
    //    nf.format(cake.getPrice())
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action= request.getParameter("action");
        if (action ==null){
            action="";
        }
        switch (action){
            case "edit":
//                editSupplement(request, response);
                break;
            case "search":
                searchSupplement(request, response);
                break;
            case "login":
                loginCustomer(request, response);
                break;
            case "register":
                registerCustomer(request, response);
                break;
            default:
                break;
        }
    }

    private void registerCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name= request.getParameter("name");
        String number= request.getParameter("number");
        String address= request.getParameter("address");
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        Customer customer= new Customer(name, number, address, username, password);
        service.insertCustomer(customer);
        RequestDispatcher dispatcher= request.getRequestDispatcher("customer/register.jsp");
        try {
            request.setAttribute("message","Create a account success !!!");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loginCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name= request.getParameter("username");
        String password= request.getParameter("password");

        List<Supplement> list= service.selectAllSupplement();

        if (name.equals("admin") && password.equals("admin")){
            RequestDispatcher dispatcher= request.getRequestDispatcher("supplement/list.jsp");
            try {
                request.setAttribute("listSupplement",list);
                request.setAttribute("nf",nf);
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{Customer customer= service.selectCustomer(name);
            String pass= service.findPass(name);
            if (name.equals(name) && password.equals(pass)){
                RequestDispatcher dispatcher= request.getRequestDispatcher("customer/home1.jsp");
                request.setAttribute("customer",customer );
                request.setAttribute("listSupplement",list);
                request.setAttribute("nf",nf);
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                RequestDispatcher dispatcher= request.getRequestDispatcher("customer/login1.jsp");
                request.setAttribute("message","Sai thông tin tài khoản hoặc mật khẩu !!!");
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void selectAsc(HttpServletRequest request, HttpServletResponse response) {
        List<Supplement> list= new ArrayList<>();
        list= service.selectAsc();
        RequestDispatcher dispatcher= request.getRequestDispatcher("customer/home1.jsp");
        request.setAttribute("listSupplement",list);
        request.setAttribute("nf",nf);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchSupplement(HttpServletRequest request, HttpServletResponse response) {
        String nameSup= request.getParameter("search");
        List<Supplement> list= new ArrayList<>();
        list= service.searchSupplement(nameSup);
        RequestDispatcher dispatcher= request.getRequestDispatcher("customer/home1.jsp");
        request.setAttribute("nf",nf);
        request.setAttribute("listSupplement",list);
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
        String action= request.getParameter("action");
        if (action ==null){
            action="";
        }
        switch (action){
            case "nutra":
                selectNutrabolics(request,response);
                break;
            case "bpi":
                selectBpi(request,response);
                break;
            case "evogen":
                selectEvogen(request,response);
                break;
            case "desc":
                selectDesc(request,response);
                break;
            case "asc":
                selectAsc(request, response);
                break;
            case "login":
                showFormLogin(request,response);
                break;
            case "register":
                showRegister(request,response);
                break;
            default:
                listSupplement(request, response);
                break;
        }

    }

    private void showRegister(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher= request.getRequestDispatcher("customer/register.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher= request.getRequestDispatcher("customer/login1.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectBpi(HttpServletRequest request, HttpServletResponse response) {
        List<Supplement> list= service.selectBPI();
        RequestDispatcher dispatcher= request.getRequestDispatcher("customer/home1.jsp");
        request.setAttribute("listSupplement",list);
        request.setAttribute("nf",nf);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectNutrabolics(HttpServletRequest request, HttpServletResponse response) {
        List<Supplement> list= service.selectNutrabolics();
        RequestDispatcher dispatcher= request.getRequestDispatcher("customer/home1.jsp");
        request.setAttribute("listSupplement",list);
        request.setAttribute("nf",nf);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectEvogen(HttpServletRequest request, HttpServletResponse response) {
        List<Supplement> list= service.selectEvogen();
        RequestDispatcher dispatcher= request.getRequestDispatcher("customer/home1.jsp");
        request.setAttribute("listSupplement",list);
        request.setAttribute("nf",nf);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectDesc(HttpServletRequest request, HttpServletResponse response) {
        List<Supplement> list= service.selectDesc();
        RequestDispatcher dispatcher= request.getRequestDispatcher("customer/home1.jsp");
        request.setAttribute("listSupplement",list);
        request.setAttribute("nf",nf);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listSupplement(HttpServletRequest request, HttpServletResponse response) {
        List<Supplement> list= service.selectAllSupplement();
        RequestDispatcher dispatcher= request.getRequestDispatcher("customer/home1.jsp");
        request.setAttribute("nf",nf);
        request.setAttribute("listSupplement", list);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
