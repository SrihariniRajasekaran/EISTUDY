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
        public void setTaskName(String TaskName) {
            this.TaskName = TaskName;
        }
    
        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }
    
        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
    
        public void setPriority(String priority) {
            this.priority = priority;
        }
    
    
        @Override
        public String toString() {
            return TaskName  + " [" + startTime + " to " + endTime + ", " + priority + "]" + (completed ? " (Completed)" : "");
        }
    }
    
     
     
    
