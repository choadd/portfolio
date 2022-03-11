package net.edupoll.kr.entity;

public class PrevNext {

	private int prev;
	private int next;

	@Override
	public String toString() {
		return "PrevNext [prev=" + prev + ", next=" + next + "]";
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

}
