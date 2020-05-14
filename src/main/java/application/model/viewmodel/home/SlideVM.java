package application.model.viewmodel.home;

public class SlideVM {
    private String title;
    private String caption;
    private String link;
    private String name;
    private String imageSlide;

    public SlideVM(String title, String caption, String link, String name, String imageSlide) {
        this.title = title;
        this.caption = caption;
        this.link = link;
        this.name = name;
        this.imageSlide = imageSlide;
    }

    public String getImageSlide() {
        return imageSlide;
    }

    public void setImageSlide(String imageSlide) {
        this.imageSlide = imageSlide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

