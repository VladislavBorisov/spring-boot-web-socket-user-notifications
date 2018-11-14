package sherybedrock;

import lombok.Builder;

@Builder
public class Notification {

    private long room;
    private String message;

    public Notification(long room, String content) {
        this.room = room;
        this.message = content;
    }

    public long getRoom() {
        return room;
    }

    public void setRoom(long room) {
        this.room = room;
    }

    public String getContent() {
        return message;
    }

}
