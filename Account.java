public class Account {
    private String username;
    private String password;
    private boolean military;
    private boolean senior;
    private boolean teacher;
    private boolean disability;

    public Account() {
        username = "";
        password = "";
        military = false;
        senior = false;
        teacher = false;
        disability = false;
    }

    public Account (String username, String password, boolean military, boolean senior, boolean teacher, boolean disability) {
        setUsername(username);
        setPassword(password);
        setMilitary(military);
        setSenior(senior);
        setTeacher(teacher);
        setDisability(disability);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMilitary() {
        return military;
    }

    public void setMilitary(boolean military) {
        this.military = military;
    }

    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    public boolean isTeacher() {
        return teacher;
    }

    public void setTeacher(boolean teacher) {
        this.teacher = teacher;
    }

    public boolean isDisability() {
        return disability;
    }

    public void setDisability(boolean disability) {
        this.disability = disability;
    }
}
