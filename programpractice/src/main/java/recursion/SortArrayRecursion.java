package recursion;

public class SortArrayRecursion {

    public static void main(String[] args) {
        int [] arr = {0,1,5,2};

        sort(arr);

        for(int val: arr){
            System.out.print(val+" ");
        }
    }


    public static void sort(int [] arr){

        sort(arr,arr.length-1);
    }

    public static void sort(int[]arr, int end){

        if(end==0){
            return;
        }
        int val = arr[end];

        sort(arr,end-1);
        insert(arr,val,end);

    }

    public static void insert(int arr[], int temp, int end){

        if(end==0 || arr[end-1]<=temp){
            arr[end]=temp;
            return;
        }
        int val = arr[end-1];
        insert(arr,temp,end-1);
        arr[end]=val;

    }
}
