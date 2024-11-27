import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Lớp đại diện cho nhân viên
class Employee {
    private int employeeId;
    private String name;

    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }
}

// Lớp đại diện cho bảng giờ làm việc (Timecard)
class Timecard {
    private int timecardId;
    private int employeeId;
    private String date;
    private int hoursWorked;

    public Timecard(int timecardId, int employeeId, String date, int hoursWorked) {
        this.timecardId = timecardId;
        this.employeeId = employeeId;
        this.date = date;
        this.hoursWorked = hoursWorked;
    }

    public int getTimecardId() {
        return timecardId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDate() {
        return date;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return "Timecard{" +
                "timecardId=" + timecardId +
                ", employeeId=" + employeeId +
                ", date='" + date + '\'' +
                ", hoursWorked=" + hoursWorked +
                '}';
    }
}

// Lớp mô phỏng cơ sở dữ liệu
class Database {
    private Map<Integer, List<Timecard>> timecardDatabase = new HashMap<>();

    public void saveTimecard(Timecard timecard) {
        timecardDatabase
            .computeIfAbsent(timecard.getEmployeeId(), k -> new ArrayList<>())
            .add(timecard);
        System.out.println("Timecard saved: " + timecard.getTimecardId());
    }

    public List<Timecard> getTimecardsByEmployeeId(int employeeId) {
        return timecardDatabase.getOrDefault(employeeId, new ArrayList<>());
    }

    public void updateTimecard(int timecardId, int employeeId, int newHours) {
        List<Timecard> timecards = timecardDatabase.get(employeeId);
        if (timecards != null) {
            for (Timecard timecard : timecards) {
                if (timecard.getTimecardId() == timecardId) {
                    timecard.setHoursWorked(newHours);
                    System.out.println("Timecard updated: " + timecardId);
                    return;
                }
            }
        }
        System.out.println("Timecard not found: " + timecardId);
    }
}

// Lớp điều khiển Bảng Giờ
class TimecardController {
    private Database database;

    public TimecardController(Database database) {
        this.database = database;
    }

    public void addTimecard(int employeeId, String date, int hoursWorked) {
        int timecardId = (int) (Math.random() * 1000);  // Giả lập ID ngẫu nhiên
        Timecard timecard = new Timecard(timecardId, employeeId, date, hoursWorked);
        database.saveTimecard(timecard);
    }

    public void updateTimecard(int timecardId, int employeeId, int newHours) {
        database.updateTimecard(timecardId, employeeId, newHours);
    }

    public List<Timecard> getTimecards(int employeeId) {
        return database.getTimecardsByEmployeeId(employeeId);
    }
}

// Lớp chính để chạy ứng dụng
public class MaintainTimecard {
    public static void main(String[] args) {
        Database database = new Database();
        TimecardController controller = new TimecardController(database);

        // Tạo nhân viên
        Employee employee1 = new Employee(1, "John Doe");
        Employee employee2 = new Employee(2, "Jane Smith");

        // Thêm bảng giờ làm việc
        controller.addTimecard(employee1.getEmployeeId(), "2024-05-01", 8);
        controller.addTimecard(employee1.getEmployeeId(), "2024-05-02", 6);
        controller.addTimecard(employee2.getEmployeeId(), "2024-05-01", 7);

        // Lấy và hiển thị bảng giờ của nhân viên 1
        System.out.println("Timecards for " + employee1.getName() + ":");
        List<Timecard> johnTimecards = controller.getTimecards(employee1.getEmployeeId());
        for (Timecard tc : johnTimecards) {
            System.out.println(tc);
        }

        // Cập nhật bảng giờ
        System.out.println("Updating timecard...");
        if (!johnTimecards.isEmpty()) {
            controller.updateTimecard(johnTimecards.get(0).getTimecardId(), employee1.getEmployeeId(), 10);
        }

        // Kiểm tra bảng giờ sau khi cập nhật
        System.out.println("Updated Timecards for " + employee1.getName() + ":");
        johnTimecards = controller.getTimecards(employee1.getEmployeeId());
        for (Timecard tc : johnTimecards) {
            System.out.println(tc);
        }
    }
}
