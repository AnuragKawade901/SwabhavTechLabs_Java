package com.aurionpro.OCP.ContentRenderer.model;

public class Article implements ContentRenderer {

	@Override
	public void getRender() {
		System.out.println("Article is rendering");
	}

}
