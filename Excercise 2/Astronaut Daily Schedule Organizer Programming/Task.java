package Excercise2;

public class Task{
        private String TaskName ;
        private String startTime;
        private String endTime;
        private String priority;
        private boolean completed;
    
        public Task(String TaskName , String startTime, String endTime, String priority) {
            this.TaskName  = TaskName ;
            this.startTime = startTime;
            this.endTime = endTime;
            this.priority = priority;
            this.completed = false;
        }
    
        public String getTaskName () {
            return TaskName ;
        }
    
        public String getStartTime() {
            return startTime;
        }
    
        public String getEndTime() {
            return endTime;
        }
    
        public String getPriority() {
            return priority;
        }
    
        public boolean isCompleted() {
            return completed;
        }
    
        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
       
    
    
        @Override
        public String toString() {
            return TaskName  + " [" + startTime + " to " + endTime + ", " + priority + "]" + (completed ? " (Completed)" : "");
        }
    }
    
     
     
    
