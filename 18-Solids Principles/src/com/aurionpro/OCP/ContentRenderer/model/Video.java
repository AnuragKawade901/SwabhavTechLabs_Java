package com.aurionpro.OCP.ContentRenderer.model;

public class Video implements ContentRenderer {
	@Override
	public void getRender() {
		System.out.println("Video is rendering");
	}

}
