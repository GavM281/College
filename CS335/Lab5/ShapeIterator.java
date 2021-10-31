package lab5;

import java.util.Iterator;

/*
 * Gavin Mulhern
 * 10/3/21
 */

public class ShapeIterator implements Iterator<Shape>{

	private Shape [] shapes;
	int pos;
	
	public ShapeIterator(Shape []shapes){
		this.shapes = shapes;
	}
	@Override
	public boolean hasNext() {
		if(pos >= shapes.length || shapes[pos] == null)
			return false;
		return true;
	}

	@Override
	public Shape next() {
		return shapes[pos++];
	}

	@Override
	public void remove() {
		if(pos <=0 )
			throw new IllegalStateException("Illegal position");
		if(shapes[pos-1] !=null){
			for (int i= pos-1; i<(shapes.length-1);i++){
				shapes[i] = shapes[i+1];
			}
			shapes[shapes.length-1] = null;
		}
	}
	
	
	
	public boolean contains (String shape) {
		for(int i = 0; i<shapes.length;i++) {
			if(shapes[i].getName().equals(shape)) {
				return true;
			}
		}
		return false;
	}
	

	public boolean hasPrev() {
		if(pos == 0 || shapes[pos--] == null) {
			return false;
		}
		return true;
	}

	
	public Shape prev () {
		return shapes[pos--];
	}
}
