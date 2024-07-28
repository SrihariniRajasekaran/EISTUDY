package Excercise2;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        TaskFactory taskFactory = new TaskFactory();

        Display user1 = new Display("user1");
        scheduleManager.addObserver(user1);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Task\n2. Remove Task\n3. View Tasks\n4. Mark Task as Completed\n5. Add observer\n6. Remove observer\n7. View by Priority\n8. Edit Existing task\n9. Exit");
            System.out.print(" Select the Option:");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Name: ");
                    String TaskName = scanner.nextLine();
                    System.out.print("Enter Start Time (HH:MM)in 24hrs format: ");
                    String startTime = scanner.nextLine();
                    System.out.print("Enter End Time (HH:MM)in 24hrs format: ");
                    String endTime = scanner.nextLine();
                    System.out.print("Enter Priority: ");
                    String priority = scanner.nextLine();
                    Task task = taskFactory.createTask(TaskName , startTime, endTime, priority);
                    scheduleManager.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter Task Name to Remove: ");
                    String removeTaskName  = scanner.nextLine();
                    scheduleManager.removeTask(removeTaskName);
                    break;
                case 3:
                    for (Task t : scheduleManager.getTasks()) {
                        System.out.println(t);
                    }
                    break;
                case 4:
                    System.out.print("Enter TaskName to Mark as Completed: ");
                    String completedTask = scanner.nextLine();
                    scheduleManager.markTaskAsCompleted(completedTask);
                    break;
                
                case 5:
                    System.out.print("Name of the Observer ");
                    String name = scanner.nextLine();
                    Display user = new Display(name);
                    scheduleManager.addObserver(user);
                    System.out.print(" New observer Added ");
                    break;
                case 6:
                    System.out.print("Name of the Observer ");
                    String deluser = scanner.nextLine();
                    scheduleManager.removeObserver(deluser);
                    System.out.print(" Observer Removed ");
                    break;
                case 7:
                    System.out.print("Enter Priority Level: ");
                    String filterPriority = scanner.nextLine();
                    System.out.println("Tasks with priority " + filterPriority + ":");
                    for (Task t : scheduleManager.getTasksByPriority(filterPriority)) {
                       System.out.println(t);
                    }
                    break;
                case 8:
                    System.out.print("Enter Task Name to Edit: ");
                    String editTaskName = scanner.nextLine();
                    System.out.print("Enter New Task Name: ");
                    String newTaskName= scanner.nextLine();
                    System.out.print("Enter New Start Time (HH:MM)in 24hrs format: ");
                    String newStartTime = scanner.nextLine();
                    System.out.print("Enter New End Time (HH:MM) in 24hrs format: ");
                    String newEndTime = scanner.nextLine();
                    System.out.print("Enter New Priority: ");
                    String newPriority = scanner.nextLine();
                    scheduleManager.editTask(editTaskName, newTaskName, newStartTime, newEndTime, newPriority);
                    break;
                case 9:
                    scanner.close();
                    return;

                
                
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}



