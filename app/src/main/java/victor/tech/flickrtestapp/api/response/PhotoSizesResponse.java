package victor.tech.flickrtestapp.api.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import victor.tech.flickrtestapp.api.entity.PhotoSize;

public class PhotoSizesResponse extends BaseResponse {

    @Expose
    @SerializedName("sizes")
    private Sizes sizes;

    public PhotoSizesResponse() {

    }

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public static class Sizes implements Serializable {

        @Expose
        @SerializedName("size")
        private List<PhotoSize> size;

        public Sizes() {

        }

        public List<PhotoSize> getSize() {
            return size;
        }

        public void setSize(List<PhotoSize> size) {
            this.size = size;
        }
    }
}
