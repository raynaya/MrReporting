/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Listener;

import java.util.*;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author shamik
 */
public class SessionListener implements HttpSessionListener  {

    public void sessionCreated(HttpSessionEvent se) {
        HashSet gflist=new HashSet();


             gflist.add("Our Mother");
        se.getSession().setAttribute("gflist",gflist);


    }

    public void sessionDestroyed(HttpSessionEvent se) {
       se.getSession().removeAttribute("gflist");
    }

}
