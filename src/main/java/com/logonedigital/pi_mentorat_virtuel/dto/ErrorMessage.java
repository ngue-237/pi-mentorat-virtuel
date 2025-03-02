<<<<<<< HEAD:src/main/java/com/logonedigital/pi_mentorat_virtuel/ErrorMessage.java
package com.logonedigital.pi_mentorat_virtuel;

=======
package com.logonedigital.pi_mentorat_virtuel.dto;
>>>>>>> origin/main:src/main/java/com/logonedigital/pi_mentorat_virtuel/dto/ErrorMessage.java

import lombok.*;

import java.util.Date;
@Setter
@Getter
@Data
public class ErrorMessage {
    private int status;
    private String msg;
    private String error;
    private Date timestamp;

    public ErrorMessage() {
    }

    public ErrorMessage(int status, String msg, String error, Date timestamp) {
        this.status = status;
        this.msg = msg;
        this.error = error;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
<<<<<<< HEAD:src/main/java/com/logonedigital/pi_mentorat_virtuel/ErrorMessage.java
    }

=======
}
>>>>>>> origin/main:src/main/java/com/logonedigital/pi_mentorat_virtuel/dto/ErrorMessage.java
