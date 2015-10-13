package ia_projeto.ia_projeto;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.probability.mdp.ActionsFunction;
import aima.core.search.framework.ResultFunction;

public class BlocksFunctionFactory {
	
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new BlocksActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new BlocksResultFunction();
		}
		return _resultFunction;
	}

	private static class BlocksActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			BlocksState board = (BlocksState) state;

			Set<Action> actions = new LinkedHashSet<Action>();
			if(board.function.contains("clear(A)")) {
				if(board.function.contains("clear(0)")) {
					actions.add(board.MOVEA0);
				}
				if(board.function.contains("clear(1)")) {
					actions.add(board.MOVEA1);
				}
				if(board.function.contains("clear(2)")) {
					actions.add(board.MOVEA2);
				}
				if(board.function.contains("clear(3)")) {
					actions.add(board.MOVEA3);
				}
				if(board.function.contains("clear(B)") && board.function.contains("on(B,Table)")) {
					actions.add(board.MOVEAB);
				}
				if(board.function.contains("clear(C)") && board.function.contains("on(C,Table)")) {
					actions.add(board.MOVEAC);
				}
				if(board.function.contains("clear(D)") && board.function.contains("on(D,Table)")) {
					actions.add(board.MOVEAD);
				}
			}
			if(board.function.contains("clear(B)")) {
				if(board.function.contains("clear(0)")) {
					actions.add(board.MOVEB0);
				}
				if(board.function.contains("clear(1)")) {
					actions.add(board.MOVEB1);
				}
				if(board.function.contains("clear(2)")) {
					actions.add(board.MOVEB2);
				}
				if(board.function.contains("clear(3)")) {
					actions.add(board.MOVEB3);
				}
				if(board.function.contains("clear(A)") && board.function.contains("on(A,Table)")) {
					actions.add(board.MOVEBA);
				}
				if(board.function.contains("clear(C)") && board.function.contains("on(C,Table)")) {
					actions.add(board.MOVEBC);
				}
				if(board.function.contains("clear(D)") && board.function.contains("on(D,Table)")) {
					actions.add(board.MOVEBD);
				}
			}
			if(board.function.contains("clear(C)")) {
				if(board.function.contains("clear(0)")) {
					actions.add(board.MOVEC0);
				}
				if(board.function.contains("clear(1)")) {
					actions.add(board.MOVEC1);
				}
				if(board.function.contains("clear(2)")) {
					actions.add(board.MOVEC2);
				}
				if(board.function.contains("clear(3)")) {
					actions.add(board.MOVEC3);
				}
				if(board.function.contains("clear(A)") && board.function.contains("on(A,Table)")) {
					actions.add(board.MOVECA);
				}
				if(board.function.contains("clear(B)") && board.function.contains("on(B,Table)")) {
					actions.add(board.MOVECB);
				}
				if(board.function.contains("clear(D)") && board.function.contains("on(D,Table)")) {
					actions.add(board.MOVECD);
				}
			}
			if(board.function.contains("clear(D)")) {
				if(board.function.contains("clear(0)")) {
					actions.add(board.MOVED0);
				}
				if(board.function.contains("clear(1)")) {
					actions.add(board.MOVED1);
				}
				if(board.function.contains("clear(2)")) {
					actions.add(board.MOVED2);
				}
				if(board.function.contains("clear(3)")) {
					actions.add(board.MOVED3);
				}
				if(board.function.contains("clear(A)") && board.function.contains("on(A,Table)")) {
					actions.add(board.MOVEDA);
				}
				if(board.function.contains("clear(B)") && board.function.contains("on(B,Table)")) {
					actions.add(board.MOVEDB);
				}
				if(board.function.contains("clear(C)") && board.function.contains("on(C,Table)")) {
					actions.add(board.MOVEDC);
				}
			}
			return actions;
		}
	}

	private static class BlocksResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			BlocksState board = (BlocksState) s;
			if(board.MOVEA0.equals(s)) {
				
			}
			else if(board.MOVEA1.equals(s)) {
				
			}
			else if(board.MOVEA2.equals(s)) {
				
			}
			else if(board.MOVEA3.equals(s)) {
				
			}
			else if(board.MOVEB1.equals(s)) {
				
			}
			else if(board.MOVEB2.equals(s)) {
				
			}
			else if(board.MOVEB3.equals(s)) {
				
			}
			else if(board.MOVEC1.equals(s)) {
				
			}
			else if(board.MOVEC2.equals(s)) {
				
			}
			else if(board.MOVEC3.equals(s)) {
	
			}
			else if(board.MOVED1.equals(s)) {
				
			}
			else if(board.MOVED2.equals(s)) {
				
			}
			else if(board.MOVED3.equals(s)) {
				
			}
			else if(board.MOVEAB.equals(s)) {
				
			}
			else if(board.MOVEAC.equals(s)) {
	
			}
			else if(board.MOVEAD.equals(s)) {
	
			}
			else if(board.MOVEBA.equals(s)) {
				
			}
			else if(board.MOVEBC.equals(s)) {
				
			}
			else if(board.MOVEBD.equals(s)) {
				
			}
			else if(board.MOVECA.equals(s)) {
			
			}
			else if(board.MOVECB.equals(s)) {
				
			}
			else if(board.MOVECD.equals(s)) {
				
			}
			else if(board.MOVEDA.equals(s)) {
				
			}
			else if(board.MOVEDB.equals(s)) {
				
			}
			else if(board.MOVEDC.equals(s)) {
				
			}
			/*
			if (board.ESVASIAR_3L.equals(a)) {
				JugsState newBoard = new JugsState();
                                newBoard.state[0]=board.state[0];
				newBoard.state[1]=0; //esvazir 3L
				return newBoard;
			} else if (board.ESVASIAR_5L.equals(a)) {
				JugsState newBoard = new JugsState();
                                newBoard.state[0]=0;
				newBoard.state[1]=board.state[1]; //esvazir 3L
				return newBoard;
                        }
			*/
			// The Action is not understood or is a NoOp
			// the result will be the current state.
			return s;
		}
	}
}
