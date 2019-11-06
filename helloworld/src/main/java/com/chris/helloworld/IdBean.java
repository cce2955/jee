package com.chris.helloworld;

public class IdBean {
	private final long id;
    private final String content;
    
    public IdBean(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
