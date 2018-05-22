package victor.tech.flickrtestapp.browser.domain.params;


public class GetPhotoParams {

    private int page;
    private int perPage;
    private int widthThreshold;
    private int heightThreshold;

    public GetPhotoParams(int page, int perPage, int widthThreshold, int heightThreshold) {
        this.page = page;
        this.perPage = perPage;
        this.widthThreshold = widthThreshold;
        this.heightThreshold = heightThreshold;
    }

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getWidthTreshold() {
        return widthThreshold;
    }

    public int getHeightTreshold() {
        return heightThreshold;
    }
}
