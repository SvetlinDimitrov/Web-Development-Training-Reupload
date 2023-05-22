public class Problem_7 {
    /*
    Find floor and ceil of a number in a sorted integer array

    Given a sorted integer array, find the floor and ceil of a given number in it.
    The floor and ceil map the given number to the largest previous or the smallest following integer in the array.

    More precisely, for a number x, floor(x) is the largest integer in the array less than or equal to x,
    and ceil(x) is the smallest integer in the array greater than or equal to x. If the floor or ceil doesn’t exist, consider it to be -1. For example,

    Input:
    nums[] = [1, 4, 6, 8, 9]
    Number: 0 to 10

    Output:
    Number 0 —> ceil is 1, floor is -1
    Number 1 —> ceil is 1, floor is 1
    Number 2 —> ceil is 4, floor is 1
    Number 3 —> ceil is 4, floor is 1
    Number 4 —> ceil is 4, floor is 4
    Number 5 —> ceil is 6, floor is 4
    Number 6 —> ceil is 6, floor is 6
    Number 7 —> ceil is 8, floor is 6
    Number 8 —> ceil is 8, floor is 8
    Number 9 —> ceil is 9, floor is 9
    Number 10 —> ceil is -1, floor is 9
     */
    public static void main(String[] args) {
        int [] nums = new int []{1, 4, 6, 8, 9};
        int from = 0;
        int to = 10;
       BS(nums , from , to);
    }
    public static void BS(int [] arr , int start , int end){
        for (int i = start; i <=end; i++) {
            int floor = floorHelper(arr ,i);
            int ceil = ceilHelper(arr ,i);
            System.out.printf("Number %d —> ceil is %d, floor is %d%n",i,ceil,floor);
        }
    }
    private static int floorHelper(int[] arr, int num){
        int start = 0;
        int end = arr.length-1;
        int result = -1;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] <= num){
                result = arr[mid];
                start = mid +1;
            }else{
                end = mid-1;
            }
        }
        return result;
    }
    private static int ceilHelper(int[] arr, int num){
        int start = 0;
        int end = arr.length-1;
        int result = -1;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] >= num){
                result = arr[mid];
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return result;
    }

}
