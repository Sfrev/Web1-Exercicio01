package br.ufscar.dc.dsw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Temperatura" })
public class Temperatura extends  HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Exercicio 01 </title>");
            out.println("<style> table {" +
                    "  border-collapse: collapse;" +
                    "  width: 30%;}");
            out.println("td, th {" +
                    "  border: 1px solid #dddddd;" +
                    "  text-align: left;" +
                    "  padding: 8px;}");
            out.println("tr:nth-child(even) {" +
                    "  background-color: #dddddd;}" +
                    "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Celsius</th>");
            out.println("<th>Fahrenheit</th>");
            out.println("</tr>");

            String minValue = request.getParameter("min");
            int min = (minValue == null || minValue.isEmpty()) ? -100 : Integer.parseInt(minValue);

            String maxValue = request.getParameter("max");
            int max = (maxValue == null || maxValue.isEmpty()) ? 100 : Integer.parseInt(maxValue);

            String incValue = request.getParameter("inc");
            int inc = (maxValue == null || incValue.isEmpty()) ? 5 : Integer.parseInt(incValue);

            for (int celsius = min; celsius <= max; celsius += inc)
            {
                double fahr = 1.8 * celsius + 32;
                out.println("<tr>");
                out.println("<td>" + celsius + "</td>");
                out.println("<td>" + fahr + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
