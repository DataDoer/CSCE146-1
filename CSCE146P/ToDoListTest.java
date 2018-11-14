//Justin Baum
//00426510


public class ToDoListTest {
  public static void main(String[] args) {
    System.out.println("To Do List Tester!\nAdding Five Tasks To Do");
    ToDoList iList = new ToDoList();
    iList.insert("Buy Ground Beef");
    iList.insert("Buy Cheese");
    iList.insert("Buy Taco Shells");
    iList.insert("Make Tacos");
    iList.insert("Eat Tacos");
    iList.showList();

    //Add item after Cheese
    System.out.println("I forgot to get salsa.  Let me add that after step");
    iList.insertAfterCurrent("Buy Salsa");
    iList.showList();

    //Change current to hot sauce
    iList.gotoNext();
    System.out.println("On second thought I’m in a spicy mood so let’s change salsa to hot sauce.");
    iList.setDataAtCurrent("Buy Hot Sauce");

    //Add Guac
    System.out.println("Do people put guacamole on tacos? I’ll add it after step 3.");
    iList.gotoNext();
    iList.insertAfterCurrent("Buy Guacamole");
    iList.showList();

    //Remove Guacamole
    iList.gotoNext();
    System.out.println("On second thought I don’t think they do let me take that out.");
    iList.deleteCurrent();
    iList.showList();

    System.out.println("Now I have tested the perfect taco related list!");

    //My own tests
    iList.gotoPrev();//Works

  }//main
}//IntLinkedListTester
