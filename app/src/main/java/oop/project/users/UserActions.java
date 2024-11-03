package oop.project.users;

import java.util.List;

public interface UserActions {
    List<?> loadQuestionsFromFile(int labNumber);
    public void showSolutionInNewWindow(int LabNumber, int questionNumber);
}

