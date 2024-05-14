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

public class HSNDAL implements ProductsDAO {

	public List<HSNcodes> getHSNvalues() {
		List<HSNcodes> hsnList = new ArrayList<>();
		try {
			ConnectionClass cc = new ConnectionClass();
			Connection con = cc.getconnectDb();
			PreparedStatement ps = con.prepareStatement("SELECT hsnc_id, hsnc_gstc_percentage FROM dhanush_HSNCodes");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				HSNcodes hsn = new HSNcodes();
				hsn.setHsnc_id(rs.getInt("hsnc_id"));

				hsn.setHsnc_gstc_percentage(rs.getInt("hsnc_gstc_percentage"));

				hsnList.add(hsn);
			}

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return hsnList;
	}

	@Override
	public List<Product> getProducts() {
		return null;
	}

	@Override
	public List<Product> getProductsByPage(int page, int pageSize, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shippingamt getShippingAmount(double totalPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupons> getCoupon() {
		// TODO Auto-generated method stub
		return null;
	}
}
