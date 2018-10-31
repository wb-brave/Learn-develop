package thinkinjava.chapter19.enums.multiroad;


import static thinkinjava.chapter19.enums.multiroad.OutCome.*;
/**
 * @author wubin
 * @Description
 * 使用enum来实现多路分发
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.multiroad
 * @email wubin326@qq.com
 * @date 2018/10/31
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/31        wubin            0.0.1
 */
public enum  RoShamBo2 implements Competitor<RoShamBo2>{

    /**
     * 根据this对象的构造形参值
     * 来进行与比较值的对比
     */
    PAPER(EQUAL,LOSE,WIN),
    SCISSORS(WIN,EQUAL,LOSE),
    ROCK(LOSE,WIN,EQUAL);

    private OutCome paper,scissors,rock;

    RoShamBo2(OutCome paper, OutCome scissors, OutCome rock) {
        this.paper = paper;
        this.scissors = scissors;
        this.rock = rock;
    }

    @Override
    public OutCome compete(RoShamBo2 roShamBo2) {
        switch (roShamBo2){
            default:
            case PAPER:return paper;
            case SCISSORS:return scissors;
            case ROCK:return rock;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class,20);
    }
}
