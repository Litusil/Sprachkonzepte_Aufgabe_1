import java.util.Arrays;

public class A2
{

    public static void main(String[] args)
    {
        int[] testLinks = {10,1,2,3,4,5,6,7,8,9};
        int[] testMitte = {1,2,3,4,5,10,6,7,8,9};
        int[] testRechts = {10,1,2,3,4,5,6,7,8,9,10};

        long t1;
        long t2;

        System.out.println("_______________Links_______________");

        t1 = System.nanoTime();
        System.out.println("maxIterativ: " + myMaxIterativ(testLinks) );
        t2 = System.nanoTime();
        System.out.println("time in nS = " + (t2-t1));

        t1 = System.nanoTime();
        System.out.println("maxRek: " + myMaxRek(testLinks) );
        t2 = System.nanoTime();
        System.out.println("time in nS = " + (t2-t1));

        t1 = System.nanoTime();
        System.out.println("maxEndRek: " + myMaxEndRek(testLinks,0) );
        t2 = System.nanoTime();
        System.out.println("time in nS = " + (t2-t1));

        System.out.println("_______________Mitte_______________");
        System.out.println("maxIterativ: " + myMaxIterativ(testMitte) );
        System.out.println("maxRek: " + myMaxRek(testMitte) );
        System.out.println("maxEndRek: " + myMaxEndRek(testMitte,0) );

        System.out.println("_______________Rechts_______________");
        System.out.println("maxIterativ: " + myMaxIterativ(testRechts) );
        System.out.println("maxRek: " + myMaxRek(testRechts) );
        System.out.println("maxEndRek: " + myMaxEndRek(testRechts,0) );
    }

    private static int myMaxIterativ(int[] arr)
    {
        int result = 0;

        for(int i = 0; i < arr.length; i++ )
        {
            if(result < arr[i])
            {
                result = arr[i];
            }
        }
        return result;
    }

    private static int myMaxRek(int[] arr)
    {
        if(arr.length == 1)
        {
            return arr[0];
        }
        int rekMax = myMaxRek(Arrays.copyOfRange(arr, 1, arr.length));
        if(arr[0] > rekMax )
        {
            return arr[0];
        } else {
            return rekMax;
        }
    }

    private static int myMaxEndRek(int[] arr, int maxBisher)
    {
        int max;
        if(arr.length == 1)
        {
            return arr[0] > maxBisher ? arr[0] : maxBisher;
        }
        if(maxBisher > arr[0])
        {
            max = maxBisher;
        }
        else
        {
            max = arr[0];
        }
        return myMaxEndRek(Arrays.copyOfRange(arr, 1, arr.length),max);
    }
}
