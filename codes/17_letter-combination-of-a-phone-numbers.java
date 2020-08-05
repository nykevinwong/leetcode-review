public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();        
    if(digits==null || digits.length()==0) return res;
    
    HashMap<String,String> m = new HashMap<>();
    
    m.put("2","abc");
    m.put("3","def");
    m.put("4","ghi");
    m.put("5","jkl");
    m.put("6","mno");
    m.put("7","pqrs");
    m.put("8","tuv");
    m.put("9","wxyz");
          
    letterCombo(m, digits, 0, "", res);
    return res;
}

public void letterCombo(HashMap<String,String> m, String digits, int index, String s, List<String> res)
{
    if(index== digits.length()) { res.add(s); return;  }
    String c = "" + digits.charAt(index);
    String keys = m.get(c);
                                 
    for(int i=0;i < keys.length();i++)
    {
        letterCombo(m, digits, index+1, s+keys.charAt(i), res);
    }
}

