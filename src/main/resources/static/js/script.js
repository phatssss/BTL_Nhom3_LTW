document.getElementById("loadBookings").addEventListener("click", function() {
    fetch('/api/admin/booking') // Giả sử bạn đã có API này trong backend
        .then(response => response.json())
        .then(data => {
            const bookingsList = document.getElementById("bookingsList");
            bookingsList.innerHTML = "";
            if (data.length === 0) {
                bookingsList.innerHTML = "<p>No bookings found</p>";
            } else {
                data.forEach(booking => {
                    const p = document.createElement("p");
                    p.textContent = `Booking ID: ${booking.id}, Flight: ${booking.ticketName}, Status: ${booking.orderStatus}`;
                    bookingsList.appendChild(p);
                });
            }
        })
        .catch(error => {
            console.error("Error fetching bookings:", error);
        });
});
