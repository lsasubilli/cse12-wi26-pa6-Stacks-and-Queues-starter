// Lalith Sasubilli
public class MyDeque<E> implements DequeInterface{
    public Object[] data;
    int size;
    int rear;
    int front;

    public MyDeque(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        data = new Object[data.length];
    }
    public int size(){
        return size;
    }
    public void expandCapacity(){
        if(data.length == 0){
            data = new Object[10];
        }
        data = new Object[data.length * 2];
        front = 0;
        rear = size - 1;
    }

    public void addFirst(E element){
        if(element == null){throw new NullPointerException();};
        if(size == data.length){
            expandCapacity();
        }
        Object[] newData = new Object[data.length + 1];
        newData[0] = element;
        for(int i = 1; i < newData.length; i++){
            newData[i] = data[(front + i - 1) % data.length];
        }
        data = newData;
        front = 0;
        rear = size;
        size++;
    }
    public void addLast(E element){
        if(element == null){throw new NullPointerException();};
        if(size == data.length){
            expandCapacity();
        }
        Object[] newData = new Object[data.length + 1];
        newData[newData.length - 1] = element;
        for(int i = 0; i < data.length; i++){
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        rear = size;
        size++;
    }
    public E removeFirst(){
        if(size == 0){
            return null;
        }
        E firstElement = (E) data[0];
        Object[] newData = new Object[data.length - 1];
        for(int i = 0; i < newData.length; i++){
            newData[i] = data[(front + i + 1) % data.length];
        }
        data = newData;
        front = 0;
        rear = size - 1;
        size--;
        return (E) firstElement;
    }
    public E removeLast(){
        if(size == 0){
            return null;
        }
        E lastElement = (E) data[size - 1];
        Object[] newData = new Object[data.length - 1];
        for(int i = 0; i < newData.length; i++){
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        rear = size - 1; 
        size--;
        return (E) lastElement;
    }
    public E peekFirst(){
        if(size == 0){
            return null;
        }
        return (E) data[0];
    }
    public E peekLast(){
        if(size == 0){
            return null;
        }
        return (E) data[size - 1];
    }

}
