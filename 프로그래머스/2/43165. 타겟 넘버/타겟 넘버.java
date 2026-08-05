class Solution {
	public int solution(int[] numbers, int target) {
			return DFS(0, 0, numbers, target);
	}
	
	private int DFS(int depth, int cur, int[] numbers, int target) {
		if(depth == numbers.length) {
			return cur == target ? 1 : 0;
		}
		
		return DFS(depth + 1, cur + numbers[depth], numbers, target) 
		+ DFS(depth + 1, cur - numbers[depth], numbers, target);
	}
	
}