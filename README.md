# EISTUDY-2024-25: Coding exercises  
 ## EXCERCISE-1: Problem Statement on Design patterns
 ### 1.CREATIONAL DESIGN PATTERN: 
 It Provide object creation mechanisms that increase flexibility and reuse of existing code.
  Two use cases to demonstrate two behavioural design pattern.
 #### i)Singleton Pattern: 
 Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.
 ##### Example: Logger
 #### ii) Factory Pattern:
 Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
   ##### Example:Tranpertation mode
 ### 2.STRUCTURAL DESIGN PATTERN:
 These patterns explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient.
 Two use cases to demonstrate two creational design pattern.
 #### i)Adapter Pattern:
 Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.
  ##### Example: Temperature Sensor Adapter
  #### ii)Facade Pattern:
  Facade is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes.
 ##### Example: HomeTheater System
  ### 3. BEHAVIOURAL DESIGN PATTERN:
 These patterns are concerned with algorithms and the assignment of responsibilities between objects.
 Two use cases to demonstrate two structural design pattern.
 #### i)Observer Pattern:
 Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.
 ##### Example:Weather Station
 #### ii)Command Pattern:
 Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a 
 Method arguments, delay or queue a request’s execution, and support undoable operations.
##### Example: HomeAutomation System
## EXCERCISE-2:Astronaut Daily Schedule Organizer Programming Exercise
### Problem Statement
Design and implement a console-based application that helps astronauts organize their daily schedules. The application should allow users to add, remove, and view daily tasks. Each task will have a description, start time, end time, and priority level. The intent behind this problem statement is to evaluate your ability to implement a basic CRUD (Create, Read, Update, Delete) application, manage data efficiently, and apply best coding practices
### Functional Requirements
#### Mandatory Requirements
1. Add a new task with description, start time, end time, and priority level.
2. Remove an existing task.
3. View all tasks sorted by start time.
4. Validate that new tasks do not overlap with existing tasks.
5. Provide appropriate error messages for invalid operations.
#### Optional Requirements
1. Edit an existing task.
2. Mark tasks as completed.
3. View tasks for a specific priority level.
#### Non-functional Requirements
1. The application should handle exceptions gracefully.
2. Ensure the application is optimized for performance.
3. Implement a logging mechanism for tracking application usage and errors.
### Key Focus
Design Patterns to be used
1. Singleton Pattern: Ensure there is only one instance of the schedule manager.
2. Factory Pattern: Use a factory to create task objects.
3. Observer Pattern: Notify users of task conflicts or updates.
### Detailed Instructions
1. Use the Singleton Pattern to create a ScheduleManager class that manages all tasks.
2. Implement a TaskFactory class to create Task objects.
3. Use the Observer Pattern to alert users if a new task conflicts with an existing one.
Possible Inputs and Corresponding Outputs
### Positive Cases
1. Input: Add Task("Morning Exercise", "07:00", "08:00", "High") Output: Task added successfully. No conflicts.
2. Input: Add Task("Team Meeting", "09:00", "10:00", "Medium") Output: Task added successfully. No conflicts.
3. Input: View Tasks Output:
a. 07:00 - 08:00: Morning Exercise [High]
b. 09:00 - 10:00: Team Meeting [Medium]
4. Input: Remove Task("Morning Exercise") Output: Task removed successfully.
5. Input: Add Task("Lunch Break", "12:00", "13:00", "Low") Output: Task added successfully. No conflicts.
### Negative Cases
1. Input: Add Task("Training Session", "09:30", "10:30", "High") Output: Error: Task conflicts with existing task "Team Meeting".
2. Input: Remove Task("Non-existent Task") Output: Error: Task not found.
3. Input: Add Task("Invalid Time Task", "25:00", "26:00", "Low") Output: Error: Invalid time format.
4. Input: Add Task("Overlap Task", "08:30", "09:30", "Medium") Output: Error: Task conflicts with existing task "Team Meeting".
5. Input: View Tasks (when no tasks exist) Output: No tasks scheduled for the day.
                              
