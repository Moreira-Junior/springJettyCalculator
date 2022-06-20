package com.MoreiraJunior.cloud.tema4.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.MoreiraJunior.cloud.tema4.appConfig.AppConfig;
import com.MoreiraJunior.cloud.tema4.calculator.Calculator;
import com.MoreiraJunior.cloud.tema4.history.History;
import com.MoreiraJunior.cloud.tema4.operations.Operation;

@WebServlet(urlPatterns = "/Calculator")
public class CalculatorServlet extends HttpServlet {
	
	public static final ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    public static final Calculator calculator = (Calculator) ac.getBean("createCalculator");
    public static final History history = (History) ac.getBean("createHistory");
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(
        		"<html>\n"
        		+ "    <head>\n"
        		+ "        <title>Calculator</title>\n"
        		+ "        \n"
        		+ "\n"
        		+ "        \n"
        		+ "    </head>\n"
        		+ "    <body>\n"
        		+ "<h1> Hi! This is the web calculator developed by Moreira-Junior</h1>"
        		+ "        <form action=\"Calculator\" method=\"get\" name=\"frm\">\n"
        		+ "        \n"
        		+ "               Enter num1:\n"
        		+ "               <input name=\"number1\" type=\"text\" />\n"
        		+ "            \n"
        		+ "\n"
        		+ "                Enter num2:\n"
        		+ "               <input name=\"number2\" type=\"text\" />\n"
        		+ "            \n"
        		+ "           \n"
        		+ "               Operator\n"
        		+ "                \n"
        		+ "                <input name=\"op\" type=\"submit\" value=\"add\" />\n"
        		+ "                <input name=\"op\" type=\"submit\" value=\"sub\" />\n"
        		+ "                <input name=\"op\" type=\"submit\" value=\"mult\" />\n"
        		+ "                <input name=\"op\" type=\"submit\" value=\"div\" />\n"
        		+ "                <input name=\"op\" type=\"submit\" value=\"pow\" />\n"
        		+ "            \n"
        		+ "        </form>\n"
        		);
        if(request == null || request.getParameter("number1") == null || request.getParameter("number1").isEmpty() ||
        		request.getParameter("number2") == null || request.getParameter("number2").isEmpty()) {
        	writer.println("</body>\n</html>");
        }
        else {
        	if(request.getParameter("number1").matches("[0-9]+") && request.getParameter("number2").matches("[0-9]+")){
        		double number1 = Double.parseDouble(request.getParameter("number1"));
        		double number2 = Double.parseDouble(request.getParameter("number2"));   
        		String chosenOperation = request.getParameter("op");
        		double result = 0;
        		try {
        			switch (chosenOperation) {
        			case "add":
        				Operation sum = (Operation) ac.getBean("sum");
        				result = calculator.calculate(number1, number2, sum);
        				break;
        			case "sub":
        				Operation sub = (Operation) ac.getBean("sub");
        				result = calculator.calculate(number1, number2, sub);
        				break;
        			case "mult":
        				Operation mult = (Operation) ac.getBean("mult");
        				result = calculator.calculate(number1, number2, mult);
        				break;
        			case "div":
        				Operation div = (Operation) ac.getBean("div");
        				result = calculator.calculate(number1, number2, div);
        				break;
        			case "pow":
        				Operation pow = (Operation) ac.getBean("pow");
        				result = calculator.calculate(number1, number2, pow);
        				break;
        			}
        		}
        		catch(Exception e) {
        			writer.println(e.getMessage());
        		}
        		writer.println("<h4>Result is: "+result+"</h4>");
        		writer.println("<h4> History: "+history.getHistory()+"</h4>");
        		writer.println("</body>\n</html>");
        	}
        	else {
        		writer.println("<h4>Please enter just numbers!</h4>");
        		writer.println("</body>\n</html>");
        	}
        }
    }
}
