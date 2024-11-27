package Filter;

import entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/sanpham/*")
public class AuthenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null){
            resp.sendRedirect("/login");

            System.out.println("User in session: " + session.getAttribute("user"));
            return;
        }
        if (user.getRole().equals("admin")){
            System.out.println("khong vao duoc trong nay");
            chain.doFilter(request,response);
        }else{
            if (uri.equals("/sanpham/load")){
                chain.doFilter(request,response);
            }else{
                request.getRequestDispatcher("/view/Staff.jsp").forward(req,resp);
            }
        }
    }
    }
