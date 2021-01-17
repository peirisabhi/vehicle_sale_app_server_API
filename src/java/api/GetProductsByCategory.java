/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductModel;

/**
 *
 * @author abhi
 */
public class GetProductsByCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String category_id = request.getParameter("category_id");
        System.out.println(category_id);
        List<Product> productsByCategory = new ProductModel().getProductsByCategory(Integer.parseInt(category_id));

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        JsonArray array = new JsonArray();
        System.out.println("request >>" + request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length()) + request.getContextPath());
        for (Product p : productsByCategory) {
            JsonObject obj = new JsonObject();
//            System.out.println(p.toString());
            obj.addProperty("id", p.getId());
            obj.addProperty("category", p.getCategory().getCategory());
            obj.addProperty("productName", p.getProductName());
            obj.addProperty("description", p.getDescription());
            obj.addProperty("price", p.getPrice());
            obj.addProperty("img",request.getContextPath()+"/resources/products/"+ p.getImg());
            
            array.add(obj);
        }

        if (productsByCategory.size() > 0) {
            jsonObject.addProperty("status", 200);
            jsonObject.add("data", array);
        } else {
            jsonObject.addProperty("status", 400);
        }

        response.setContentType("text/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.print(jsonObject.toString());
            System.out.println(jsonObject);
        }
    }

}
