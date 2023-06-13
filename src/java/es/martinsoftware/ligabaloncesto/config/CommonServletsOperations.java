/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.martinsoftware.ligabaloncesto.config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author G14
 */
public class CommonServletsOperations extends HttpServlet{

    public CommonServletsOperations() {
       
    }
    
    protected boolean checkSession(HttpSession session){
        boolean ret = false;
        return ret;
    }

    @Override
    public void init() throws ServletException {
        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    

}
