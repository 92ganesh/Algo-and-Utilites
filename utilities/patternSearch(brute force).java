public static boolean patsc(String st, String pt){
	for(int i=0;i<st.length()-pt.length();i++){
		for(int j=0;j<pt.length();j++){
			if(st.charAt(i+j)==pt.charAt(j)){
				if(j==pt.length()-1) return true;
			}
		}
	}
	return false;
}