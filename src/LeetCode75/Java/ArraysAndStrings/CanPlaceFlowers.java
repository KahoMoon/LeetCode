package LeetCode75.Java.ArraysAndStrings;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] test = {1,0,0,0,1};
        System.out.println(canPlaceFlowers(test, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed.length < 2 && flowerbed[0] == 0) {
            return true;
        }

        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 && flowerbed.length > 1 && flowerbed[i + 1] == 0) {
                    count++;
                    i++;
                } else if (i == flowerbed.length - 1 && flowerbed.length > 1 && flowerbed[i - 1] == 0) {
                    count++;
                    i++;
                } else if (i != 0 && i != flowerbed.length - 1){
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        count++;
                        i++;
                    }
                }
            }
        }

        return count >= n;
    }
}
