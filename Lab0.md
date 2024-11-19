![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3fTZJcPogeAkdO9JVfALGaHcda9onk45-Ln0he8kK1WiRwNW319KI7guQs4UcXQFmrjo5V8IAo6I2YKP3tVjLyW3ghP7DyCl_V22IeKCcFhaXxkN9ogK7DwIgV1mzzGyBeVKl1IGYm00003__mC0)
![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bToJc9niO9ZNcPkOev2DPS22EGbvgPQAGIN56NcfKD4YWjI4xCrDAqKml8pKxXgeRfSyjCLKYjAKlDIq4r8IYm2AtS_lAWKJ825uHgT4qi8QFHDpGTXe60jbmDG7SYf00000F__0m00)
![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3XUOmMNbb_5mrze2XP332p8LiZFo7-vQd6SD5yq5aYL0uOUxLfPQSsMcAMX09OvCFBmhBrsX14cNGjdX1IWQx3KLIZ9IynGqaWzlrkHI00AhaABIIeLai0ab6OSNv6Ke91_UafTkpPMQKvoge96T0U91rJeztBKm3sJHOeKyYAN5YPceDeAexSbehapDIybC0_eklu3B0SW6UHK0003__mC0)

1. Phân tích kiến trúc hệ thống
-- Kiến trúc đề xuất:
Mô hình Client-Server kết hợp với kiến trúc 3 lớp (Three-tier architecture):
  * Lớp trình bày (Presentation Layer): Giao diện người dùng (UI) chạy trên máy tính cá nhân của sinh viên, giáo viên, và quản trị viên. Giao diện này sẽ tuân thủ chuẩn Windows 95/98 như được yêu cầu.
  * Lớp ứng dụng (Application Layer): Máy chủ ứng dụng (Application Server) chịu trách nhiệm xử lý logic nghiệp vụ như đăng ký môn học, tính toán chi phí, kiểm tra điều kiện tham gia khóa học, và xử lý dữ liệu.
  * Lớp dữ liệu (Data Layer): Bao gồm cơ sở dữ liệu khóa học hiện tại (Ingres RDBMS) trên hệ thống DEC VAX và các cơ sở dữ liệu mới có thể được thêm để quản lý thông tin sinh viên, lịch học, và bảng điểm.

-- Lý do lựa chọn kiến trúc này:
Khả năng mở rộng: Kiến trúc 3 lớp dễ dàng mở rộng khi số lượng sinh viên, giáo viên, hoặc dữ liệu tăng lên.
  * Tích hợp hệ thống cũ: Kiến trúc hỗ trợ việc truy cập vào cơ sở dữ liệu khóa học cũ thông qua giao diện SQL mở, đáp ứng yêu cầu tích hợp.
  * Phân chia nhiệm vụ: Giảm tải cho lớp trình bày bằng cách chuyển logic xử lý xuống lớp ứng dụng, đồng thời đảm bảo dữ liệu được bảo mật tại lớp dữ liệu.
  * Hiệu năng: Hỗ trợ tới 2000 người dùng đồng thời như yêu cầu và tối ưu hóa truy vấn đến cơ sở dữ liệu cũ bằng xử lý trung gian tại lớp ứng dụng.

-- Các thành phần kiến trúc chính:
Client (Sinh viên/Giảng viên/Quản trị viên):
Giao diện desktop cho phép thực hiện các tác vụ như đăng nhập, chọn khóa học, xem bảng điểm.
Application Server:
  * Module Đăng ký khóa học: Đảm bảo việc xử lý đăng ký khóa học, kiểm tra số lượng sinh viên tham gia, và xử lý thay đổi trong thời gian add/drop.
  * Module Xử lý bảng điểm: Cung cấp khả năng nhập điểm của giảng viên và xem điểm của sinh viên.
  * Module Bảo mật: Quản lý quyền truy cập, đảm bảo dữ liệu được bảo mật.
Database Layer:
  * Cơ sở dữ liệu khóa học (Legacy): Truy xuất thông tin khóa học cũ, nhưng không cập nhật.
  * Cơ sở dữ liệu mới: Lưu trữ thông tin về sinh viên, giảng viên, lịch học, bảng điểm, và các giao dịch.

