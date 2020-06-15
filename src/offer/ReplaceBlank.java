package offer;

/**
 * @description 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 思路：1.遍历一次字符串，计算出字符串空额的总数
 * 2.准备两个指针p1和p2，p1指向原始字符串的末尾，p2指向替换之后的字符串末尾
 * 3.向前移动p1，逐个把它指向的字符赋值到p2指向的位置，知道碰到第一个空额为止
 * 4.碰到第一个空格后，把p1向前移动1格，在p2前面插入字符串"%20",由于"%20"的长度为3，所以同时把p2向前移动3位
 * 5.重复3、4操作直到p1和p2指向同一位置，表明所有空格都已经替换完毕
 *
 * @author: zhongwenjian
 * @create: 2020-06-15 22:17
 */
public class ReplaceBlank {

    public static void replaceBlank(StringBuilder str){
        int oldLength = str.length();
        if (str == null || oldLength <= 0){
            return ;
        }
        int spaceNumber = 0;

        for (int i = 0;i < str.length();i++){
            if (str.charAt(i) == ' '){
                spaceNumber++;
            }
        }

        int indexOld = oldLength - 1;//原来数组末尾索引
        int newLength = oldLength + spaceNumber * 2;//计算空格转换成%20之后的长度
        int indexNew = newLength - 1;//indexold为把空格替换为%20后的下标
        str.setLength(newLength);//使str的长度扩大到转换成%20之后的长度,防止下标越界

        for (;indexOld > 0 && indexOld < indexNew;indexOld--){
            if (str.charAt(indexOld) == ' '){
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');

            }else {
                str.setCharAt(indexNew--,str.charAt(indexOld));
            }
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("we");
        str.append(" ");
        str.append("are");
        str.append(" ");
        str.append("happy");
        str.append(".");
        int lengh = str.length() - 1;
        replaceBlank(str);
    }
}
