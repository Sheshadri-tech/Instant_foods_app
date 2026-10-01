<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.food.model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Premium Eats | Discover Restaurants</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary: #fc8019;
            --primary-hover: #e27115;
            --text-main: #1c1c1c;
            --text-muted: #686b78;
            --bg-color: #f7f7f7;
            --card-bg: #ffffff;
            --rating-green: #48c479;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Inter', sans-serif;
        }

        body {
            background-color: var(--bg-color);
            color: var(--text-main);
        }

        .navbar {
            background-color: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            position: sticky;
            top: 0;
            z-index: 1000;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 1.2rem 5%;
            box-shadow: 0 2px 15px rgba(0,0,0,0.05);
        }

        .logo {
            font-size: 1.5rem;
            font-weight: 700;
            color: var(--primary);
            text-decoration: none;
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .nav-links {
            display: flex;
            align-items: center;
            gap: 2rem;
        }

        .nav-links a {
            text-decoration: none;
            color: var(--text-main);
            font-weight: 600;
            font-size: 1rem;
            transition: color 0.3s;
        }

        .nav-links a:hover {
            color: var(--primary);
        }

        .btn-signup {
            background-color: var(--primary);
            color: #fff !important;
            padding: 0.6rem 1.5rem;
            border-radius: 8px;
            transition: background-color 0.3s, transform 0.2s;
        }

        .btn-signup:hover {
            background-color: var(--primary-hover);
            transform: translateY(-2px);
        }

        .hero {
            padding: 4rem 5%;
            background: linear-gradient(rgba(0,0,0,0.6), rgba(0,0,0,0.6)), url('https://images.unsplash.com/photo-1504674900247-0877df9cc836?q=80&w=2070&auto=format&fit=crop') center/cover;
            color: white;
            text-align: center;
        }

        .hero h1 {
            font-size: 3rem;
            margin-bottom: 1rem;
        }

        .hero p {
            font-size: 1.2rem;
            font-weight: 300;
            opacity: 0.9;
        }

        .container {
            padding: 4rem 5%;
            max-width: 1400px;
            margin: 0 auto;
        }

        .section-title {
            font-size: 2rem;
            margin-bottom: 2rem;
            color: var(--text-main);
        }

        .grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 2.5rem;
        }

        .card {
            background: var(--card-bg);
            border-radius: 16px;
            overflow: hidden;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            cursor: pointer;
            text-decoration: none;
            display: flex;
            flex-direction: column;
            color: inherit;
        }

        .card:hover {
            transform: translateY(-8px);
            box-shadow: 0 15px 30px rgba(0,0,0,0.1);
        }

        .card-img-wrapper {
            position: relative;
            width: 100%;
            padding-top: 65%;
            overflow: hidden;
        }

        .card-img-wrapper img {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            object-fit: cover;
            transition: transform 0.5s ease;
        }

        .card:hover .card-img-wrapper img {
            transform: scale(1.05);
        }

        .status-badge {
            position: absolute;
            top: 12px;
            left: 12px;
            background-color: rgba(255, 255, 255, 0.9);
            color: var(--rating-green);
            padding: 4px 10px;
            border-radius: 20px;
            font-size: 0.8rem;
            font-weight: 700;
            box-shadow: 0 2px 5px rgba(0,0,0,0.15);
            z-index: 10;
        }
        
        .status-badge.closed {
            color: #d9534f;
        }

        .card-content {
            padding: 1.5rem;
            display: flex;
            flex-direction: column;
            gap: 0.6rem;
        }

        .card-header {
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
        }

        .card-title {
            font-size: 1.25rem;
            font-weight: 700;
            margin-bottom: 0.2rem;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            max-width: 80%;
        }

        .rating {
            background-color: var(--rating-green);
            color: white;
            padding: 0.2rem 0.5rem;
            border-radius: 6px;
            font-weight: 700;
            font-size: 0.9rem;
            display: flex;
            align-items: center;
            gap: 4px;
        }

        .cuisine {
            color: var(--text-muted);
            font-size: 0.95rem;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .address {
            color: var(--text-muted);
            font-size: 0.85rem;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            margin-top: -4px;
        }

        .card-meta {
            display: flex;
            justify-content: space-between;
            color: var(--text-muted);
            font-size: 0.9rem;
            font-weight: 600;
            margin-top: 0.5rem;
            padding-top: 1rem;
            border-top: 1px solid #eee;
        }

        @media (max-width: 768px) {
            .nav-links { gap: 1rem; }
            .hero h1 { font-size: 2rem; }
        }
    </style>
</head>
<body>

    <nav class="navbar">
        <a href="#" class="logo">🍔 Premium Eats</a>
        <div class="nav-links">
            <a href="#">Home</a>
            <a href="#">Profile</a>
            <a href="#">Login</a>
            <a href="#" class="btn-signup">Sign Up</a>
        </div>
    </nav>

    <section class="hero">
        <h1>Discover the Best Food & Drinks</h1>
        <p>Explore top-rated restaurants, cafes, and bars around you.</p>
    </section>

    <div class="container">
        <h2 class="section-title">Restaurants near you</h2>
        <div class="grid">
            <%
                List<Restaurant> allRestaurants = (List<Restaurant>) request.getAttribute("allRestaurants");
                
                if (allRestaurants != null && !allRestaurants.isEmpty()) {
                    for (Restaurant r : allRestaurants) {
            %>
            
            <a href="#" class="card">
                <div class="card-img-wrapper">
                    <div class="status-badge <%= r.isActive() ? "" : "closed" %>">
                        <%= r.isActive() ? "Open Now" : "Closed" %>
                    </div>
                    <img src="<%= (r.getImagePath() != null && !r.getImagePath().trim().isEmpty()) ? r.getImagePath() : "https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?q=80&w=2070&auto=format&fit=crop" %>" alt="Restaurant Image">
                </div>
                <div class="card-content">
                    <div class="card-header">
                        <h3 class="card-title"><%= r.getName() %></h3>
                        <div class="rating"><%= r.getRating() %> ★</div>
                    </div>
                    <p class="cuisine"><%= r.getCuisineType() %></p>
                    <p class="address"><%= r.getAddress() %></p>
                    <div class="card-meta">
                        <span><%= r.getDeliveryTime() %> min</span>
                        <span>₹400 for two</span>
                    </div>
                </div>
            </a>

            <%
                    }
                } else {
            %>
                <p style="grid-column: 1 / -1; text-align: center; font-size: 1.2rem; color: #666;">No restaurants found at the moment.</p>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>