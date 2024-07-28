package Excercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());
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
            notifyObservers("New Task Added Sucessfully- " + task);
            logger.log(Level.INFO, "Task Added: {0}", task);
        } else {
            notifyObservers("Error: Task conflicts with existing task or invalid time.");
            logger.log(Level.WARNING, "Failed to Add task due to conflict or invalid time: {0}", task);
        }
    }

    public void removeTask(String TaskName ) {
        for (Task task : tasks) {
            if (task.getTaskName ().equals(TaskName)) {
                tasks.remove(task);
                notifyObservers("Task removed: " + task);
                logger.log(Level.INFO, "Task removed: {0}", task);
                return;
            }
        }
        notifyObservers("Error: Task not found: " + TaskName );
        logger.log(Level.WARNING, "Failed to Remove task due to conflict or invalid time: {0}", TaskName);
    }

    public void markTaskAsCompleted(String TaskName ) {
        for (Task task : tasks) {
            if (task.getTaskName ().equals(TaskName )) {
                task.setCompleted(true);
                notifyObservers("Task marked as completed: " + task);
                logger.log(Level.INFO, "Mark As Completed: {0}", task);
                return;
            }
        }
        notifyObservers("Error: Task not found: " + TaskName );
        logger.log(Level.WARNING, "Failed to mark as completed task due to conflict or invalid time: {0}", TaskName);
    }

    public List<Task> getTasks() {
        if(tasks.isEmpty()){
            System.out.println("No Tasks scheduled for the day.");
        }
        else{
        System.out.println(" \nTasks:");
        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));}
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
    public List<Task> getTasksByPriority(String priority) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                filteredTasks.add(task);
            }
        }
        filteredTasks.sort(Comparator.comparing(Task::getStartTime)); 
        return filteredTasks;
    }
    public void editTask(String TaskName, String newTaskName, String newStartTime, String newEndTime, String newPriority) {
        for (Task task : tasks) {
            if (task.getTaskName().equals(TaskName)) {
                Task editedTask = new Task(newTaskName, newStartTime, newEndTime, newPriority);
                if (isValidTask(editedTask) || (task.getStartTime().equals(newStartTime) && task.getEndTime().equals(newEndTime))) {
                    task.setTaskName(newTaskName);
                    task.setStartTime(newStartTime);
                    task.setEndTime(newEndTime);
                    task.setPriority(newPriority);
                    Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
                    notifyObservers("Task edited: " + task);
                    logger.log(Level.INFO, "Task Edited: {0}", task);
                } else {
                    notifyObservers("Error: Edited task conflicts with existing tasks or invalid time.");
                    logger.log(Level.WARNING, "Failed to Edit the task due to conflict or invalid time: {0}", TaskName);
                }
                return; 
            }
        }
        notifyObservers("Error: Task not found: " + TaskName);
    }
    
}

    
