package Sesion13;

public class Patient {
    private int id;
    public String name;
    public int age;
    public String gender;
    public String disease;

    public Patient(int id, String name, int age, String gender, String disease) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Btth {

}
