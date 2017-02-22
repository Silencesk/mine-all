package com.mine.simpler.enums;

public enum ImageType {
	JPG("jpg"),
	PNG("png"),
	TIFF("tiff"),
	PDF("pdf");
	
	private String type;
	
	private ImageType(String type){
		this.setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
