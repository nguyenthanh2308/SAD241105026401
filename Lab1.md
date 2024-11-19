
1. Phân tích kiến trúc hệ thống
1.1 Kiến trúc đề xuất:
Mô hình Client-Server kết hợp với kiến trúc 3 lớp (Three-tier architecture):
  * Lớp trình bày (Presentation Layer): Giao diện người dùng (UI) chạy trên máy tính cá nhân của sinh viên, giáo viên, và quản trị viên. Giao diện này sẽ tuân thủ chuẩn Windows 95/98 như được yêu cầu.
  * Lớp ứng dụng (Application Layer): Máy chủ ứng dụng (Application Server) chịu trách nhiệm xử lý logic nghiệp vụ như đăng ký môn học, tính toán chi phí, kiểm tra điều kiện tham gia khóa học, và xử lý dữ liệu.
  * Lớp dữ liệu (Data Layer): Bao gồm cơ sở dữ liệu khóa học hiện tại (Ingres RDBMS) trên hệ thống DEC VAX và các cơ sở dữ liệu mới có thể được thêm để quản lý thông tin sinh viên, lịch học, và bảng điểm.
    
1.2 Lý do lựa chọn kiến trúc này:
Khả năng mở rộng: Kiến trúc 3 lớp dễ dàng mở rộng khi số lượng sinh viên, giáo viên, hoặc dữ liệu tăng lên.
  * Tích hợp hệ thống cũ: Kiến trúc hỗ trợ việc truy cập vào cơ sở dữ liệu khóa học cũ thông qua giao diện SQL mở, đáp ứng yêu cầu tích hợp.
  * Phân chia nhiệm vụ: Giảm tải cho lớp trình bày bằng cách chuyển logic xử lý xuống lớp ứng dụng, đồng thời đảm bảo dữ liệu được bảo mật tại lớp dữ liệu.
  * Hiệu năng: Hỗ trợ tới 2000 người dùng đồng thời như yêu cầu và tối ưu hóa truy vấn đến cơ sở dữ liệu cũ bằng xử lý trung gian tại lớp ứng dụng.
    
1.3 Các thành phần kiến trúc chính:
Client (Sinh viên/Giảng viên/Quản trị viên):
Giao diện desktop cho phép thực hiện các tác vụ như đăng nhập, chọn khóa học, xem bảng điểm.
Application Server:
  * Module Đăng ký khóa học: Đảm bảo việc xử lý đăng ký khóa học, kiểm tra số lượng sinh viên tham gia, và xử lý thay đổi trong thời gian add/drop.
  * Module Xử lý bảng điểm: Cung cấp khả năng nhập điểm của giảng viên và xem điểm của sinh viên.
  * Module Bảo mật: Quản lý quyền truy cập, đảm bảo dữ liệu được bảo mật.
Database Layer:
  * Cơ sở dữ liệu khóa học (Legacy): Truy xuất thông tin khóa học cũ, nhưng không cập nhật.
  * Cơ sở dữ liệu mới: Lưu trữ thông tin về sinh viên, giảng viên, lịch học, bảng điểm, và các giao dịch.
    
