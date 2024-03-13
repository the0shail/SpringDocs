package the.zero.shail.sender.util;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ServerResponse<D>{
    private final int status;
    private final String message;
    private final D data;
    private final LocalDateTime timestamp;

    public ServerResponse(int status, String message, D data, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }
}
