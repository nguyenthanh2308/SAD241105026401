# 3.Xác định các phần tử thiết kế
 1. Phần tử dữ liệu bệnh nhân (Patient Data Element)
  - Chức năng:  
    - Lưu trữ và quản lý thông tin chi tiết về bệnh nhân, bao gồm:  
      - Thông tin cá nhân (họ tên, mã bệnh nhân, địa chỉ, thông tin liên hệ).
      - Lịch sử chẩn đoán và điều trị.
      - Hồ sơ thuốc đã kê và phản ứng phụ (nếu có).
  - Các thành phần chính:
    - Thuộc tính:
      - PatientID (Mã bệnh nhân): Unique, string.
      - Name, Address, ContactInfo: string.
      - DiagnosisHistory: list of diagnosis objects.
      - PrescriptionHistory: list of prescription objects.
    - Hành vi:
      - AddPatient(), UpdatePatient(), RetrievePatient(), DeletePatient()

 2. Phần tử quản lý lịch hẹn (Appointment Management Element)
  - Chức năng:
    - Đồng bộ hóa lịch hẹn từ hệ thống APPOINTMENTS.
    - Ghi nhận và quản lý các lịch hẹn bị bỏ lỡ.
  - Các thành phần chính:
    - Thuộc tính:
      - AppointmentID: Unique, string.
      - PatientID: Foreign key liên kết với bệnh nhân.
      - DateTime, Status: datetime, string.
    - Hành vi:
      - SyncAppointments(), TrackMissedAppointments(), RescheduleAppointment().

3. Phần tử quản lý cảnh báo nguy cơ (Risk Alert Element)
 - Chức năng:
    - Phát hiện và cảnh báo các nguy cơ liên quan đến hành vi tự hại hoặc gây hại của bệnh nhân.
 - Các thành phần chính:
    - Thuộc tính:
      - RiskID: Unique, string.
      - PatientID: Foreign key.
      - RiskLevel (Low, Medium, High): enum.
      - RiskDetails: string.
    - Hành vi:
      - MonitorRisk(), SendRiskNotification().

4. Phần tử quản lý báo cáo (Report Management Element)
 - Chức năng:
   - Tạo và lưu trữ các báo cáo quản lý hoặc báo cáo ẩn danh.
 - Các thành phần chính:
   - Thuộc tính:
    - ReportID: Unique, string.
    - ReportType (Management, Anonymized): enum.
    - CreatedBy: string.
    - DateCreated: datetime.
  - Hành vi:
    - GenerateReport(), SaveReport(), ExportReport().

5. Phần tử bảo mật và quyền riêng tư (Security and Privacy Element)
  - Chức năng:
    - Bảo vệ dữ liệu và quản lý quyền truy cập hệ thống dựa trên vai trò.
  - Các thành phần chính:
    - Thuộc tính:
      - UserID: Unique, string.
      - Role (Admin, ClinicalStaff, Manager): enum.
      - Permissions: list of permissions.
    - Hành vi:
      - AuthenticateUser(), AssignRole(), LogAccess().
