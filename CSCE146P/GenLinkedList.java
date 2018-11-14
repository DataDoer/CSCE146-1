
public class GenLinkedList <T>	{ //MAKES IT A GENERIC TYPE

	//Internal class of the node
	private class ListNode
	{
		private T data; //T CAN BE ANYTHING
		private ListNode link;

		public ListNode()
		{
			data = null;
			link = null;
		}//ListNode

		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}//ListNode
	}//ListNode

	//POINTER NODES
	private ListNode head;
	private ListNode current;
	private ListNode previous;

	public GenLinkedList()
	{
		head = current = previous = null;
	}//GenLinkedList

	public T getCurrent()
	{
		if(current != null)//If current is not end of list
		{
			return current.data;
		}//if
		else
		{
			return null;
		}//else
	}//getCurrent

	public void setCurrent(T aData)
	{
		if(current!=null)
		{
			this.current.data = aData;
		}//if
	}//setCurrent

	public T getPrevious() {
		if(previous == null) return null;
		return previous;
	}

	//INSERT A NEW ELEMENT TO THE END OF THE LIST
	public void insert(T newData)
	{
		//Create a new node
		ListNode newNode = new ListNode(newData,null);
		if(head == null)//THIS MEANS THE LIST IS EMPTY
		{
			head = newNode; //POINTS HEAD TO THE NEW NODE
			current = head; //SET THE CURRENT TO THE HEAD
			return;
		}//if
		ListNode tmp = head;	//TMP NEEDS TO POINT TO THE HEAD
		ListNode prev;
		while(tmp.link != null)	//AS LONG AS THE NODE IS POINTING TO SOMETHING
		{
			//MOVE THE TMP MODE FORWARD
			prev = tmp;
			tmp = tmp.link;
		}//while
		//NOW WE'RE AT THE END OF THE LIST
		tmp.link  = newNode;
		newNode.previous = prev;
	}//insert

	public void insertAfterCurrent(T newData)
	{
		//ANY INSERT STARTS OUT BY CREATING A NEW LODE
		ListNode newNode = new ListNode(newData, null);
		if(current!=null)
		{
			newNode.link = current.link; 	//BECAUSE THE NEW NODE SHOULD BE POINTING AT WHERE THE CURRENT IS POINTING
			current.link = newNode; 		//NOW CURRENT HAS TO POINT AT THE NEW NODE
		}//if
		else if(head!=null)
		{
			System.out.println("Current is outside of the linked list");
		}//else fi
		else
		{
			System.out.println("List is empty");
		}//else
		// IF HEAD IS NULL THAT MEANS YOU HAVE AN EMPTY LIST, BUT IF CURRENT IS NULL THERE COULD BE A VARIETY OF REASONS WHY s
	}//insertAfterCurrent

	//MOVE CURRENT FORWARD
	public void goToNext()
	{
		if(current != null)
		{
				previous = current;
				current = current.link;
		}//if
	}//goToNext

	public void resetCurrent()
	{
		current = head;
		previous = null;
	}//resetCurrent

	public boolean hasMore() {
		return current != null;
	}//hasMore

	public void print()
	{
		ListNode tmp = head;
		while(tmp!=null)
		{
			System.out.println(tmp.data);
			tmp = tmp.link;
		}//while
	}//print

	public void deleteCurrent()
	{
		if(current!=null&&previous!=null)//INDICATES THAT CURRENT IS NOT EQUAL TO THE HEAD
		{
			previous.link = current.link;//EFFECTIVELY POINTS OVER TOP OF IT
			current = current.link;
		}//if
		else if(current != null && previous == null)//YOU'RE AT THE HEAD
		{
			head = head.link; //or you can do head = current.link because tehy are pointing to the same thing
			current = head;
		}//else if
	}//deleteCurrent
}//GenLinkedList
