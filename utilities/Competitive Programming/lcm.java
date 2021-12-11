// GCD by Euclidean algorithms
// Time Complexity: O(Log min(a, b))

public static long lcm(long a,long b){
    long gcd = gcd(a,b);
    long lcm = (a*b)/gcd;
    return lcm;
}

public static long gcd(long a,long b){
    return (b==0?a:gcd(b,a%b));
}
