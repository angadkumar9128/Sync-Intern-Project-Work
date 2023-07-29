import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Survey {
    private String title;
    private ArrayList<String> questions;

    public Survey(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(String question) {
        questions.add(question);
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public String getTitle() {
        return title;
    }
}

class SurveyResponse {
    private Survey survey;
    private HashMap<String, String> responses;

    public SurveyResponse(Survey survey) {
        this.survey = survey;
        this.responses = new HashMap<>();
    }

    public void addResponse(int questionNumber, String response) {
        if (questionNumber >= 0 && questionNumber < survey.getQuestions().size()) {
            responses.put(survey.getQuestions().get(questionNumber), response);
        }
    }

    public HashMap<String, String> getResponses() {
        return responses;
    }

    public Survey getSurvey() {
        return survey;
    }
}

class SurveySystem {
    private ArrayList<Survey> surveys;
    private ArrayList<SurveyResponse> surveyResponses;
    private Scanner scanner;

    public SurveySystem() {
        this.surveys = new ArrayList<>();
        this.surveyResponses = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void createSurvey() {
        System.out.println("Enter the title of the survey:");
        String title = scanner.nextLine();
        Survey survey = new Survey(title);

        System.out.println("Enter the number of questions in the survey:");
        int numQuestions = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numQuestions; i++) {
            System.out.println("Enter question " + (i + 1) + ":");
            String question = scanner.nextLine();
            survey.addQuestion(question);
        }

        surveys.add(survey);
        System.out.println("Survey created successfully.");
    }

    public void takeSurvey() {
        if (surveys.isEmpty()) {
            System.out.println("No surveys available.");
            return;
        }

        System.out.println("Choose a survey to take:");

        for (int i = 0; i < surveys.size(); i++) {
            System.out.println((i + 1) + ". " + surveys.get(i).getTitle());
        }

        int surveyChoice = Integer.parseInt(scanner.nextLine()) - 1;

        if (surveyChoice >= 0 && surveyChoice < surveys.size()) {
            Survey survey = surveys.get(surveyChoice);
            SurveyResponse response = new SurveyResponse(survey);

            for (int i = 0; i < survey.getQuestions().size(); i++) {
                System.out.println("Q" + (i + 1) + ". " + survey.getQuestions().get(i));
                System.out.println("Enter your response:");
                String userResponse = scanner.nextLine();
                response.addResponse(i, userResponse);
            }

            surveyResponses.add(response);
            System.out.println("Survey completed successfully.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void viewSurveyResults() {
        if (surveyResponses.isEmpty()) {
            System.out.println("No survey responses yet.");
            return;
        }

        System.out.println("Choose a survey to view results:");

        for (int i = 0; i < surveys.size(); i++) {
            System.out.println((i + 1) + ". " + surveys.get(i).getTitle());
        }

        int surveyChoice = Integer.parseInt(scanner.nextLine()) - 1;

        if (surveyChoice >= 0 && surveyChoice < surveys.size()) {
            Survey survey = surveys.get(surveyChoice);
            ArrayList<SurveyResponse> responsesForSurvey = new ArrayList<>();

            for (SurveyResponse response : surveyResponses) {
                if (response.getSurvey() == survey) {
                    responsesForSurvey.add(response);
                }
            }

            if (responsesForSurvey.isEmpty()) {
                System.out.println("No responses for this survey yet.");
            } else {
                System.out.println("Survey Results:");
                for (SurveyResponse response : responsesForSurvey) {
                    System.out.println("Response:");
                    HashMap<String, String> responses = response.getResponses();
                    for (Map.Entry<String, String> entry : responses.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    System.out.println();
                }
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void displayMenu() {
        System.out.println("\nWelcome to the Online Survey System!");
        while (true) {
            System.out.println("1. Create a new survey");
            System.out.println("2. Take a survey");
            System.out.println("3. View survey results");
            System.out.println("4. Exit");
            System.out.println("\nSelect an option:");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createSurvey();
                    break;
                case 2:
                    takeSurvey();
                    break;
                case 3:
                    viewSurveyResults();
                    break;
                case 4:
                    System.out.println("Thank you for using the Online Survey System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SurveySystem surveySystem = new SurveySystem();
        surveySystem.displayMenu();
    }
}
