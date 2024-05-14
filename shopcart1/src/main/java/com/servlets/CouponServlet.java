package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dal.CouponDAL;
import com.dal.ProductsDAO;
import com.models.Coupons;

@WebServlet("/CouponServlet")
public class CouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductsDAO pdao = new CouponDAL();
		List<Coupons> coup = pdao.getCoupon();

		request.setAttribute("coup", coup);
		// RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
		// rd.forward(request, response);

	}

}
