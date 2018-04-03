public class Human {
    private String firstName;
    private String surname;
    private String patronymic;//отчество
    private int yearOfBirth;
    public Human(String firstName, String surname, String patronymic, int yearOfBirth){
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.yearOfBirth = yearOfBirth;
    }
    public Human(Human copy){
        this.firstName = copy.firstName;
        this.surname = copy.surname;
        this.patronymic = copy.patronymic;
        this.yearOfBirth = copy.yearOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (yearOfBirth != human.yearOfBirth) return false;
        if (firstName != null ? !firstName.equals(human.firstName) : human.firstName != null) return false;
        if (surname != null ? !surname.equals(human.surname) : human.surname != null) return false;
        return patronymic != null ? patronymic.equals(human.patronymic) : human.patronymic == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + yearOfBirth;
        return result;
    }
}
