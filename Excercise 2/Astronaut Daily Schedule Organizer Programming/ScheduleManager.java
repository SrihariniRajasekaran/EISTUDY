package Excercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface TaskObserver {
    void update(String message);
} 
class Display implements TaskObserver {
    private String name;

    public Display(String name) {
        this.name = name;
    }
     @Override
    public void update(String message) {
        System.out.println(name + ":" + message);
    }
   
}
public class ScheduleManager {
    
 
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<TaskObserver> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }
    @SuppressWarnings("unlikely-arg-type")
    public void removeObserver(String observer) {
        observers.remove(observer);
    }
    
    public void addTask(Task task) {
        if (isValidTask(task)) {
            tasks.add(task);
            Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
            notifyObservers("New Task Added Sucessfully " + task);
        } else {
            notifyObservers("Error: Task conflicts with existing task or invalid time.");
        }
    }

    public void removeTask(String TaskName ) {
        for (Task task : tasks) {
            if (task.getTaskName ().equals(TaskName)) {
                tasks.remove(task);
                notifyObservers("Task removed: " + task);
                return;
            }
        }
        notifyObservers("Error: Task not found: " + TaskName );
    }

    public void markTaskAsCompleted(String TaskName ) {
        for (Task task : tasks) {
            if (task.getTaskName ().equals(TaskName )) {
                task.setCompleted(true);
                notifyObservers("Task marked as completed: " + task);
                return;
            }
        }
        notifyObservers("Error: Task not found: " + TaskName );
    }

    public List<Task> getTasks() {
        if(tasks.isEmpty()){
            System.out.println("No Tasks ");
        }
        System.out.println(" Tasks:\n");
        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
        return tasks;
    }
    private void notifyObservers(String message) {
        for (TaskObserver observer : observers) {
            observer.update(message);
        }
    }
    private boolean isValidTask(Task newTask) {
        for (Task task : tasks) {
            if (isOverlap(task, newTask)) {
                return false;
            }
        }
        return isValidTimeFormat(newTask.getStartTime()) && isValidTimeFormat(newTask.getEndTime());
    }

    private boolean isOverlap(Task existingTask, Task newTask) {
        return (newTask.getStartTime().compareTo(existingTask.getEndTime()) < 0 && newTask.getEndTime().compareTo(existingTask.getStartTime()) > 0);
    }

    private boolean isValidTimeFormat(String time) {
        return time.matches("([0-1]?[0-9]|2[0-3]):[0-5][0-9]");
    }

}

    
