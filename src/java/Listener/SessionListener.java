/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Listener;

import Org.MrReporting.Shamik.BeanClass.Mr;
import java.util.*;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author shamik
 */
public class SessionListener implements HttpSessionListener  {

    public void sessionCreated(HttpSessionEvent se) {
      


    }

    public void sessionDestroyed(HttpSessionEvent se) {
        Mr a=(Mr) se.getSession().getAttribute("UserInfo");
        String name=a.getLoginId();
  HashSet s= (HashSet)se.getSession().getServletContext().getAttribute("OnlineList");
  s.remove(name);
  
    }

}
