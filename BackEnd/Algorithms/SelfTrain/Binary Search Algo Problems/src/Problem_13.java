public class Problem_13 {
    /*
    Find the square root of a number using a binary search

    Given a positive number, return the square root of it. If the number is not a perfect square, return the floor of its square root.

    For example,

    Input:  x = 12
    Output: 3

    Input:  x = 16
    Output: 4
     */
    public static void main(String[] args) {
        int taget = 12;
        System.out.println(BS(taget));
    }
    private static int BS(int taget){
        int start = 1;
        int end = taget;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(mid * start == taget){
                return mid;
            }
            if(mid*start > taget){
                end = mid-1;
                start =1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}
