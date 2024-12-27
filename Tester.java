public class Tester extends Object{



    public static void main(String args[]){

        int[] d = {1,2,3,4,5,6,7,8,9};
        int [] e = {6, 4, 7};
        GasUtility g = new GasUtility();
        GasUtility.append(d, e);
        System.out.println(GasUtility.append(d, e)[8]) ;
    }
    
}