package Excercise2;

public class TaskFactory {
    
        public Task createTask(String TaskName, String startTime, String endTime, String priority) {
            return new Task(TaskName, startTime, endTime, priority);
        }
    }
    
