package practice.a;

import static practice.a.ArrayUtil.printArray;

import java.io.IOException;
import java.util.Scanner;

public class ArrayRotation {

    public static void main(String[] args) throws IOException {
        int[] a = new int[]{1,2,3,4,5};
        //practice.a = rotLeft(practice.a, 4);
        //cyclicRotateByOne(practice.a);
        printArray(a);
        int netRotation = 0;
        int l = 0, r = 2;
        netRotation = getNetRotation(netRotation, 2, a.length, true);
        netRotation = getNetRotation(netRotation, 1, a.length, false);
        int[] cumulativeSums = getCumulativeSums(a);
        // Modify l and r, and handle l<r and vice versa conditions
        l=(l-netRotation)%a.length;
        r=(r-netRotation)%a.length;
        if(l>r) {
            System.out.println(cumulativeSums[a.length-1]+cumulativeSums[r]-cumulativeSums[l-1]);
        } else {
            System.out.println(cumulativeSums[r]-cumulativeSums[l-1]);
        }
        //System.out.println(cumulativeSums[(r-netRotation)%practice.a.length]-cumulativeSums[((l-netRotation)%practice.a.length)-1]);
        //System.out.println(searchInRotatedArr(practice.a, 1));
        //rotForMaxPlaceValueSum(practice.a);
    }

    static int[] getCumulativeSums(int[] a) {
        int[] cumulativeSums = new int[a.length];
        cumulativeSums[0] = a[0];
        for(int i=1; i<a.length; i++) {
            cumulativeSums[i] = cumulativeSums[i-1] + a[i];
        }
        return cumulativeSums;
    }

    static int getNetRotation(int netRotation, int times, int len, boolean isLeftRotate) {
        return isLeftRotate?(netRotation-times)%len:(netRotation+times)%len;
    }

    static int rotForMaxPlaceValueSum(int[] a) {
        int arrSum = 0, currSum = 0;
        for(int i=0; i<a.length ;i++) {
            arrSum+=a[i];
            currSum+=(i*a[i]);
        }

        int maxValue = currSum, position = 0;
        for(int j=1; j<a.length; j++) {
            currSum=currSum+(arrSum-(a.length*a[a.length-j]));
            if(currSum>maxValue) {
                maxValue = currSum;
                position = j;
            }
        }

        System.out.println(maxValue + " " + position);
        return position;
    }


    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        a = reverse(a, 0, a.length-1);
        for(int i : a) {
            System.out.print(i + " ");
        }
        a = reverse(a, a.length-d, a.length-1);
        for(int i : a) {
            System.out.print(i + " ");
        }
        a = reverse(a, 0, a.length-d-1);
        for(int i : a) {
            System.out.print(i + " ");
        }
        return a;
    }
    // Complete the rotLeft function below.
    // 1 2 3 4 5 6 7 8 9
    static int[] rotLeftUsingJuggling(int[] a, int d) {
        int i=0;
        int temp=0;
        while (d*i<a.length) {
            // store first element of set (practice.a[i]) into temp
            temp = a[i];
            for(int j=i; j<a.length; j *= (1+d)) {
                a[j] = a[j*(1+d)];
            }
            temp = a[i*d];
            a[i*d] = a[((i+1)*d)%a.length];
        }
        return a;
    }

    static int[] reverse(int[] a, int startIndex, int endIndex) {
        for(int i=startIndex; i<=(endIndex+startIndex)/2; i++) {
            int temp = a[i];
            a[i] = a[endIndex+startIndex-i];
            a[endIndex+startIndex-i] = temp;
        }
        return a;
    }


    static long arrayManipulation(int n, int[][] queries) {
        int maxNum = 0;
        for(int i=0; i<queries.length; i++) {
            maxNum = queries[i][2]>maxNum?queries[i][2]:maxNum;
        }
        int temp = queries[0][3];
        for(int i=1; i<queries.length; i++) {
            if(queries[i-1][2]>=queries[i][1]) {
                temp += queries[i][3];
                continue;
            }
            maxNum = temp>maxNum?temp:maxNum;
            temp = 0;
            }
        //return maxNum;

        int[] arr = new int[n];
        int i = 0;
        for(i =0; i<n; i++) arr[i]=0;
        for(i=0; i<queries.length; i++){
            for(int j=queries[i][0]; j<=queries[i][1];j++) {
                arr[j] +=queries[i][2];
            }
        }

        for(i=0; i<n; i++) {
            maxNum = arr[i]>maxNum?arr[i]:maxNum;
        }
        return maxNum;
    }

    static void cyclicRotateByOne(int[] a) {
        for(int i=0, j=a.length-1; i<j; i++) {
            a[i]+=a[j];
            a[j]=a[i]-a[j];
            a[i]=a[i]-a[j];
        }
    }


    static int searchInRotatedArr(int[] a, int term) {
        int pivotPoint = getPivotPoint(a, 0, a.length-1);
        return binarySearch(a, 0, pivotPoint, term) + binarySearch(a, pivotPoint+1, a.length, term) + 1;
    }

    static int getPivotPoint(int[] a, int start, int end) {
        if(start>end) return -1;
        if(start==end) return start;

        int mid=(start+(end-start))/2;
        if(a[mid]>a[mid+1]) return mid;
        if(a[mid-1]>a[mid]) return mid-1;
        if(a[mid]<=a[end]) return getPivotPoint(a, start, mid);
        else return getPivotPoint(a, mid+1, end);
    }

    static int binarySearch(int[] a, int start, int end, int term) {
        if(start>end) return -1;
        if(start==end) if(a[start]==term) return start; else return -1;
        int mid = start+(end-start)/2;
        if(a[mid]==term) return mid;
        else if(a[mid]<term) return binarySearch(a, mid+1, end, term);
        else if(a[mid]>term) return binarySearch(a, start, mid, term);
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

}
