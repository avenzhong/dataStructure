package offer;

/**
 * 找出数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @author: avenzhong
 * @create: 2020-05-28 22:49
 *
 * 思路：当扫描到下标i的数字时，首先比较这个数字（用m表示）是不是等于i，如果是，则扫描下个数字；
 * 如果不是，再拿它与和第m个数字相比，如果相等，就找到一个重复的数字（该数字同时出现在下标为i和m的位置）
 * 如果它和第m个数字不相等，就把第i个数字和第m个数字交换，把m放到属于它的位置。接下来重复这个操作，直到找到重复的数字为止
 */
public class DuplicateNumberInArray {

    public static boolean duplicate(int numbers[],int length){
        if (numbers == null || length < 0){
            return false;
        }
        //遍历每个数字判断是否符合要求
        for (int i = 0;i < length; ++i){
            if (numbers[i] < 0 || numbers[i] > length - 1){
                return false;
            }
        }

        for (int i = 0; i < length ; ++i){
            while (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
                    return true;
                }
                // 交换下标i的值与下标为numbers[i]的值
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        //1.长度为n的数组里包含一个或多个重复的数字
        int numbers1[] = {1,3,4,3,2};

        //2.数组中不包含重复的数字
        int numbers2[] = {1,0,3,2};

        //3.无效输入测试用例
        int numbers3[] = {1,3,4,9,2};
        System.out.println(duplicate(numbers1,numbers1.length));
        System.out.println(duplicate(numbers2,numbers2.length));
        System.out.println(duplicate(numbers3,numbers3.length));

    }

}
