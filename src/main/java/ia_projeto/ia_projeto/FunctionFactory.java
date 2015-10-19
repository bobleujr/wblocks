package ia_projeto.ia_projeto;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;

/**
 * Class to define actions and when they need to be taken 	 
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class FunctionFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	/**
	 * Return new action until goal is achieved
	 * @return new Action
	 */
	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new BlocksActionsFunction();
		}
		return _actionsFunction;
	}

	/**
	 * Return new result for a action until goal is achieved
	 * @return new Result
	 */
	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new BlocksResultFunction();
		}
		return _resultFunction;
	}

	/**
	 * Static function to set an Action based on world state 
	 */
	private static class BlocksActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			State board = (State) state;

			Set<Action> actions = new LinkedHashSet<Action>();
			
			for(String s : board.functions) {
				if(s.equals("Clear(A)")) {
					if(board.functions.contains("Clear(0)")) {
						actions.add(board.MOVEA0);
					}
					if(board.functions.contains("Clear(1)")) {
						actions.add(board.MOVEA1);
					}
					if(board.functions.contains("Clear(2)")) {
						actions.add(board.MOVEA2);
					}
					if(board.functions.contains("Clear(3)")) {
						actions.add(board.MOVEA3);
					}
					if(board.functions.contains("Clear(B)")) {
						actions.add(board.MOVEAB);
					}
					if(board.functions.contains("Clear(C)")) {
						actions.add(board.MOVEAC);
					}
					if(board.functions.contains("Clear(D)")) {
						actions.add(board.MOVEAD);
					}
				}
				else if(s.equals("Clear(B)")) {
					if(board.functions.contains("Clear(0)")) {
						actions.add(board.MOVEB0);
					}
					if(board.functions.contains("Clear(1)")) {
						actions.add(board.MOVEB1);
					}
					if(board.functions.contains("Clear(2)")) {
						actions.add(board.MOVEB2);
					}
					if(board.functions.contains("Clear(3)")) {
						actions.add(board.MOVEB3);
					}
					if(board.functions.contains("Clear(A)")) {
						actions.add(board.MOVEBA);
					}
					if(board.functions.contains("Clear(C)")) {
						actions.add(board.MOVEBC);
					}
					if(board.functions.contains("Clear(D)")) {
						actions.add(board.MOVEBD);
					}
				}
				else if(s.equals("Clear(C)")) {
					if(board.functions.contains("Clear(0)")) {
						actions.add(board.MOVEC0);
					}
					if(board.functions.contains("Clear(1)")) {
						actions.add(board.MOVEC1);
					}
					if(board.functions.contains("Clear(2)")) {
						actions.add(board.MOVEC2);
					}
					if(board.functions.contains("Clear(3)")) {
						actions.add(board.MOVEC3);
					}
					if(board.functions.contains("Clear(A)")) {
						actions.add(board.MOVECA);
					}
					if(board.functions.contains("Clear(B)")) {
						actions.add(board.MOVECB);
					}
					if(board.functions.contains("Clear(D)")) {
						actions.add(board.MOVECD);
					}
				}
				else if(s.equals("Clear(D)")) {
					if(board.functions.contains("Clear(0)")) {
						actions.add(board.MOVED0);
					}
					if(board.functions.contains("Clear(1)")) {
						actions.add(board.MOVED1);
					}
					if(board.functions.contains("Clear(2)")) {
						actions.add(board.MOVED2);
					}
					if(board.functions.contains("Clear(3)")) {
						actions.add(board.MOVED3);
					}
					if(board.functions.contains("Clear(A)")) {
						actions.add(board.MOVEDA);
					}
					if(board.functions.contains("Clear(B)")) {
						actions.add(board.MOVEDB);
					}
					if(board.functions.contains("Clear(C)")) {
						actions.add(board.MOVEDC);
					}
				}
			}			
			return actions;
		}

	}

	/**
	 * Static function to execute an Action
	 */
	private static class BlocksResultFunction implements ResultFunction {	
		public Object result(Object s, Action a) {
			State board = (State) s;
			ArrayList<String> function = new ArrayList<String>();
			for(String str : board.functions()) {
				function.add(str);
			}
			State newBoard = new State(function);
			if(a.equals(board.MOVEA0)) {
				Block b = newBoard.getBlock('A');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(A,0)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(0)");
				return newBoard;
			}
			else if(a.equals(board.MOVEA1)) {
				Block b = newBoard.getBlock('A');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(A,1)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(1)");
				return newBoard;
			}
			else if(a.equals(board.MOVEA2)) {
				Block b = newBoard.getBlock('A');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(A,2)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(2)");
				return newBoard;
			}
			else if(a.equals(board.MOVEA3)) {
				Block b = newBoard.getBlock('A');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(A,3)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(3)");
				return newBoard;
			}
			else if(a.equals(board.MOVEB0)) {
				Block b = newBoard.getBlock('B');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(B,0)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(0)");
				return newBoard;
			}
			else if(a.equals(board.MOVEB1)) {
				Block b = newBoard.getBlock('B');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(B,1)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(1)");
				return newBoard;
			}
			else if(a.equals(board.MOVEB2)) {
				Block b = newBoard.getBlock('B');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(B,2)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(2)");
				return newBoard;
			}
			else if(a.equals(board.MOVEB3)) {
				Block b = newBoard.getBlock('B');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(B,3)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(3)");
				return newBoard;
			}
			else if(a.equals(board.MOVEC0)) {
				Block b = newBoard.getBlock('C');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(C,0)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(0)");
				return newBoard;
			}
			else if(a.equals(board.MOVEC1)) {
				Block b = newBoard.getBlock('C');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(C,1)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(1)");
				return newBoard;
			}
			else if(a.equals(board.MOVEC2)) {
				Block b = newBoard.getBlock('C');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(C,2)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(2)");
				return newBoard;
			}
			else if(a.equals(board.MOVEC3)) {
				Block b = newBoard.getBlock('C');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(C,3)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(3)");
				return newBoard;
			}
			else if(a.equals(board.MOVED0)) {
				Block b = newBoard.getBlock('D');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(D,0)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(0)");
				return newBoard;
			}
			else if(a.equals(board.MOVED1)) {
				Block b = newBoard.getBlock('D');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(D,1)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(1)");
				return newBoard;
			}
			else if(a.equals(board.MOVED2)) {
				Block b = newBoard.getBlock('D');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(D,2)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(2)");
				return newBoard;
			}
			else if(a.equals(board.MOVED3)) {
				Block b = newBoard.getBlock('D');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				String newOn = "On(D,3)";
				b.setOn(newOn);
				newBoard.add(newOn);
				newBoard.remove("Clear(3)");
				return newBoard;
			}
			else if(a.equals(board.MOVEAB)) {
				Block b = newBoard.getBlock('A');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				newBoard.remove("Clear(B)");
				newBoard.add("On(A,B)");
				return newBoard;
			}
			else if(a.equals(board.MOVEAC)) {
				Block b = newBoard.getBlock('A');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				newBoard.remove("Clear(C)");
				newBoard.add("On(A,C)");
				return newBoard;
			}
			else if(a.equals(board.MOVEAD)) {
				Block b = newBoard.getBlock('A');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				newBoard.remove("Clear(D)");
				newBoard.add("On(A,D)");
				return newBoard;
			}
			else if(a.equals(board.MOVEBA)) {
				Block b = newBoard.getBlock('B');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				newBoard.remove("Clear(A)");
				newBoard.add("On(B,A)");
				return newBoard;
			}
			else if(a.equals(board.MOVEBC)) {
				Block b = newBoard.getBlock('B');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				newBoard.remove("Clear(C)");
				newBoard.add("On(B,C)");
				return newBoard;
			}
			else if(a.equals(board.MOVEBD)) {
				Block b = newBoard.getBlock('B');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				newBoard.remove("Clear(D)");
				newBoard.add("On(B,D)");
				return newBoard;
			}
			else if(a.equals(board.MOVECA)) {
				Block b = newBoard.getBlock('C');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				newBoard.remove("Clear(A)");
				newBoard.add("On(C,A)");
				return newBoard;
			}
			else if(a.equals(board.MOVECB)) {
				Block b = newBoard.getBlock('C');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				newBoard.remove("Clear(B)");
				newBoard.add("On(C,B)");
				return newBoard;
			}
			else if(a.equals(board.MOVECD)) {
				Block b = newBoard.getBlock('C');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				newBoard.remove("Clear(D)");
				newBoard.add("On(C,D)");
				return newBoard;
			}
			else if(a.equals(board.MOVEDA)) {
				Block b = newBoard.getBlock('D');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				newBoard.remove("Clear(A)");
				newBoard.add("On(D,A)");
				return newBoard;
			}
			else if(a.equals(board.MOVEDB)) {
				Block b = newBoard.getBlock('D');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				newBoard.remove("Clear(B)");
				newBoard.add("On(D,B)");
				return newBoard;
			}
			else if(a.equals(board.MOVEDC)) {
				Block b = newBoard.getBlock('D');
				newBoard.remove(b.getOn());
				newBoard.add("Clear("+b.getOn().split(",")[1]);
				newBoard.remove("Clear(C)");
				newBoard.add("On(D,C)");
				return newBoard;
			}
			return s;
		}

	}
}
