package ProjectCoWorking.models;

public class Feedback {
    int id;
    String message;
    String recallTime;
    int userId;

    public Feedback() {
    }

    public Feedback(int id, String message, String recallTime, int userId) {
        this.id = id;
        this.message = message;
        this.recallTime = recallTime;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getRecallTime() {
        return recallTime;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", recallTime='" + recallTime + '\'' +
                ", userId=" + userId +
                '}';
    }
}