package com.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;


// http://localhost:8089/lesson1/first_servlet
public class FirstServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(FirstServlet.class);
    private static final float leftLimit = 1F;
    private static final float rightLimit = 1000F;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            float generatedFloat = leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
            Product product = new Product(i, "product" + i, generatedFloat);
            resp.getWriter().printf("%03d. title: %s cost: %5.2f <br>", product.getId() + 1,
                    product.getTitle(), product.getCost());
        }
        resp.getWriter().printf("</body></html>");
    }

    /*
    <html><body>
    <h1>0</h1>
    <h1>1</h1>
    <h1>2</h1>
    <h1>3</h1>
    <h1>4</h1>
    ...
    </body></html>
     */

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}