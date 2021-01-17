/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.net.Proxy.Type.HTTP;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserModel;

/**
 *
 * @author abhi
 */
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean status = true;
        User saveUser = null;

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }

            System.out.println(jb.toString());

            Gson gson = new Gson();

            User user = gson.fromJson(jb.toString(), User.class);
            System.out.println(user.toString());

            user.setCreatedAt(new Date());

            UserModel userModel = new UserModel();
            saveUser = userModel.saveUser(user);

        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }

        JsonObject jsonObject = new JsonObject();
        if (status) {
            jsonObject.addProperty("status", 200);
        } else {
            jsonObject.addProperty("status", 400);
        }

        System.out.println(jsonObject.toString());
//        
//        System.out.println(user);
        response.setContentType("text/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.print(jsonObject.toString());
        }

    }

}
