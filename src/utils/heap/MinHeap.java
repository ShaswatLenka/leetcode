package utils.heap;

/**
 *
 Create a complete binary tree using an array, then use the binary tree to construct a heap
 *
  */
public class MinHeap {
    int[] minHeap;
    int heapSize; // number of elements in the heap is required for instantiating array
    int realSize = 0; // realSize records the number of elements in the heap

    public MinHeap(int heapSize) {
        this.heapSize = heapSize;
        minHeap = new int[heapSize + 1];
        // To better track the indices of the binary tree,
        // we will not use the 0-th element in the array
        minHeap[0] = 0;
    }

    public void add(int element) {
        realSize++;
        if (realSize > heapSize) {
            System.out.println("Added too many elements");
            realSize--;
            return;
        }
        minHeap[realSize] = element;
        int index = realSize;

        /*
          Note: We are using an array to represent a complete binary tree with root node at index 1
          in this case:
           parent of any node = [index of node/2]
           left child = [index of node * 2]
           right child = [index of node * 2 + 1]
         */
        int parent = index / 2;

        /*
        * If the newly added element is smaller than its parent node, then its value will be exchanged with the parent
        * repeat till you reach root
        * O(log N) steps, where N is the heapSize
        * */
        while(minHeap[index] < minHeap[parent] && index > 1) {
            int temp = minHeap[index];
            minHeap[index] = minHeap[parent];
            minHeap[parent] = temp;
            index = parent;
            parent = index / 2;
        }
    }

    // Get top element of the heap
    public int peek() {
        return minHeap[1];
    }


    // Delete the top element of the heap
    public int pop() {
        // If the number of elements in the current Heap is 0,
        // print "Don't have any elements" and return a default value
        if (realSize < 1) {
            System.out.println("Don't have any element!");
            return Integer.MAX_VALUE;
        } else {
            // When there are still elements in the Heap
            // realSize >= 1
            int removeElement = minHeap[1];
            // Put the last element in the Heap to the top of Heap
            minHeap[1] = minHeap[realSize];
            realSize--;
            int index = 1;
            // When the deleted element is not a leaf node
            while (index <= realSize / 2) {
                // the left child of the deleted element
                int left = index * 2;
                // the right child of the deleted element
                int right = (index * 2) + 1;
                // If the deleted element is larger than the left or right child
                // its value needs to be exchanged with the smaller value
                // of the left and right child
                if (minHeap[index] > minHeap[left] || minHeap[index] > minHeap[right]) {
                    if (minHeap[left] < minHeap[right]) {
                        int temp = minHeap[left];
                        minHeap[left] = minHeap[index];
                        minHeap[index] = temp;
                        index = left;
                    } else {
                        // maxHeap[left] >= maxHeap[right]
                        int temp = minHeap[right];
                        minHeap[right] = minHeap[index];
                        minHeap[index] = temp;
                        index = right;
                    }
                } else {
                    break;
                }
            }
            return removeElement;
        }
    }

    // return the number of elements in the Heap
    public int size() {
        return realSize;
    }

    public String toString() {
        if (realSize == 0) {
            return "No element!";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 1; i <= realSize; i++) {
                sb.append(minHeap[i]);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // Test case
        MinHeap minHeap = new MinHeap(3);
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);
        // [1,3,2]
        System.out.println(minHeap.toString());
        // 1
        System.out.println(minHeap.peek());
        // 1
        System.out.println(minHeap.pop());
        // [2, 3]
        System.out.println(minHeap.toString());
        minHeap.add(4);
        // Add too many elements
        minHeap.add(5);
        // [2,3,4]
        System.out.println(minHeap.toString());
    }

}
