// GCD by Euclidean algorithms
// Time Complexity: O(Log min(a, b))

public static int gcd(int a,int b){
    return (b==0?a:gcd(b,a%b));
}