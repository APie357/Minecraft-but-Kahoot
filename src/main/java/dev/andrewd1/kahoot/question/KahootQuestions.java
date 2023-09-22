package dev.andrewd1.kahoot.question;

import java.util.*;

//@Environment(EnvType.SERVER)
public final class KahootQuestions {
    public static List<Question> questions = new ArrayList<>();

    public static void init() {
        questions.add(new Question("question 1", Arrays.asList("this is a test to see how long this can possibly be before it cuts off or extends too far", "answer 2", "answer 3", "answer 4"), 400));
        questions.add(new Question("question 2", Arrays.asList("answer 1", "answer 2", "answer 3", "answer 4"), 400));
        questions.add(new Question("question 3", Arrays.asList("answer 1", "answer 2"), 400));
    }

    public static Question getRandomQuestion() {
        Random rand = new Random();
        int index = rand.nextInt(0, questions.size());
        return questions.get(index);
    }

    public static Question shuffleQuestion(Question original) {
        List<String> questions = new ArrayList<>(original.answers);
        Collections.shuffle(questions);
        return new Question(original.question, questions, original.time);
    }

    public static Question getRandomShuffledQuestion() {
        return shuffleQuestion(getRandomQuestion());
    }
}
