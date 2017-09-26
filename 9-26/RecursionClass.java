public class RecursionClass {
  public static void main(String args[]) {
    int[] nums = new int[args.length];
    for(int i = 0; i < args.length; i++) {
      nums[i] = Integer.parseInt(args[i]);
    }//for loop to get integers passed
    System.out.println(factorial(nums[0]));
    System.out.println(gcd(nums[1],nums[2]));
    System.out.println(fibonacci(nums[3]));
    System.out.println(forfibonacci(nums[3]));
  }//main

  public static int factorial(int number) {
    if(number < 0) return 0; //Infinite recursion
    if(number == 0) return 1;
    else return number*factorial(number-1);//recursive call
  }//factorial

  public static int gcd(int num1, int num2) {
    if (num2 == 0) return num1;
    else return gcd(num2, num1%num2);//Recursive call
  }//greatest common divisor

  public static int fibonacci(int number) {
    if(number <= 0) return 0;
    if(number == 1 || number == 2) return 1;
    else return fibonacci(number - 1) + fibonacci(number - 2);
  }//fibonacci

}

//Sample Call
//javac RecursionClass.java && java RecursionClass 5 15 7 8
