package victor.tech.flickrtestapp.api.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PhotoSize implements Serializable {

    @Expose
    @SerializedName("width")
    private Integer width;
    @Expose
    @SerializedName("height")
    private Integer height;
    @Expose
    @SerializedName("source")
    private String source;
    @Expose
    @SerializedName("label")
    private String label;

    public PhotoSize() {

    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
