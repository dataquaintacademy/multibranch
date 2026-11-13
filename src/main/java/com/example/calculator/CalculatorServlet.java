package com.example.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
    private final ArithmeticCalculator calculator = new ArithmeticCalculator();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String message;
        try {
            double left = parseNumber(request.getParameter("left"));
            double right = parseNumber(request.getParameter("right"));
            String operator = request.getParameter("operator");
            double result = calculator.calculate(left, right, operator);
            message = left + " " + operatorSymbol(operator) + " " + right + " = " + result;
        } catch (IllegalArgumentException exception) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = exception.getMessage();
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!doctype html>");
            out.println("<html lang=\"en\"><head><meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("<title>Calculator result</title></head><body>");
            out.println("<main><h1>Calculator result</h1><p>" + message + "</p>");
            out.println("<p><a href=\"" + request.getContextPath() + "/\">Back to calculator</a></p>");
            out.println("</main></body></html>");
        }
    }

    private double parseNumber(String value) {
        try {
            double number = Double.parseDouble(value);
            if (!Double.isFinite(number)) {
                throw new IllegalArgumentException("Enter finite numbers.");
            }
            return number;
        } catch (NullPointerException | NumberFormatException exception) {
            throw new IllegalArgumentException("Enter valid numbers.");
        }
    }

    private String operatorSymbol(String operator) {
        switch (operator) {
            case "add":
                return "+";
            case "subtract":
                return "-";
            case "multiply":
                return "×";
            case "divide":
                return "÷";
            default:
                throw new IllegalArgumentException("Unsupported operation.");
        }
    }
}
