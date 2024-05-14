package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.db.ConnectionClass;
import com.models.Coupons;
import com.models.HSNcodes;
import com.models.Product;
import com.models.Shippingamt;

public class ShippingDAL implements ProductsDAO {

	public Shippingamt getShippingAmount(double totalPrice) {
		Shippingamt sa = new Shippingamt();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			ConnectionClass ob = new ConnectionClass();
			Connection conn = ob.getconnectDb();
			String query = "SELECT orvl_shippingamount FROM dhanush_OrderValueRanges WHERE ? BETWEEN orvl_from AND orvl_to";
			stmt = conn.prepareStatement(query);
			stmt.setDouble(1, totalPrice);
			rs = stmt.executeQuery();
			if (rs.next()) {
				sa.setOrvl_shippingamount(rs.getInt("orvl_shippingamount"));
			}

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sa;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByPage(int page, int pageSize, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HSNcodes> getHSNvalues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupons> getCoupon() {
		// TODO Auto-generated method stub
		return null;
	}
}
