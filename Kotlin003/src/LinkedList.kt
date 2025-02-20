class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var newNode: Node<T>? = null
    private var size: Int = 0

    fun isEmpty(): Boolean{
        return size == 0
    }

    override fun toString(): String {
        if(isEmpty()){
            return ""
        }else{
            return "${head}"
        }
    }

    fun push(value: T): LinkedList<T>{
        newNode = Node(value = value, next = null)
        if(head == null){
            head = newNode
            tail = newNode
        }else{
            newNode?.next = head
            head = newNode
        }
        size++
        return this
    }

    fun append(value: T ):LinkedList<T>{
        newNode = Node(value = value, next = null)
        if(isEmpty()){
            head = newNode
            tail = newNode
        }else{
            tail?.next = newNode
            tail = newNode
        }
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentIndex: Int = 0;
        var currentNode: Node<T>? = head;
        while(currentIndex < index && currentNode != null){
            currentNode = currentNode?.next
            currentIndex++
        }
        return currentNode
    }

    fun insertAt(value: T,currentNode: Node<T>?): Node<T>? {
        if(tail == currentNode){
            tail?.next = currentNode
            tail = currentNode
        }
        newNode = Node(value = value, next = null)
        newNode?.next = currentNode?.next
        currentNode?.next = newNode
        return currentNode
    }

}