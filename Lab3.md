1. Subsystem context diagrams

  Biểu đồ này mô tả cách hệ thống "Payroll System" tương tác với các hệ thống con và các tác nhân bên ngoài:

* Employee: Gửi yêu cầu liên quan đến thông tin thanh toán, chẳng hạn như bảng lương hoặc thu nhập.
* Admin: Quản lý hệ thống, thực hiện các tác vụ như quản lý người dùng hoặc cập nhật dữ liệu.
* BankSystem: Nhận thông tin thanh toán từ hệ thống Payroll System để thực hiện chuyển tiền.
* PrintService: Hỗ trợ in các bảng lương, phiếu chi trả, hoặc báo cáo.
* ProjectManagementDatabase: Cung cấp dữ liệu về các dự án liên quan để tính toán chi phí hoặc phân bổ lương.

  Biểu đồ giúp xác định rõ vai trò của từng hệ thống con và kết nối của chúng với hệ thống trung tâm:

* Biểu đồ ngữ cảnh - BankSystem:

![Diagram](https://www.planttext.com/api/plantuml/png/T951JiCm44NtFiKe-ro0HTMYKea54gA83M8nTIQLLNjSx8bGX3WP2uxKAzInez0AueKNdl_-_1cVld-MKJ18vwn2BJx0dJjQtnC1Hg3nRTKumyC3AdL4VS0zGNMBVDZsKSXLyAaW7OAwNi3h8_R1Mmkb-0OtK3tHUqTH89KSiS0zjxxA3Cuo3yX3dx5IrFdw8yuElt4olILkfdPh4ZGs5eyhvOJ26WLt6AdGQMg2vu0SqmQCvpbqsbRsM6djEvPiaU6M0cmwRk9b_1ccRlm7_nzdrC0B1TCQZINHbrgc8OUVEmC00F__0m00)

* Biểu đồ ngữ cảnh - PrintService:

![Diagram](https://www.planttext.com/api/plantuml/png/PD312i8m30RWUvyYzBuNy20JzW3J7SL3wC8ejjriqy4Gdyo3Z-GhE3jq5NiADD-VaEVzKGP6pz4QWOfx3xlMQWSO08KOK9sn8v2rruuRygDM9E4gO7u8HR65OusJxus1PWfCzWGRa0UwH0eCyrSmUe2ajUjaSdzYYSacf926NFjDg93netyQLqiUzf7YWbC5LQ-Y9SUvNDjocb2gCtGJvRp3-p8l0000__y30000)

* Biểu đồ ngữ cảnh - ProjectManagementDatabase:

![Diagram](https://www.planttext.com/api/plantuml/png/bD2z2i8m40VmFKznPEyBE4WB8ZW8fHt5uKpFppJHv3eKySaSV2HVmJIs86W7insv_--uUzuVgMTqtDHQe6Bh8AlgWm7qW4ASKPrmHo1pPu-aU8acb3KPdY7Z1Zr9k0e83o59fh3AiNLMQoXRprIlOGAoe4j3dg4dae8qCbKGMZi85cPhPJI-qczoR7JKvyHgFzZGVGtMUEoJZH4em-AXBOgPKkJzNzIlfRbnfaTk8YLJTHT-0G00__y30000)

2. Analysis Class to Design Element Map

  Biểu đồ này chuyển đổi từ phân tích yêu cầu thành các thành phần thiết kế cụ thể:

* Employee và Admin: Hai lớp đại diện cho người dùng hệ thống, mỗi lớp có các thuộc tính và chức năng riêng như Name, Role hoặc Authentication.
* PayrollSystem: Lớp trung tâm thực hiện các chức năng chính như xử lý thanh toán (ProcessPayment) và tạo phiếu lương (GeneratePayslip).
* BankSystem: Lớp đảm nhiệm chức năng chuyển khoản, nhận dữ liệu từ Payroll System.
* PrintService: Lớp phục vụ in ấn các tài liệu liên quan.
* ProjectManagementDatabase: Lớp hỗ trợ truy xuất thông tin về dự án từ cơ sở dữ liệu.

  Biểu đồ này cho thấy sự liên kết giữa các lớp trong hệ thống và các chức năng chính của chúng:

![Diagram](https://www.planttext.com/api/plantuml/png/V99BJiGm38RtFKNLrR2O2x10CwWCOi6eed00anecaCV8Ta4LucGiE19N854wVKY5RjBOts_dT_BpzRrX0PBMcamPOCwlxD7u3Z7_oFBuxS5Y-hifqrg30UgopwnNR1khtGb_O2GtIAgGV_VKfDsTDpZAAkZ86rDtB6XFyegyGkQGi-XaTPQYr-YGG324sUXZ20zLBi6zpalS4pX-Gjgrhk4fMf5sKYEzQOLZln0hlMhxTXFOlw2IMt3mZ35PWi0ZyA3SeQX3JvKee4tVREvhlRuOHtgU5wbWiK2bCGPasyeXDDGgE5u29vO37GQ-1CtC_eVzPJCUHCMxAB8DkYO-a5y0003__mC0)
