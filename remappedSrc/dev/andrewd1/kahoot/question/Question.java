package dev.andrewd1.kahoot.question;

import java.util.List;

public class Question {
    public final String question;
    public final List<String> answers;
    public final int time;
    public final String answer;

    public Question(String question, List<String> answers, int time) {
        this.question = question;
        this.answers = answers;
        this.time = time;
        this.answer = answers.get(0);
    }
}
