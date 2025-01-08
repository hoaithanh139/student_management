/* resources/static/js/script.js */
function confirmPopup(message) {
    return confirm(message);
}

document.addEventListener("DOMContentLoaded", function() {
    // Lấy tất cả các input quantity và nút "Xóa"
    const quantityInputs = document.querySelectorAll(".quantity-input");
    const removeButtons = document.querySelectorAll(".btn-danger");

    // Tính toán tổng tiền giỏ hàng
    function calculateTotal() {
        let total = 0;
        const rows = document.querySelectorAll(".table tbody tr");

        rows.forEach(row => {
            const price = parseFloat(row.querySelector("td:nth-child(3)").innerText);
            const quantity = parseInt(row.querySelector(".quantity-input").value);
            total += price * quantity;
        });

        document.getElementById("total-price").innerText = total.toFixed(2);
    }

    // Cập nhật tổng giỏ hàng khi thay đổi số lượng
    quantityInputs.forEach(input => {
        input.addEventListener("change", function() {
            calculateTotal();
        });
    });

    // Tính toán tổng tiền giỏ hàng khi trang được tải
    calculateTotal();
});
