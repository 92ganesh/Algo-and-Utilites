 static class Multiset<T>{
	TreeMap<T,Integer> hm;
	int totalElements;
	Multiset(){
		hm=new TreeMap<>();
		totalElements=0;
	}
	void add(T key){
		Integer val = hm.get(key);
		if(val==null){ val=0; }
		hm.put(key,val+1);
		totalElements++;
	}
	void removeOne(T key){
		Integer val = hm.get(key);
		if(val!=null){
			val--;  totalElements--;
			if(val==0){ hm.remove(key); }
			else{   hm.put(key,val);    }
		}
	}
	void removeAll(T key){
		hm.remove(key);
		totalElements=0;
	}
	T get(int n){
		if(n<0||n>totalElements-1) return null;
		n++;
		for(T each:hm.keySet()){
			if(hm.get(each)<=n){
				n -= hm.get(each);
				if(n==0){ return each; }
			}else{
				return each;
			}
		}
		return null;
	}
	ArrayList<T> getAll(){
		ArrayList<T> arr=new ArrayList<>();
		for(T each:hm.keySet()){
			for(int i=1,n=hm.get(each); i<=n; i++){
				arr.add(each);
			}
		}
		return arr;
	}
}