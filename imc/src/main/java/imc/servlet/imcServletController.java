package imc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class imcServletController extends HttpServlet
{
	private String peso(HttpServletRequest req, String param, String padrao)
	{
		String result = req.getParameter(param);
		if (result == null) {result = padrao;}
		return result;
	}
	
	private float toFloat(HttpServletRequest req, String param, String padrao) 
	{
		return Float.parseFloat(peso(req, param, padrao));
	}	


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		float peso = toFloat(req, "peso", "0");
		float altura = toFloat(req, "altura", "0");				

		String resultadoCalculo = imcServletModel.calcularIMC(peso, altura);
		
		req.setAttribute("resultado",resultadoCalculo);

		req.getRequestDispatcher("imcServletView.jsp").forward(req, resp);		
	}
}