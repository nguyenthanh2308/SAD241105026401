# 1. Login

Mô tả: Quy trình đăng nhập của người dùng vào hệ thống. Người dùng nhập tên và mật khẩu để xác thực và truy cập các chức năng hệ thống.

Biểu đồ PlantUML:

![Diagram](https://www.planttext.com/api/plantuml/png/LD112i8m40NGVKunkD95Bz25r5fTAOZY0SPcg84sAJEfFPmBZ-GLx1HfTH48F-_FGDxFLoOHENPDRR2CWU4gnAOT8bUw5ds4nI5Kpky3Dmj00RtylskZm8Wt51f9aHkZ8IJhaQT0FX9hvB6XZRSd5Ea3s-NAA51Ov2ayi7OM8wdSCjcXvh2MGHKv9DEqBtF1dqcwEaupj9U2t4D_wSgIH8x3mOf-rinannnu1Xbvgx_m0G00__y30000)

Giải thích:
* User nhập tên và mật khẩu.
* LoginForm kiểm tra thông tin người dùng với UserDatabase.
* Nếu thông tin hợp lệ, người dùng được truy cập hệ thống; nếu không hợp lệ, hệ thống hiển thị thông báo lỗi.

# 2. Maintain Timecard
Mô tả: Nhân viên nhập thông tin giờ làm việc vào bảng công của mình. Hệ thống sẽ kiểm tra tính hợp lệ của thông tin và lưu lại.

Biểu đồ PlantUML:

![Diagram](https://www.planttext.com/api/plantuml/png/R95DJiCm58JtFeNL5InwWInGbGJ4fXk8rFN3UQKM_jDxTgkUZGL7uWhO4OuIwCAIvPdvD2D_VtxjE0B5P8q05Jt9HnkCloAAa9-rqW5Sb9j1MrH0uvCdkv70ibpMbXhi8S8RC4wslhtDcSIX4wAcvFPXOZRI1tJLTdSlocCH-xQHHupgL1CBJz_AxPnNYGXThF8CgBb6Zfg3WUi2yBz59Y0z-qHyyFI1ooP3ryWp63r2d4kKqTaoT8iYlnxjtGjoCd4rXU7yDxnQKVJEkwCcEo5kpE2JlxmcfP1vdm-yOuRiq8tbCty0003__mC0)

Giải thích:
* Employee mở bảng công và nhập giờ làm việc.
* TimecardForm hiển thị bảng công hiện tại từ EmployeeDatabase.
* Dữ liệu được kiểm tra tính hợp lệ, sau đó lưu vào cơ sở dữ liệu.

# 3. Run Payroll
Mô tả: Quy trình tính lương cho nhân viên dựa trên dữ liệu bảng công, sau đó thực hiện thanh toán và in phiếu lương.

Biểu đồ PlantUML:

![Diagram](https://www.planttext.com/api/plantuml/png/T591RiCW4Bpp2fIJSyW7V8XIunuh8UK56xADKMomODl8R-kXJ-eNkf2aTeXw0dPcPsTM_7nzxo91e8-X5s381_bo7AmJ8zUiiICuaYiDK_1zhxoZT69OIOXoVZwoNuUnznDY2mG7Y9Z9RVCaQJeqvmngzGWsuCxxAH8E6KxFeZjOHtiCdzPSvNE1ZOZiNcws2tUrp0bl8NJm1cEirc9c97xRrF8ToNHB-yng6xafv731A5IqgkK97GOWl4UCrR9XBRHwKXplr48k9MVqQfdr1dGKgpzscU6sXTJ1btd-lmrvMxoVpb-KPvD8rhitdWKdvEmxTCVqCNu1003__mC0)

Giải thích:
* Admin bắt đầu quy trình tính lương.
* PayrollController lấy dữ liệu nhân viên từ EmployeeDatabase và tính lương cho từng nhân viên.
* Paycheck được tạo và thanh toán qua BankSystem, cuối cùng phiếu lương được in qua PrintService.

# 4. Add Employee
Mô tả: Thêm thông tin nhân viên mới vào hệ thống, bao gồm kiểm tra tính hợp lệ và lưu thông tin vào cơ sở dữ liệu.

Biểu đồ PlantUML:

![Diagram](https://www.planttext.com/api/plantuml/png/V91DRi8m44RtFiM85LrmWIoY06btRDeJJ98f7Sa_aMS2ucmiE19Nm3O80K9TMBBzlUzvvFFnr8XYrCbPWxs62Cl1iJTZkkEUH_GAiqytsd0W-WhHpG05ykOzqg9YXq85QrVleHAcWp7bCLZKnLW1UQLuLv4YMvb_c1p28b45hs1W6IqUydLANnmoTOxrjLodOIhOeUK1bHwdJKYxAlPh_yPmyDyaazKdWU3kttBEry7_SdH5SI_V9fU_iF-P-fv4DcdXbfAX8J_a_xy0003__mC0)

Giải thích:
* Admin nhập thông tin nhân viên mới.
* EmployeeForm kiểm tra tính hợp lệ của dữ liệu và lưu vào EmployeeDatabase.
* Sau khi lưu thành công, thông báo cho Admin.

# 5. Delete Employee
Mô tả: Xóa thông tin nhân viên khỏi hệ thống, bao gồm xác nhận việc xóa và xóa dữ liệu từ cơ sở dữ liệu.

Biểu đồ PlantUML:

![Diagram](https://www.planttext.com/api/plantuml/png/R8yn3i8m34NtdCBg14Clq06LAenCz08cCH2fIQh65U9i31o9A-14GM9WyE3_lh_jz_FL9yQ5LpyfD1mNs5llWff5SyRD61YQWv-d-23Io7Z6H0rW0ZtyDnKeZL8b2TgTM3j8D97XhscCMdgcpLRf8Li4T61YkBZ55-HY42Woj3MXKioeJcNPbg3V4skey7A1xBx5-sarXb8wIk4rx-qfsFpr1m00__y30000)

Giải thích:
* Admin chọn nhân viên cần xóa.
* EmployeeDatabase yêu cầu Employee xác nhận việc xóa.
* Sau khi xác nhận, thông tin của nhân viên sẽ bị xóa khỏi cơ sở dữ liệu.

# 6. Post a Sale
Mô tả: Đăng bán sản phẩm hoặc dịch vụ, bao gồm kiểm tra tính sẵn có và ghi lại thông tin giao dịch.

Biểu đồ PlantUML:

![Diagram](https://www.planttext.com/api/plantuml/png/R90n3i8m303tlC9YWe4FT40WiZ0W8UK59ZKGaIPLx8BwDWQUn1Tm0I5031xiiy-MRvVhd0MBT4qqw2KNS1Y9MogSascL11zQJ0AZ1t0z2pKZG0RdllagdIYfeNzGpVwCMnJS8jDJO8tvs0RJcJehK0cLeMv9C4GUJunp0rHb1Vv0_hWfkUwyB4xASHjYa5wxbCFq9Mc_EYAz5CvMKCZdKlyiiEz9Lh3CQHTAWnBq2NzEv4C-3sNNUK_CQmtSathcbEhXbNS0003__mC0)

Giải thích:
* Salesperson nhập thông tin giao dịch.
* SalesSystem kiểm tra sản phẩm có sẵn trong kho.
* Sau khi xác nhận, thông tin giao dịch được ghi vào SalesDatabase, và Salesperson nhận thông báo thành công.

# 7. Generate Paycheck
Mô tả: Quy trình tạo phiếu lương cho nhân viên sau khi tính toán lương.

Biểu đồ PlantUML:

![Diagram](https://www.planttext.com/api/plantuml/png/P94n3i8m34Ntdi9YWe4BT40LXRqI9x221H5fKZa6gMTZu4XS0QS5IiEKsF_v-qTvtXzL56Ivjgv08u7Xq4UXjkYqQOtjq0ii6kmvE5S7B-aaNW16cCevlMyx5tgY0TBYpykSoLm6jQdduXRzPGmmoAdCfjbwEH3Vh1dzXuOcACOnM6z-SfLm8a-CGf-jorKnoGdMV2KOTERgHam9xS4wCuheaFiT2LeNCu-cLWkctpKpFD-PdbL2ny5GZ3hIafTbK-VO-sc9rClNEe4L-MFwiXS0003__mC0)

Giải thích:
* System yêu cầu tạo phiếu lương.
* PayrollController yêu cầu Employee tính toán mức lương.
* Paycheck được tạo và thanh toán qua BankSystem, cuối cùng phiếu lương được in qua PrintService.

# 8. Change Employee Details
Mô tả: Chỉnh sửa thông tin nhân viên, bao gồm kiểm tra tính hợp lệ và lưu thay đổi.

Biểu đồ PlantUML:

![Diagram](https://www.planttext.com/api/plantuml/png/R95BJiCm48RtFeNLLLdq0bcW4b9stV0um61Fw4X-AJDfbREnu4XS0Tk2448NbcpFvsz-sv_l7tiM66JqJe6HEEWxwocebFV8K88WUdFmoSK9yI4EVgE1TPbSHpeGU0N6YdNjTQWMyqAfsaplRgknqOmEZVnWp_5WIROtgXGBrBMDxb7CQUw60kGu8rshTxC65s7cmxLLeornSZ3zDwoY-6YfdtxBomndS6H1y5WOGblwh3DyCnJ38_Bev8-0uOmlgIZiyk7MZeBTnz3JuAjfVHS-nSlJQ0mo7_E0Dyo6FGPRVlCB003__mC0)

Giải thích:
* Admin chọn nhân viên cần chỉnh sửa.
* EmployeeForm lấy thông tin nhân viên từ EmployeeDatabase và hiển thị.
* Sau khi chỉnh sửa, hệ thống kiểm tra tính hợp lệ và lưu thông tin mới.

# 9. Query Employee Data
Mô tả: Truy vấn thông tin nhân viên từ cơ sở dữ liệu, bao gồm tìm kiếm và hiển thị kết quả.

Biểu đồ PlantUML:

![Diagram](https://www.planttext.com/api/plantuml/png/R8yn3i8m34NtdCBg14Clq06LAXp499Q8bAGXTeUUZO4ZSGNS226GElg_xsVvzNYEB5XbIT6Waxd2sQUGJT4ik50m2tINLEAy4baKl29J1yXWf_rIWpeOqqpGdxGw01DMT_ir7Ox6JXlMS83xGdNzOX8CaRMX2VGV1VtJjgsedHd01ouHTnGZPR-zzmO00F__0m00)

Giải thích:
* Admin yêu cầu truy vấn thông tin nhân viên.
* EmployeeDatabase tìm kiếm và truy vấn dữ liệu từ Employee.
* Thông tin được hiển thị cho Admin.

# 10. Generate Reports
Mô tả: Quy trình tạo báo cáo lương và các báo cáo khác trong hệ thống.

Biểu đồ PlantUML:

![Diagram](https://www.planttext.com/api/plantuml/png/R9113i8W44Ntd6BIbIvw0HQc9eHk2JUOjAEIK8f05psR2u_a5QIqqPguvVt_FfdNuzd4X25DWsNOfJ70kH-COpw_cSvuT0agJNuCgIL70NEa0eoWsz-CmZcCrWfCMBWI_npIM5hhah6o1FKfkpW4kayKqnex79bk5w84XmkbxhRJPwW4r5lFVy7MqPB3TVqhRRfTA9jbAPTr3hs9tkBysMt8zSintW000F__0m00)

Giải thích:
* Admin yêu cầu tạo báo cáo.
* ReportGenerator lấy dữ liệu từ PayrollData.
* ReportFile tạo và hiển thị báo cáo cho Admin.
