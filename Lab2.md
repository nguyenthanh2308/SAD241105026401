Phần 1: Tiến hành phân tích tất cả các ca sử dụng còn lại trong hệ thống Payroll System

1. Create Employee Report Mô tả ca sử dụng: Ca sử dụng này cho phép nhân viên tạo các báo cáo về số giờ làm việc, số giờ làm việc cho dự án, thời gian nghỉ phép, hoặc tổng tiền lương trong năm.

Các lớp phân tích:

* Employee (Nhân viên)

Nhiệm vụ: Đại diện cho nhân viên tạo báo cáo.

* Report (Báo cáo)

Nhiệm vụ: Đại diện cho các báo cáo có thể được tạo ra từ hệ thống.
Thuộc tính: reportID, reportType, startDate, endDate, employeeID

* ReportController (Bộ điều khiển báo cáo)

Nhiệm vụ: Xử lý logic liên quan đến việc tạo và quản lý báo cáo.

* Database (Cơ sở dữ liệu)

Nhiệm vụ: Lưu trữ và truy xuất thông tin cho các báo cáo.

Biểu đồ Sequence

![Diagram](https://www.planttext.com/api/plantuml/png/X9113e9034NtSuh6bIHw0HQ602xS4YymGb6ISMOinOIpkV18Ni4Ee0PZucgQzh__stdSxadBchWx6wLBTWJRipUkHrHUsatPU6qP5WLwHvmvo-ICGLg0Rg78Ved6qNoIQzO7tU8morEbNYcmteWDn41uwR3bqM99mxFlFQvWs4yCf4HRXI9IWWYOfmBMoEKf-F-5HFv92z90JLQ5D8zeaKGvso5e9E-BtDdQJUJxaXWgDCqLQSO7PQGIMI9yyHC00F__0m00)

2. Maintain Employee Information
Mô tả ca sử dụng: Ca sử dụng này cho phép quản trị viên tiền lương duy trì thông tin nhân viên, bao gồm thêm, cập nhật và xóa thông tin nhân viên.

Các lớp phân tích:
* PayrollAdministrator (Quản trị viên tiền lương)

Nhiệm vụ: Đại diện cho người dùng quản trị viên thực hiện nghiệp vụ quản lý thông tin nhân viên.

* Employee (Nhân viên)

Nhiệm vụ: Đại diện cho thông tin nhân viên mà quản trị viên có thể quản lý.
Thuộc tính: employeeID, name, address, ssn, deductions, rate, position

* EmployeeController (Bộ điều khiển thông tin nhân viên)

Nhiệm vụ: Xử lý logic liên quan đến việc thêm, cập nhật và xóa thông tin nhân viên.

* Database (Cơ sở dữ liệu)

Nhiệm vụ: Lưu trữ và truy xuất thông tin nhân viên.

Biểu đồ Sequence

![Diagram](https://www.planttext.com/api/plantuml/png/f98z3i8m38Ntd29Y0Wakm83wamviB1p0DAuKAKrAuYBrR0mSYIkGKZeKKgaIc-Nt-Rqt-7b_99x0KLjh1YLPnq_GEQjrAcjbb2S7OScQWAXIDM28hugwqRP3pAsX7aMtuk1vaSUnGPng0WWku0TDP8p5Kldk44pvdZkyjkWfbNBqNEDdE9hARbYW0Ykom7guuGmLzD6njAPIhWPIrYmBFpSIAE8ijhnzI_AdIhlmvAzU0ZL6GoPLv3mrbpvSHojyaGaQsV_F2m00__y30000)

3. Create Administrative Report
Mô tả ca sử dụng: Ca sử dụng này cho phép quản trị viên tạo các báo cáo về tổng số giờ làm việc hoặc tổng tiền lương đã thanh toán trong một khoảng thời gian nhất định.

Các lớp phân tích:

* PayrollAdministrator (Quản trị viên tiền lương)

Nhiệm vụ: Thực hiện các nghiệp vụ liên quan đến báo cáo.

* AdminReport (Báo cáo quản trị)

Nhiệm vụ: Đại diện cho các báo cáo quản trị được tạo ra.
Thuộc tính: reportID, reportType, startDate, endDate

* AdminReportController (Bộ điều khiển báo cáo quản trị)

Nhiệm vụ: Xử lý logic tạo báo cáo cho quản lý.

* Database (Cơ sở dữ liệu)

Nhiệm vụ: Lưu trữ và truy xuất thông tin cần thiết để tạo báo cáo.

Biểu đồ Sequence

![Diagram](https://www.planttext.com/api/plantuml/png/f98z3i8m38Ntd29Y0Wakm83wamviB1p0DAuKAKrAuYBrR0mSYIkGKZeKKgaIc-Nt-Rqt-7b_99x0KLjh1YLPnq_GEQjrAcjbb2S7OScQWAXIDM28hugwqRP3pAsX7aMtuk1vaSUnGPng0WWku0TDP8p5Kldk44pvdZkyjkWfbNBqNEDdE9hARbYW0Ykom7guuGmLzD6njAPIhWPIrYmBFpSIAE8ijhnzI_AdIhlmvAzU0ZL6GoPLv3mrbpvSHojyaGaQsV_F2m00__y30000)
