package qls.ast;

import qls.QLSNode;

public abstract class Literal<T> implements QLSNode {
	private final T value;
	
	public Literal(T value) {
		this.value = value;
	}
	
	public abstract QLSType getType();
	
	public T getValue() {
		return this.value;
	}	
	
	public String toString() {
		return value.toString();
	}
}
