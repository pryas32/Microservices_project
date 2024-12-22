package com.Icwd.user.service.payload;




import org.springframework.http.HttpStatus;

public class ApiResponse {

    private String message;
    private boolean success;
    private HttpStatus status;

    // Default constructor
    public ApiResponse() {}

    // Constructor with parameters
    public ApiResponse(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    // Builder pattern implementation
    public static class Builder {

        private String message;
        private boolean success;
        private HttpStatus status;

        // Set the message
        public Builder message(String message) {
            this.message = message;
            return this;
        }

        // Set the success flag
        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        // Set the status
        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        // Build the ApiResponse object
        public ApiResponse build() {
            return new ApiResponse(message, success, status);
        }
    }

    // Optional: Static method to get a builder
    public static Builder builder() {
        return new Builder();
    }
}
