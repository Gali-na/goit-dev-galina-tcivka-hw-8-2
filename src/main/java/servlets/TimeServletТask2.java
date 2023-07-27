package servlets;

import service.TimeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/time2")
public class TimeServletТask2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String form = "<form  method=post>" +
                "Time Zone: <input type=text name=ZoneName><br>" +
                "<input type=submit value=Submit>" +
                "</form>";
        resp.setContentType("text/html charset=utf-8 ");
        PrintWriter writer = resp.getWriter();
        writer.write(form);
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        InputStream inputStream = req.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        String requestBodyString = requestBody.toString();
        String[] requests = requestBodyString.split("=");
        String nameTimeZone = requests[1];
        PrintWriter writer = resp.getWriter();
        if(TimeService.checkTimeZoneValidity(nameTimeZone)){
        String currentTimeDateZone = TimeService.getTimeDateTimeZoneByZoneId(nameTimeZone);
        writer.write(currentTimeDateZone);
        writer.close();
        }else{
            writer.write(TimeService.getTimeDateByUTC());
            writer.close();
        }
    }
}