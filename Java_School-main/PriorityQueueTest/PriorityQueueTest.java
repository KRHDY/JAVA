package PriorityQueueTest;
import java.util.*;
public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test1();
		MyQueue queue = new MyQueue();
		queue.offer(new Task("작업1",1));
		queue.offer(new Task("작업2",2));
		queue.offer(new Task("작업3",3));
		queue.offer(new Task("작업4",4));
		queue.offer(new Task("작업5",5));
		// 4,2,1,5,3
		for (int i = 0; i<5;i++) {
			System.out.println(queue.poll());
		}
	}

	private static void test1 () {
		/*
		 * 우선 순위큐 객체를 생성하고 
		 * Task 인스턴스를 삽입, 인출 해보자
		 */
		// priority 우선순위큐는 기본적으로 오름차순으로 인출된다
//		Queue<Task> queue = new PriorityQueue<>();
		Queue<Task> queue = new PriorityQueue<>(new TaskComparator());
		queue.offer(new Task("작업1",3));
		queue.offer(new Task("작업2",2));
		queue.offer(new Task("작업3",5));
		queue.offer(new Task("작업4",1));
		queue.offer(new Task("작업5",4));
		// 작업 4,2,1,5,3
		while( queue.isEmpty() == false ) {
			Task task = queue.poll();
			
			System.out.println(task);
		}
	}
}

class Task implements Comparable<Task>{  //<<task
//	↑ task 인스턴스를 비교가능한 객체로 생성하기위해
	
	String desc; 		// 설명
	int priority = 5; 	// 이 작업의 우선순위
	
	@Override
	public String toString() {
		return "[desc:"+desc+", priority:"+priority+"]";
	}
	
	public Task(String desc, int priority) {
		this.desc = desc;
		this.priority = priority;
	}

	@Override
	public int compareTo(Task o) {
		// 이 객체의 값이 크면 양수, 같으면 0, 작으면 음수를 반환.
		return this.priority - o.priority;
	}
}

//class MyQueue<T extends Comparable<T>>{
//	Object[]list = new Object[5];
//	int idx=0;
//	public boolean offer(T value) {
//		if (((T)list[0]).compareTo(value)==0){
//			
//		}else if (((T)list[0]).compareTo(value)>0){
//			
//		}else {
//		
//		}
//		return true;
//	}
//}

class MyQueue{
	Task[] tasks = new Task[10];
	int idx		= 0;
	int pidx	= 0;
	
	public void offer(Task value) {
		tasks[idx++] = value;
		// 새로운 객체가 들어올때마다 선택정렬로 sorting 한다.
		for (int i=idx-1 ; i>=0; i--) {
			int max = i; //제일 마지막 원소가 최대값이 가정.
			for (int j=0; j<i-1; j++) {
				if (tasks[j].compareTo(tasks[max])>0) {
					max = j;
				}
			}
			// max, i를 swap
			Task tmp = tasks[max];
			tasks[max] = tasks[i];
			tasks[i] = tmp;
		}
	}
	
	public Task poll() {
		return tasks[pidx];
	}
}


class TaskComparator implements Comparator<Task>{

	@Override
	public int compare(Task o1, Task o2) {
		// TODO Auto-generated method stub
		return o1.priority - o2.priority; // 오름차순
//		return o2.priority - o1.priority; // 내림차순
		
	}
	
}



