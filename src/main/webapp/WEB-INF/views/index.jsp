<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simple FE</title>
    <!-- Link to CSS in /static/css/styles.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<header>
    <h1>Welcome to Spring Boot + Frontend Example</h1>
</header>
<div class="content">
    <p>Click the button to load booking history</p>
    <button id="loadBookings">Load Bookings</button>
    <div id="bookingsList"></div>
</div>
<!-- Link to JS in /static/js/script.js -->
<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>
