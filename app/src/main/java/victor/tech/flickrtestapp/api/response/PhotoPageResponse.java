package victor.tech.flickrtestapp.api.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import victor.tech.flickrtestapp.api.entity.PhotoData;

public class PhotoPageResponse extends BaseResponse {

    @Expose
    @SerializedName("photos")
    private PhotoPage page;

    public PhotoPageResponse() {

    }

    public PhotoPage getPage() {
        return page;
    }

    public void setPage(PhotoPage page) {
        this.page = page;
    }

    public static class PhotoPage implements Serializable {

        @Expose
        @SerializedName("photo")
        private List<PhotoData> photos;

        public PhotoPage() {

        }

        public List<PhotoData> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotoData> photos) {
            this.photos = photos;
        }
    }

}
