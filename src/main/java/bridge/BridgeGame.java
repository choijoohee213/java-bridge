package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridgeColumns;
    private int moveCount = 0;

    public void make() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = bridgeMaker.inputBridgeSize();
        bridgeColumns = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        BridgeMover bridgeMover = new BridgeMover();
        String markToMove = bridgeMover.inputBridgeMarkToMove();
        boolean movable = bridgeMover.checkMovable(bridgeColumns, markToMove, moveCount);
        bridgeMover.printBridgeMap(bridgeColumns, moveCount, movable);
        moveCount++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
