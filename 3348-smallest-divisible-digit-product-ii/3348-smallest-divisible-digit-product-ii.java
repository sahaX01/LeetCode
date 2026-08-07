class Solution {
    
    String freeSlotFiller(long required, long len){
        StringBuilder sb = new StringBuilder();
        
        for(int digit = 9; digit>=2; digit--){
          while(required % digit == 0){
            sb.append((char)(digit+'0'));
            required /= digit;
          }
        }
        
        while(sb.length() < len){
            sb.append('1');
        }

        return sb.reverse().toString();
    }
    long gcd(long a,long b){

        while(b!=0){

            long temp=a%b;
            a=b;
            b=temp;
        }

        return a;
    }
    public String smallestNumber(String num, long t) {
        int n = num.length();

        long temp = t;
        int primeFactors[] = {2, 3, 5, 7};
        for(int primeFact : primeFactors){
            while(temp % primeFact == 0){
                temp /= primeFact;
            }
        }

        if(temp != 1){
            return "-1";
        }

        // Precompute remainingFactor[i] = if we take i digits of num in my result, what
        // factor remaining for t

        long[] remainingFactor = new long[n + 1];
        Arrays.fill(remainingFactor, t);

        for(int i=0; i<n; i++){
            int digit = num.charAt(i) - '0';
            if(digit == 0) break;
            remainingFactor[i+1] = remainingFactor[i] / gcd(remainingFactor[i], (long) digit);
        }

        if(remainingFactor[n] == 1){
            return num;
        }

        int zeroPos = num.indexOf('0');
        int zeroIdx = n-1;

        if(zeroPos != -1){
            zeroIdx = zeroPos;
        }
        
        for(int i=zeroIdx; i>=0; i--){
            long required = remainingFactor[i];
            long freeSlots = n - 1 - i;

            for(int digit = (num.charAt(i) - '0')+1; digit<=9; digit++){

                long furtherRequired = required / gcd(required, digit);
                String requiredNumber = freeSlotFiller( furtherRequired, freeSlots);

                if(requiredNumber.length() ==  freeSlots){
                    return num.substring(0, i) + (char) (digit+'0')+ requiredNumber;
                }
            }

        }
         return freeSlotFiller(t, n+1);
    }
}