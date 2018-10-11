public class A1
{

    public static void main(String[] args)
    {
        int a=0,b=0,c=1, d=1;
        boolean result;
        result = ((a++ == 0) || (++b == 1)) && ((--c == 1) && (--d == 0));
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("c:" + c);
        System.out.println("d:" + d);
        System.out.println("result:" + result);
    }
}
