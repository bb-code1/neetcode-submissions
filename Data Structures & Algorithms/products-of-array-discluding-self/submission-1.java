// // brute force solution will be
// we will loop over the array , calculate product of all the numbers excep the curr
// index number and store the product in array 
// int will be o(N2) time and o(N) space

// better will be
// to get product of all the elements and count number of zeroes
// and divide by current index number here we will have  cases
// case 
// more than 1 zeroes : all elements will be zero
// 1 zero : then  alll will be zero except that element , it will be prod
// no zeros : then prod /nums[i];


class Solution {
    public int[] productExceptSelf(int[] nums) {
       int n = nums.length;
       int [] result = new int [n];
       int [] preProd = new int [n];
       int [] sufProd = new int [n];

       preProd[0]= 1;
       sufProd[n-1] = 1;

       for(int i=1; i<n;i++){
        preProd[i] = nums[i-1] * preProd[i-1];
        
       } 

       for(int i=n-2; i>=0;i--){
        sufProd[i] = nums[i+1] * sufProd[i+1];
       }

       for(int i =0;i<n;i++){
        result[i] =  sufProd[i] *preProd[i];
       }
       return result;

    }
}  
