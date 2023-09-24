import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void findTrueSimpleTask() {
        Task simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = true;
        boolean actual = simpleTask.matches("родителям");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findFalseSimpleTask() {
        Task simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = false;
        boolean actual = simpleTask.matches("теория");
        Assertions.assertEquals(expected, actual);
    }

    @Test
   public void findTrueMeetingTask() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void findFalseMeetingTask() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");
        boolean expected = false;
        boolean actual = meeting.matches("вторник");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void findTrueEpicTask() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Task epic = new Epic(55, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void findFalseEpicTask() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Task epic = new Epic(55, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("Персики");
        Assertions.assertEquals(expected, actual);
    }
}