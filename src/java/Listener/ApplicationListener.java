/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashSet;

/**
 *
 * @author shamik
 */
public class ApplicationListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        HashSet s=new HashSet();
       sce.getServletContext().setAttribute("OnlineList", s);

    }

    public void contextDestroyed(ServletContextEvent sce) {

            sce.getServletContext().removeAttribute("OnlineList");
    }

}

