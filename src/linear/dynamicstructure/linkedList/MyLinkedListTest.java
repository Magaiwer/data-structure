package linear.dynamicstructure.linkedList;

/**
 * @author Magaiver Santos
 */
public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Task> tasks = new MyLinkedList<>();
        System.out.println("Adicionando tarefas no final ");
        tasks.addLast(new Task(0));
        tasks.addLast(new Task(1));
        tasks.addLast(new Task(2));
        tasks.addLast(new Task(3));
        tasks.addLast(new Task(4));
        tasks.addLast(new Task(5));
        tasks.addLast(new Task(6));
        System.out.println("Lista de tarefas" + tasks.toString());
        System.out.println("");

        tasks.addFirst(new Task(7));
        System.out.println("Adicionando tarefa no inicio " + tasks.getFirst());
        System.out.println("");
        System.out.println("Lista de tarefas" + tasks.toString());
        System.out.println("");

        System.out.println("Ultima tarefa --> " + tasks.getLast());
        System.out.println("");
        System.out.println("Primeira tarefa --> " + tasks.getFirst());
        System.out.println("");
        System.out.println("Removendo a ultima  tarefa --> " + tasks.removeLast());
        System.out.println("");
        System.out.println("Lista de tarefas" + tasks.toString());
        System.out.println("");
        System.out.println("Removendo a primeira tarefa --> " + tasks.removeFirst());
        System.out.println("");
        System.out.println("Lista de tarefas" + tasks.toString());

    }

    public static class Task {
        private final int pid;

        public Task(int pid) {
            this.pid = pid;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "pid=" + pid +
                    '}';
        }
    }
}
