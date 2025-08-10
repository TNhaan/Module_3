package AcademyManager;

public class Teacher extends Employee {
    private String subject;
    private int hourWorking;

    public Teacher(String id, String name, int age, String email, int hourWorking, String subject) {
        super(id, name, age, email);
        this.hourWorking = hourWorking;
        this.subject = subject;
    }

    public Teacher() {
    }

    // Calculate salary
    public long calculateSalary(int hourWorking) {
        return hourWorking * 200000L;
    }

    public int getHourWorking() {
        return hourWorking;
    }

    public void setHourWorking(int hourWorking) {
        this.hourWorking = hourWorking;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
