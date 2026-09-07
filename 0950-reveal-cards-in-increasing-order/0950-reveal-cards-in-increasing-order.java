class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = deck.length - 1; i >= 0; i--) {

            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }

            deque.addFirst(deck[i]);
        }

        int[] result = new int[deck.length];
        int idx = 0;

        for (int num : deque) {
            result[idx++] = num;
        }

        return result;
    }
}