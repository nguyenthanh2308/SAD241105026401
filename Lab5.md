# CÁC HỆ THỐNG CON CỦA HỆ THỐNG PAYROLL SYSTEM

## 1. Run Payroll (Chạy bảng lương)
### 1.1. Mô tả
Chức năng này cho phép bộ phận trả lương có thể tính toán lương cho tất cả nhân viên trong một kỳ thanh toán dựa trên dữ liệu đầu vào cụ thể như thời gian làm việc, chức vụ, và các khoản khấu trừ. Cả giao diện người dùng và bảo mật đều được tối ưu để đảm bảo hiệu quả và bảo mật thông tin.

### 1.2. Chức năng chính
- **Nhập thông tin lương**:
  - Hệ thống cung cấp giao diện cho phép bộ phận tài chính nhập dữ liệu về thời gian làm việc, các khoản phụ cấp,     
  thưởng hay khấu trừ.
  - Tính toán tự động dựa trên các công thức đã cấu hình sẵn trong hệ thống.
- **Tính toán bảng lương**:
  - Hệ thống sẽ thực hiện tính toán tổng thu nhập, các khoản khấu trừ thuế, bảo hiểm, và lương ròng cho nhân viên.
  - Sử dụng các quy tắc tính thuế và các khoản trích nộp theo quy định pháp luật.
- **Tạo và xuất báo cáo**:
  - Xuất báo cáo bảng lương chi tiết cho từng nhân viên.
  - Phân tích chi phí lương của tổ chức, so sánh với các kỳ trước để ra quyết định.
  - Xuất báo cáo dưới định dạng PDF, Excel hoặc CSV để tiện cho việc lưu trữ và chia sẻ.
### 1.3. Use Case
- **Chạy bảng lương**:
  - Người dùng: Payroll Administrator
  - Tiến trình: Chọn kỳ tính lương; Nhập thông tin; Nhấn "Run Payroll".
  - Kết quả: Hệ thống tính toán và lưu trữ thông tin bảng lương.
    
- **Tạo báo cáo**:
  - Người dùng: Payroll Administrator
  - Tiến trình: Chọn loại báo cáo; Nhấn "Generate Report".
  - Kết quả: Hệ thống tạo báo cáo và cung cấp tùy chọn xuất ra tệp.
