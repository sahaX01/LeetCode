class ProductOfNumbers {
    ArrayList<Integer> list = new ArrayList<>();
    public ProductOfNumbers() {
        
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int p = 1;
        int n = list.size()-1;

        for(int i=n; i>n-k; i--){
            p = p * list.get(i);
            if(p == 0){
                return 0;
            }
        }

        return p;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */