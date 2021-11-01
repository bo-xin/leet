package 剑指offer;

public class offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null && B!= null) && (subCur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }
    public boolean subCur(TreeNode A,TreeNode B){
        if(B ==null) return true;
        if(A==null || A.val != B.val) return false;
        return subCur(A.left,B.left) && subCur(A.right,B.right);
    }
}
