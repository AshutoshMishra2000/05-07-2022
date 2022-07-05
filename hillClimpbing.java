public class hillClimpbing {
    public static int ways(int n,int[] cache){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int result=ways(n-1, cache)+ways(n-2, cache);
        cache[n]=result;
        return result;
    }
    public static void main(String[] args) {
        int n=10;
        int cache[]=new int[n+1];
        
        System.out.println(ways(n, cache));


    }
}
