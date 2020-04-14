public class Account {
    private String username;
    private String password;
    private boolean military;
    private boolean senior;
    private boolean teacher;
    private boolean disability;
    private boolean student;
    private boolean discount;
    private Payment payment;
    private AccountType type;

    public Account() {
        username = "";
        password = "";
        military = false;
        senior = false;
        teacher = false;
        disability = false;
        student = false;
        discount = false;
        payment = null;
        type = null;
    }

    public Account(String username, String password, boolean military, boolean senior, boolean teacher,
                   boolean disability, boolean student, boolean discount, Payment payment, AccountType type) {
        setUsername(username);
        setPassword(password);
        setMilitary(military);
        setSenior(senior);
        setTeacher(teacher);
        setDisability(disability);
        setStudent(student);
        setDiscount(discount);
        setPayment(payment);
        setAccountType(type);
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

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getAccountType() {
        return type.getAccountType();
    }

    public void setAccountType(AccountType type) {
        this.type = type;
    }
}