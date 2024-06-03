import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculateDistance")
public class CalculateDistanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Received POST request to /calculateDistance");

        // Отримайте параметри lat1, lon1, lat2, lon2 з запиту
        double lat1 = Double.parseDouble(request.getParameter("lat1"));
        double lon1 = Double.parseDouble(request.getParameter("lon1"));
        double lat2 = Double.parseDouble(request.getParameter("lat2"));
        double lon2 = Double.parseDouble(request.getParameter("lon2"));

        // Викличте ваш метод обчислення відстані
        double distance = haversine(lat1, lon1, lat2, lon2);

        // Помістіть результат у атрибут запиту
        request.setAttribute("distance", Double.toString(distance));

        // Перенаправте наш запит до jsp-сторінки для відображення результату
        request.getRequestDispatcher("/distanceCalculator.jsp").forward(request, response);
    }

    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371.01; // Радіус Землі в кілометрах

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
}