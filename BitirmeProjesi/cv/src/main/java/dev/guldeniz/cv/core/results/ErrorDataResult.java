package dev.guldeniz.cv.core.results;

public class ErrorDataResult<T> extends DataResult<T> {

	
	public ErrorDataResult(T data) {
		super(data, false);
		// TODO Auto-generated constructor stub
	}

	public ErrorDataResult(T data, boolean success, String message) {
		super(data, false, message);
		// TODO Auto-generated constructor stub
	}
	
	public ErrorDataResult() {
		super(null,false);
	}

	public ErrorDataResult(String message) {
		super(null, false, message);
	}
}
