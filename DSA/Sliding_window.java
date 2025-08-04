// https://leetcode.com/problems/longest-substring-without-repeating-characters
public int lengthOfLongestSubstringWithoutDuplicates(String s) {
    int n = s.length();

    int max=0;
    int curr=0; //default value if the array has no elements

    int[] charCnt = new int[1000]; //required to check validity of the window
    for(int left=0, right=0; right<n; right++) {
        //add first ele to arr irrespective of the condition
        curr++;
        charCnt[s.charAt(right)]++;

        while ( left<=right &&  !isValidWindow(charCnt)) {
            //while the window is invalid, remove elements from left until the window becomes valid
            //make sure left<=right

            // remove the element
            charCnt[s.charAt(left)]--;
            curr--;

            left++;
        }

        //extract max value. here its possible that we add just one element then remove them.
        //Means right and left are going neck to neck
        max = Math.max(max, curr);
    }

    return max;
}

boolean isValidWindow(int[] charCnt){
    return Arrays.stream(charCnt).anyMatch(e->e>=2) ? false : true;
}