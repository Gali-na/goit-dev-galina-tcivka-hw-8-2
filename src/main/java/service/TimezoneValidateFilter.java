package service;


import service.TimeService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/time3")
public class TimezoneValidateFilter implements Filter {
    @Override public void init(FilterConfig filterConfig) throws ServletException { }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String timezoneParam = request.getParameter("ZoneName");
        if (!TimeService.checkTimeZoneValidity(timezoneParam)) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Invalid timezone");
            ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            chain.doFilter(request, response);
        }
    }
}