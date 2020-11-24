package com.mhboy.algorithms.leetcode.string;

import java.util.HashMap;
import java.util.Map;

class RansomNoteSolution {
    public boolean canConstruct(String ransomNote, String magazine) {
      int len = ransomNote.length();
      Map<Character, Integer> map = new HashMap();
      for(int i = 0; i < len; i++){
          char target = ransomNote.charAt(i);
          if(magazine.contains(String.valueOf(target))){
              Integer index = map.get(target);
              if(null != index){
                  String tempString = magazine.substring(index + 1);
                  if(tempString.contains(String.valueOf(target))){
                      map.put(target, tempString.indexOf(target) + index + 1);
                  }else{
                      return false;
                  }
              }else{
                  map.put(target, magazine.indexOf(target));
              }
          }else{
              return false;
          }
      }
      return true;
    }

    public static void main(String[] args) {
        RansomNoteSolution solution = new RansomNoteSolution();
        System.out.println(solution.canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }
}