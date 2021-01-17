/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SignIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User saveUser = null;
        Gson gson = new Gson();

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }

            System.out.println(jb.toString());

            User user = gson.fromJson(jb.toString(), User.class);
            System.out.println(user.toString());

            UserModel userModel = new UserModel();
            saveUser = userModel.chekIsUser(user.getEmail(), user.getPassword());

        } catch (Exception e) {
            e.printStackTrace();

        }

        JsonObject jsonObject = new JsonObject();
        if (saveUser != null) {

            System.out.println("okk signed in");
            jsonObject.addProperty("status", 200);
            jsonObject.addProperty("data", gson.toJson(saveUser));

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
