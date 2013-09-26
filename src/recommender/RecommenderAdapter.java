package recommender;

import java.util.List;
import commons.dataClasses.Recommendation;
import commons.interfaces.IConnector;
import commons.interfaces.IRecommender;

public class RecommenderAdapter {
	private IRecommender recommender;
	private IProgressContext progressContext;
	public void setConnector(IConnector connector){
		recommender.setConnector(connector);
	}
	public IConnector getConnector(){
		return recommender.getConnector();
	}
	
	public void setProgressContext(IProgressContext progressContext){
		this.progressContext = progressContext;
	}
	
	public IProgressContext getProgressContext(){
		return this.progressContext;
	}
	
	public RecommenderAdapter(IConnector c){
		recommender.setConnector(c);
		
	}
	
	//Trying to avoid background threading. Would have used SwingWorker
	public void getRecommendations(Recs displayList){
		List<Recommendation> result = null ;
		try {
		result= recommender.getRecommendations();
		} catch (Exception e) {
			// TODO: handle exception
		}
		//empty it
		displayList.clear();
		if(result.size()>0){
			for (Recommendation recommendation : result) {
				//when I will have an add method for it
				displayList.add(recommendation);
			}
			//progressContext.updateProgress(1.0);
		} //else cannot generate recommendations
	
	}
}
