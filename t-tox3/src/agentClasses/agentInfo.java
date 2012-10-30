package agentClasses;

public class agentInfo {
	//molecule ID
	private int _agentID;
	
	public int GetAgentID(){
		return _agentID;
	}
	
	public void SetAgentID(int agentID){
		_agentID = agentID;
	}
	
	//molecule name
	private String _name;
	
	public String GetName(){
		return _name;
	}
	public void SetName(String name){
		_name = name;
	}
	
	//molar mass of this molecule
	private int _molarMass;
	
	public int GetMolarMass(){
		return _molarMass;
	}
	
	public void SetMolarMass(int molarMass){
		_molarMass = molarMass;
	}
	
	//coefficient
	private float _fst;
	
	public float GetFst(){
		return _fst;
	}
	
	public void SetFst(float fst){
		_fst = fst;
	}
	
	//structural formula
	private String _smiles;
	
	public String GetSmiles(){
		return _smiles;
	}
	
	public void SetSmiles(String smiles){
		_smiles = smiles;
	}
}
