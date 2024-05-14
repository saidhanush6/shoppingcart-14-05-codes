package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dal.ProductsDAO;
import com.dal.ShippingDAL;
import com.models.Shippingamt;

@WebServlet("/ShippingServlet")
public class Shippingservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String totalPriceStr = request.getParameter("totalPrice");
		double totalPrice = Double.parseDouble(totalPriceStr);
		System.out.println(totalPrice);

		ProductsDAO pd = new ShippingDAL();
		Shippingamt shippingAmt = pd.getShippingAmount(totalPrice);

		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("shippingAmt", shippingAmt);
		RequestDispatcher rd1 = request.getRequestDispatcher("CouponServlet");
		rd1.include(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
		rd.forward(request, response);
	}

}
