package exceptionhandling;

public class Main2 {
    public static void main(String[] args) {
        int[] a = {2,4,1,5,7};
        for(int i=0; i<8; i++){
            try{
                System.out.println(a[i]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Array Out Of Bound Exception Error : "+ e);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