1.4 Biểu đồ package (Package Diagram):
![Diagram](https://www.planttext.com/api/plantuml/png/Z9InJkD048PxFyN81N05Ia-1I8X04G6XM51Tiwm7UqMyQ-skWmBY8QXfG5TSTRe-AIXu4Z_1lSAjlJPPnqwKAl7l-NR-sN_aVylF4wM9r5aozL927qY4u5zBLCWrqKnm69CvIX-UFG0gabHmymRyG6TXyUTqoioF3qH19LcbMNqjnJqg9QHR_ors4VqmOTojBeMgyiLRUUsdwPJHRLOd636bfIq9KCuOnV98zqMbDybpIKA4Iy9DfwHGNBfysOa5I3F9zBnHNekTn1WZGkSmuXeZwwTahEoeZSc7H1DtvD0ytn65tyUTYaoQns6b_-G78nwPQ64o75m6FvmMmq63ly97bwgpthCpAqkQ8eCPG_jmaIy-DV1y-SgWlJimovTl35f1UOs5WSF3uwv4uAXE46NlbXbdTYpbUsiBL9xWfbAWGNQNC6r1wzxtd5NQrjNclchNjhkMQG6DHSHuhv_fM4ZsPAFiDBehksvsLsujbjRjLwcibiZhkeQYOsiBYvvdg6diRfY_aIyNfSo2pB1tavezm_fZKQ6Dr3OoTNvjGokRbfeW2IkXwc2kOv0lVWb8yiKV3H7Bbty9qAyF2Zh-UkSnf76--CqtJj5nxxTaoafZVKfDl1rZx0AT80-Bh-z_0000__y30000)

1.5 Ý nghĩa các thành phần:
  * Client: Cung cấp giao diện dễ sử dụng cho người dùng cuối, giúp họ tương tác với hệ thống.
  * Application Server: Xử lý logic nghiệp vụ, tối ưu hóa hiệu suất hệ thống và cung cấp các API để truy cập dữ liệu.
  * Data Layer: Đảm bảo lưu trữ dữ liệu an toàn, truy cập nhanh chóng và khả năng tích hợp hệ thống cũ.

2. Cơ chế phân tích
2.1 Cơ chế bảo mật (Security)
* Mục tiêu:
Đảm bảo chỉ có người dùng hợp lệ (sinh viên, giảng viên, nhân viên văn phòng) mới truy cập được vào hệ thống.
Phân quyền rõ ràng: Sinh viên chỉ chỉnh sửa lịch học của mình, giảng viên chỉ cập nhật điểm cho lớp mình dạy, nhân viên văn phòng mới có quyền thay đổi thông tin sinh viên/giảng viên.
* Giải pháp:
Xác thực: Sử dụng hệ thống đăng nhập với tên người dùng và mật khẩu.
Phân quyền: Áp dụng mô hình Role-Based Access Control (RBAC) để kiểm soát quyền truy cập.

2.2 Cơ chế quản lý phiên làm việc (Session Management)
* Mục tiêu:
Duy trì trạng thái đăng nhập của người dùng trong một khoảng thời gian nhất định.
Đảm bảo người dùng không cần đăng nhập lại quá thường xuyên, nhưng phiên làm việc phải tự động hết hạn sau một thời gian không hoạt động.
* Giải pháp:
Sử dụng cookie hoặc token để lưu trữ thông tin phiên làm việc.
Cài đặt thời gian timeout cho mỗi phiên.

2.3 Cơ chế xử lý đồng thời (Concurrency Management)
* Mục tiêu:
Đảm bảo nhiều người dùng có thể thao tác cùng lúc mà không gây xung đột dữ liệu (ví dụ: hai sinh viên cùng chọn một khóa học cuối cùng).
* Giải pháp:
Áp dụng các khóa (locks) trên cơ sở dữ liệu: Sử dụng cơ chế optimistic locking hoặc pessimistic locking.
Giao dịch (Transactions): Đảm bảo tính nhất quán và toàn vẹn dữ liệu thông qua các giao dịch ACID.

2.4 Cơ chế kiểm tra điều kiện tiên quyết (Validation)
* Mục tiêu:
Xác nhận rằng sinh viên đáp ứng đủ điều kiện trước khi đăng ký khóa học (đã hoàn thành các môn học tiên quyết).
* Giải pháp:
Thực hiện kiểm tra thông qua tầng logic ứng dụng (Application Layer) với truy vấn kiểm tra điều kiện trong cơ sở dữ liệu.

2.5 Cơ chế thông báo thời gian thực (Real-Time Notifications)
* Mục tiêu:
Cảnh báo ngay cho sinh viên nếu khóa học đầy trong lúc đăng ký hoặc nếu thay đổi xảy ra trong thời gian add/drop.
* Giải pháp:
Sử dụng giao thức WebSocket hoặc Long Polling để đẩy thông báo thời gian thực từ server đến client.

2.6 Cơ chế tích hợp với hệ thống kế thừa (Legacy System Integration)
* Mục tiêu:
Tích hợp với cơ sở dữ liệu Ingres của hệ thống cũ để truy cập thông tin khóa học mà không làm gián đoạn hệ thống hiện tại.
* Giải pháp:
Sử dụng JDBC hoặc lớp wrapper để giao tiếp với cơ sở dữ liệu kế thừa.
Đảm bảo các truy vấn được tối ưu hóa để giảm tải cho hệ thống cũ.

2.7 Cơ chế xử lý giao dịch (Transaction Handling)
* Mục tiêu:
Đảm bảo các hành động như đăng ký hoặc xóa khóa học được thực hiện đầy đủ hoặc không thực hiện (tính toàn vẹn dữ liệu).
* Giải pháp:
Sử dụng cơ chế giao dịch (transactions) với tính năng rollback khi có lỗi.

2.8 Cơ chế xử lý lỗi (Error Handling)
* Mục tiêu:
Thông báo lỗi rõ ràng khi người dùng thao tác không thành công (ví dụ: đăng ký trùng lịch hoặc hệ thống không khả dụng).
* Giải pháp:
Xây dựng các lớp Exception để xử lý các lỗi thường gặp.
Hiển thị thông báo lỗi thân thiện với người dùng.

2.9 Cơ chế bảo mật thông tin nhạy cảm (Data Security)
* Mục tiêu:
Đảm bảo rằng thông tin như bảng điểm hoặc điểm danh sách sinh viên không bị truy cập trái phép.
* Giải pháp:
Mã hóa dữ liệu quan trọng trước khi lưu trữ.
Dùng HTTPS để truyền dữ liệu.

2.10 Cơ chế theo dõi và ghi log (Logging and Auditing)
* Mục tiêu:
Lưu lại các thao tác quan trọng để kiểm tra và xử lý sự cố sau này.
* Giải pháp:
Sử dụng công cụ logging như Log4j để ghi lại các thao tác như đăng nhập, đăng ký khóa học, hoặc cập nhật điểm.

3. Phân tích ca sử dụng Payment
3.1 Mô tả ca sử dụng
Mục tiêu: Hệ thống xử lý việc thanh toán tiền học phí của sinh viên. Ca sử dụng này bao gồm:
Hệ thống tính toán số tiền cần thanh toán dựa trên lịch đăng ký khóa học của sinh viên.
Gửi thông tin đến hệ thống thanh toán hoặc phát hành hóa đơn.
Xác nhận thanh toán thành công.

3.2 Các lớp phân tích
Dựa trên ca sử dụng, các lớp phân tích được xác định như sau:
Student:	Đại diện cho sinh viên, chứa thông tin cá nhân và danh sách khóa học đã đăng ký.
Course:	Đại diện cho khóa học, chứa thông tin về học phí và thời gian.
PaymentProcessor:	Lớp xử lý thanh toán, tính toán học phí, kiểm tra số dư, và gửi thông tin tới hệ thống thanh toán.
Invoice:	Đại diện cho hóa đơn thanh toán, chứa thông tin chi tiết về số tiền cần thanh toán và trạng thái.
BillingSystem:	Hệ thống thanh toán bên ngoài, xử lý giao dịch thanh toán.

3.3 Biểu đồ sequence mô tả hành vi
Dưới đây là các bước của ca sử dụng:
-Sinh viên yêu cầu thanh toán học phí.
-Hệ thống truy xuất thông tin từ các khóa học đã đăng ký.
-Hệ thống tính tổng số tiền cần thanh toán.
-Hệ thống tạo hóa đơn.
-Gửi yêu cầu thanh toán tới hệ thống BillingSystem.
-Nhận phản hồi từ BillingSystem.
-Cập nhật trạng thái hóa đơn và thông báo kết quả cho sinh viên.
Biểu đồ sequence:
![Diagram](https://www.planttext.com/api/plantuml/png/X9113e8m44NtdA9BM7W15YxKcBWZSe86lgH9QR4p9U5iBZoILx2ca8X2s4td__VpEw_7isHVmx3OxKKXXpQCXRCLYAmJkN2uUn2FIfebVvx0JH6vQC1ND8eO3lNHUaUW5IYgaJa3AwwBwQsgFhRAGJB6TygMfGxOCdLGMYlJb4CeqWQsY-Bq2nL3Jc2fD6N9tBvyY2wkIfRiQQEgx-fGDLhJ6RXrFsDPtORY6_aDU0C00F__0m00)

3.4 Nhiệm vụ của từng lớp phân tích
* Student:
Lưu trữ thông tin cá nhân của sinh viên.
Cung cấp danh sách các khóa học đã đăng ký.
* Course:
Cung cấp thông tin học phí cho từng khóa học.
* PaymentProcessor:
Xử lý logic nghiệp vụ liên quan đến thanh toán.
Tính toán tổng học phí dựa trên các khóa học đã đăng ký.
Tạo và quản lý hóa đơn.
Giao tiếp với BillingSystem để thực hiện giao dịch.
* Invoice:
Lưu trữ thông tin hóa đơn như tổng tiền, trạng thái thanh toán (chưa thanh toán, đã thanh toán).
* BillingSystem:
Hệ thống bên ngoài chịu trách nhiệm xử lý các giao dịch thanh toán.

3.5 Biểu đồ lớp
Biểu đồ lớp thể hiện các thuộc tính, phương thức và quan hệ giữa các lớp.
![Diagram](https://www.planttext.com/api/plantuml/png/T591JiCm4Bpx5JwMGpwG0wf0Gd13v0MRU5jMijULTrqfGhoC0q_Y2zXDWvAM7ZspdjaP--VhUoiAINFmPl0WOZlD3bdjXx7ModHuSMt14_6-WWSOGmLv5vSmCIc1ukj4R-vQUupapASvAp_6d0JVS4-Y2PGYTwCeXibgXpgyFv3tcolJebI9EkL83Xx6qzoLGKNB-5ArBz1wUmWnixRsoKVG2Xp1aojxpvfzZ1w1JqbJ751aaMWc_ppFt3EmyvWcqvAE1OQQyD_cEWNDiYGazu5qzbcjk4WvFqtJtEpIt2ovN5hrOousRvhxYu4jigl_uXS00F__0m00)

4. Phân tích ca sử dụng: Maintain Timecard
4.1 Xác định các lớp phân tích
Các lớp liên quan đến ca sử dụng này bao gồm:
 -Employee: Người thực hiện thêm, sửa, hoặc xóa thông tin timecard.
 -Timecard: Biểu thị thông tin thời gian làm việc của nhân viên.
 -TimecardHandler: Xử lý các thao tác thêm, sửa, xóa timecard.
 -ProjectManagementSystem: Hệ thống cung cấp danh sách các mã dự án (charge numbers).

4.2 Biểu đồ Sequence
Biểu đồ Sequence mô tả hành vi khi nhân viên duy trì timecard.
![Diagram](https://www.planttext.com/api/plantuml/png/R94_JiCm5CPtd-Af4moeUmTKAG9bQLMHNE3L_YX6jXFibvIUZO4ZSGNSfcb4X4Vxz_sJVxw-rqauIkUTOYrDf2VVkkO4g3PVMsrR3aABsdfeZgRaO1pYWZXHNVvbTh5vXvOD1px08qXrIW9_ONURwd_3mQbGQiobXyVilA8NV7H8Gd85wQwtE2xPc6NN6XOi3Hm4zwekBvhYh95eqOFmQPFOSBYf5JkXBOuqvYhAfox6j28YMrB8n4s2OAxUkVsAdY7wZTfX9Ed68AdyCFMLBWRYdgtZlSECdC-hkhstGiEKHD9CkTEUYlEM_2S3DIT6ozo-2QysUagTraX9hNFryu_-0W00__y30000)

4.3 Xác định nhiệm vụ của từng lớp
 * Employee:
-Gửi yêu cầu tạo, chỉnh sửa, hoặc xóa thông tin timecard.
-Chọn mã dự án và nhập giờ làm việc.
 * TimecardHandler:
-Xử lý logic quản lý timecard (thêm, sửa, xóa).
-Tương tác với hệ thống quản lý dự án để lấy danh sách mã dự án.
-Ghi hoặc cập nhật timecard.
 * Timecard:
-Lưu trữ và hiển thị thông tin thời gian làm việc.
-ProjectManagementSystem:
-Cung cấp danh sách các mã dự án để nhân viên lựa chọn.
-- Các thuộc tính và quan hệ
Thuộc tính của các lớp:
 * Employee:
-employeeId: String: Mã nhân viên.
-name: String: Tên nhân viên.
 * Timecard:
-timecardId: String: Mã timecard.
-date: Date: Ngày làm việc.
-hoursWorked: Float: Số giờ làm việc.
-projectCode: String: Mã dự án.
 * TimecardHandler:
-transactionId: String: Mã giao dịch.
-status: String: Trạng thái xử lý.
 * ProjectManagementSystem:
-projectCodes: List<String>: Danh sách mã dự án.
 * Quan hệ giữa các lớp:
-Employee tạo hoặc sửa đổi Timecard thông qua TimecardHandler.
-TimecardHandler tương tác với ProjectManagementSystem để lấy mã dự án.
-TimecardHandler lưu trữ hoặc cập nhật thông tin vào Timecard.

4.4 Biểu đồ lớp
Biểu đồ lớp thể hiện các thuộc tính, phương thức và quan hệ giữa các lớp.
![Diagram](https://www.planttext.com/api/plantuml/png/X99DJiCm48NtFeMNGI8Ng51Ln8z0AX9IaLYFx25DYUtKCwvK8Kx6WYDn1MmIqoIqOfFeJLxcVNx9ryVdWXWy1zC8rG2Hl35ju_Q8yar8AR5NztecL-nhMwMf1OD3xN4RaFYfDgZ0wql5jRC5_DooxsmcTwxMubtqGTdT1N6lna4QE0PTnsjIQnSyFJl_Yj5qspZWD6szsw3YAwT7J0GxB79erA5DougJ67TWTOE-f_5WgUCV0yMoED1m4kCL4kKrnT_6pkNn9kBBByXg_NWu02M-PKryqLdd1yxUzG0MAZHeURKdHjFn3ZgWoOBuj4B-B-FtgvVbj14nRQWivwTeZdhpJ2pGwlIZVGC00F__0m00)

4.5 Giải thích
 * Biểu đồ Sequence:
Minh họa luồng thông tin khi nhân viên thực hiện các thao tác với timecard.
Các bước từ yêu cầu cho đến khi xác nhận thành công đều được mô tả.
 * Biểu đồ Lớp:
Các lớp được phân tích rõ ràng với nhiệm vụ, thuộc tính, và phương thức cụ thể.
Quan hệ giữa các lớp đảm bảo tính liên kết và chức năng của hệ thống.

5. Tài liệu mô tả phân tích hệ thống
5.1 Giới thiệu
Tài liệu này hợp nhất kết quả phân tích của hai ca sử dụng Payment và Maintain Timecard để tạo ra một mô hình tổng thể. Hệ thống hỗ trợ quản lý thanh toán và thông tin timecard của nhân viên một cách hiệu quả.
5.2 Các lớp phân tích
Dựa trên hai ca sử dụng, các lớp phân tích chính bao gồm:
 * Employee:
Đại diện cho người dùng (nhân viên) tương tác với hệ thống.
Quản lý yêu cầu thanh toán và cập nhật timecard.
 * Timecard:
Lưu trữ thông tin về thời gian làm việc của nhân viên.
 * TimecardHandler:
Quản lý logic xử lý timecard (thêm, sửa, xóa).
 * ProjectManagementSystem:
Cung cấp danh sách mã dự án liên quan đến timecard.
 * PaymentHandler:
Xử lý các giao dịch thanh toán.
 * BillingSystem:
Hệ thống quản lý hóa đơn và xác nhận thanh toán.
 * CourseRegistrationSystem:
Hệ thống cung cấp thông tin hóa đơn liên quan đến các khóa học.

5.3 Biểu đồ Sequence
 * Thanh toán (Payment)
![Diagram](https://www.planttext.com/api/plantuml/png/N94xRiCm38PtdOB8tWjuA08xBJmAyGaKcKq9wE6ArE2pTUYHUeL8QUp6tWJzt_y0-FlzSsGnIR9tobY92TxyvEACgARoJPOc4mGENSo94Svu9PPaX6A0OMP1Vm33q9s7BT-ISnIkpqoxGxIPFPP7RyBeCDqPtIkr382NrvhRbDAlZ2mmFGmZYY77geYLQGloZc8_uL9ALxKTdW8afx2L7-Qbh84JyUJCVASs6tJVm90ldjO5IlTBiKxH8lEg_BLMInV31oM_y_ptxNJWR6kIEc8OwpLk0000__y30000)
 * Duy trì Timecard (Maintain Timecard)
![Diagram](https://www.planttext.com/api/plantuml/png/R94_JiCm5CPtd-Af4moeUmTKAG9bQLMHNE3L_YX6jXFibvIUZO4ZSGNSfcb4X4Vxz_sJVxw-rqauIkUTOYrDf2VVkkO4g3PVMsrR3aABsdfeZgRaO1pYWZXHNVvbTh5vXvOD1px08qXrIW9_ONURwd_3mQbGQiobXyVilA8NV7H8Gd85wQwtE2xPc6NN6XOi3Hm4zwekBvhYh95eqOFmQPFOSBYf5JkXBOuqvYhAfox6j28YMrB8n4s2OAxUkVsAdY7wZTfX9Ed68AdyCFMLBWRYdgtZlSECdC-hkhstGiEKHD9CkTEUYlEM_2S3DIT6ozo-2QysUagTraX9hNFryu_-0W00__y30000)

5.4 Biểu đồ lớp hợp nhất
Biểu đồ lớp kết hợp cả hai ca sử dụng.
![Diagram](https://www.planttext.com/api/plantuml/png/Z5JRIiD047tVhyXZ1FC3HKgrAWeAOWMVfycOhkubxauAGVmo7_maVy6T9ccpJGjzIPZBddFcp2P_FxypJ-2eraha2hnFRdIbR8EOV8aaIR2Bxej9iY0dJSbP0ng7iSFF6ZrTvYIjIM7pwkjdasHjPI6-HKVm8ZNcu8gMWBee9YY00i5rU7AqihNphzPzO6YwLHQ8ivMpxvZJt1QH5WzhJ7lI4DSLWwL7PTo1AHIwJeq3urlziQ1W4jL-c0dqENhVmwHZfywJmqw4msz8-UffDu1dVG_IqqNREjtfxBeUmK296Wqj6a-eMxq33tm4mCKIwKGAQ1ZuD2UgjdanCiJNIosfmqf1szfGjwwH-LTIgN1iECeof6Ac288JQr2IbycdUPgbjGh13BRHim-AMyuvto9ynZ9uu8076z9lDh817Yyoe75bSp6bhnGqlO9-gkr7asNx5okgnKwB_JkOPTDZ-pxOs-V4tWQv5baiOiEvVimECKDJyE_W7m00__y30000)

5.5 Nhiệm vụ và quan hệ giữa các lớp
Employee:
Tương tác với cả TimecardHandler và PaymentHandler để gửi yêu cầu liên quan đến timecard và thanh toán.
TimecardHandler:
Chịu trách nhiệm xử lý thông tin timecard, kết nối với ProjectManagementSystem và Timecard.
PaymentHandler:
Quản lý các giao dịch thanh toán, tương tác với BillingSystem.
BillingSystem:
Xác thực hóa đơn, xử lý thanh toán và nhận thông tin từ CourseRegistrationSystem.
ProjectManagementSystem:
Cung cấp mã dự án cho timecard.

5.6 Tổng kết
Hệ thống hỗ trợ:
Quản lý thanh toán liên quan đến các khóa học.
Cập nhật, chỉnh sửa, và duy trì thông tin timecard.
Kết nối các thành phần khác nhau để đảm bảo tính toàn vẹn dữ liệu và hiệu suất hoạt động.
