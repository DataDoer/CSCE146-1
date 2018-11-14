//Justin Baum
//00426510

public class ProcessScheduler {
  QueueInterface processes;
  Process currentProcess;

  public ProcessScheduler() {
    processes = new LinkedListQueue<Process>();
    currentProcess = null;
  }//ProcessScheduler


  private void update() {
  }//update

  public Process getCurrentProcess() {
    if (currentProcess == null) {
      runNextProcess();
    }
    return currentProcess;
  }//getCurrProcess

  public void addProcess(Process aProcess) {
    processes.enqueue(aProcess);
  }//addProcess

  public void runNextProcess() {
    System.out.println(currentProcess);
    currentProcess = (Process)processes.dequeue();
  }//runNextProcess

  public void cancelCurrentProcess() {
    runNextProcess();
  }//runNextProcess

  public void printProcessQueue() {
    processes.print();
  }//print
}
