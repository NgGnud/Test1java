package Servlet;

import entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value ={
        "/login"
})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/login")){
            String userName = request.getParameter("userName");
            String pass = request.getParameter("pass");
            User valiuser = null;
            for (User user1: User.listus) {
                if (userName.equals(user1.getUserName())){
                    valiuser = user1;
                    break;
                }
            }

            if (valiuser == null){
                request.setAttribute("mes", "UserName không tồn tại");
            } else if (!pass.equals(valiuser.getPass())) {
                request.setAttribute("mes","Pass không đúng");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user",valiuser);
                response.sendRedirect("/sanpham/load");
                return;
            }
            request.getRequestDispatcher("/view/login.jsp").forward(request,response);
        }
    }
}
