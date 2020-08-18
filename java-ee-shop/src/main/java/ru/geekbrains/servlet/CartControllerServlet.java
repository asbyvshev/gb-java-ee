package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.Cart;
import ru.geekbrains.persist.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="CartControllerServlet",urlPatterns = {"/cart/*"})
public class CartControllerServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ProductControllerServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Index cart page");

        String path = req.getServletPath();
        if (path.startsWith("/cart")) {
            path = path.replace("cart", "");
        }

        req.setAttribute("activePage", "cart");

        if (req.getSession().getAttribute("cart")==null){
            req.getSession().setAttribute("cart",new Cart());
        }
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        List<Product> products = cart.getProducts();
//        if (path.equals("/add")){
            Product product = (Product) req.getAttribute("productToCart");
            if (product!=null){
                products.add(product);
            }
//        }
        req.setAttribute("cart",cart);
        getServletContext().getRequestDispatcher("/WEB-INF/cart.jsp").forward(req, resp);
    }
}

