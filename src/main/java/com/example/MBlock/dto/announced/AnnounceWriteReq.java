package com.example.MBlock.dto.announced;

import org.springframework.web.multipart.MultipartFile;

public class AnnounceWriteReq {

    private String title;

    private String content;

    private String writer;

    private MultipartFile file;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
