package com.wd.demo.tree;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TreeTest {
    public static void main(String[] args) {
        TreeChildren children1 = new TreeChildren(0, 1, "1", null);
        TreeChildren children2 = new TreeChildren(1, 2, "1.1", null);
        TreeChildren children3 = new TreeChildren(1, 3, "1.2", null);
        TreeChildren children4 = new TreeChildren(2, 4, "1.1.1", null);
        List<TreeChildren> treeList = new ArrayList<>();
        treeList.add(children1);
        treeList.add(children2);
        treeList.add(children3);
        treeList.add(children4);

        List<TreeNode<Integer>> collect = treeList.stream().map(getNodeFunction()).collect(Collectors.toList());
        List<Tree<Integer>> build = TreeUtil.build(collect, 0);
        
        BeanUtils.copyProperties(build, new ArrayList<TreeChildren>());
        System.out.println();
    }


    private static Function<TreeChildren, TreeNode<Integer>> getNodeFunction(){
        return item ->{
            TreeNode<Integer> node = new TreeNode<>();
            node.setId(item.getId());
            node.setParentId(item.getParentId());

            Map<String, Object> map = new HashMap<>();
            map.put("name", item.getName());
            node.setExtra(map);
            return node;
        };
    }

}



@Data
@AllArgsConstructor
class TreeChildren{
    private Integer parentId;
    private Integer id;
    private String name;
    private List<TreeChildren> children;
}