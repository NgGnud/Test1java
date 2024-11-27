package Servlet;

import Repository.SanPhamRepos;
import com.google.gson.Gson;
import entity.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet", value = "/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    SanPhamRepos sanPhamRepo = new SanPhamRepos();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("da chay vao api");
        Integer id = Integer.parseInt(request.getParameter("id"));
        SanPham sanPham = sanPhamRepo.detail(id);
        Gson gson= new Gson();
        response.setContentType("application/json");
        String Spjson = gson.toJson(sanPham);
        PrintWriter result = response.getWriter();
        result.print(Spjson);
        result.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
