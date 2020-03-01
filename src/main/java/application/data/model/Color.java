package application.data.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "dbo_color")
public class Color {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "color_id")
    private int colorId;

    @Column(name = "name")
    private String name;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "short_desc")
    private String shortDesc;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "color")
    private List<ProductEntity> productEntityList = new ArrayList<>();

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }
}
