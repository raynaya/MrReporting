/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Org.MrReporting.Shamik.Filter;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.*;
import javax.servlet.http.*;


public class filter implements javax.servlet.Filter {

    private ArrayList<String>    urlList;
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String url = request.getRequestURI();
        boolean allowedRequest = false;
 System.out.println(url);

        if(urlList.contains(url)) {
            allowedRequest = true;
            System.out.println("in list");

        }

 
        if (!allowedRequest) {
            Object o = request.getSession().getAttribute("UserInfo");
            if (null == o) {
                System.out.println("Hey i am in");
                response.sendRedirect("/login.jsp");
                return ;
            }
        }
 
        chain.doFilter(req, res);
    }
public void init(FilterConfig config) throws ServletException {
        String urls = config.getInitParameter("avoid-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");

    urlList = new ArrayList<String>();

        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());

        }
    System.out.println("here gos the list "+urlList.toString());
    }
public void destroy(){
}
}
