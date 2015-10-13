package ia_projeto.ia_projeto;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.probability.mdp.ActionsFunction;
import aima.core.search.framework.ResultFunction;

/**
 * Class to define actions and when they need to be taken 	 
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class BlocksFunctionFactory {
	
	private static ActionsFunction _actionsFunction = null; //Actions array
	private static ResultFunction _resultFunction = null;	//Results array

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

	/**
	 * Static function to execute an Action
	 */
	private static class BlocksResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			BlocksState board = (BlocksState) s;
			if(board.MOVEA0.equals(s)) {
				Block from = board.state().blocks('A');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(A")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(0)")) {
						board.function().remove(str);
						board.function().add("on(A,table)");
					}
				}
				board.state().move(from, from.position(), 0);
			}
			else if(board.MOVEA1.equals(s)) {
				Block from = board.state().blocks('A');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(A")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(1)")) {
						board.function().remove(str);
						board.function().add("on(A,table)");
					}
				}
				board.state().move(from, from.position(), 1);
			}
			else if(board.MOVEA2.equals(s)) {
				Block from = board.state().blocks('A');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(A")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(2)")) {
						board.function().remove(str);
						board.function().add("on(A,table)");
					}
				}
				board.state().move(from, from.position(), 2);
			}
			else if(board.MOVEA3.equals(s)) {
				Block from = board.state().blocks('A');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(A")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(3)")) {
						board.function().remove(str);
						board.function().add("on(A,table)");
					}
				}
				board.state().move(from, from.position(), 3);
			}
			else if(board.MOVEB0.equals(s)) {
				Block from = board.state().blocks('B');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(B")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(0)")) {
						board.function().remove(str);
						board.function().add("on(B,table)");
					}
				}
				board.state().move(from, from.position(), 0);
			}
			else if(board.MOVEB1.equals(s)) {
				Block from = board.state().blocks('B');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(B")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(1)")) {
						board.function().remove(str);
						board.function().add("on(B,table)");
					}
				}
				board.state().move(from, from.position(), 1);
			}
			else if(board.MOVEB2.equals(s)) {
				Block from = board.state().blocks('B');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(B")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(2)")) {
						board.function().remove(str);
						board.function().add("on(B,table)");
					}
				}
				board.state().move(from, from.position(), 2);
			}
			else if(board.MOVEB3.equals(s)) {
				Block from = board.state().blocks('B');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(B")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(3)")) {
						board.function().remove(str);
						board.function().add("on(B,table)");
					}
				}
				board.state().move(from, from.position(), 3);
			}
			else if(board.MOVEC0.equals(s)) {
				Block from = board.state().blocks('C');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(C")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(0)")) {
						board.function().remove(str);
						board.function().add("on(C,table)");
					}
				}
				board.state().move(from, from.position(), 0);
			}
			else if(board.MOVEC1.equals(s)) {
				Block from = board.state().blocks('C');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(C")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(1)")) {
						board.function().remove(str);
						board.function().add("on(C,table)");
					}
				}
				board.state().move(from, from.position(), 1);
			}
			else if(board.MOVEC2.equals(s)) {
				Block from = board.state().blocks('C');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(C")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(2)")) {
						board.function().remove(str);
						board.function().add("on(C,table)");
					}
				}
				board.state().move(from, from.position(), 2);
			}
			else if(board.MOVEC3.equals(s)) {
				Block from = board.state().blocks('C');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(C")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(3)")) {
						board.function().remove(str);
						board.function().add("on(C,table)");
					}
				}
				board.state().move(from, from.position(), 3);
			}
			else if(board.MOVED0.equals(s)) {
				Block from = board.state().blocks('D');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(D")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(0)")) {
						board.function().remove(str);
						board.function().add("on(D,table)");
					}
				}
				board.state().move(from, from.position(), 0);
			}
			else if(board.MOVED1.equals(s)) {
				Block from = board.state().blocks('D');
				board.state().move(from, from.position(), 1);
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(D")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(1)")) {
						board.function().remove(str);
						board.function().add("on(D,table)");
					}
				}
			}
			else if(board.MOVED2.equals(s)) {
				Block from = board.state().blocks('D');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(D")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(2)")) {
						board.function().remove(str);
						board.function().add("on(D,table)");
					}
				}
				board.state().move(from, from.position(), 2);
			}
			else if(board.MOVED3.equals(s)) {
				Block from = board.state().blocks('D');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(D")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(3)")) {
						board.function().remove(str);
						board.function().add("on(D,table)");
					}
				}
				board.state().move(from, from.position(), 3);
			}
			else if(board.MOVEAB.equals(s)) {
				Block from = board.state().blocks('A');
				Block to = board.state().blocks('B');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(A")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(B)")) {
						board.function().remove(str);
						board.function().add("on(A,B)");
					}
				}
				board.state().move(from, from.position(), to.position());
			}
			else if(board.MOVEAC.equals(s)) {
				Block from = board.state().blocks('A');
				Block to = board.state().blocks('C');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(A")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(C)")) {
						board.function().remove(str);
						board.function().add("on(A,C)");
					}
				}
				board.state().move(from, from.position(), to.position());
			}
			else if(board.MOVEAD.equals(s)) {
				Block from = board.state().blocks('A');
				Block to = board.state().blocks('D');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(A")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(D)")) {
						board.function().remove(str);
						board.function().add("on(A,D)");
					}
				}
				board.state().move(from, from.position(), to.position());
			}
			else if(board.MOVEBA.equals(s)) {
				Block from = board.state().blocks('B');
				Block to = board.state().blocks('A');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(B")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(A)")) {
						board.function().remove(str);
						board.function().add("on(B,A)");
					}
				}
				board.state().move(from, from.position(), to.position());
			}
			else if(board.MOVEBC.equals(s)) {
				Block from = board.state().blocks('B');
				Block to = board.state().blocks('C');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(B")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(C)")) {
						board.function().remove(str);
						board.function().add("on(B,C)");
					}
				}
				board.state().move(from, from.position(), to.position());
			}
			else if(board.MOVEBD.equals(s)) {
				Block from = board.state().blocks('B');
				Block to = board.state().blocks('D');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(B")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(D)")) {
						board.function().remove(str);
						board.function().add("on(B,D)");
					}
				}
				board.state().move(from, from.position(), to.position());
			}
			else if(board.MOVECA.equals(s)) {
				Block from = board.state().blocks('C');
				Block to = board.state().blocks('A');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(C")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(A)")) {
						board.function().remove(str);
						board.function().add("on(C,A)");
					}
				}
				board.state().move(from, from.position(), to.position());
			}
			else if(board.MOVECB.equals(s)) {
				Block from = board.state().blocks('C');
				Block to = board.state().blocks('B');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(C")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(B)")) {
						board.function().remove(str);
						board.function().add("on(C,B)");
					}
				}
				board.state().move(from, from.position(), to.position());
			}
			else if(board.MOVECD.equals(s)) {
				Block from = board.state().blocks('C');
				Block to = board.state().blocks('D');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(C")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(D)")) {
						board.function().remove(str);
						board.function().add("on(C,D)");
					}
				}
				board.state().move(from, from.position(), to.position());
			}
			else if(board.MOVEDA.equals(s)) {
				Block from = board.state().blocks('D');
				Block to = board.state().blocks('A');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(D")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(A)")) {
						board.function().remove(str);
						board.function().add("on(D,A)");
					}
				}
				board.state().move(from, from.position(), to.position());
			}
			else if(board.MOVEDB.equals(s)) {
				Block from = board.state().blocks('D');
				Block to = board.state().blocks('B');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(D")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(B)")) {
						board.function().remove(str);
						board.function().add("on(D,B)");
					}
				}
				board.state().move(from, from.position(), to.position());
			}
			else if(board.MOVEDC.equals(s)) {
				Block from = board.state().blocks('D');
				Block to = board.state().blocks('C');
				for(String str : board.function()) {
					if(str.split(",")[0].equals("on(D")) {
						if(str.split(",")[1].equals("table)")) {
							board.function().add("clear("+from.position()+")");
						}
						else {
							board.function().add("clear("+str.split(",")[1]);
						}
						board.function().remove(str);
					}
					else if(str.equals("clear(C)")) {
						board.function().remove(str);
						board.function().add("on(D,C)");
					}
				}
				board.state().move(from, from.position(), to.position());
			}
			return s;
		}
	}
}
