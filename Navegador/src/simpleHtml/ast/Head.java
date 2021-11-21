package simpleHtml.ast;

import simpleHtml.visitor.Visitor;

public class Head implements AstHtml {
	
	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	Title title;
	Link link;
	
	public Head(Title title, Link link) {
		this.title = title;
		this.link = link;
	}
	
	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

}
