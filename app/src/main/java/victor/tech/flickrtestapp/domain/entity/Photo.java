package victor.tech.flickrtestapp.domain.entity;


import victor.tech.flickrtestapp.commons.Rectangle;

public class Photo implements Rectangle {

    private String id;
    private String url;
    private String title;
    private int width;
    private int height;

    public Photo(String id, String url, String title, int width, int height) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public int height() {
        return height;
    }

    public int width() {
        return width;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            Photo photoObj = (Photo) obj;
            if (id != null && id.equals(photoObj.getId())) {
                return true;
            }
        }
        return false;
    }
}
