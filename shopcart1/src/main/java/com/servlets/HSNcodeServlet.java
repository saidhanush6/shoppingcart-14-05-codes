package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dal.HSNDAL;
import com.models.HSNcodes;
import com.models.Product;

@WebServlet("/HSNcodeServlet")
public class HSNcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HSNDAL hsnDal = new HSNDAL();
		List<HSNcodes> hsn = hsnDal.getHSNvalues();

		List<Product> cartItems = (List<Product>) request.getAttribute("cartItems");
		request.setAttribute("hsnvalues", hsn);
		request.setAttribute("cartItems", cartItems);

		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
	}
}
