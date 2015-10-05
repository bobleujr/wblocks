package ia_projeto.ia_projeto;

import aima.core.search.framework.GoalTest;

public class BlocksGoalTest implements GoalTest{

		
	JawsState goal = new JawsState(2, 3);
	    
	@Override
	public boolean isGoalState(Object state) {
	        
		JawsState jarra = (JawsState) state;
	        
		return jarra.equals(goal);
	       
	}

	
	
}