### 1.4. Biểu đồ Use Case
![Diagram](https://www.planttext.com/api/plantuml/png/J8yx3i8m38RtdCBg14Clq06LgMABmWciraAHya29ErGL9sFWI5m1Xr30u__z3_bvV_IPCV7i7O32aME2HkEIedDmdBmDDdD2aHl0N1KngaGZOxWu-hdFIsRo3Qp2GMvdvW0Vk2zXepSoK20ffGs3eMjC_7ODseZjLaRgMjiUIhI3Kx1i_rEWH2-uP3hujjOsmJs5IJvx0G00__y30000)



## 2. Maintain Timecard (Duy trì thẻ thời gian)
### 2.1. Mô tả
Chức năng này cho phép nhân viên ghi lại thời gian làm việc của họ. Nhân viên có thể nhập giờ vào, giờ ra, và các khoản thời gian nghỉ phép. Hệ thống hỗ trợ việc phê duyệt từ quản lý.

### 2.2. Chức năng chính
- **Nhập thẻ thời gian**:
  - Nhân viên có thể nhập detai giờ làm việc trên giao diện dễ sử dụng.
  - Ghi rõ các ca làm việc, thời gian nghỉ và lý do nếu có.
    
- **Chỉnh sửa và gửi thẻ thời gian**:
  - Nhân viên có thể chỉnh sửa địa input cho đúng trước khi gửi tới quản lý.
  - Tính năng gửi thông báo cho quản lý về thẻ thời gian đã gửi.
    
- **Phê duyệt thẻ thời gian**:
  - Quản lý nhận được thông báo và có thể xem, chỉnh sửa và phê duyệt thẻ thời gian.
  - Hệ thống sẽ lưu lịch sử phê duyệt để dễ dàng theo dõi.

### 2.3. Use Case
- **Nộp thẻ thời gian**:
  - Người dùng: Employee
  - Tiến trình: Nhập thời gian; Nhấn "Submit".
  - Kết quả: Thẻ thời gian được gửi tới quản lý.
  
- **Phê duyệt thẻ thời gian**:
  - Người dùng: Manager
  - Tiến trình: Nhận thông báo; Kiểm tra và phê duyệt.
  - Kết quả: Thẻ thời gian được phê duyệt và lưu trong hệ thống.
 
### 2.4. Biểu đồ Use Case
![Diagram](https://www.planttext.com/api/plantuml/png/ND112eCm40NGlQSOiceNNg2BefGiNUa5fd48KXDbZ0KfFLaNFLAlq4n0H9VXVURFvFVv5bD03hFh0J8qOM1Gsetzi10fm0dYOvCAFLhY19LbY98ncO3UzWIgwHn1msWUdRTGBrCWf-0LKp49ftg-kow0f0noUvOfTNDRMRT7r1kMuyZ3a_PU9d_B5h9cdb_Jl0iScc9WTPryLoLNo372PU9ZMGmKvDluINy0003__mC0)



## 3. Login (Đăng nhập)
### 3.1. Mô tả
Phần này cung cấp các chức năng đăng nhập an toàn cho người dùng để truy cập vào hệ thống. Đảm bảo rằng chỉ có những người có quyền mới có thể vào hệ thống và truy cập vào các thông tin nhạy cảm.

### 3.2. Chức năng chính
- **Đăng nhập**:
  - Người dùng nhập tên đăng nhập và mật khẩu trên giao diện.
  - Hệ thống sẽ kiểm tra thông tin và xác thực.
    
- **Khôi phục mật khẩu**:
  - Nếu người dùng quên mật khẩu, họ có thể yêu cầu gửi link khôi phục qua email.
  - Quy trình khôi phục sẽ yêu cầu trả lời các câu hỏi bảo mật đã thiết lập trước đó.
    
- **Quản lý quyền truy cập**:
  - Hệ thống phân loại người dùng theo vai trò (như nhân viên, quản lý, admin) và xác định quyền truy cập cho từng vai trò.
    
### 3.3. Use Case
- **Đăng nhập vào hệ thống**:
  - Người dùng: User
  - Tiến trình: Nhập thông tin đăng nhập và nhấn "Login".
  - Kết quả: Nếu thông tin chính xác, truy cập vào hệ thống thành công.
    
- **Khôi phục mật khẩu**:
  - Người dùng: User
  - Tiến trình: Nhấn "Forgot Password"; Nhập email và nhận thông tin khôi phục.
  - Kết quả: Nhận link khôi phục mật khẩu.
 
### 3.4. Biểu đồ Use Case
![Diagram](https://www.planttext.com/api/plantuml/png/F8zB2i9038RtFKNeIXUzG1TI47SLIiK3X6aO2kqC9gbIn9Evy4XUmKpLPfNyZm_oVhugKMITnW4WGwUH8JyBSGuea1QJCoQd6Fn0Nm-E6D3JI47XD8lIcCFTSc2pgQFlmpQrwx_KaejNgpKeSelSBMxRcFr8z0LP53ihb708QjUUgJDwZuDOOWrOfuIMBXE9hZJuuMTBLXGwU-K3003__mC0)

---

# YÊU CẦU HỆ THỐNG

## 1. Yêu cầu Chức năng
- **Run Payroll**:
  - Đảm bảo tính chính xác trong việc tính toán và lưu dữ liệu.
  - Cho phép nhập và hiển thị báo cáo một cách dễ dàng và nhanh chóng.
- **Maintain Timecard**:
  - Cho phép nhân viên cập nhật và gửi thẻ thời gian dễ dàng.
  - Quản lý có thể phê duyệt một cách thuận tiện và lưu trữ lịch sử.
- **Login**:
  - Phải đảm bảo các thông tin đăng nhập được mã hóa và lưu trữ an toàn.
  - Tính năng khôi phục mật khẩu phải an toàn và dễ dàng cho người dùng.

## 2. Yêu cầu Phi chức năng
- **Hiệu suất**:
  - Hệ thống cần xử lý bảng lương cho tối đa 1000 nhân viên trong thời gian tối đa 5 phút.
- **Bảo mậ**t:
  - Sử dụng mã hóa cho tất cả dữ liệu nhạy cảm và thông tin đăng nhập người dùng.
  - Hệ thống phải tuân thủ quy định bảo vệ dữ liệu cá nhân GDPR hoặc CCPA nếu hoạt động ở các khu vực đó.
- **Khả năng mở rộng**:
  - Hệ thống cần linh hoạt để thêm mới chức năng hoặc mở rộng khi số lượng nhân viên tăng lên mà không làm giảm hiệu suất.
- **Khả năng sử dụng**:
  - Giao diện người dùng cần dễ sử dụng, với thiết kế thân thiện để người dùng có thể làm quen nhanh chóng.
 
---

# KIẾN TRÚC HỆ THỐNG VÀ ĐỒ HỌA UML
## 1. Kiến trúc Tổng quan
Hệ thống được xây dựng dựa trên mô hình nhiều lớp với các thành phần sau:
- **Giao diện người dùng (UI)**: Trực tiếp tương tác với người dùng thông qua trình duyệt hoặc ứng dụng desktop.
- **Lớp dịch vụ (Service Layer)**: Xử lý tất cả các logic nghiệp vụ và interlink giữa UI và Database.
- **Lớp dữ liệu (Data Layer)**: Kết nối và thao tác với cơ sở dữ liệu để lưu trữ và truy xuất dữ liệu.
  
## 2. Biểu đồ Kiến trúc UML
![Diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbkZe82Lq5YSdPYUgg2Ka1YPL5-Jev2S6LnIMgkaa8rK5918JgqEBL8mJEl9BKeBJ4vDLP1LzTE8JeujQWiCpbLmIUnChKe5g8GJGoipYMn934fiHX9OIqGEwJcfG0j1m000F__0m00)
