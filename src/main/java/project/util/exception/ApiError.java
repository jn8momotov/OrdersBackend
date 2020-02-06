package project.util.exception;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ApiError {
    private HttpStatus status;
    private Instant time;
    private String message;

    public ApiError(HttpStatus status, String message) {
        this.time = Instant.now();
        this.status = status;
        this.message = message;
    }


    public HttpStatus getStatus() {
        return status;
    }

    public ApiError setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public Instant getTime() {
        return time;
    }

    public ApiError setTime(Instant time) {
        this.time = time;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ApiError setMessage(String message) {
        this.message = message;
        return this;
    }
}
