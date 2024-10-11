// JAVA PROGRAM - CODSOFT
// TASK 4 - QUIZ APPLICATION WITH TIMER

// Importing Scanner, Timer, TimerTask classes from util package
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

// Storing the quiz data 
class quizData 
{
    String questions;
    String[] options;
    char rightAns;

    quizData(String q, String o[], char r) 
    {
        this.questions = q;
        this.options = o;
        this.rightAns = r;
    }
}

// Quiz questions in an array
class questions
{
    static quizData[] ques = 
    {
        new quizData("Which of these values can a boolean variable contain?", new String[]{"(a) Any integer value", "(b) True & False", "(c) 0 & 1", "(d) true"}, 'd'),
        new quizData("What is the default value of a boolean variable in Java?", new String[]{"(a) true", "(b) false", "(c) 0", "(d) 1", "(e) null"}, 'b'),
        new quizData("How can you achieve multiple inheritance in Java?", new String[]{"(a) Using interfaces", "(b) Using abstract classes", "(c) Using the extends keyword", "(d) Java does not support multiple inheritance"}, 'a')
    };
}

// Quiz Application
class quizApp
{
    static int score = 0;
    static Scanner scanner = new Scanner(System.in);
    static boolean timedOut = false;

    public static void main(String[] args) 
    {
        System.out.println("\n---------------------------------------");
        System.out.println("Quiz Application\n(15 seconds timer for each question)\nNOTE: Enter option");
        System.out.println("\n---------------------------------------");
        System.out.println("QUIZ STARTS NOW....");
        System.out.println("---------------------------------------\n");

        for (quizData q : questions.ques) 
            askQuestion(q);

        System.out.println("\nYour Score is " + score + "/" + questions.ques.length + "\nExiting......");
    }

    // Display quiz data
    static void askQuestion(quizData q) 
    {
        System.out.println("\n-------------------------------------------------------------\n" + q.questions);
        for (String op : q.options) 
            System.out.println(op);

        timedOut = false;

        // Sets a timer to mark timedOut as true and exits the program after 15 seconds
        Timer timer = new Timer();
        timer.schedule(new TimerTask() 
        {
            public void run() 
            {
                timedOut = true;
                System.out.println("\n\nTime Up!");
                System.out.println("Your Score is " + score + "/" + questions.ques.length);
                System.out.println("Exiting.....");
                System.exit(0);
            }
        }, 15000);

        System.out.print("\nYour answer: ");

        // reads and converts input to uppercase
        String input = scanner.nextLine();

        // Stops the timer
        timer.cancel(); 

        // Gets the first character
        char answer = input.charAt(0);

        // Compares the uppercase versions of answer and q.rightAns
        if (Character.toUpperCase(answer) == Character.toUpperCase(q.rightAns)) {
            score++;
            System.out.println("CORRECT!");
        }
        else 
            System.out.println("Incorrect. The correct answer is " + q.rightAns);
    }
}
