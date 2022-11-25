
public class Main {
    //Test module
    //Second commit
    public static void main(String[] args) {
       // System.out.println("Hello world!");

    }
    public static class Task1 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = m+n-1, a = m-1, b = n-1; b>=0; i--) {
                if (a >= 0 && nums1[a] > nums2[b]) nums1[i] = nums1[a--];
                else nums1[i] = nums2[b--];
            }

        }
    }

    class Task2 {
        public int[] buildArray(int[] nums) {
            var ans = new int[nums.length];
            for (var i = 0; i < nums.length; i++)
                ans[i] = nums[nums[i]];
            return ans;
        }
    }

    class Task3 {
        public int removeElement(int[] A, int elem) {
            int m = 0;
            for(int i = 0; i < A.length; i++){
                if(A[i] != elem){
                    A[m++] = A[i];
                }
            }
            return m;
        }
    }

    class Task4 {
        public String reverseWords(String s) {
            StringBuilder reversed = new StringBuilder(s.length());
            char[] chars = s.toCharArray();
            int end = chars.length;
            for (int start = chars.length - 1; start >= 0; start--) {
                if (chars[start] == ' ') {
                    end = start;
                } else if (start == 0 || chars[start - 1] == ' ') {
                    if (reversed.length() > 0) {
                        reversed.append(' ');
                    }
                    reversed.append(chars, start, end - start);
                }
            }
            return reversed.toString();
        }
    }

}