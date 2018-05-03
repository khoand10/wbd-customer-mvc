package controller;

import bean.Customer;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletCustomer", urlPatterns = "/customer")
public class ServletCustomer extends HttpServlet {
    CustomerServiceImpl service = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String method = request.getParameter("method");
//        int id = Integer.parseInt(request.getParameter("id"));
//        switch (method) {
//            case "edit":
//                request.setAttribute("customerDetail", service.findById(id));
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        if (method == null) {
            method = "";
        }
        switch (method) {
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("customerDetail", service.findById(id));
                request.setAttribute("customers", service.findAll());
                break;
            case "delete":
                service.remove(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("customers", service.findAll());
                break;
            case "info":
                int id_info = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("user_info",service.findById(id_info));
                requestDispatcher = request.getRequestDispatcher("info.jsp");
                break;
            case "create":
                int id_save = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                if ((service.findById(id_save)) == null) {
                    service.save(new Customer(id_save, name, email, address));
                } else {
                    service.update(id_save, new Customer(id_save, name, email, address));
                }
                request.setAttribute("customers", service.findAll());
                break;
            default:
                request.setAttribute("customers", service.findAll());
        }
        requestDispatcher.forward(request, response);
    }
}
