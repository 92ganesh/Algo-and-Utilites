   // Time Complexity O(log(n)) 
   // Note:- log with base 2
   
static public boolean BinarySearch(long arr[], int l,int r,int val){
    if(l<=r&&arr[l]<=val&&val<=arr[r]){
        int mid = l + (r-l)/2;
        if(arr[mid]==val){
            return true;
        }else{
            if(arr[mid]>val){
                return BinarySearch(arr,l,mid,val);
            }else{
                return BinarySearch(arr,mid,r,val);
            }
        }
    }
    return false;
}
