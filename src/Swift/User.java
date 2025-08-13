package Swift;

public abstract class User {
    // Declare attributes:
    protected String name;
    protected int age;
    protected String cpf;

    // Implement builder method
    public User(String name, int age, String cpf){
        this.name = name;
        this.age = age;
        this.cpf = cpf;
    }

    // Implement getters and setters methods:
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCpf() {
        return cpf;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // Declare behaviour methods
    public boolean checkAge(){
        return age >= 18;
    }
    public boolean checkCPF(){
        return cpf.length() == 12;
    }

    // Declare abstract methods
    public abstract boolean login();
    public abstract boolean updateProfile();
}
