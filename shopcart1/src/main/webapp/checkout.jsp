<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.models.*" %>
<%@ page import="com.db.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Josefin+Sans">
    <style>
        body {
            font-family: "Josefin Sans", sans-serif;
            background-image: url("sc2.jpg");
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
            background-attachment: fixed;
            color: #fff;
            margin: 0;
            padding: 0;
        }
        .ins {
            color: black;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }
        .card {
            border: 1px solid #dee2e6;
            border-radius: 8px;
            padding: 15px;
            margin-bottom: 15px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .card-content {
            padding: 15px;
        }
        .card h3 {
            font-size: 18px;
            color: #333;
            margin-bottom: 10px;
            text-decoration: underline;
        }
        .card p {
            color: #666;
            margin-bottom: 5px;
        }
        .order-details {
            border: 2px solid #f8f9fa;
            border-radius: 8px;
            padding: 15px;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .order-details h2 {
            color: #333;
            font-size: 24px;
            margin-bottom: 10px;
        }
        .order-details p {
            font-size: 16px;
            color: #333;
            margin-bottom: 5px;
        }
        .back-to-cart {
            display: block;
            width: fit-content;
            margin: 20px auto;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 8px;
            font-weight: bold;
            border: none;
            background-color: #17a2b8;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.25s;
        }
        .coupon-section {
            margin-top: 40px;
        }
        .coupon-section h2 {
            font-size: 20px;
            color: #333;
            margin-bottom: 10px;
        }
        .coupon-section select,
        .coupon-section button {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-right: 10px;
        }
        .coupon-section button {
            background-color: #17a2b8;
            color: #fff;
            cursor: pointer;
        }
        .coupon-section p {
            font-size: 16px;
            color: green;
            display: none;
        }
        #couponDiscount {
            color: green;
        }
    </style>
</head>
<body>
   <div class="container">
        <h2>Order Summary</h2>
        <div>
            <% 
            List<Product> cartItems = (List<Product>) session.getAttribute("cart2");
            double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
            %>
        </div>
        <div class="order-details">
            <h2>Order Details</h2>
            <p>Order ID: <span id="ordid"><%= generateOrderID() %></span></p>
            <p>Order Date: <%= getCurrentDate() %></p>
            <p>Order Subtotal: <%= String.format("%.2f", totalPrice) %></p>
            <% 
            double shippingCharges = 0;
            double shippingTax = 0.0;
            double couponDiscount = 0.0;
            double orderTotal = 0.0;
            if (totalPrice > 0) {
                try {
                    
                	    Shippingamt s =  (Shippingamt)request.getAttribute("shippingAmt");
                	    shippingCharges = s.getOrvl_shippingamount();
                        
                        shippingTax = shippingCharges * 0.05; // 5% GST
                        int selectedDiscount = Integer.parseInt(request.getParameter("couponDiscount")); // Get the selected discount amount
                        couponDiscount = selectedDiscount;
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            %>
            <p>Shipping and Handling: <%=shippingCharges %></p>
            <p>Shipping Tax: <%= String.format("%.2f", shippingTax) %></p>
            <p id="couponDiscount">Coupon Discount: $<%= String.format("%.2f", couponDiscount) %></p>
            <% 
            orderTotal = totalPrice + shippingCharges + shippingTax - couponDiscount;
            %>
            <p>Order Total: <strong id="orto"><%= String.format("%.2f", orderTotal) %></strong></p>
        </div>
        <%
        session.setAttribute("cartItems", cartItems);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("shippingCharges", shippingCharges);
        session.setAttribute("shippingTax", shippingTax);
        session.setAttribute("couponDiscount", couponDiscount);
        %>

        <div class="coupon-section">
            <h2>Add Coupon</h2>
            <div>
                <select id="couponCode" class="form-control">
                    <%
                    List<Coupons> coup = (List<Coupons>) request.getAttribute("coup");
                    for(Coupons c:coup){
                    %>
                    <option value="<%= c.getDiscount_amount() %>"><%= c.getCoupon_id() %> - $<%= c.getDiscount_amount() %> off</option>
                    <%
                    }
                    %>
                </select>
                <button id="applyCouponButton" class="btn btn-primary">Apply Coupon</button>
                <p id="couponSuccessMessage" style="display: none;">Coupon applied successfully!</p>
            </div>
        </div>

        <div class="instruction-section">
            <br>
            <h2>Instructions</h2>
            <p class="ins">Please provide any additional comments or instructions for the seller:</p>
            <textarea id="sellerInstructions" class="form-control" rows="4"></textarea>
        </div>

        <button id="payButton" class="back-to-cart">Payment</button>

        <%!
            String generateOrderID() {
                return "ORD" + (int)(Math.random() * 1000);
            }

            String getCurrentDate() {
                Date currentDate = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return dateFormat.format(currentDate);
            }
        %>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://checkout.razorpay.com/v1/checkout.js"></script>

    <script>
    
        document.addEventListener("DOMContentLoaded", function() {
            document.getElementById("payButton").addEventListener("click", function() {
                initiatePayment();
            });

            function initiatePayment() {
                var orderId = document.getElementById("ordid").innerText;
                console.log(orderId);
                var orderTotal = parseFloat(document.getElementById("orto").innerText); // Parse as float
                var selectedDiscount = parseInt(document.getElementById("couponCode").value); // Get the selected discount amount

                var razorpayOptions = {
                    key: 'rzp_test_x2opF2PLN1VQH0', // Replace with your Razorpay API key
                    amount: orderTotal * 100, // Amount in paisa
                    currency: 'INR',
                    name: 'Burada Dhanush',
                    description: 'Payment for your product',
                    handler: function(response) {
                        alert('Payment successful! Payment ID: ' + response.razorpay_payment_id);
                        window.location.href = 'bill.jsp?couponDiscount=' + selectedDiscount +
                        '&totalAmountAfterCoupon=' + orderTotal +
                        '&OrderId=' + orderId;
                    }
                };

                var rzp1 = new Razorpay(razorpayOptions);
                rzp1.open();
            }

            document.getElementById("applyCouponButton").addEventListener("click", function() {
                applyCoupon();
            });

            function applyCoupon() {
                var selectedDiscount = parseInt(document.getElementById("couponCode").value); // Get the selected discount amount
                var orderTotalElement = document.getElementById("orto");
                var currentOrderTotal = parseFloat(orderTotalElement.innerText); // Parse the current order total as float

                var discountedTotal = currentOrderTotal - selectedDiscount;
                orderTotalElement.innerText = discountedTotal.toFixed(2);

                var couponDiscountElement = document.getElementById("couponDiscount");
                couponDiscountElement.innerText = "Coupon Discount: $" + selectedDiscount;

                document.getElementById("couponSuccessMessage").style.display = "block";
            }
        });
    </script>
</body>
</html>
