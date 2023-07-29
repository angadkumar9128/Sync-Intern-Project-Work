import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeBuilder {
    private Map<String, Resume> resumes;

    public ResumeBuilder() {
        this.resumes = new HashMap<>();
    }

    public void createResume(String id, String name, String email, String phone, String education,
                             String educationalInstitute, String courseName, String courseStream,
                             List<Experience> experiences, List<Project> projects) {
        Resume resume = new Resume(name, email, phone, education);
        resume.setEducationalInstitute(educationalInstitute);
        resume.setCourseName(courseName);
        resume.setCourseStream(courseStream);

        for (Experience experience : experiences) {
            resume.addExperience(experience);
        }

        for (Project project : projects) {
            resume.addProject(project);
        }

        resumes.put(id, resume);
    }

    public Resume getResume(String id) {
        return resumes.get(id);
    }
}
