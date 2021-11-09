package it.unibo.oop.lab.nesting2;

import java.util.LinkedList;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {
	
	private final List<T> acceptableList;
	
	public OneListAcceptable(List<T> l) {
		this.acceptableList = l;
	}

	@Override
	public Acceptor<T> acceptor() {
		return new Acceptor<T>(){
			
			private List<T> toAccept = new LinkedList<T>(acceptableList);
			
			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {
				if (this.toAccept.isEmpty()
						|| !this.toAccept.remove(0).equals(newElement)) {
					throw new Acceptor.ElementNotAcceptedException(newElement);
				}
			}

			@Override
			public void end() throws EndNotAcceptedException {
				if (!this.toAccept.isEmpty()) {
					throw new Acceptor.EndNotAcceptedException();
				}
			}

		};
	}

}
