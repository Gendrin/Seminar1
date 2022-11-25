
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


}