# Design Patterns - Java Project
## State + Strategy + Decorator

---

## Cấu trúc project

```
DesignPatterns/
└── src/
    ├── Main.java                        ← Chạy demo cả 3 bài
    │
    ├── order/                           ← BÀI 1: Quản lý đơn hàng
    │   ├── OrderState.java              ← Interface (State Pattern)
    │   ├── NewOrderState.java           ← Trạng thái: Mới tạo
    │   ├── ProcessingState.java         ← Trạng thái: Đang xử lý
    │   ├── DeliveredState.java          ← Trạng thái: Đã giao
    │   ├── CancelledState.java          ← Trạng thái: Đã hủy
    │   └── Order.java                   ← Context class
    │
    ├── tax/                             ← BÀI 2: Tính thuế sản phẩm
    │   ├── TaxStrategy.java             ← Interface (Strategy Pattern)
    │   ├── VATStrategy.java             ← Thuế VAT 10%
    │   ├── IncomeTaxStrategy.java       ← Thuế tiêu thụ đặc biệt 5%
    │   ├── LuxuryTaxStrategy.java       ← Thuế xa xỉ 20%
    │   └── Product.java                 ← Context class
    │
    └── payment/                         ← BÀI 3: Hệ thống thanh toán
        ├── PaymentStrategy.java         ← Interface (Strategy Pattern)
        ├── CreditCardPayment.java       ← Thanh toán thẻ tín dụng
        ├── PayPalPayment.java           ← Thanh toán PayPal
        ├── PaymentDecorator.java        ← Abstract Decorator
        ├── ProcessingFeeDecorator.java  ← Decorator: Thêm phí xử lý 2%
        ├── DiscountDecorator.java       ← Decorator: Thêm mã giảm giá
        └── PaymentProcessor.java       ← Context class
```

---

## Cách biên dịch và chạy

```bash
# 1. Tạo thư mục output
mkdir -p out

# 2. Biên dịch tất cả file Java
javac -d out -sourcepath src src/Main.java src/order/*.java src/tax/*.java src/payment/*.java

# 3. Chạy chương trình
java -cp out Main
```

---

## Mô tả từng Design Pattern

### 1. STATE PATTERN (Bài 1 - Đơn hàng)
| Trạng thái      | Hành vi processOrder()          | Hành vi cancelOrder()     |
|-----------------|--------------------------------|---------------------------|
| Mới tạo         | Kiểm tra → chuyển Đang xử lý  | Hủy đơn, hoàn tiền        |
| Đang xử lý      | Đóng gói → chuyển Đã giao     | Hủy đơn, hoàn tiền        |
| Đã giao         | Không làm gì                   | Không thể hủy             |
| Đã hủy          | Không làm gì                   | Không làm gì              |

### 2. STRATEGY PATTERN (Bài 2 - Thuế)
| Strategy              | Thuế suất |
|-----------------------|-----------|
| VATStrategy           | 10%       |
| IncomeTaxStrategy     | 5%        |
| LuxuryTaxStrategy     | 20%       |

### 3. STRATEGY + DECORATOR PATTERN (Bài 3 - Thanh toán)
- **Strategy**: CreditCardPayment, PayPalPayment — có thể đổi tại runtime
- **Decorator**: ProcessingFeeDecorator (+2%), DiscountDecorator (x%) — xếp chồng tùy ý

```
// Ví dụ xếp chồng nhiều Decorator:
new ProcessingFeeDecorator(
    new DiscountDecorator(
        new PayPalPayment("email@gmail.com"),
        "VIP15", 15
    )
)
// → Giảm 15% trước, sau đó cộng phí 2%
```
