package ru.geekbrains.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@WebListener
public class AppBootstrapListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(AppBootstrapListener.class);

//    Выполняемые действия при старте приложения
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Initializing application");

//    Задаем параметры подключения к БД из web.xml
        ServletContext sc = sce.getServletContext();
        String jdbcConnectionString = sc.getInitParameter("jdbcConnectionString");
        String username = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");

        try {
//            Подключаемся к БД
            Connection conn = DriverManager.getConnection(jdbcConnectionString, username, password);
            sc.setAttribute("connection", conn); // передаем подключение в атрибуты контекста

//            Создаем интерфей для работы с БД
            ProductRepository productRepository = new ProductRepository(conn);
            sc.setAttribute("productRepository", productRepository);

//             Если список продуктов пуст заполняем значениями поумолчанию
            if (productRepository.findAll().isEmpty()) {
                logger.info("No products in DB. Initializing.");

                productRepository.insert(new Product(
                        -1L, "Apple Macbook pro 2015", "Apple profession laptop", new BigDecimal(3000)));
                productRepository.insert(new Product(
                        -1L, "Apple Macbook air 2015", "Apple netbook", new BigDecimal(2000)));
                productRepository.insert(new Product(
                        -1L, "Apple iPad", "Apple tablet", new BigDecimal(1000)));
            }

        } catch (SQLException ex) {
            logger.error("", ex);
        }
    }

//     Выполняемые действия при завершении приложения
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        Получаем котекст
        ServletContext sc = sce.getServletContext();
//        Получем подключение к БД из атрибутов контекста
        Connection conn = (Connection) sc.getAttribute("connection");
//        Закрываем подключение к БД
        try {
            if (conn != null && conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
    }
}
