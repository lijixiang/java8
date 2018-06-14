package methodref;

public class Student {
    private String name;
    private int score;

    public static int compareStudentByScore(Student s1,Student s2){
        return s1.getScore() - s2.getScore();
    }
    public static int compareStudentByName(Student s1,Student s2){
        return s1.getName().compareToIgnoreCase(s2.getName());
    }

    public int compareByScore(Student s1){
        return this.getScore() - s1.getScore();
    }
    public int compareByName(Student s1){
        return this.getName().compareToIgnoreCase(s1.getName());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(String name, int score) {

        this.name = name;
        this.score = score;
    }



}
