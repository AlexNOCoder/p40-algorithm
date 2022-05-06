package common;

import com.alibaba.fastjson.JSONObject;

public class TreeNode {
   public int val;
   public TreeNode left;
   public TreeNode right;
   public TreeNode(int x){val = x;}

   @Override
   public String toString() {
      return JSONObject.toJSONString(this);
   }
}
