public class Problem_4 {
    //Find the first or last occurrence of a given number in a sorted array


    //Given a sorted integer array, find the index of a given number’s first or last occurrence.
    // If the element is not present in the array, report that as well.

    //Input:
    //nums = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
    //target = 5
    //
    //Output:
    //The first occurrence of element 5 is located at index 1
    //The last occurrence of element 5 is located at index 3
    public static void main(String[] args) {
        int [] arr = new int []{5, 5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,6, 6, 8, 9, 9, 9};
        int target = 5;
        System.out.println(BS(arr , target));
    }

    private static String BS(int[] arr, int target) {
        StringBuilder build = new StringBuilder();
        int start = left(arr,target , 0 , arr.length-1 , -1);
        int end = right(arr,target,0,arr.length-1 , -1);
        build.append(String.format("The first occurrence of element %d is located at index %d",target,start));
        build.append(String.format("\n"));
        build.append(String.format("The last occurrence of element %d is located at index %d",target,end));
        return build.toString();
    }

    private static int right(int[] arr, int target, int start, int end, int answer) {
        int mid = start + (end -start)/2;
        if(start > end){return  answer;}
        if(arr[mid] == target){ return right(arr , target , mid+1 , end , mid);}
        else if(arr[mid] > target) {return  right(arr , target ,start , mid-1 , answer);}
        else {return right(arr,target,mid+1 , end , answer);}
    }

    private static int left(int[] arr, int target, int start, int end, int answer) {
        int mid = start + (end - start)/2;
        if(start > end){return answer;}
        if(arr[mid] == target){ return left(arr , target , start , mid-1 , mid);}
        else if(arr[mid] >target){ return left(arr , target , start , mid-1 , answer);}
        else{return left(arr , target, mid+1 , end , answer);}
    }
}
