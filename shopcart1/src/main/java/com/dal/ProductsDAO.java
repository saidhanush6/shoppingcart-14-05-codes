package com.dal;

import java.util.List;

import com.models.Coupons;
import com.models.HSNcodes;
import com.models.Product;
import com.models.Shippingamt;

public interface ProductsDAO {

	public List<Product> getProducts();

	public List<Product> getProductsByPage(int page, int pageSize, int offset);

	public List<HSNcodes> getHSNvalues();

	public Shippingamt getShippingAmount(double totalPrice);

	public List<Coupons> getCoupon();
}
