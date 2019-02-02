package edu.ujcv.progra2;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int[] arreglo = {3,6,2,9,3,7,23,8,13,67,5,22,1};

        arreglo = mergeSort(arreglo);

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]+", ")  ;
        }
    }


    public static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]< arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public  static int[] mergeSort(int[] arr){
        //caso base.
        if(arr.length <= 1){
            return arr;
        }
        // caso recursivo.

        int medio = arr.length /2;

        int[] inferior = new int[medio];
        int[] superior = new int[arr.length - medio];
        for (int i = 0; i < medio; i++) {
            inferior[i] = arr[i];
        }

        for (int i = 0; i < superior.length ; i++) {
            superior[i] = arr[i + inferior.length];
        }
        return  merge(mergeSort(inferior), mergeSort(superior));
    }


    public static int[] merge(int[] a, int[] b){
        int[] retval = new int[a.length+ b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (j < a.length && k < b.length ){
            if(a[j] < b[k]){
                retval[i++] = a[j++];
            }else{
                retval[i++] = b[k++];
            }
        }

        while (j < a.length){
            retval[i++] = a[j++];
        }

        while (k < b.length){
            retval[i++] = b[k++];
        }
        return retval;
    }

}