-- Biểu đồ package (Package Diagram):
![Diagram](https://www.planttext.com/api/plantuml/png/Z9InJkD048PxFyN81N05Ia-1I8X04G6XM51Tiwm7UqMyQ-skWmBY8QXfG5TSTRe-AIXu4Z_1lSAjlJPPnqwKAl7l-NR-sN_aVylF4wM9r5aozL927qY4u5zBLCWrqKnm69CvIX-UFG0gabHmymRyG6TXyUTqoihttps://www.planttext.com/api/plantuml/png/Z9InJkD048PxFyN81N05Ia-1I8X04G6XM51Tiwm7UqMyQ-skWmBY8QXfG5TSTRe-AIXu4Z_1lSAjlJPPnqwKAl7l-NR-sN_aVylF4wM9r5aozL927qY4u5zBLCWrqKnm69CvIX-UFG0gabHmymRyG6TXyUTqoioF3qH19LcbMNqjnJqg9QHR_ors4VqmOTojBeMgyiLRUUsdwPJHRLOd636bfIq9KCuOnV98zqMbDybpIKA4Iy9DfwHGNBfysOa5I3F9zBnHNekTn1WZGkSmuXeZwwTahEoeZSc7H1DtvD0ytn65tyUTYaoQns6b_-G78nwPQ64o75m6FvmMmq63ly97bwgpthCpAqkQ8eCPG_jmaIy-DV1y-SgWlJimovTl35f1UOs5WSF3uwv4uAXE46NlbXbdTYpbUsiBL9xWfbAWGNQNC6r1wzxtd5NQrjNclchNjhkMQG6DHSHuhv_fM4ZsPAFiDBehksvsLsujbjRjLwcibiZhkeQYOsiBYvvdg6diRfY_aIyNfSo2pB1tavezm_fZKQ6Dr3OoTNvjGokRbfeW2IkXwc2kOv0lVWb8yiKV3H7Bbty9qAyF2Zh-UkSnf76--CqtJj5nxxTaoafZVKfDl1rZx0AT80-Bh-z_0000__y30000)

-- Ý nghĩa các thành phần:
  * Client: Cung cấp giao diện dễ sử dụng cho người dùng cuối, giúp họ tương tác với hệ thống.
  * Application Server: Xử lý logic nghiệp vụ, tối ưu hóa hiệu suất hệ thống và cung cấp các API để truy cập dữ liệu.
  * Data Layer: Đảm bảo lưu trữ dữ liệu an toàn, truy cập nhanh chóng và khả năng tích hợp hệ thống cũ.

2. Cơ chế phân tích
-- Cơ chế bảo mật (Security)
* Mục tiêu:
Đảm bảo chỉ có người dùng hợp lệ (sinh viên, giảng viên, nhân viên văn phòng) mới truy cập được vào hệ thống.
Phân quyền rõ ràng: Sinh viên chỉ chỉnh sửa lịch học của mình, giảng viên chỉ cập nhật điểm cho lớp mình dạy, nhân viên văn phòng mới có quyền thay đổi thông tin sinh viên/giảng viên.
* Giải pháp:
Xác thực: Sử dụng hệ thống đăng nhập với tên người dùng và mật khẩu.
Phân quyền: Áp dụng mô hình Role-Based Access Control (RBAC) để kiểm soát quyền truy cập.

-- Cơ chế quản lý phiên làm việc (Session Management)
* Mục tiêu:
Duy trì trạng thái đăng nhập của người dùng trong một khoảng thời gian nhất định.
Đảm bảo người dùng không cần đăng nhập lại quá thường xuyên, nhưng phiên làm việc phải tự động hết hạn sau một thời gian không hoạt động.
* Giải pháp:
Sử dụng cookie hoặc token để lưu trữ thông tin phiên làm việc.
Cài đặt thời gian timeout cho mỗi phiên.

-- Cơ chế xử lý đồng thời (Concurrency Management)
* Mục tiêu:
Đảm bảo nhiều người dùng có thể thao tác cùng lúc mà không gây xung đột dữ liệu (ví dụ: hai sinh viên cùng chọn một khóa học cuối cùng).
* Giải pháp:
Áp dụng các khóa (locks) trên cơ sở dữ liệu: Sử dụng cơ chế optimistic locking hoặc pessimistic locking.
Giao dịch (Transactions): Đảm bảo tính nhất quán và toàn vẹn dữ liệu thông qua các giao dịch ACID.

-- Cơ chế kiểm tra điều kiện tiên quyết (Validation)
* Mục tiêu:
Xác nhận rằng sinh viên đáp ứng đủ điều kiện trước khi đăng ký khóa học (đã hoàn thành các môn học tiên quyết).
* Giải pháp:
Thực hiện kiểm tra thông qua tầng logic ứng dụng (Application Layer) với truy vấn kiểm tra điều kiện trong cơ sở dữ liệu.

-- Cơ chế thông báo thời gian thực (Real-Time Notifications)
* Mục tiêu:
Cảnh báo ngay cho sinh viên nếu khóa học đầy trong lúc đăng ký hoặc nếu thay đổi xảy ra trong thời gian add/drop.
* Giải pháp:
Sử dụng giao thức WebSocket hoặc Long Polling để đẩy thông báo thời gian thực từ server đến client.

-- Cơ chế tích hợp với hệ thống kế thừa (Legacy System Integration)
* Mục tiêu:
Tích hợp với cơ sở dữ liệu Ingres của hệ thống cũ để truy cập thông tin khóa học mà không làm gián đoạn hệ thống hiện tại.
* Giải pháp:
Sử dụng JDBC hoặc lớp wrapper để giao tiếp với cơ sở dữ liệu kế thừa.
Đảm bảo các truy vấn được tối ưu hóa để giảm tải cho hệ thống cũ.

-- Cơ chế xử lý giao dịch (Transaction Handling)
* Mục tiêu:
Đảm bảo các hành động như đăng ký hoặc xóa khóa học được thực hiện đầy đủ hoặc không thực hiện (tính toàn vẹn dữ liệu).
* Giải pháp:
Sử dụng cơ chế giao dịch (transactions) với tính năng rollback khi có lỗi.

-- Cơ chế xử lý lỗi (Error Handling)
* Mục tiêu:
Thông báo lỗi rõ ràng khi người dùng thao tác không thành công (ví dụ: đăng ký trùng lịch hoặc hệ thống không khả dụng).
* Giải pháp:
Xây dựng các lớp Exception để xử lý các lỗi thường gặp.
Hiển thị thông báo lỗi thân thiện với người dùng.

-- Cơ chế bảo mật thông tin nhạy cảm (Data Security)
* Mục tiêu:
Đảm bảo rằng thông tin như bảng điểm hoặc điểm danh sách sinh viên không bị truy cập trái phép.
* Giải pháp:
Mã hóa dữ liệu quan trọng trước khi lưu trữ.
Dùng HTTPS để truyền dữ liệu.

-- Cơ chế theo dõi và ghi log (Logging and Auditing)
* Mục tiêu:
Lưu lại các thao tác quan trọng để kiểm tra và xử lý sự cố sau này.
* Giải pháp:
Sử dụng công cụ logging như Log4j để ghi lại các thao tác như đăng nhập, đăng ký khóa học, hoặc cập nhật điểm.

3. Phân tích ca sử dụng Payment
-- Mô tả ca sử dụng
Mục tiêu: Hệ thống xử lý việc thanh toán tiền học phí của sinh viên. Ca sử dụng này bao gồm:
Hệ thống tính toán số tiền cần thanh toán dựa trên lịch đăng ký khóa học của sinh viên.
Gửi thông tin đến hệ thống thanh toán hoặc phát hành hóa đơn.
Xác nhận thanh toán thành công.

-- Các lớp phân tích
Dựa trên ca sử dụng, các lớp phân tích được xác định như sau:
Student:	Đại diện cho sinh viên, chứa thông tin cá nhân và danh sách khóa học đã đăng ký.
Course:	Đại diện cho khóa học, chứa thông tin về học phí và thời gian.
PaymentProcessor:	Lớp xử lý thanh toán, tính toán học phí, kiểm tra số dư, và gửi thông tin tới hệ thống thanh toán.
Invoice:	Đại diện cho hóa đơn thanh toán, chứa thông tin chi tiết về số tiền cần thanh toán và trạng thái.
BillingSystem:	Hệ thống thanh toán bên ngoài, xử lý giao dịch thanh toán.

-- Biểu đồ sequence mô tả hành vi
Dưới đây là các bước của ca sử dụng:
-Sinh viên yêu cầu thanh toán học phí.
-Hệ thống truy xuất thông tin từ các khóa học đã đăng ký.
-Hệ thống tính tổng số tiền cần thanh toán.
-Hệ thống tạo hóa đơn.
-Gửi yêu cầu thanh toán tới hệ thống BillingSystem.
-Nhận phản hồi từ BillingSystem.
-Cập nhật trạng thái hóa đơn và thông báo kết quả cho sinh viên.
Biểu đồ sequence:
![Diagram](https://www.planttext.com/api/plantuml/png/Z9InJkD048PxFyN81N05Ia-1I8X04G6XM51Tiwm7UqMyQ-skWmBY8QXfG5TSTRe-AIXu4Z_1lSAjlJPPnqwKAl7l-NR-sN_aVylF4wM9r5aozL927qY4u5zBLCWrqKnm69CvIX-UFG0gabHmymRyG6TXyUTqoioF3qH19LcbMNqjnJqg9QHR_ors4VqmOTojBeMgyiLRUUsdwPJHRLOd636bfIq9KCuOnV98zqMbDybpIKA4Iy9DfwHGNBfysOa5I3F9zBnHNekTn1WZGkSmuXeZwwTahEoeZSc7H1DtvD0ytn65tyUTYaoQns6b_-G78nwPQ64o75m6FvmMmq63ly97bwgpthCpAqkQ8eCPG_jmaIy-DV1y-SgWlJimovTl35f1UOs5WSF3uwv4uAXE46NlbXbdTYpbUsiBL9xWfbAWGNQNC6r1wzxtd5NQrjNclchNjhkMQG6DHSHuhv_fM4ZsPAFiDBehksvsLsujbjRjLwcibiZhkeQYOsiBYvvdg6diRfY_aIyNfSo2pB1tavezm_fZKQ6Dr3OoTNvjGokRbfeW2IkXwc2kOv0lVWb8yiKV3H7Bbty9qAyF2Zh-UkSnf76--CqtJj5nxxTaoafZVKfDl1rZx0AT80-Bh-z_0000__y30000)

