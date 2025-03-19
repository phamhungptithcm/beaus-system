# Tổng Quan Hệ Thống
Beaus System là nền tảng toàn diện cung cấp giải pháp mua bán website và UI template, kèm theo tài liệu chi tiết và hệ thống thiết kế hiện đại. Hệ thống được xây dựng theo kiến trúc microservices với các dịch vụ độc lập, giúp mở rộng quy mô, bảo trì dễ dàng và triển khai nhanh chóng các tính năng mới.

## Kiến Trúc Microservices & Các Service Chính
### Các Service Chức Năng
- **Auth Service:**
    - Cung cấp Single Sign-On (SSO) sử dụng OAuth2 và JWT.
    - Tích hợp đăng nhập qua social login như Facebook, Google.
- **Product Service:**
    - Quản lý danh mục sản phẩm, các logic xử lý liên quan.
- **Order Service:**
    - Xử lý giao dịch mua hàng, quản lý đơn hàng từ khâu tạo đơn đến thanh toán.
- **Notification Service:**
    - Trung tâm gửi thông báo nội bộ (in-app) và ngoại vi (email, SMS, push notification).
- **Promotion Service:**
    - Quản lý và phát hành chương trình khuyến mãi, mã giảm giá và các chiến dịch marketing.
- **Payment Service:**
    - Hỗ trợ thanh toán đa kênh: thẻ tín dụng/ghi nợ, Apple Pay, Google Pay, PayPal, đảm bảo tuân thủ tiêu chuẩn bảo mật (PCI-DSS).
- **Search Engine Service:**
    - Cung cấp khả năng tìm kiếm toàn văn bản sử dụng Elasticsearch để nâng cao hiệu quả truy vấn sản phẩm.
- **Customer Service:**
    - Hệ thống tin nhắn tự động và chăm sóc khách hàng, hỗ trợ chat và quản lý phản hồi khách hàng.

### Giao Tiếp và Quản Lý API
- **API Gateway:** Là điểm tiếp nhận truy cập từ bên ngoài, định tuyến yêu cầu tới đúng service và xử lý các tác vụ xác thực, cân bằng tải.
- **Giao thức REST/Message Queue:** Các dịch vụ liên kết với nhau qua API RESTful và hệ thống message broker như Kafka để đảm bảo tính đồng bộ và giảm độ trễ trong giao tiếp.

## Tech Stack
Để đảm bảo hiệu suất, bảo mật và khả năng mở rộng, Beaus System áp dụng các công nghệ tiên tiến sau:

### Backend:
- **Java 8:** Ngôn ngữ lập trình chủ đạo.
- **Spring Boot:** Xây dựng các microservice một cách nhanh chóng và hiệu quả.
- **Spring Cloud:** Quản lý cấu hình, service discovery, và routing giữa các microservice.
- **Spring AI:** (nếu áp dụng) tích hợp các giải pháp AI để tối ưu hóa hệ thống, dự báo hành vi người dùng.
- **Kafka:** Hệ thống message broker cho việc giao tiếp bất đồng bộ giữa các dịch vụ.
- **Redis:** Cache và lưu trữ dữ liệu tạm thời, tăng tốc độ truy cập.
- **Postgres:** Hệ quản trị cơ sở dữ liệu quan hệ, đảm bảo tính toàn vẹn dữ liệu.

### Search:
- **Elastic Search:** Cung cấp khả năng tìm kiếm toàn văn bản với tốc độ và độ chính xác cao.

### Frontend:
- **Angular:** Phát triển giao diện web hiện đại, responsive.
- **Flutter:** (nếu cần thiết) xây dựng ứng dụng di động đa nền tảng.

### Hạ tầng & Cloud:
- **AWS/Oracle Cloud:** Đảm bảo khả năng mở rộng và độ ổn định cho hệ thống.
- **Cloudflare:** Tăng cường bảo mật, bảo vệ và tối ưu hóa hiệu năng website.

## CI/CD và Source Control
### CI/CD Pipeline
- **Docker:**
    - Đóng gói ứng dụng và các dịch vụ dưới dạng container, đảm bảo môi trường nhất quán giữa các giai đoạn phát triển, kiểm thử và triển khai.
- **Kubernetes:**
    - Quản lý và orchestrate các container, đảm bảo khả năng mở rộng và tính sẵn sàng cao cho hệ thống.
- **GitHub Action:**
    - Tự động hóa quy trình kiểm thử, build và triển khai, giúp giảm thiểu sai sót và tăng tốc độ đưa sản phẩm ra thị trường.

### Source Control
- **GitHub:**
    - Quản lý mã nguồn, hỗ trợ hợp tác nhóm và kiểm soát phiên bản, đảm bảo quy trình phát triển minh bạch và theo dõi thay đổi hiệu quả.

## Tiêu Chuẩn Phát Triển & Checklist
- **Clean Code:**
    - Mã nguồn được viết rõ ràng, dễ đọc, dễ bảo trì, giảm thiểu lỗi và tăng khả năng mở rộng.
- **Clean Architecture:**
    - Thiết kế kiến trúc hệ thống theo nguyên tắc SOLID, đảm bảo sự tách biệt rõ ràng giữa các lớp, module và tầng logic.
- **Best Practice:**
    - Tuân thủ các tiêu chuẩn phát triển phần mềm hiện đại, kiểm thử tự động, code review và documentation đầy đủ.
- **Checklist Phát Triển:**
    - Tất cả các đoạn code và module được triển khai phải tuân thủ các quy chuẩn clean code, clean architecture và các best practices của ngành để đảm bảo chất lượng và tính ổn định của hệ thống.
