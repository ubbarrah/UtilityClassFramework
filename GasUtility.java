public class GasUtility {
    public double cuberoot(double a){
        double x = a + 1;
        while (x * x * x - a > 1e-10){
            x = x - ((x*x*x - a)/(3*x*x));
        }
        return x;
    }

    public String toLowerCase(String s){
        return s.toLowerCase();
    }

    public String shout (String s, int exPoints){
        String newString = s;
        for (int i =0; i < exPoints; i++){
            newString = newString + "!";
        }
        return newString;
    }
    public static void squareAll (int[] a){

        for (int i = 0; i < a.length; i++){
            a[i] = a[i] * a[i];
        }
    }

    public static int[] append (int[] a, int[] b){
        int[] c = new int[(a.length+b.length)];

        for (int i = 0; i < (a.length); i++){
            c[i] = a[i];
        }
        for (int j = 0; j < b.length; j++){
            c[(a.length+j)] = b[j];
        }
        return c;
    }
        
}
