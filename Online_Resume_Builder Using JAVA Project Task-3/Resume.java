import java.util.ArrayList;
import java.util.List;

public class Resume {
    private String name;
    private String email;
    private String phone;
    private String education;
    private String educationalInstitute;
    private String courseName;
    private String courseStream;
    private List<Experience> experiences;
    private List<Project> projects;

    public Resume(String name, String email, String phone, String education) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.education = education;
        this.experiences = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducationalInstitute() {
        return educationalInstitute;
    }

    public void setEducationalInstitute(String educationalInstitute) {
        this.educationalInstitute = educationalInstitute;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseStream() {
        return courseStream;
    }

    public void setCourseStream(String courseStream) {
        this.courseStream = courseStream;
    }

    // Add methods to add experience and project details
    public void addExperience(Experience experience) {
        experiences.add(experience);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Project> getProjects() {
        return projects;
    }

    // Inner classes (Experience and Project) as before
}
