/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.JsonObject;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mail.Mail;
import model.UserModel;

/**
 *
 * @author abhi
 */
public class ResetPassword extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        JsonObject jsonObject = new JsonObject();
        User chekIsUserAvailable = new UserModel().chekIsUserAvailable(email);
        
        if(chekIsUserAvailable != null){
            String html = " <!doctype html> <html lang='en-US'> <head> <meta content='text/html; charset=utf-8' http-equiv='Content-Type' /> <title>Reset Password Email Template</title> <meta name='description' content='Reset Password Email Template.'> <style type='text/css'> a:hover {text-decoration: underline !important;} </style> </head> <body marginheight='0' topmargin='0' marginwidth='0' style='margin: 0px; background-color: #f2f3f8;' leftmargin='0'> <!--100% body table--> <table cellspacing='0' border='0' cellpadding='0' width='100%' bgcolor='#f2f3f8'style='@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;'> <tr> <td> <table style='background-color: #f2f3f8; max-width:670px;  margin:0 auto;' width='100%' border='0'align='center' cellpadding='0' cellspacing='0'> <tr> <td style='height:80px;'>&nbsp;</td> </tr> <tr> <td style='text-align:center;'> </td> </tr> <tr> <td style='height:20px;'>&nbsp;</td> </tr> <tr> <td> <table width='95%' border='0' align='center' cellpadding='0' cellspacing='0'style='max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);'> <tr> <td style='height:40px;'>&nbsp;</td> </tr> <tr> <td style='padding:0 35px;'> <h1 style='color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;'>You have requested to reset your password</h1> <span style='display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;'></span> <p style='color:#455056; font-size:15px;line-height:24px; margin:0;'> We cannot simply send you your old password. A unique link to reset your password has been generated for you. To reset your password, click the following link and follow the instructions. </p> <a href='http://localhost:8080/AndroidAssignment1Shop/?email="+email+"'style='background:#20e277;text-decoration:none !important; font-weight:500; margin-top:35px; color:#fff;text-transform:uppercase; font-size:14px;padding:10px 24px;display:inline-block;border-radius:50px;'>Reset Password</a> </td> </tr> <tr> <td style='height:40px;'>&nbsp;</td> </tr> </table> </td> <tr> <td style='height:20px;'>&nbsp;</td> </tr> <tr> </tr> <tr> <td style='height:80px;'>&nbsp;</td> </tr> </table> </td> </tr> </table> <!--/100% body table--> </body> </html>";
            boolean status = true;
            try {
                Mail.sendMail(email, "Reset Your Password", html);
            } catch (Exception e) {
                status = false;
                e.printStackTrace();
            }
            
            if (status) {
                jsonObject.addProperty("status", 200);
            }else{
                jsonObject.addProperty("status", 500);
            }
            
        }else{
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "Invalid Email Address");
        }
        
        response.setContentType("text/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.print(jsonObject.toString());
            System.out.println(jsonObject);
        }
        
    }

}
