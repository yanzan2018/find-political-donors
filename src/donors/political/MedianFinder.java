package donors.political;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
	//maxHeap contains the smaller half of the numbers.
    private Queue<Integer> maxHeap;
    
    //minHeap contains the larger half of the numbers.
    private Queue<Integer> minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>();
        minHeap = new PriorityQueue<>();
    }
    
    public void addNumber(int num) {
        maxHeap.offer(num);
        minHeap.offer(-maxHeap.poll());
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(-minHeap.poll());
        }
    }
    
    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() - minHeap.peek()) / 2.0;
    }
	
}
