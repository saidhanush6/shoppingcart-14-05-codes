package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.ConnectionClass;
import com.models.Coupons;
import com.models.HSNcodes;
import com.models.Product;
import com.models.Shippingamt;

public class CouponDAL implements ProductsDAO {

	public List<Coupons> getCoupon() {

		List<Coupons> coupList = new ArrayList<>();
		try {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ConnectionClass cc = new ConnectionClass();
			conn = cc.getconnectDb();
			String query = "SELECT coupon_id, discount_amount FROM dhanush_Coupons";
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Coupons c = new Coupons();

				c.setCoupon_id(rs.getString("coupon_id"));
				c.setDiscount_amount(rs.getInt("discount_amount"));

				coupList.add(c);
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return coupList;
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
	public Shippingamt getShippingAmount(double totalPrice) {
		// TODO Auto-generated method stub
		return null;
	}
}
