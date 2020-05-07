package application.model.viewmodel;

import application.extension.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class ColorVM {
    private int id;
    private String name;
    private String shortDesc;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date createdDate;

    public ColorVM(int id, String name, String shortDesc, Date createdDate) {
        this.id = id;
        this.name = name;
        this.shortDesc = shortDesc;
        this.createdDate = createdDate;
    }

    public ColorVM() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
