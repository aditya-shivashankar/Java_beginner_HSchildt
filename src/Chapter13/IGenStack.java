package Chapter13;


// A generic queue interface
public interface IGenStack<T> {

    // Push an item in the stack
    void push(T obj) throws StackFullException;

    // pop an item from the stack
    T pop() throws StackEmptyException;
}
