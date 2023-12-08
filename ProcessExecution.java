import java.util.*;

public class ProcessExecution {

    public static int maxComputePower(int[] power) {
        // // Sort the array of computing powers
        Arrays.sort(power);
        List<Integer> indexes=new ArrayList<>();
        List<Integer> values=new ArrayList<>();
        for(int i=0;i<power.length;i++){
            if(!values.contains(power[i])){
                indexes.add(i);
                values.add(power[i]);
            }
        }
        int[] dp=new int[values.size()+1];
        dp[0]=0;
        dp[1]=(indexes.get(1) - indexes.get(0))*values.get(0);
        System.out.println("dp[1] "+dp[1]);


        for(int i=2;i<=values.size();i++){
            int curr = values.get(i-1);
            int currCount;
            if(i<values.size()){
                currCount=indexes.get(i)-indexes.get(i-1);
            }else{
                currCount=power.length-indexes.get(i-1);
            }
            int prev = values.get(i-2);
            if(curr!=prev+1){
                dp[i]=dp[i-1]+curr*currCount;
                System.out.println(i+" "+curr+" "+prev+" "+dp[i]+" "+currCount);
            }
            else{
                dp[i]=Math.max(dp[i-2]+curr*currCount,dp[i-1]);
                System.out.println("else "+i+" "+curr+" "+prev+" "+dp[i]);
            }
        }
        return dp[values.size()];
    }

    public static void main(String[] args) {
        // Example usage
        int[] power = {3,3,3,4,4,1,8};
        int result = maxComputePower(power);
        System.out.println(result);
    }
}
