# TaskTracker CLI Application

This is a simple command-line interface (CLI) application for managing tasks. The application allows users to add, update, delete, and list tasks. Tasks are stored in a JSON file (`tasks.json`) for persistence, and the application can update and read from this file as users interact with it. It is a solution to the following project: https://roadmap.sh/projects/task-tracker

## Features

- **Add a Task:** Create a new task with a unique ID, description, and initial status.
- **Update a Task:** Modify the description or status of an existing task.
- **Delete a Task:** Remove a task by its unique ID.
- **List All Tasks:** View all tasks along with their details such as ID, description, status, creation, and update timestamps.
- **Persist Tasks:** Tasks are saved to a `tasks.json` file, allowing for data persistence between application sessions.

## Task Properties

Each task has the following properties:

- **ID:** A unique identifier for each task.
- **Description:** A brief summary of the task.
- **Status:** One of three states (`TO_DO`, `IN_PROGRESS`, `DONE`).
- **Created At:** The date and time when the task was created.
- **Updated At:** The date and time when the task was last updated.

## Prerequisites

- **Java:** Make sure you have Java installed on your system.
- **JSON:** The application uses the native Java I/O functionality to read from and write to a JSON file (`tasks.json`).

## Usage

### Running the Application

To run the application, compile and execute the `Runner` class in your terminal or IDE.

```bash
javac taskTracker/Runner.java
java taskTracker.Runner
```

### Options

When you run the application, you will be presented with the following menu options:

1. **Create New Task:** Allows you to enter a new task with a unique ID and description.
2. **Update Task:** Allows you to update a task by its ID, changing either the description, status, or both.
3. **Delete Task:** Allows you to delete a task by its ID.
4. **Exit:** Exits the application.

### Adding a Task

```bash
Choose an option:
1. Create New Task
```

You will be prompted to enter:
- A unique task ID (integer).
- A description of the task (string).

The task will automatically be assigned a status of `TO_DO` and stored in `tasks.json`.

### Updating a Task

```bash
Choose an option:
2. Update Task
```

You will be prompted to:
- Select a task by its ID.
- Choose what to update: description, status, or both.
- Update the description or change the status (`TO_DO`, `IN_PROGRESS`, `DONE`).

### Deleting a Task

```bash
Choose an option:
3. Delete Task
```

You will be prompted to enter the ID of the task to delete. The task will be removed from the list and the `tasks.json` file.

### Listing All Tasks

Currently, tasks are automatically listed during update and delete operations to help users identify task IDs. A separate method (`listTasks`) is available to display all tasks in the console.

## Contributing

Feel free to submit issues or pull requests to suggest improvements or fix bugs!

## License

This project is open-source and licensed under the MIT License.

---
