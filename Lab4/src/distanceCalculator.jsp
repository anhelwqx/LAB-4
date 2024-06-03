<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Distance Calculator</title>
</head>
<body>
    <h1>Distance Calculator</h1>
    <form action="/calculateDistance" method="post">
        <label for="lat1">Latitude 1:</label>
        <input type="text" name="lat1" id="lat1"><br>
        <label for="lon1">Longitude 1:</label>
        <input type="text" name="lon1" id="lon1"><br>
        <label for="lat2">Latitude 2:</label>
        <input type="text" name="lat2" id="lat2"><br>
        <label for="lon2">Longitude 2:</label>
        <input type="text" name="lon2" id="lon2"><br>
        <input type="submit" value="Calculate Distance">
    </form>
    <%
        String distance = (String) request.getAttribute("distance");
        if (distance != null) {
            out.println("<p>Distance: " + distance + " km</p>");
        }
    %>
</body>
</html>
