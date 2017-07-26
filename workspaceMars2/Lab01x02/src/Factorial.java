class Factorial {

    private static long fact( long n ) {
        System.out.println(n);
        if ( n == 0)
            return 1;
        else
            return n*fact(n-1);
    }


    public static void main (String[] args) {
        long a = Integer.parseInt(args[0]);
        System.out.println( fact(a) );
    }
    
}
