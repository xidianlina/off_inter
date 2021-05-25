package algorithm;

/*
有一个随机数发生器，以概率P产生0，概率(1-P)产生1，请问能否利用这个随机数发生器，
构造出新的发生器，以1/2的概率产生0和1。请写明结论及推理过程。
 */
public class RandEqual {
    /*
        已知:产生0的概率为P，产生1的概率为（1-P）
        则:产生01的概率为P（1-P），产生10的概率为（1-P）P，两者相等
        新函数:产生01返回0，产生10返回1
     */
    public int getRand() {
        // int i = rand();
        // int j = rand();
        int i = 0;
        int j = 0;

        int res = -1;
        while (true) {
            if (i == 0 && j == 1) {
                res = 0;
                break;
            } else if (i == 1 && j == 0) {
                res = 1;
                break;
            }
        }

        return res;
    }
}
