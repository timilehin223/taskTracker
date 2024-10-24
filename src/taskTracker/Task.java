package taskTracker;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(int id, String description, Status status, LocalDateTime createdAt) {
        this.id = id;
        this.description = description;
        this.status = Status.TO_DO;
        this.createdAt = LocalDateTime.now();
    }


}
