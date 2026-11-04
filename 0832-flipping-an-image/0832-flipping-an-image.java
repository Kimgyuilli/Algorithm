class Solution {
    private int len;
    public int[][] flipAndInvertImage(int[][] image) {
        len = image.length;
        for(int[] img : image) {
            img = reverse(img);
            img = invert(img);
        }
        return image;
    }

    private int[] reverse(int[] img) {
        int left = 0;
        int right = len - 1;

        while(left < right) {
            int temp = img[left];
            img[left] = img[right];
            img[right] = temp;
            left++;
            right--;
        }
        return img;
    }

    private int[] invert(int[] img) {

        for(int i = 0; i < len; i++) {
            img[i] = (img[i] + 1) % 2;
        }
        return img;
    }

}