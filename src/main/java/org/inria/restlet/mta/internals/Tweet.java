package org.inria.restlet.mta.internals;

public class Tweet {
	String text;
	
	public Tweet(String text){
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
