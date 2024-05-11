import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class m1707 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String name:names){
            int beg=name.indexOf("(");
            int end=name.indexOf(")");
            map.put(name.substring(0,beg),Integer.valueOf(name.substring(beg+1,end)));
        }
        List<String> removeName=new ArrayList<>();
        for(String synonym:synonyms){
            int mid=synonym.indexOf(",");
            String n1=synonym.substring(1,mid);
            String n2=synonym.substring(mid+1,synonym.length()-1);
            if(n1.compareTo(n2)<0){//n1的字典序小
                map.put(n1,map.get(n1)+map.get(n2));
                map.remove(n2);
            }else{
                map.put(n2,map.get(n1)+map.get(n2));
                map.remove(n1);
            }
        }
        int len=map.size();
        String[] res=new String[len];
        int i=0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res[i++]=entry.getKey()+"("+entry.getValue()+")";
        }
        return res;
    }

}
