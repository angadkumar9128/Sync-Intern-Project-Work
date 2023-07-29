import java.util.ArrayList;
import java.util.List;

public class Experience {
    private String companyName;
    private String jobTitle;
    private int yearsOfExperience;
    private List<String> skills;

    public Experience(String companyName, String jobTitle, int yearsOfExperience) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.yearsOfExperience = yearsOfExperience;
        this.skills = new ArrayList<>();
    }

    // Getters and Setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    // Add methods to add and retrieve skills
    public void addSkill(String skill) {
        skills.add(skill);
    }

    public List<String> getSkills() {
        return skills;
    }
}
