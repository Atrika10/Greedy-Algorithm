public class LemonadeChangeProblem {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;

        for (int i = 0; i < bills.length; i++) {        // Time complexity => O(n), where 'n' is the length of the bills array
            if (bills[i] == 5) {
                five++;
            }
            else if(bills[i] == 10 && five >=1){
                ten++;
                five--;
            }else if(bills[i] == 20){ 
                
                twenty++;
                if (ten >= 1 && five >=1) {
                  ten--;
                  five--;  
                }else if (five >= 3) {
                    five -= 3;
                }else{
                    return false;
                }
                
                
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int bills[] = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(lemonadeChange(bills));
    }
}
