public class Project {
    private String projectName;
    private String projectTitle;
    private String projectDescription;

    public Project(String projectName, String projectTitle, String projectDescription) {
        this.projectName = projectName;
        this.projectTitle = projectTitle;
        this.projectDescription = projectDescription;
    }

    // Getters and Setters
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
}
