package AcademyManager;

public class BackendStudent extends Student {
    private String programLanguage;

    public BackendStudent(String id, String name, int age, String email, double averagePoint, int numberOfLesson, String programLanguage) {
        super(id, name, age, email, averagePoint, numberOfLesson);
        this.programLanguage = programLanguage;
    }

    public BackendStudent() {
    }

    @Override
    public String ranking(double averagePoint) {
        if (averagePoint >= 7.5) {
            return "Distinction";
        } else if (averagePoint >= 5) {
            return "Good";
        } else {
            return "Average";
        }
    }

    @Override
    public long tuition(int numberOfLesson) {
        return numberOfLesson * 50000L;
    }
}
