package tree;

public class UFSet {
	int[] nodedeep;//记录根结点深度（非根结点无意义）
	int[] tree;//记录val的父结点
	int unionCount;
	UFSet(int len){
		tree=new int[len];
		for(int i=0;i<len;++i) {
			tree[i]=i;
		}
		nodedeep=new int[len];
		for(int i=0;i<len;++i) {
			nodedeep[i]=1;
		}
		unionCount=0;
	}
	
	int findKey(int val) {//找val所在集合的序号=找树的根结点
		int beg=val;
		while(beg!=tree[beg]) {
			beg=tree[beg];
		}
		return beg;
	}

	//进一步优化---路径压缩：使find的每个结点直接指向根结点,进一步降低高度
	int findKeyZip(int val) {
		if(val==tree[val]) {
			return val;
		}
		return tree[val]=findKeyZip(tree[val]);//注意return a=1的写法
	}
	
	void unit(int a,int b) {//合并两个集合=连接两个结点=合并两颗树
//		int roota=findKey(a);
//		int rootb=findKey(b);
		int roota=findKeyZip(a);
		int rootb=findKeyZip(b);
		if(roota==rootb) {
			return;
		}
		++unionCount;
		if(nodedeep[roota]>nodedeep[rootb]) {//合并		
			tree[rootb]=roota;
		}else {
			tree[roota]=rootb;
		}
		if(nodedeep[roota]==nodedeep[rootb]) {//修改根的高度
			++nodedeep[roota];
			++nodedeep[roota];//此时a和b有一个不是树根，没有意义
		}
	}
	
	
}
