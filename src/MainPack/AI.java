package MainPack;

public class AI {

	private int nodesWithoutPruning = 0;
	private int nodesWithPruning = 0;
	
	public Board play(Board board) {
		Max_Value(board,Integer.MIN_VALUE,Integer.MAX_VALUE,false,true);
		return Max_Value(board,Integer.MIN_VALUE,Integer.MAX_VALUE,true,true); 
	}
	
	public Board Min_Value(Board state,int alpha,int beta,boolean pruning,boolean first) {
		if(state.isTerminated() != 'T') {
			return state;
		}
		Board nextState = null,tmpState = null;
		int min = Integer.MAX_VALUE;
		for (int i = 2; i >=0 ; i--) {
			for (int j = 2; j >= 0; j--) {
				if(state.get(i,j) == '_') {
					if(pruning) {
						nodesWithPruning++;
					}else {
						nodesWithoutPruning++;
					}
					Board newState = new Board(state);
					newState.set(i, j, 'X');
					tmpState = Max_Value(newState,alpha,beta,pruning,false);
					if(tmpState.score()<min) {
						min = tmpState.score();
						nextState = tmpState;
						if(pruning) {
							beta = min;
						}	
					}
					if(min<=alpha) {
						return nextState;
					}
				}
			}
		}
		return nextState;
	}
	
	public Board Max_Value(Board state,int alpha,int beta,boolean pruning,boolean first) {
		if(state.isTerminated() != 'T') {
			return state;
		}
		Board nextState = null,tmpState = null;
		int max = Integer.MIN_VALUE;;
		for (int i = 2; i >=0 ; i--) {
			for (int j = 2; j >=0 ; j--) {
				if(state.get(i,j) == '_') {
					if(pruning) {
						nodesWithPruning++;
					}else {
						nodesWithoutPruning++;
					}
					Board newState = new Board(state);
					newState.set(i, j, 'O');
					tmpState  = Min_Value(newState,alpha,beta,pruning,false);
					
					if(tmpState.score()>max) {
						max = tmpState.score();
						if(first) {
							nextState = newState;
						}else {
							nextState = tmpState;
						}
						if(pruning) {
							alpha = max;
						}	
					}
					if(max>=beta) {
						return nextState;
					}
				}
			}
		}
		return nextState;
	}
		
	public int getNodesWithoutPruning() {
		return nodesWithoutPruning;
	}

	public int getNodesWithPruning() {
		return nodesWithPruning;
	}
}
