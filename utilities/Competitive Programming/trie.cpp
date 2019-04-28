/*   TRIE    */
#include <bits/stdc++.h>
using namespace std;


/*****************************************
*   Trie data structure from codechef user 'cheng2014'
*   However it is modified to generalize
*   It is available at https://www.codechef.com/viewsolution/13476683
******************************************/
#define TRIE_SIZE 422222
#define TRIE_CHILDREN_COUNT 26

long long cnt=0;   // set it to 0 to reset trie
struct Node {
	long long tot;
	Node *ch[TRIE_CHILDREN_COUNT];
} node[TRIE_SIZE];

void init(long long u){
	for(long long j=0; j<TRIE_CHILDREN_COUNT; j++){
		node[u].ch[j]=NULL;
		node[u].tot=0;
	}
}

void insert(char *s, long long l,long long r){
	Node *qn=node;
	for(long long i=l; i<=r; i++){
		if(qn->ch[s[i]-'a']==NULL){
			init(++cnt);
			qn->ch[s[i]-'a']=node+cnt;
		}
		qn=qn->ch[s[i]-'a'];
	}
	qn->tot=1;
}

void trav(char *s, long long l,long long r){
	Node *qn=node;
	for(long long i=l; i<=r; i++){
		qn=qn->ch[s[i]-'a'];
		if(qn!=NULL){
    		// cout<<(qn->tot)<< endl;
		}else{
		    cout<<"NOT WORD"<<endl; return;
		}
	}
	cout<<(qn->tot)<< endl;
}
/******************** Trie Ends *******************************/


int main() {
	char str[] = "hello";
	char str2[] = "hello";

	// how to use:- 
	long long l=0,r=strlen(str)-1;
	cnt=0;  // reset trie
	insert(str,l,r);
	trav(str2,l,r);
	
	return 0;
}

