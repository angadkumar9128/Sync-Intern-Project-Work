import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter your educational institute name: ");
        String educationalInstitute = scanner.nextLine();

        System.out.print("Enter your course name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter your course stream name: ");
        String courseStream = scanner.nextLine();

        System.out.print("Enter your education details: ");
        String education = scanner.nextLine();

        ResumeBuilder resumeBuilder = new ResumeBuilder();

        // Create a new resume
        Resume resume = new Resume(name, email, phone, education);
        resume.setEducationalInstitute(educationalInstitute);
        resume.setCourseName(courseName);
        resume.setCourseStream(courseStream);

        boolean addExperience = true;
        while (addExperience) {
            System.out.print("Enter company name (or type 'exit' to finish adding experience): ");
            String companyName = scanner.nextLine();
            if ("exit".equalsIgnoreCase(companyName)) {
                addExperience = false;
                break;
            }

            System.out.print("Enter job title: ");
            String jobTitle = scanner.nextLine();

            System.out.print("Enter years of experience: ");
            int yearsOfExperience = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading int

            Experience experience = new Experience(companyName, jobTitle, yearsOfExperience);

            boolean addSkill = true;
            while (addSkill) {
                System.out.print("Enter a skill (or type 'exit' to finish adding skills): ");
                String skill = scanner.nextLine();
                if ("exit".equalsIgnoreCase(skill)) {
                    addSkill = false;
                } else {
                    experience.addSkill(skill);
                }
            }

            resume.addExperience(experience);
        }

        boolean addProject = true;
        while (addProject) {
            System.out.print("Enter project name (or type 'exit' to finish adding projects): ");
            String projectName = scanner.nextLine();
            if ("exit".equalsIgnoreCase(projectName)) {
                addProject = false;
                break;
            }

            System.out.print("Enter project title: ");
            String projectTitle = scanner.nextLine();

            System.out.print("Enter project description: ");
            String projectDescription = scanner.nextLine();

            Project project = new Project(projectName, projectTitle, projectDescription);
            resume.addProject(project);
        }

        // Close the scanner after reading input
        scanner.close();

        // Add the created resume to the resume builder
        resumeBuilder.createResume("1", name, email, phone, education, educationalInstitute, courseName, courseStream,
                resume.getExperiences(), resume.getProjects());

        // Retrieve the resume
        Resume retrievedResume = resumeBuilder.getResume("1");
        if (retrievedResume != null) {
            System.out.println("\nResume Details:");
            System.out.println("Name: " + retrievedResume.getName());
            System.out.println("Email: " + retrievedResume.getEmail());
            System.out.println("Phone: " + retrievedResume.getPhone());
            System.out.println("Educational Institute: " + retrievedResume.getEducationalInstitute());
            System.out.println("Course Name: " + retrievedResume.getCourseName());
            System.out.println("Course Stream: " + retrievedResume.getCourseStream());
            System.out.println("Education: " + retrievedResume.getEducation());

            // Display experience details
            List<Experience> experiences = retrievedResume.getExperiences();
            if (!experiences.isEmpty()) {
                System.out.println("\nExperience:");
                for (Experience experience : experiences) {
                    System.out.println("Company Name: " + experience.getCompanyName());
                    System.out.println("Job Title: " + experience.getJobTitle());
                    System.out.println("Years of Experience: " + experience.getYearsOfExperience());
                    System.out.println("Skills: " + experience.getSkills());
                    System.out.println();
                }
            }

            // Display project details
            List<Project> projects = retrievedResume.getProjects();
            if (!projects.isEmpty()) {
                System.out.println("\nProjects:");
                for (Project project : projects) {
                    System.out.println("Project Name: " + project.getProjectName());
                    System.out.println("Project Title: " + project.getProjectTitle());
                    System.out.println("Project Description: " + project.getProjectDescription());
                    System.out.println();
                }
            }

            // Create a text file and save resume data
            String txtFileName = "user_resume.txt";
            saveResumeData(retrievedResume, txtFileName);
        } else {
            System.out.println("Resume not found!");
        }
    }

    public static void saveResumeData(Resume resume, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Name: " + resume.getName());
            writer.newLine();
            writer.write("Email: " + resume.getEmail());
            writer.newLine();
            writer.write("Phone: " + resume.getPhone());
            writer.newLine();
            writer.write("Educational Institute: " + resume.getEducationalInstitute());
            writer.newLine();
            writer.write("Course Name: " + resume.getCourseName());
            writer.newLine();
            writer.write("Course Stream: " + resume.getCourseStream());
            writer.newLine();
            writer.write("Education: " + resume.getEducation());
            writer.newLine();

            // Writing experience details
            List<Experience> experiences = resume.getExperiences();
            if (!experiences.isEmpty()) {
                writer.newLine();
                writer.write("Experience:");
                writer.newLine();
                for (Experience experience : experiences) {
                    writer.write("Company Name: " + experience.getCompanyName());
                    writer.newLine();
                    writer.write("Job Title: " + experience.getJobTitle());
                    writer.newLine();
                    writer.write("Years of Experience: " + experience.getYearsOfExperience());
                    writer.newLine();
                    writer.write("Skills: " + experience.getSkills());
                    writer.newLine();
                    writer.newLine();
                }
            }

            // Writing project details
            List<Project> projects = resume.getProjects();
            if (!projects.isEmpty()) {
                writer.newLine();
                writer.write("Projects:");
                writer.newLine();
                for (Project project : projects) {
                    writer.write("Project Name: " + project.getProjectName());
                    writer.newLine();
                    writer.write("Project Title: " + project.getProjectTitle());
                    writer.newLine();
                    writer.write("Project Description: " + project.getProjectDescription());
                    writer.newLine();
                    writer.newLine();
                }
            }

            System.out.println("Resume data saved to " + fileName + " successfully!");
        } catch (IOException e) {
            System.err.println("Error while saving resume data: " + e.getMessage());
        }
    }
}
