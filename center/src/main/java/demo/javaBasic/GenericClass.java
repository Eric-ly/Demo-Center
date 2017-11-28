package demo.javaBasic;

public class GenericClass<T>
{		 
	    private T data;

	    public GenericClass() {

	    }

	    public GenericClass(T data) {
	        setData(data);
	    }

	    public T getData() {
	        return data;
	    }

	    public void setData(T data) {
	        this.data = data;
	    }

	
}
