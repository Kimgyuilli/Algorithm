// nums: 기본 숫자 배열
// l: query start idx
// r: query finished idx

// 1. 각 쿼리별 구간 추출하기
// 2. 1을 정렬해야 되는데 어떻게함?
// 3. 1 copy를 하나 둔다 2. max min 값을 두고 그 사이 값들의 개수로 gap 계산하기
// 머가 더 빠름?





class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();

        for(int i = 0; i < l.length; i++) {
            if(l[i] - r[i] == 1) {
                answer.add(true);
                continue;
            }

            int[] copy = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(copy);

            boolean flag = true;
            for(int j = 0; j < copy.length - 2; j++) {
                if(copy[j + 1] - copy[j] != copy[j + 2] - copy[j + 1]) {
                    flag = false;
                }
            }

            answer.add(flag);
        }
        return answer;
    }
}