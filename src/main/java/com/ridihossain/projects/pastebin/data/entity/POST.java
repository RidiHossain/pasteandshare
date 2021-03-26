package com.ridihossain.projects.pastebin.data.entity;

import javax.persistence.*;

@Entity
@Table(name="POST")
public class POST {
    @Id
    @Column(name="URL")
    private String url;

    @Column(name="CONTENT")
    private String content;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String post) {
        this.content = post;
    }




}
