package servlets;

import service.TimeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/time3")
public class TimeServletТask3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String timezoneParam = req.getParameter("ZoneName");
        resp.setContentType("text/html charset=utf-8 ");
        PrintWriter writer = resp.getWriter();
        writer.write(TimeService.getTimeDateTimeZoneByZoneId(timezoneParam));
        writer.close();

    }
}
