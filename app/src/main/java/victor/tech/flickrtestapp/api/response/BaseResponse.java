package victor.tech.flickrtestapp.api.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    public static final String STATUS_OK = "ok";
    public static final String STATUS_FAIL = "fail";

    @Expose
    @SerializedName("stat")
    private String status;
    @Expose
    @SerializedName("code")
    private Integer code;
    @Expose
    @SerializedName("message")
    private String message;

    public BaseResponse() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isOk() {
        return STATUS_OK.equals(status);
    }
}
