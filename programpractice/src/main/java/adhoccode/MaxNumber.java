package adhoccode;

/*
* Given three numbers num1,num2,num3
* find max number k, such that
* k<=num3
* k%num1 = num2
*
* */

public class MaxNumber {

    public static void main(String args[])
    {
        System.out.println(findMaxNumber(15,10,100));
    }

    /* for equation x % num1 = num2
     * it must follow (x+num2) % num1 = 0
     * get max multiple of num1 to reach near number num3 by dividing num3 by num1
     * Now add num2 to it and check whether it is less than or equal to num3
     * if it is more then decrement quotient by 1 and follow the same relation
    * */

    public static int findMaxNumber(int num1, int num2, int num3){
        int quotient = num3/num1;
        int k =Integer.MIN_VALUE;
        while(quotient>0)
        {
            int result = (num1*quotient)+num2;
            System.out.println("quotient: "+quotient+" result: "+result);
            if(result<=num3 && (result % num1 == num2))
            {
                k = result; break;
            }
            quotient--;
        }

        return k;
    }
}
