/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;

/**
 *
 * @author abhi
 */
public class GetAllCategories extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Category> categories = new CategoryModel().getCategories();

        Gson gson = new Gson();

        JsonObject jsonObject = new JsonObject();
        if (categories.size() > 0) {
            
            JsonArray array = new JsonArray();
            for (int i = 0; i < categories.size(); i++) {
                JsonObject obj = new JsonObject();
                obj.addProperty("id", categories.get(i).getId());
                obj.addProperty("category", categories.get(i).getCategory());
                obj.addProperty("img", request.getContextPath() + "/resources/categories/" + categories.get(i).getImg());
                
                array.add(obj);
            }

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
