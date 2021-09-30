package  divya.com.androidquizapplication;

public class QuizWrapper {

    private int qid;
    private String question;
    private String options;
    private int correct_answer;

    public QuizWrapper(int id, String question, String answers, int correctAnswer) {
        this.qid = id;
        this.question = question;
        this.options = answers;
        this.correct_answer = correctAnswer;
    }

    public int getId() {
        return qid;
    }

    public void setId(int id) {
        this.qid = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswers() {
        return options;
    }

    public void setAnswers(String answers) {
        this.options = answers;
    }

    public int getCorrectAnswer() {
        return correct_answer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correct_answer = correctAnswer;
    }
}
