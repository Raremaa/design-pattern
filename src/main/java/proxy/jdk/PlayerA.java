package proxy.jdk;

/**
 * 玩家A
 *
 * @author masaiqi
 * @date 2020/3/14 11:22 下午
 */
public class PlayerA implements IPlayer{

    @Override
    public void pickGame() {
        System.err.println("玩家A: 我选择switch中的喷射战士2!");
    }
}
