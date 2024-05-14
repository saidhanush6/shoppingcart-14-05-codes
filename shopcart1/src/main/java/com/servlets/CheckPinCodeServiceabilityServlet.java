package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.ConnectionClass;

@WebServlet("/checkPinCodeServiceability")
public class CheckPinCodeServiceabilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Extract product ID and pin code from the request parameters
		String productId = request.getParameter("productId");
		String pincode = request.getParameter("pincode");

		// Perform the pin code serviceability check
		boolean isServiceable = checkServiceability(productId, pincode);

		// Send the response back to the client
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(isServiceable ? "true" : "false");
		out.flush();
	}

	private boolean checkServiceability(String productId, String pincode) {
		boolean isServiceable = false;
		ConnectionClass connectionClass = new ConnectionClass();
		try {
			Connection conn = connectionClass.getconnectDb();
			String sql = "SELECT * FROM dhanush_ServiceableRegions WHERE srrg_pin = ?::INTEGER AND prct_id IN (SELECT Prod_prct_id FROM dhanush_products WHERE Prod_id = ?::INTEGER)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pincode);
			pstmt.setInt(2, Integer.parseInt(productId));
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				isServiceable = true;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return isServiceable;
	}
}
