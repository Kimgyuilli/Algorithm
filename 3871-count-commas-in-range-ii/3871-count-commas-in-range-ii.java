class Solution {
    public long countCommas(long n) {
        long total = 0;

        for (long boundary = 1_000L;
             boundary <= n;
             boundary *= 1_000L) {

            total += n - boundary + 1;
        }

        return total;
    }
}