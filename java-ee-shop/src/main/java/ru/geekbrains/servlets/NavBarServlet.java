package ru.geekbrains.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NavBarServlet",urlPatterns = "/nav")
public class NavBarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<!DOCTYPE html>");
        resp.getWriter().println("<html lang="+'"'+"en"+'"'+">");
                resp.getWriter().println("<head>");
                        resp.getWriter().println("<meta charset="+'"'+"UTF-8"+'"'+">");
                                resp.getWriter().println("<title>Title</title>");
                                        resp.getWriter().println("<!-- Bootstrap CSS -->");
                                                resp.getWriter().println("<link rel="+'"'+"stylesheet"+'"'+" href="+'"'+"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"+'"');
        resp.getWriter().println("integrity="+'"'+"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"+'"'+" crossorigin="+'"'+"anonymous"+'"'+">");
                resp.getWriter().println("<link rel="+'"'+"stylesheet"+'"'+" href="+'"'+"https://use.fontawesome.com/releases/v5.3.1/css/all.css"+'"'+"/>");
        resp.getWriter().println("</head>");
                resp.getWriter().println("<body>");
resp.getWriter().println("<ul class="+'"'+"nav justify-content-center"+'"'+">");
    resp.getWriter().println("<li class="+'"'+"nav-item"+'"'+">");
        resp.getWriter().println("<a class="+'"'+"nav-link active"+'"'+" href="+'"'+req.getContextPath()+"/main"+'"'+">Main</a>");
    resp.getWriter().println("</li>");
    resp.getWriter().println("<li class="+'"'+"nav-item"+'"'+">");
        resp.getWriter().println("<a class="+'"'+"nav-link"+'"'+" href="+'"'+req.getContextPath()+"/catalog"+'"'+">Catalog</a>");
    resp.getWriter().println("</li>");
    resp.getWriter().println("<li class="+'"'+"nav-item"+'"'+">");
        resp.getWriter().println("<a class="+'"'+"nav-link"+'"'+" href="+'"'+req.getContextPath()+"/product"+'"'+">Product</a>");
    resp.getWriter().println("</li>");
    resp.getWriter().println("<li class="+'"'+"nav-item"+'"'+">");
        resp.getWriter().println("<a class="+'"'+"nav-link"+'"'+" href="+'"'+req.getContextPath()+"/cart"+'"'+">Cart</a>");
    resp.getWriter().println("</li>");
    resp.getWriter().println("<li class="+'"'+"nav-item"+'"'+">");
        resp.getWriter().println("<a class="+'"'+"nav-link"+'"'+" href="+'"'+req.getContextPath()+"/order"+'"'+">Order</a>");
    resp.getWriter().println("</li>");
resp.getWriter().println("</ul>");
resp.getWriter().println("</body>");
resp.getWriter().println("</html>");
    }
}
